package com.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import com.hospital.jdbc.Jdbc;
import com.hospital.model.Model_user;

public class Dao_user {
	
	static List<Model_user> list = new ArrayList<Model_user>();
	static Jdbc jdbc = new Jdbc();
	static int i = 0;
	
	//查询数据库，返回结果集
	public List<Model_user> query(){
		System.out.println("+++dao层++query++");
		String sql = "select * from user";
		list = jdbc.query(sql);
		return list;
	}
	
	//增添数据库，返回int i
	public int add_user(Model_user user){
		System.out.println("+++dao层++add_user++");
		String sql = "insert into user values(null,"+user.getName()+","+user.getPassword()+","+user.getTimestamp()+")";
		i = jdbc.CUD(sql);
		return i;
	}
	
	//更新数据库 ，返回int i;
	public int update_user(Model_user user){
		System.out.println("+++dao层++update_user++");
		String sql = "update ueser set password="+user.getPassword()+"where id="+user.getId()+"and name="+user.getName();
		i = jdbc.CUD(sql);
		return i;
	}
	
	//删除数据库，返回int i;
	public int delete_user(int id){
		System.out.println("+++dao层++delete_user++");
		String sql = "delete from user where id="+id;
		i = jdbc.CUD(sql);
		return i;
	}
	
	//查询数据库 通过ID ，
	public int findUserById(int id){
		System.out.println("+++dao层++findUserById++");
		String sql = "select id,name,password,timestamp from user where id="+id;
		i = jdbc.CUD(sql);
		return i ;
	}
	
	
}
