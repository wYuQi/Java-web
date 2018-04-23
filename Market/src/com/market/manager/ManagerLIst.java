package com.market.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.market.servlet.SessionMan;

import DB.DBUtils;

/**
 * Servlet implementation class ManagerLIst
 */
@WebServlet("/ManagerList.do")
public class ManagerLIst extends HttpServlet {
	public static List<Map<String,String>> marketList = new ArrayList<>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLIst() {
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
		System.out.println("跳转managerList");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		

		//投送超市信息
		
		String sql_market = "select * from market where marketname != '无'";
		marketList = DBUtils.dao().find(sql_market);
		session.setAttribute("List", marketList);
		
		
		
		//删除功能
	    String id = request.getParameter("number");//根据编号number来删除
		DBUtils.dao().update("delete from market where id = ?", id);
		request.getRequestDispatcher("/index/main/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
