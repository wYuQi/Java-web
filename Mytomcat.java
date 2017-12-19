package com.tomcat.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//������
public class Mytomcat {
	
	//������
	private static int count;
	
	public static void main(String[] args) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = format.format(new Date());
		
		ServerSocket ss = null;//������
		Socket socket = null;//�ͻ���
		
		try {
			ss = new ServerSocket(8000);//���캯����Ҫint�͵Ĳ�����Ϊ�˿�port
			System.out.println("�������Ѿ���ʼ�����ȴ��ͻ���������");
			while(true){
				socket = ss.accept();//��ȡ�ͻ���,���ڲ�����������
				count++;
				System.out.println("��"+count+"�����ӷ�����");
				
	//*********************��ȡ������Ϣ*************************
				//��ȡsocket�ڵ�������
				InputStream in = socket.getInputStream();
				
				Request request = new Request(in);
				
	//******************���ͷ��񷵻���Ϣ*******************************
				//��ȡsocket�е������
				OutputStream out = socket.getOutputStream();
				
				Response response = new Response(out);
				
	//********************ҵ���߼�***********************************
				String url = request.getUrl();
				//�ж�����ǲ��Ǿ�̬��Դ����̬��html��css��img��js
				if(url.endsWith(".html")){
					response.writeHTMLfile(url.substring(1));
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
