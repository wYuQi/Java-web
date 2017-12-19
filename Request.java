package com.tomcat.two;

import java.io.IOException;
import java.io.InputStream;

//*****������Դ·��*******
public class Request {

	private String url;
	
	public Request(InputStream in) throws IOException{
		byte[] buff = new byte[1024];
		int len = in.read(buff);//������ÿ�ζ�����Ϣ����buff��read������������ֵ�Ƕ�ȡ���ֽڳ��ȣ����len����0���ж���
		if(len > 0){
			String str = new String(buff, 0, len);//ӵ������ͳ���lenʱ��ѡȡ���ʵ�String���췽��
			url = str.substring(str.indexOf("/"), str.indexOf("HTTP/1.1")-1);//��ȡ����Ҫ��·��
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
