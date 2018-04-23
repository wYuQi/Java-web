package com.market.boss;

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
 * Servlet implementation class Suppler
 */
@WebServlet("/Suppler.do")
public class Suppler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suppler() {
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
			System.out.println("man����");
		}
		
		System.out.println("��תsuppler");
		
		List<Map<String,String>> suppler ;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		

		//Ͷ�ͳ�����Ϣ
		Map<String,String> mapMan = (Map<String,String>) session.getAttribute("man");
		String sql_role = "select * from suppler where maeketID = ? ";
		suppler = DBUtils.dao().find(sql_role,mapMan.get("marketID"));
		if(suppler==null)System.out.println("000");
		session.setAttribute("suppler", suppler);
		
		
		
		//ɾ������
	    String id = request.getParameter("id");//���ݱ��number��ɾ��
		DBUtils.dao().update("delete from suppler where id = ?", id);
		
		//�Ѿ��ı����ݿ������jspҳ������ı�
		request.getRequestDispatcher("/boss/suppler.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
