package com.hospital.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.Model_user;

public class Jdbc {
	
	static String url = "jdbc:mysql://localhost:3306/hospital?CharacterEncoding=utf-8";
	static String user = "root";
	static String password = "root";
	
	static Connection cn = null;
	static Statement st = null;
	static ResultSet rs = null;
	List<Model_user> list = new ArrayList<Model_user>();
	
	//查询数据  返回 结果集 query();
	public List<Model_user> query(String sql){
		System.out.println("--jdbc层--查询数据库第一步");
		try {
			cn = DriverManager.getConnection(url, user, password);
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				list.add(new Model_user(rs.getInt(1) ,rs.getString(2),rs.getString(3),rs.getTimestamp(4)));
			System.out.println("--jdbc层--查询数据返回结果--"+list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/* 添加/更新/删除 数据库操作方法 CUD() */
	public int CUD(String sql){
		System.out.println("--JDBC层--增删改第一步--");
		int i = 0;
		try {
			cn = DriverManager.getConnection(url, user, password);
			st = cn.createStatement();
			 i = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--JDBC层--返回结果i--"+i);
		return i;
	}
	

}
