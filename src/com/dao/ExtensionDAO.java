/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.util.DBConnector;

/**
 * 貸出延長を更新する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class ExtensionDAO {

	/**
	 * 貸出状況のチェック
	 */
	private String reservationGain;

	/**
	 * 既に予約が入っているか確認するメソッド
	 * @param title
	 * @return result
	 */
	public boolean judge(String title){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT reservation_gain from reservation_list WHERE  book_title = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				reservationGain = rs.getString("reservation_gain");
			}
			if(reservationGain.equals("×")){
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
	 * 貸出延長を更新する為のメソッド
	 * @param name
	 * @param title
	 * @param reservationGain
	 * @param day
	 * @return count
	 */
	public int update(String name, String title, String reservationGain, int day){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE reservation_list SET return_date = ? WHERE borrow_name = ? "
				+ "AND book_title = ? AND reservation_gain = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			/*
			 * 返却予定日の挿入
			 */
			Calendar date = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			date.add(Calendar.DATE, day);
			String date2 = sdf.format(date.getTime());

			ps.setString(1, date2);
			ps.setString(2, name);
			ps.setString(3, title);
			ps.setString(4, reservationGain);
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
