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

import com.market.role.Boss;
import com.market.role.Manager;
import com.market.role.Role;
import com.market.role.Staff;
import com.market.servlet.Jd;
import com.market.servlet.SessionMan;

import DB.DBUtils;
/**
 * 判断登陆页面
 */

/**
 * Servlet implementation class Which
 */
@WebServlet("/which.do")
public class Which extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Map<String,String>> marketList = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Which() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("输入完成");
		String ID = request.getParameter("ID");
		String password = request.getParameter("password");
		String jpg = request.getParameter("jpg");
		System.out.println(ID+"+"+password);
		
		HttpSession session = request.getSession();
		String j = (String) session.getAttribute("jpg");

		Manager role = new Manager(ID, password);
		if(role.up()&& jpg.equals(j)){
			/*Manager a = new Manager();
			session.setAttribute("man", a.map());
			session.setAttribute("manlist", a.list());*/
			Map<String,String> temp = role.map();
			session.setAttribute("man", temp);
			System.out.println(role.map().get("name"));
			String a = "1";
			String b = "2";
			String c = "3";
			
			//验证权限
			System.out.println("登陆号"+temp.get("roleId"));
			if(a.equals(temp.get("roleId")) ){
				response.sendRedirect("ManagerList.do");
				
			}else if(b.equals(temp.get("roleId"))){
				response.sendRedirect("boss.do");
				
			}else  if(c.equals(temp.get("roleId"))){
				response.sendRedirect("Straff.do");
				
			}
			}else {
				session.setAttribute("wrong", "输入错误");
				response.sendRedirect("Login.do");
		
		}

	}

}
