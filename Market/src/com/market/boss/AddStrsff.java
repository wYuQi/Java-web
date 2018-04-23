package com.market.boss;

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
 * Servlet implementation class AddStrsff
 */
@WebServlet("/AddStraff.do")
public class AddStrsff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStrsff() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		System.out.println("zangj++"+account);
		if(account==""||name==""||password==""){
			if(account=="")
				request.setAttribute("acc", "���������˺�");
			if(password=="")
				request.setAttribute("pw", "������������");
			if(name=="")
				request.setAttribute("na", "������������");
			request.getRequestDispatcher("/boss/Add.jsp").forward(request, response);
			return;
		}
		
		String sql = "insert into user (account,name,password,roleId,createDate,marketID) value(?,?,?,?,?,?)";
		int a = DBUtils.dao().update(sql,account,name,password,kind,datetime,market);
		System.out.println(a);
		response.sendRedirect("StraffList.do");
	}

}
