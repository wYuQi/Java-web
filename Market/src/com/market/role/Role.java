package com.market.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DB.DBUtils;

/**
 * �û�����½����
 * �������sql���,��jsp��ȡ��ID��password
 * ����up�����û����룬����boolean
 * @author YuQi
 *
 */
public class Role {

	private static String sql = "SELECT * FROM USER";
	public boolean up(String ID,String password){
		List<Map<String,String>> userList = new ArrayList<>();
		userList = DBUtils.dao().find(sql);
		//�����ݿ��˺�����
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
