package com.market.does;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Utils.DBUtils;

/**
 * Servlet implementation class Inout
 */
@WebServlet("/in.uhtml")
public class Inout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post请求解决乱码
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				//get请求乱码
				//String aa = new String("asdas".getBatyes("iso-8859-1"),"utf-8")
				List<Map<String,String>> goodsList = new ArrayList<>();
				String sql = "select * from `inout`";
				//激活JDBC调用find（）
				goodsList = DBUtils.dao().find(sql);
				request.setAttribute("List",goodsList);
				request.getRequestDispatcher("/WEB-INF/view/in.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
