package com.tomcat.two;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//�ļ������࣬������ȡ��̬�ļ�
public class FileUtils {

	// ������Ҫ�Ĳ�����·��
	public static String getFileContent(String path) {

		StringBuffer sb = new StringBuffer();
		// �ַ������ֽ����������ַ���
		FileReader fread = null;
		java.io.BufferedReader br = null;
		try {
			fread = new FileReader(path);// ·��ȡ��ͨ��
			br = BufferedReader(fread);// ȡ��������ȡͨ��
			String line = br.readLine();// ��һ��
			while (line != null) {//����sb
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fread.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return sb.toString();
	}

	private static java.io.BufferedReader BufferedReader(FileReader fread) {
		// TODO Auto-generated method stub
		return null;
	}
}
