package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ty32";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "";
	
	private Connection conn;
	
	private PreparedStatement ps;
	
	private ResultSet rs;
	
	private static DBUtils db;
	
	private DBUtils(){
		//什么都不写
	}
	
	/**
	 * data access object
	 * @return
	 */
	public static DBUtils dao() {
		if(db == null) {
			db = new DBUtils();
		}
		return db;
	}
	
	
	/**
	 * 建立数据库链接
	 * @return
	 */
	private Connection getConn() {
		try {
		//1.加载驱动
			System.out.println("加载驱动。。。。");
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		//获取链接
		} catch (ClassNotFoundException e) {
			System.err.println("INFO：加载数据库驱动失败可能。com.mysql.jdbc.Driver 写错了！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("INFO：获取链接失败！可能是账号密码错误，可能是数据库名称错误。");
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public List<Map<String,String>> find(String sql,Object... params) {
		List<Map<String,String>> list = new ArrayList<>();
		try {
			ps = getConn().prepareStatement(sql);//预编译处理
			if(params != null && params.length > 0) {
				for (int i = 0;  i < params.length; i++) {
					ps.setObject(i + 1, params[i]);//给预编译语句对象传递参数
				}
			}
			System.out.println(ps);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();//结果集的结构
			int columnCount = rsmd.getColumnCount();//获取多少列
			while(rs.next()) {
				Map<String,String> map = new HashMap<>();
				for(int i = 1; i<= columnCount; i++) {
					map.put(rsmd.getColumnLabel(i), rs.getString(i));//rsmd.getColumnLabel(i)获取列名，rs.getString(i)获取列内容
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	/**
	 * 修改
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object... params) {
		int num = 0;
		try {
			ps = getConn().prepareStatement(sql);
			if(params != null && params.length > 0) {
				for (int i = 0;  i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			System.out.println(ps);
		num = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return num;
	}
	
	private void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Map<String,String> findOne(String sql,Object... params){
		List<Map<String,String>> list = find(sql,params);
		return list.size() == 0 ? null : list.get(0);
	}
}
