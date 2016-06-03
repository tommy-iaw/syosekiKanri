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
 * 本更新画面へ遷移する為データを接続するクラス
 * @author S.Sugimoto
 *
 */
public class GoUpdateBookDAO {

	/**
	 * タイトルのフリガナ
	 */
	private String titleKana;

	/**
	 * 著者
	 */
	private String author;

	/**
	 * 出版社
	 */
	private String contents;

	/**
	 * 画像パス
	 */
	private String imgPath;

	/**
	 * 本の詳細を取得する為のメソッド
	 * @param title
	 * @return result
	 */
	public boolean select(String title){

		boolean result = false;;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT title_kana,author,contents,img_path FROM book Where title = ?";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				titleKana = rs.getString("title_kana");
				author = rs.getString("author");
				contents = rs.getString("contents");
				imgPath = rs.getString("img_path");
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @return titleKana
	 */
	public String getTitleKana() {
		return titleKana;
	}

	/**
	 * @param titleKana セットする titleKana
	 */
	public void setTitleKana(String titleKana) {
		this.titleKana = titleKana;
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author セットする author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents セットする contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * @return imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath セットする imgPath
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}