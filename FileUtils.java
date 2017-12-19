package com.tomcat.two;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//文件工具类，用来读取静态文件
public class FileUtils {

	// 方法需要的参数是路径
	public static String getFileContent(String path) {

		StringBuffer sb = new StringBuffer();
		// 字符流和字节流，采用字符流
		FileReader fread = null;
		java.io.BufferedReader br = null;
		try {
			fread = new FileReader(path);// 路径取到通道
			br = BufferedReader(fread);// 取用容器收取通道
			String line = br.readLine();// 读一行
			while (line != null) {//加入sb
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
