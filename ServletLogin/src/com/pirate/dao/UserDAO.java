package com.pirate.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pirate.bean.User;
import com.pirate.util.DBUtil;

public class UserDAO {

	public static int saveUser(User user) throws ClassNotFoundException {
		int status = 0;
		try {
			Connection conn = DBUtil.getCon();
			String insertQuery = "INSERT INTO userS(id, name, username, password) values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUsername());		
			pstmt.setString(4, user.getPassword());
			status = pstmt.executeUpdate();
			System.out.println("Data Inserted...");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println(e1);
		} catch (IOException e2) {
			e2.printStackTrace();
			System.out.println("\nIO Probem");
		}		
		System.out.println(status);
		return status;
	}
	
	public static List<User> getAllUser() throws ClassNotFoundException{
		List<User> list = new ArrayList<>();
		try {
			Connection conn = DBUtil.getCon();
			String query = "SELECT * FROM users";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
				list.add(user);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static int editUser(User u) throws ClassNotFoundException{
		int status=0;
		try {
			Connection conn = DBUtil.getCon();
			String query = "UPDATE users SET name=?, password=?, username=? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getUsername());		
			pstmt.setString(4, u.getId());
			status = pstmt.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static User userById(String id) throws ClassNotFoundException {
		User user = new User();
		try {
			Connection conn = DBUtil.getCon();
			String query = "select * from users where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
