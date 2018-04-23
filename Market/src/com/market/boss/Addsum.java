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
 * Servlet implementation class Addsum
 */
@WebServlet("/Addsum.do")
public class Addsum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addsum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println("跳转StraffList");
		
	HttpSession session = request.getSession();
	if(session.getAttribute("man")==null){
		request.getRequestDispatcher("/servlet/wrongMan.jsp").forward(request, response);;
		
	}else {
		System.out.println("man存在");
	}		
	
	List<Map<String,String>> strff ;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		

		//投送超市信息
		
		/*String sql_role = "select * from user where roleId = 3";
		strff = DBUtils.dao().find(sql_role);
		if(strff==null)System.out.println("000");
		session.setAttribute("strff", strff);*/
		request.getRequestDispatcher("/boss/Addsun.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
