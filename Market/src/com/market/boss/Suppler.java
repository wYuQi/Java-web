package com.market.boss;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBUtils;

/**
 * Servlet implementation class Suppler
 */
@WebServlet("/Suppler.do")
public class Suppler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suppler() {
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
		
		System.out.println("跳转suppler");
		
		List<Map<String,String>> suppler ;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		

		//投送超市信息
		Map<String,String> mapMan = (Map<String,String>) session.getAttribute("man");
		String sql_role = "select * from suppler where maeketID = ? ";
		suppler = DBUtils.dao().find(sql_role,mapMan.get("marketID"));
		if(suppler==null)System.out.println("000");
		session.setAttribute("suppler", suppler);
		
		
		
		//删除功能
	    String id = request.getParameter("id");//根据编号number来删除
		DBUtils.dao().update("delete from suppler where id = ?", id);
		
		//已经改变数据库所查表，jsp页面无需改变
		request.getRequestDispatcher("/boss/suppler.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
