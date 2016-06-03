/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.GoDeleteDTO;
import com.util.DBConnector;

/**
 * 本削除画面へ遷移する為データを接続するクラス
 * @author S.Sugimoto
 *
 */
public class GoDeleteDAO {

	/**
	 * 本の一覧を取得する為のリスト
	 */
	private ArrayList<GoDeleteDTO> bookList = new ArrayList<>();

	/**
	 * 本の一覧を取得する為のメソッド
	 * @return result
	 */
	public boolean select(){

		boolean result = false;;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT book_number,title FROM book WHERE delete_check = ? order by book_number desc";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			//delete_checkがされていないもの
			ps.setString(1, "×");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				GoDeleteDTO dto = new GoDeleteDTO();
				dto.setBookNumber(rs.getInt("book_number"));
				dto.setTitle(rs.getString("title"));
				bookList.add(dto);
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
	 * @return bookList
	 */
	public ArrayList<GoDeleteDTO> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList セットする bookList
	 */
	public void setBookList(ArrayList<GoDeleteDTO> bookList) {
		this.bookList = bookList;
	}
}
