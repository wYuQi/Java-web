package com.tomcat.two;

import java.io.IOException;
import java.io.OutputStream;

//*******相应的封装类：写信息给客户端**********
public class Response {

	private OutputStream out = null;
	
	public Response(OutputStream out){
		this.out = out;
	}
	
	
	//*****响应动态*******
	public void writeConten(String content) throws IOException{
		out.write(content.getBytes());
		out.flush();
		out.close();
	}
	//***响应静态输出请求*****
	public void writeHTMLfile(String path) throws IOException{
		
		//调用文件工具类，读静态资源文件
		String htmlConte = FileUtils.getFileContent(path);
		/*****解决代码重用/***
		out.write(htmlConte.getBytes());
		out.flush();
		out.close();
		*/
		writeConten(htmlConte);
	}
	
}
