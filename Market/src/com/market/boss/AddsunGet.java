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
 * Servlet implementation class AddsunGet
 */
@WebServlet("/AddsumGet.do")
public class AddsunGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddsunGet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if(session.getAttribute("man")==null){
			request.getRequestDispatcher("/servlet/wrongMan.jsp").forward(request, response);;
			
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
		
		String marketID = request.getParameter("select");
		String name = request.getParameter("name");
		String goods = request.getParameter("goods");
		String tell = request.getParameter("tell");
		
		if(name==""||goods==""||tell==""){
			if(name=="")
				request.setAttribute("na", "必须输入厂家名");
			if(goods=="")
				request.setAttribute("goods", "必须输入货物名");
			if(tell=="")
				request.setAttribute("tell", "必须输入电话");
			request.getRequestDispatcher("/boss/Addsun.jsp").forward(request, response);
		}
		
		String sql = "insert into suppler (maeketID,name,goods,tell) value(?,?,?,?)";
		int a = DBUtils.dao().update(sql,marketID,name,goods,tell);
		System.out.println(a);
		response.sendRedirect("Suppler.do");
	}

}
