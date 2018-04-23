package com.market.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DB.DBUtils;

/**
 * 用户名登陆功能
 * 输入参数sql语句,在jsp获取的ID和password
 * 方法up检验用户密码，返回boolean
 * @author YuQi
 *
 */
public class Role {

	private static String sql = "SELECT * FROM USER";
	public boolean up(String ID,String password){
		List<Map<String,String>> userList = new ArrayList<>();
		userList = DBUtils.dao().find(sql);
		//查数据库账号密码
				boolean temp = false;
				for (Map<String, String> map : userList) {
					System.out.println(map.get("account"));
					if(map.get("account").equals(ID))
						if(map.get("password").equals(password))
							temp = true;
					
				}
				System.out.println(temp);
				return temp;
	}
}
