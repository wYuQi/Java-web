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
		
		//在内存中构造了一个图像数据的缓存区的实例对象
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		//所谓“画笔”
		Graphics2D g = (Graphics2D) image.getGraphics();
		//设置背景色
		setBackground(g) ;
		//设置边框
		setBorder(g);
		//设置干扰线
		setRandomLine(g);
		//存验证码
		String randomString = drawRandomDate(g);
		request.getSession().setAttribute("jpg", randomString);
		
		//把图片给客户机
		response.setContentType("image/jpeg");
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
	
	//华内容
	private String drawRandomDate(Graphics2D g){
		g.setColor(Color.red);
		//设置字体样式
		g.setFont(new Font("宋体",Font.BOLD,20));
		
		StringBuffer sbBuffer = new StringBuffer();
		//字符内容
		String base = "0123456789abcdefghi";
		int x = 5;
		for(int i=0;i<4;i++){
			//取单个字符
			String ch = base.charAt(new Random().nextInt(base.length()))+"";
			//弧度
			int du = new Random().nextInt()%30;
			g.rotate((du*Math.PI)/180,x,20);//将画笔以弧形画一个字
			//写入
			g.drawString(ch, x, 20);
			//将画笔还原
			g.rotate(-(du*Math.PI)/180, x, 20);
			//移动位置到下一位
			x += 30;
			sbBuffer.append(ch);
		}
		return sbBuffer.toString();
		
	}
	//设置背景色
	private void setBackground(Graphics g){
		//将画笔变成白色
		g.setColor(Color.white);
		//填充整个矩形
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	//设置边框
	private void setBorder(Graphics g){
		//画笔色
		g.setColor(Color.GREEN);
		
		//画边框
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
	}
	//干扰线
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
