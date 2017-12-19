package com.tomcat.two;

import java.io.IOException;
import java.io.OutputStream;

//*******��Ӧ�ķ�װ�ࣺд��Ϣ���ͻ���**********
public class Response {

	private OutputStream out = null;
	
	public Response(OutputStream out){
		this.out = out;
	}
	
	
	//*****��Ӧ��̬*******
	public void writeConten(String content) throws IOException{
		out.write(content.getBytes());
		out.flush();
		out.close();
	}
	//***��Ӧ��̬�������*****
	public void writeHTMLfile(String path) throws IOException{
		
		//�����ļ������࣬����̬��Դ�ļ�
		String htmlConte = FileUtils.getFileContent(path);
		/*****�����������/***
		out.write(htmlConte.getBytes());
		out.flush();
		out.close();
		*/
		writeConten(htmlConte);
	}
	
}
