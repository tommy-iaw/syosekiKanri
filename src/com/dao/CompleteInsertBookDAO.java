/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnector;

/**
 * 本追加をする為の接続クラス
 * @author S.Sugimoto
 *
 */
public class CompleteInsertBookDAO {

	/**
	 * 追加処理を行うメソッド
	 * @param title
	 * @param titleKana
	 * @param author
	 * @param contents
	 * @param imgPath
	 * @param name
	 * @return count
	 */
	public int insert(String title, String titleKana, String author, String contents, String imgPath, String name){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO book(title, title_kana, author, contents, img_path, edit_person)values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, titleKana);
			ps.setString(3, author);
			ps.setString(4, contents);
			ps.setString(5, imgPath);
			ps.setString(6, name);
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
