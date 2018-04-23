package com.market.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DB.DBUtils;

public class Jd {
	
	public Jd(){
		System.out.println("跳转managerList");
	}
	
	
	//request.setCharacterEncoding("UTF-8");
	//response.setContentType("text/html;charset=UTF-8");
	
	//投送超市信息
	public List<Map<String,String>> marketList(String sql){
		List<Map<String,String>> marketList = new ArrayList<>();
		//String sql_market = "select * from ?";
		marketList = DBUtils.dao().find(sql);
		//request.setAttribute("List", marketList);
		return marketList;
	}
	
	//删除功能
	public void dele(String sql){
	    //String id = request.getParameter("number");//根据编号number来删除
		DBUtils.dao().update("delete from market where number = ?", sql);
		//request.getRequestDispatcher("/WEB-INF/view/manager/managerList.jsp").forward(request, response);
	}
}
