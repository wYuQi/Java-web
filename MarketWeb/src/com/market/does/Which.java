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
 * Servlet implementation class Which
 */
@WebServlet("/which.uhtml")
public class Which extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Which() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("ID");
		String password = request.getParameter("password");
		System.out.println(ID+"00");
		List<Map<String,String>> goodsList = new ArrayList<>();
		String sql = "select * from manager";//��ѯ����Ա���ݿ�
		//����JDBC����find����
		goodsList = DBUtils.dao().find(sql);
		request.setAttribute("List",goodsList);
		//�����ݿ��˺�����
		boolean temp = false;
		for (Map<String, String> map : goodsList) {
			System.out.println(map.get("ID"));
			if(map.get("ID").equals(ID))
				if(map.get("password").equals(password))
					temp = true;
			
		}
		System.out.println(temp);
		if(temp){
			request.getRequestDispatcher("/ManageMarket").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
