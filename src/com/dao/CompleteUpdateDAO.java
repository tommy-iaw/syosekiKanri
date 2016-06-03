/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnector;

/**
 * 本更新処理を行う接続クラス
 * @author S.Sugimoto
 *
 */
public class CompleteUpdateDAO {

	/**
	 * 更新処理を行うメソッド
	 * @param bookNumber
	 * @param title
	 * @param titleKana
	 * @param author
	 * @param contents
	 * @param imgPath
	 * @param name
	 * @return count
	 */
	public int update(int bookNumber, String title, String titleKana, String author, String contents, String imgPath, String name){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE book SET title = ?, title_kana = ?, author =?, contents = ?, img_path = ?, edit_person = ?, edited_date = CURRENT_TIMESTAMP WHERE book_number = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, titleKana);
			ps.setString(3, author);
			ps.setString(4, contents);
			ps.setString(5, imgPath);
			ps.setString(6, name);
			ps.setInt(7, bookNumber);
			count = ps.executeUpdate();

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
