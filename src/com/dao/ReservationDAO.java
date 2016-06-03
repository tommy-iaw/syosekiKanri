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
 * 借出、予約をする為の接続クラス
 * @author S/Sugimoto
 *
 */
public class ReservationDAO {

	/**
	 * 借出状況チェック
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
			//借りている人、予約待ちの人がいるか判定
			if(reservationGain.equals("☆") || reservationGain.equals("×")){
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
	 * 貸出履歴を入力する為のメソッド(直ぐに借りることが出来る場合)
	 * @param name
	 * @param title
	 * @param reservationGain
	 * @return count
	 */
	public int insert(String name, String title, String reservationGain, int day){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO reservation_list(borrow_name, book_title, reservation_gain, lend_date, return_date)values(?,?,?,CURRENT_TIMESTAMP,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, reservationGain);

			/*
			 * 返却予定日の挿入
			 */
			Calendar date = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			date.add(Calendar.DATE, day);
			String date2 = sdf.format(date.getTime());

			ps.setString(4, date2);
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
	 * 予約履歴を入力する為のメソッド(予約待ちの場合)
	 * @param name
	 * @param title
	 * @param reservationGain
	 * @return count
	 */
	public int insert2(String name, String title, String reservationGain){

		int count = 0;
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO reservation_list(borrow_name, book_title, reservation_gain)values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, reservationGain);
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