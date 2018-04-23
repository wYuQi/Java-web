package com.market.manager;

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
 * 用户表操作
 */
/**
 * Servlet implementation class RoleList
 */
/**
 * 查看用户表相关
 * @author YuQi
 *
 */
@WebServlet("/RoleList.do")
public class RoleList extends HttpServlet {
	static List<Map<String,String>> roleList ;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleList() {
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
		
		
		System.out.println("跳转userList");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//投送超市信息
		
		String sql_role = "SELECT	s.id,	s.account,	s.`password`,	s.roleId,	s.`name`,s.marketID,s.addess,s.age,s.createDate,s.tel,	m.marketname,	a.rolename FROM	`user` AS s,	role AS a,	market as m WHERE	s.roleId = a.id and s.marketID = m.id";
		roleList = DBUtils.dao().find(sql_role);
		if(roleList==null)System.out.println("000");
		session.setAttribute("userList", roleList);
		
		
		
		//删除功能
	    String id = request.getParameter("id");//根据编号number来删除
		DBUtils.dao().update("delete from user where id = ?", id);
		
		
		request.getRequestDispatcher("/manager/userList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
