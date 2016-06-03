/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.dto.MyReservationDTO;
import com.util.DBConnector;

/**
 * 予約履歴を取得する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class MyReservationDAO {

	/**
	 * 予約履歴を格納する為のリスト
	 */
	private ArrayList<MyReservationDTO> historyList = new ArrayList<>();

	/**
	 * 予約履歴を格納する為のメソッド
	 * @param name
	 * @return result
	 */
	public boolean show(String name){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT book_title,reservation_gain,reserved_date FROM reservation_list WHERE borrow_name = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyReservationDTO  dto = new MyReservationDTO();
				dto.setBookTitle(rs.getString("book_title"));
				dto.setReservationGain(rs.getString("reservation_gain"));
				String date = new SimpleDateFormat("yyyy年MM月dd日").format(rs.getTimestamp("reserved_date"));
				dto.setReservedDate(date);
				historyList.add(dto);
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
	 * @return historyList
	 */
	public ArrayList<MyReservationDTO> getHistoryList() {
		return historyList;
	}

	/**
	 * @param historyList セットする historyList
	 */
	public void setHistoryList(ArrayList<MyReservationDTO> historyList) {
		this.historyList = historyList;
	}

}
