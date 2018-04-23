package com.market.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBUtils;

/**
 * 完善个人中心
 * 输入动态信息
 * 根据登陆用户信息重定向到各页面
 * @author YuQi
 *
 */
@WebServlet("/Chengeuser.do")
public class Chengeuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chengeuser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if(session.getAttribute("man")==null){
			//request.getRequestDispatcher("/servlet/wrongMan.jsp").forward(request, response);;
			response.sendRedirect("servlet/wrongMan.jsp");
		}else {
			System.out.println("man存在");
		}
		
		
		System.out.println("添加页面");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String datetime = sdf.format(date);
		
		Map<String,String> mapId =  (Map<String, String>) session.getAttribute("man");
		String id = mapId.get("id");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tell = request.getParameter("tell");
		String address = request.getParameter("address");
		
		
			
			String sql = "update `user` set account=? , password=?,name=?,age=?, tel=?, addess=?, modifedDat=? where id=?";
			int a = DBUtils.dao().update(sql,account,password,name,age,tell,address,datetime,id);
			
			
			//刷新登陆用户信息
			String sql_man = "SELECT	s.id,	s.account,	s.`password`,	s.roleId,	s.`name`,s.marketID,s.addess,s.age,s.createDate,s.tel,	m.marketname,	a.rolename FROM	`user` AS s,	role AS a,	market as m WHERE	s.roleId = a.id and s.marketID = m.id";
			Map<String,String> userList = DBUtils.dao().findOne(sql);
			session.setAttribute("man", userList);
			
			session.invalidate();
			response.sendRedirect("Login.do");
			/*
			if(mapId.get("roleId").equals("1")){
				response.sendRedirect("Market.do");
			}else if(mapId.get("roleId").equals("2")){
				response.sendRedirect("Suppler.do");
			}else if(mapId.get("roleId").equals("3")){
				response.sendRedirect("ComList.do");
			}*/
		}
	

}
