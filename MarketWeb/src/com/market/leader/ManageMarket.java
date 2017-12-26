package com.market.leader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.RealTimeSequencerProvider;

import Utils.DBUtils;

/**
 * Servlet implementation class ManageMarket
 */
@WebServlet("/ManageMarket")
public class ManageMarket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageMarket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    
	    //向jsp投送开启超市信息
	    List<Map<String,String>> marketList = new ArrayList<>();
	    String sql = "select * from market";
	    marketList = DBUtils.dao().find(sql);//一个错误：忘记将查询对象传递到marketList
	    request.setAttribute("List", marketList);
	    
	    //向jsp投送超市管理信息
	    List<Map<String,String>> manatext = new ArrayList<>();
	    String sql_mana = "select * from mana";
	    manatext = DBUtils.dao().find(sql_mana);
	    request.setAttribute("mana", manatext);
	    
		request.getRequestDispatcher("/WEB-INF/view/market_leader/manageMarket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
