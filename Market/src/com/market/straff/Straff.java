package com.market.straff;

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
 * Servlet implementation class Straff
 */
@WebServlet("/Straff.do")
public class Straff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Straff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("man")==null){
			request.getRequestDispatcher("/servlet/wrongMan.jsp").forward(request, response);;
			
		}else {
			System.out.println("man存在");
		}
		
		
		//删除表
		//String id = request.getParameter("id");
		//DBUtils.dao().update("delete from(select s.id, s.goodsName, t.type,s.priceNum, s.inPrice, s.outPrice, s.count from commodity as s,type as t, suppler as a where s.supplierID = a.id = t.id) where id = ?",id);

		Map<String,String> mapMan = (Map<String,String>) session.getAttribute("man");
		//查表
		String sql_bossmarket = "select s.id, s.goodsName, t.type,s.priceNum, s.inPrice, s.outPrice, s.count from commodity as s,type as t, suppler as a where s.supplierID = a.id = t.id and marketID = ? order by priceNum asc";
		List<Map<String,String>> bossmarketList = DBUtils.dao().find(sql_bossmarket,mapMan.get("marketID"));
		if(bossmarketList == null)System.out.println("没查出来");
		session.setAttribute("bossmarketList", bossmarketList);
		
		request.getRequestDispatcher("/straff/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
