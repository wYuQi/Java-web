package com.tomcat.two;

import java.io.IOException;
import java.io.InputStream;

//*****请求资源路径*******
public class Request {

	private String url;
	
	public Request(InputStream in) throws IOException{
		byte[] buff = new byte[1024];
		int len = in.read(buff);//输入流每次读出信息放入buff；read（）方法返回值是读取的字节长度，如果len不是0则有读出
		if(len > 0){
			String str = new String(buff, 0, len);//拥有数组和长度len时，选取合适的String构造方法
			url = str.substring(str.indexOf("/"), str.indexOf("HTTP/1.1")-1);//切取出想要的路径
			System.out.println("--"+str+"--");
			System.out.println(url);
		}else
			System.out.println("bad");
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
