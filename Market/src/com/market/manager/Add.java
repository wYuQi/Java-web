package com.market.manager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBUtils;

/**
 * ����û�
 */
/**
 * Servlet implementation class Add
 */
@WebServlet("/Add.do")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if(session.getAttribute("man")==null){
			request.getRequestDispatcher("/servlet/wrongMan.jsp").forward(request, response);;
			
		}else {
			System.out.println("man����");
		}
		
		
		System.out.println("���ҳ��");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//��ȡʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String datetime = sdf.format(date);
		
		String account = request.getParameter("account");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String kind = request.getParameter("role");
		String market = request.getParameter("select");
		
		if(account==""||name==""||password==""){
			if(account=="")
				request.setAttribute("acc","���������˺�");
			if(account=="")
				request.setAttribute("name","������������");
			if(account=="")
				request.setAttribute("password","������������");
			request.getRequestDispatcher("/servlet/Add.jsp").forward(request, response);;
			return;
		}
		
		String sql = "insert into user (account,name,password,roleId,createDate,marketID) value(?,?,?,?,?,?)";
		int a = DBUtils.dao().update(sql,account,name,password,kind,datetime,market);
		System.out.println(a);
		response.sendRedirect("RoleList.do");
		
	}

}
