package com.market.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DB.DBUtils;

/**
 * Manager锟教筹拷Role
 * 锟斤拷锟斤拷员锟斤拷
 * 锟斤拷确锟斤拷锟斤拷1
 * @author YuQi
 *
 */
public class Manager extends Role {

	private static String sql = "SELECT	s.id,	s.account,	s.`password`,	s.roleId,	s.`name`,s.marketID,s.addess,s.age,s.createDate,s.tel,	m.marketname,	a.rolename FROM	`user` AS s,	role AS a,	market as m WHERE	s.roleId = a.id and s.marketID = m.id";
	boolean temp = false;
	private static Map<String,String> userMap ;
	private static List<Map<String,String>> userList ;
	public Manager(String ID,String password){
		System.out.println("管理员尝试");
		
		userList = DBUtils.dao().find(sql);
		//锟斤拷锟斤拷菘锟斤拷撕锟斤拷锟斤拷锟�
				
				for (Map<String, String> map : userList) {
					System.out.println(map.get("account"));
					if(map.get("account").equals(ID))
						if(map.get("password").equals(password)){
							temp = true;
							userMap = map;
						}
					
				}
	}
	public boolean up(){
		
		
				System.out.println(temp);
				return temp;
	}
	
	//返回单条结果
	public Map<String,String> map(){
		
	
		return userMap;
		
	}
	
	//返回结果集
	public List<Map<String,String>> list(){
		
		
			return userList;
		
		
		
	}

}
