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
 * 本の詳細を取得する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class ItemDetailDAO {

	/**
	 * 貸出状況
	 */
	private String reservationGain;

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
	 * 予約件数
	 */
	private int count;


	/**
	 * 既にその本を借出、予約していないか確認する為のメソッド
	 * @param name
	 * @param title
	 * @return result
	 */
	public boolean judge(String name, String title){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT reservation_gain from reservation_list WHERE borrow_name = ? AND book_title = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, title);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				reservationGain = rs.getString("reservation_gain");
			}

			//利用者、予約待ちがいるか判定
			if(reservationGain.equals("☆") || reservationGain.equals("△") || reservationGain.equals("×")){
				result = true;
			}

		} catch (Exception e) {
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
	 * @return reservationGain
	 */
	public String getReservationGain() {
		return reservationGain;
	}

	/**
	 * @param reservationGain セットする reservationGain
	 */
	public void setReservationGain(String reservationGain) {
		this.reservationGain = reservationGain;
	}


	/**
	 * 本の詳細を取得する為のメソッド
	 * @param title
	 * @return result
	 */
	public boolean select(String title){

		boolean result = false;;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT author,contents,img_path FROM book Where title = ?";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
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
	 * @return img_path
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param img_path セットする img_path
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	/**
	 * 予約件数を取得する為のメソッド
	 * @param title
	 * @return result
	 */
	public boolean select2(String title){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT reservation_gain FROM reservation_list WHERE book_title = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				String mark = rs.getString("reservation_gain");
				if(mark.equals("×") || mark.equals("☆") || mark.equals("△")){
					count++;
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
