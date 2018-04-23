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
 * 接收角色修改
 * @author YuQi
 *
 */
@WebServlet("/bechengeuserGet.do")
public class bechengeuserGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bechengeuserGet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String datetime = sdf.format(date);
		
		HttpSession session = request.getSession();
		String id = ((Map<String,String>) session.getAttribute("chengeuser")).get("id");

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tell = request.getParameter("tell");
		String address = request.getParameter("address");
		
			
			String sql = "update `user` set account=? , password=?,name=?,age=?, tel=?, addess=?, modifedDat=? where id=?";
			int a = DBUtils.dao().update(sql,account,password,name,age,tell,address,datetime,id);
			
			
			
			//重定向到登录用户主系统
			Map<String,String> mapId = (Map<String, String>) session.getAttribute("man");
			if(mapId.get("roleId").equals("1")){
				response.sendRedirect("Market.do");
			}else if(mapId.get("roleId").equals("2")){
				response.sendRedirect("Suppler.do");
			}else if(mapId.get("roleId").equals("3")){
				response.sendRedirect("ComList.do");
			}
		
	}

}
