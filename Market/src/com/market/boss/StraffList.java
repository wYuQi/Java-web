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
 * Ա����ʾ
 */
/**
 * Servlet implementation class StraffList
 */
@WebServlet("/StraffList.do")
public class StraffList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StraffList() {
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
		
		System.out.println("��תStraffList");
		
		List<Map<String,String>> strff ;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
	
		//����ͬ����Ա����Ϣ
		Map<String,String> mapMan = (Map<String,String>) session.getAttribute("man");
		String sql_role = "SELECT	s.id,	s.account,	s.`password`,	s.roleId,	s.`name`,s.marketID,s.addess,s.age,s.createDate,s.tel,	m.marketname,	a.rolename FROM	`user` AS s,	role AS a,	market as m WHERE	s.roleId = a.id and s.marketID = m.id and roleId = 3 and marketId = ?";
		strff = DBUtils.dao().find(sql_role,mapMan.get("marketID"));
		if(strff==null)System.out.println("000");
		session.setAttribute("userList", strff);
		
		
		
		//ɾ������
	    String id = request.getParameter("id");//���ݱ��number��ɾ��
		DBUtils.dao().update("delete from user where id = ?", id);
		
		//�Ѿ��ı����ݿ������jspҳ������ı�
		request.getRequestDispatcher("/boss/userlist.jsp").forward(request, response);
		//request.getRequestDispatcher("/boss/StrffList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
