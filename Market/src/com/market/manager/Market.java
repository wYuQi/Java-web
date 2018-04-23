package com.market.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBUtils;

/**
 * Servlet implementation class Market
 */
@WebServlet("/Market.do")
public class Market extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Market() {
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
			System.out.println("man存在");
		}
		//投送超市信息
		
		String sql_market = "select * from market where marketname != '无'";
		ManagerLIst.marketList = DBUtils.dao().find(sql_market);
//		if(marketList==null)System.out.println("000");
		session.setAttribute("List", ManagerLIst.marketList);
		//request.getRequestDispatcher("/demo/list_demo.jsp").forward(request, response);
		request.getRequestDispatcher("/manager/MarketreList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
