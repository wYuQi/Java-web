package com.market.straff;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBUtils;

/**
 * Servlet implementation class ShipmentGet
 */
@WebServlet("/ShipmentGet.do")
public class ShipmentGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShipmentGet() {
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
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//��ȡʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String datetime = sdf.format(date);
		
		String account = request.getParameter("select");
		String number = request.getParameter("account");
		
		//��ѯ��Ʒ���ȡ���
		Map<String,String> purchoseOne ;
		String sql_role = "select * from commodity where id = ?";//��ҳ���ϻ�ȡ��׼ȷid��ȡ׼ȷ��������
		purchoseOne = DBUtils.dao().findOne(sql_role, account);
		String id = purchoseOne.get("count");
		String maxcount = purchoseOne.get("maxcount");
		int num = Integer.parseInt(number);
		int count1 = Integer.parseInt(id);
		int maxcount2 = Integer.parseInt(maxcount);
		
		int lastnum = count1-num;
		String lastCount = Integer.toString(lastnum);//�����޸�Ŀ��
		System.out.println(id);
		//��ȡ��½����Ϣ�Ա㶨λ

		Map<String,String> listman = (Map<String, String>) session.getAttribute("man");
		 String marketID = listman.get("marketID");//c�ӵ�½�߻�ȡ�ĳ���ID
		
		 
		 
		 
		 //��������������
		 session.setAttribute("less", "");
		if(num > count1){
			System.out.println("������");
			session.setAttribute("less", "��治��");
		}else {
			String sqlad = "insert into shipment(commodity_id,market_id,number,time) values(?,?,?,?)";
			int f = DBUtils.dao().update(sqlad,account, marketID,number,datetime);
			//�޸���Ʒ��
			String sql_up = "update commodity as c set c.count = ? where c.id = ? and c.marketID = ?";
			int n = DBUtils.dao().update(sql_up,lastCount ,account,marketID);//
			
			
		}
	
		
		request.getRequestDispatcher("Shipment.do").forward(request, response);
	}
}
