package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.dto.LoginDto;
import mysql.db.DbConnect;

public class LoginDao {
	DbConnect db = new DbConnect();
	//CREATE
	
	//ȸ�����
	public boolean insertUser(LoginDto dto) {
		boolean check = false;
		Connection conn = db.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into usertest ( pw, name, email, mobile, addr, postcode, registerday) values ( ?, ?, ?, ?, ?, ?, now())";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getMobile());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getPostcode());
			int num = ps.executeUpdate();
			if(num != 0) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.dbClose(ps, conn);
		}
		return check;
	}
		
		
	
	
	//READ
	
	//�������� üũ
	public boolean userInfoCheck(int number, String data) {
		//ã����� �������� ����  1 name, 2 email, 3 pw
		
		//�� �����Ϳ� �´� ���� �Է�
		
		boolean sameUserInfo =false;
		Connection conn = db.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		switch (number) {
		case 1:
			sql = "select * from usertest where name = ?";
			break;
		case 2:
			sql = "select * from usertest where email = ?";
			break;
		case 3:
			sql = "select * from usertest where pw = ?";
			break;
		}
		try {
			ps = conn.prepareStatement(sql);
			//���ε�
			ps.setString(1, data);
			//����
			rs = ps.executeQuery();
			if(rs.next()) {
				sameUserInfo = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, ps, conn);
		}
		
		return sameUserInfo;
	}
	
	//�������� ���
	public LoginDto getUserInfo(int number, String data) {
		//ã����� �������� ����  1 name, 2 email, 3 pw
		
		//�� �����Ϳ� �´� ���� �Է�
		
		Connection conn = db.getConnection();
		LoginDto dto = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		switch (number) {
		case 1:
			sql = "select * from usertest where name = ?";
			break;
		case 2:
			sql = "select * from usertest where email = ?";
			break;
		case 3:
			sql = "select * from usertest where pw = ?";
			break;
		}
		try {
			ps = conn.prepareStatement(sql);
			//���ε�
			ps.setString(1, data);
			//����
			rs = ps.executeQuery();
			if(rs.next()) {
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String name = rs.getString("name");
				dto = new LoginDto(pw, email, name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, ps, conn);
		}
		
		return dto;
	}
	
	
	//��й�ȣüũ
	public String getPw(String email) {
		String pw = "";
		Connection conn = db.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select pw from usertest where email = ?";
		try {
			ps = conn.prepareStatement(sql);
			//���ε�
			ps.setString(1, email);
			//����
			rs = ps.executeQuery();
			if(rs.next()) {
				pw = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, ps, conn);
		}
		
		return pw;
	}
	
	
	
	
	//UPDATE
	
	//��й�ȣ����
	public boolean updatePw(String email, String pw) {
		boolean check = false;
		Connection conn = db.getConnection();
		PreparedStatement ps = null;
		String sql = "update usertest set pw = ? where email = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setString(2, email);
			int num = ps.executeUpdate();
			if(num != 0) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.dbClose(ps, conn);
		}
		
		return check;
		
	}
	
	
	
	
	//DELETE
	
	
	

}
