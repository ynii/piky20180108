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
	
	//��ѯ����  ���� ����� query();
	public List<Model_user> query(String sql){
		System.out.println("--jdbc��--��ѯ���ݿ��һ��");
		try {
			cn = DriverManager.getConnection(url, user, password);
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				list.add(new Model_user(rs.getInt(1) ,rs.getString(2),rs.getString(3),rs.getTimestamp(4)));
			System.out.println("--jdbc��--��ѯ���ݷ��ؽ��--"+list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/* ���/����/ɾ�� ���ݿ�������� CUD() */
	public int CUD(String sql){
		System.out.println("--JDBC��--��ɾ�ĵ�һ��--");
		int i = 0;
		try {
			cn = DriverManager.getConnection(url, user, password);
			st = cn.createStatement();
			 i = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--JDBC��--���ؽ��i--"+i);
		return i;
	}
	

}
