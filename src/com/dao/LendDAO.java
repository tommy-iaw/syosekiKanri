/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnector;

/**
 * 利用履歴を更新する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class LendDAO {

	/**
	 * 利用履歴を更新する為のメソッド
	 * @param number
	 * @param reservationGain
	 * @param returnDate
	 * @return count
	 */
	public int update(int number, String reservationGain, String lendDate, String returnDate){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE reservation_list SET reservation_gain = ?, reserved_date = CURRENT_TIMESTAMP ,lend_date = ?, return_date = ? "
				+ "WHERE number = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reservationGain);
			ps.setString(2, lendDate);
			ps.setString(3, returnDate);
			ps.setInt(4, number);
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