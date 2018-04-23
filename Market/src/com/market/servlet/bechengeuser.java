package com.market.servlet;

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
 * 推送角色修改页面回显信息
 * @author YuQi
 *
 */
@WebServlet("/bechengeuser.do")
public class bechengeuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bechengeuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("man")==null){
			request.getRequestDispatcher("/servlet/wrongMan.jsp").forward(request, response);;
			
		}else {
			System.out.println("man存在");
		}
		String id = request.getParameter("id");
		if(id != null)
			session.setAttribute("userid", id);
		System.out.println(id);
		
			String userid = (String) session.getAttribute("userid");
		//投送超市信息
		Map<String,String> chengeuser ;
		String sql_market = "select * from user where id=? ";
		chengeuser = DBUtils.dao().findOne(sql_market,userid);
		session.setAttribute("chengeuser", chengeuser);
		
		request.getRequestDispatcher("/servlet/bechengeuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
