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
 * 返却処理をする為の接続クラス
 * @author S.Sugimoto
 *
 */
public class ReturnCompletionDAO {

	/**
	 * 予約履歴番号
	 */
	private int number;

	/**
	 * 次の予約者氏名
	 */
	private String nextName;

	/**
	 * 返却処理をする為のメソッド
	 * @param reservationGain
	 * @param name
	 * @param bookTitle
	 * @return count
	 */
	public int update(String reservationGain, String name, String bookTitle){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE reservation_list SET reservation_gain = ?, return_date = CURRENT_TIMESTAMP WHERE borrow_name = ? AND book_title = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reservationGain);
			ps.setString(2, name);
			ps.setString(3, bookTitle);
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

	/**
	 * 次の予約者がいるか調べる為のメソッド
	 * @param bookTitle
	 * @return ewsult
	 */
	public boolean select(String bookTitle){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT number,borrow_name,reservation_gain FROM reservation_list WHERE book_title = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bookTitle);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				number = rs.getInt("number");
				nextName = rs.getNString("borrow_name");
				String mark = rs.getString("reservation_gain");
				if(mark.equals("×")){
					result = true;
					return result;
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
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number セットする number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return nextName
	 */
	public String getNextName() {
		return nextName;
	}

	/**
	 * @param nextName セットする nextName
	 */
	public void setNextName(String nextName) {
		this.nextName = nextName;
	}


	/**
	 * 次の予約者が借出処理を出来るようにする為のメソッド
	 * @param reservationGain
	 * @param number
	 * @return count
	 */
	public int update2(String reservationGain, int number){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE reservation_list SET reservation_gain = ?, lend_date = CURRENT_TIMESTAMP  WHERE number = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reservationGain);
			ps.setInt(2, number);
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
