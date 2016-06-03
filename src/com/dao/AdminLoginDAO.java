/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnector;

/**
 * 管理者ログイン判定する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class AdminLoginDAO {

	/**
	 * 管理者名
	 */
	private String adminName;

	/**
	 * ログイン判定をする為のメソッド
	 * @param id
	 * @param password
	 * @return result
	 */
	public boolean check(String id, String password){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT name FROM admin WHERE id = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				adminName = rs.getString("name");
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @return adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName セットする adminName
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}