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
			System.out.println("man����");
		}
		
		
		System.out.println("��ӻ�����Ʒ��Ϣҳ��");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//��ȡʱ��
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
		
		//�����Ƿ�Ϊ�գ�������
		if(goodsname==""||priceNum==""||inPrice==""||outPrice==""||count==""||maxcount==""){
			if(goodsname=="")
				request.setAttribute("goodsname", "�������������");
			if(priceNum=="")
				request.setAttribute("priceNum", "�����ҵ�����");
			if(inPrice=="")
				request.setAttribute("inPrice", "�����������");
			if(outPrice=="")
				request.setAttribute("outPrice", "���������ۼ�");
			if(count=="")
				request.setAttribute("count", "����������");
			if(maxcount=="")
				request.setAttribute("maxcount", "�������������");
			
			request.getRequestDispatcher("/straff/addcom.jsp").forward(request, response);
			return;
		}
		
		String sql = "insert into commodity (marketID,goodsName,typeID,priceNum,supplierID,inPrice,outPrice,count,maxcount,createDate) value(?,?,?,?,?,?,?,?,?,?)";
		int a = DBUtils.dao().update(sql,maeketID,goodsname,typeID,priceNum,suppler,inPrice,outPrice,count,maxcount,datetime);
		System.out.println(a);
		response.sendRedirect("StraffList.do");
	}

}
