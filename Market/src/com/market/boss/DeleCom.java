package com.market.boss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import DB.DBUtils;
import java.util.Map;

/**
 * Servlet implementation class DeleCom
 */
@WebServlet("/DeleCom.do")
public class DeleCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleCom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("man")==null){
			request.getRequestDispatcher("/servlet/wrongMan.jsp").forward(request, response);;
			
		}else {
			System.out.println("man存在");
		}
		
		
	    String id = request.getParameter("number");//根据编号number来删除
	    //检验商品数量，小于1可以删除
	    String com = "select * from commodity where id = ?";
	    Map<String, String> mapCom  = DBUtils.dao().findOne(com, id);
	    int num = Integer.parseInt(mapCom.get("count"));
	    
	    if(num > 1){
	    	session.setAttribute("comWorng", "数量大于1，不可删除");
	    }else{
		    System.out.println("删除"+id);
			DBUtils.dao().update("delete from commodity where id = ?", id);
			request.getRequestDispatcher("ComList.do").forward(request, response);
	    }
		response.sendRedirect("ComList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
