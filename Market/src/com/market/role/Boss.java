package com.market.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DB.DBUtils;

/**
 * 锟斤拷锟斤拷页锟斤拷
 * 锟斤拷确锟斤拷锟斤拷2
 * @author YuQi
 *
 */
public class Boss extends Role{
	private static String sql = "select * from boss";
		
	boolean temp = false;
	private static Map<String,String> userMap ;
	private static List<Map<String,String>> userList ;
		public Boss(){
			System.out.println("经理尝试");
		}
		
		public boolean up(String ID,String password){
			
			userList = DBUtils.dao().find(sql);
			//锟斤拷锟斤拷菘锟斤拷撕锟斤拷锟斤拷锟�
					
					for (Map<String, String> map : userList) {
						System.out.println(map.get("ID"));
						if(map.get("ID").equals(ID))
							if(map.get("password").equals(password))
								temp = true;
						
					}
					System.out.println(temp);
					return temp;
		}
		
		//返回单条结果
		public Map<String,String> map(){
			
			if(temp){
				userMap = userList.get(0);
			}
			return userMap;
			
		}
		
		//返回结果集
		public List<Map<String,String>> list(){
			
			
				return userList;
			
			
			
		}

}
