package com.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import com.hospital.jdbc.Jdbc;
import com.hospital.model.Model_user;

public class Dao_user {
	
	static List<Model_user> list = new ArrayList<Model_user>();
	static Jdbc jdbc = new Jdbc();
	static int i = 0;
	
	//��ѯ���ݿ⣬���ؽ����
	public List<Model_user> query(){
		System.out.println("+++dao��++query++");
		String sql = "select * from user";
		list = jdbc.query(sql);
		return list;
	}
	
	//�������ݿ⣬����int i
	public int add_user(Model_user user){
		System.out.println("+++dao��++add_user++");
		String sql = "insert into user values(null,"+user.getName()+","+user.getPassword()+","+user.getTimestamp()+")";
		i = jdbc.CUD(sql);
		return i;
	}
	
	//�������ݿ� ������int i;
	public int update_user(Model_user user){
		System.out.println("+++dao��++update_user++");
		String sql = "update ueser set password="+user.getPassword()+"where id="+user.getId()+"and name="+user.getName();
		i = jdbc.CUD(sql);
		return i;
	}
	
	//ɾ�����ݿ⣬����int i;
	public int delete_user(int id){
		System.out.println("+++dao��++delete_user++");
		String sql = "delete from user where id="+id;
		i = jdbc.CUD(sql);
		return i;
	}
	
	//��ѯ���ݿ� ͨ��ID ��
	public int findUserById(int id){
		System.out.println("+++dao��++findUserById++");
		String sql = "select id,name,password,timestamp from user where id="+id;
		i = jdbc.CUD(sql);
		return i ;
	}
	
	
}
