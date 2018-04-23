package com.market.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class L
 */
@WebServlet("/L")
public class L extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  

	private static final int WIDTH = 120;
	private static final int HEIGHT = 35;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/heml;charser=UTF-8");
		
		//���ڴ��й�����һ��ͼ�����ݵĻ�������ʵ������
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		//��ν�����ʡ�
		Graphics2D g = (Graphics2D) image.getGraphics();
		//���ñ���ɫ
		setBackground(g) ;
		//���ñ߿�
		setBorder(g);
		//���ø�����
		setRandomLine(g);
		//����֤��
		String randomString = drawRandomDate(g);
		request.getSession().setAttribute("jpg", randomString);
		
		//��ͼƬ���ͻ���
		response.setContentType("image/jpeg");
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
	
	//������
	private String drawRandomDate(Graphics2D g){
		g.setColor(Color.red);
		//����������ʽ
		g.setFont(new Font("����",Font.BOLD,20));
		
		StringBuffer sbBuffer = new StringBuffer();
		//�ַ�����
		String base = "0123456789abcdefghi";
		int x = 5;
		for(int i=0;i<4;i++){
			//ȡ�����ַ�
			String ch = base.charAt(new Random().nextInt(base.length()))+"";
			//����
			int du = new Random().nextInt()%30;
			g.rotate((du*Math.PI)/180,x,20);//�������Ի��λ�һ����
			//д��
			g.drawString(ch, x, 20);
			//�����ʻ�ԭ
			g.rotate(-(du*Math.PI)/180, x, 20);
			//�ƶ�λ�õ���һλ
			x += 30;
			sbBuffer.append(ch);
		}
		return sbBuffer.toString();
		
	}
	//���ñ���ɫ
	private void setBackground(Graphics g){
		//�����ʱ�ɰ�ɫ
		g.setColor(Color.white);
		//�����������
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	//���ñ߿�
	private void setBorder(Graphics g){
		//����ɫ
		g.setColor(Color.GREEN);
		
		//���߿�
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
	}
	//������
	private void setRandomLine(Graphics g){
		g.setColor(Color.black);
		for(int i=0;i<5;i++){
			int x1 = 0;
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = WIDTH;
			int y2 = y1;
					
		}
	}

}
