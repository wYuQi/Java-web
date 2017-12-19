package com.tomcat.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//服务类
public class Mytomcat {
	
	//计数器
	private static int count;
	
	public static void main(String[] args) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = format.format(new Date());
		
		ServerSocket ss = null;//服务器
		Socket socket = null;//客户端
		
		try {
			ss = new ServerSocket(8000);//构造函数需要int型的参数作为端口port
			System.out.println("服务器已经初始化，等待客户端连接中");
			while(true){
				socket = ss.accept();//获取客户端,其内部含有输入流
				count++;
				System.out.println("第"+count+"次连接服务器");
				
	//*********************获取请求信息*************************
				//获取socket内的输入流
				InputStream in = socket.getInputStream();
				
				Request request = new Request(in);
				
	//******************发送服务返回信息*******************************
				//获取socket中的输出流
				OutputStream out = socket.getOutputStream();
				
				Response response = new Response(out);
				
	//********************业务逻辑***********************************
				String url = request.getUrl();
				//判断这个是不是静态资源，静态：html、css、img、js
				if(url.endsWith(".html")){
					response.writeHTMLfile(url.substring(1));
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
