package com.market.straff;

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
 * Servlet implementation class AddcomGet
 */
@WebServlet("/AddcomGet.do")
public class AddcomGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddcomGet() {
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
		
		
		System.out.println("添加回收商品信息页面");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String datetime = sdf.format(date);
		
		String maeketID = request.getParameter("market");
		String goodsname = request.getParameter("goodsName");
		String typeID = request.getParameter("typeID");
		String priceNum = request.getParameter("priceNum");
		String suppler = request.getParameter("select");
		String inPrice = request.getParameter("inPrice");
		String outPrice = request.getParameter("outPrice");
		String count = request.getParameter("count");
		String maxcount = request.getParameter("maxcount");
		
		//检验是否为空，并回显
		if(goodsname==""||priceNum==""||inPrice==""||outPrice==""||count==""||maxcount==""){
			if(goodsname=="")
				request.setAttribute("goodsname", "必须输入货物名");
			if(priceNum=="")
				request.setAttribute("priceNum", "必须找到销量");
			if(inPrice=="")
				request.setAttribute("inPrice", "必须输入进价");
			if(outPrice=="")
				request.setAttribute("outPrice", "必须输入售价");
			if(count=="")
				request.setAttribute("count", "必须输入库存");
			if(maxcount=="")
				request.setAttribute("maxcount", "必须输入最大库存");
			
			request.getRequestDispatcher("/straff/addcom.jsp").forward(request, response);
			return;
		}
		
		String sql = "insert into commodity (marketID,goodsName,typeID,priceNum,supplierID,inPrice,outPrice,count,maxcount,createDate) value(?,?,?,?,?,?,?,?,?,?)";
		int a = DBUtils.dao().update(sql,maeketID,goodsname,typeID,priceNum,suppler,inPrice,outPrice,count,maxcount,datetime);
		System.out.println(a);
		response.sendRedirect("StraffList.do");
	}

}
