package com.market.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DB.DBUtils;

public class Jd {
	
	public Jd(){
		System.out.println("��תmanagerList");
	}
	
	
	//request.setCharacterEncoding("UTF-8");
	//response.setContentType("text/html;charset=UTF-8");
	
	//Ͷ�ͳ�����Ϣ
	public List<Map<String,String>> marketList(String sql){
		List<Map<String,String>> marketList = new ArrayList<>();
		//String sql_market = "select * from ?";
		marketList = DBUtils.dao().find(sql);
		//request.setAttribute("List", marketList);
		return marketList;
	}
	
	//ɾ������
	public void dele(String sql){
	    //String id = request.getParameter("number");//���ݱ��number��ɾ��
		DBUtils.dao().update("delete from market where number = ?", sql);
		//request.getRequestDispatcher("/WEB-INF/view/manager/managerList.jsp").forward(request, response);
	}
}
