/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConnector;

/**
 * 本を削除（非表示）処理を行う接続クラス
 * @author S.Sugimoto
 *
 */
public class CompleteDeleteDAO {

	/**
	 * 非表示処理を行うメソッド
	 * @param deleteList
	 * @return count
	 */
	public int delete(ArrayList<Object> deleteList){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE book SET delete_check = ?, edited_date = CURRENT_TIMESTAMP WHERE title = ?";

		try {
			for(int i=0; i<deleteList.size(); i++){
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, "○");
				String title = (String) deleteList.get(i);
				ps.setString(2, title);
				count = ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}
