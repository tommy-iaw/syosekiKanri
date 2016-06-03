/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.dto.GoReturnDTO;
import com.util.DBConnector;

/**
 * 借出している本の一覧を取得する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class GoReturnDAO {

	/**
	 * 借出している本の一覧を格納する為のリスト
	 */
	private ArrayList<GoReturnDTO> returnList = new ArrayList<>();

	/**
	 * 借出している本の一覧を取得する為のメソッド
	 * @param name
	 * @param reservationGain
	 * @return result
	 */
	public boolean select(String name, String reservationGain){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT book_title,lend_date,return_date FROM reservation_list WHERE borrow_name = ? AND reservation_gain = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, reservationGain);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				GoReturnDTO dto = new GoReturnDTO();
				dto.setBookTitle(rs.getString("book_title"));
				String date = new SimpleDateFormat("yyyy年MM月dd日").format(rs.getTimestamp("lend_date"));
				dto.setLendDate(date);
				String date2 = new SimpleDateFormat("yyyy年MM月dd日").format(rs.getTimestamp("return_date"));
				dto.setReturnDate(date2);
				returnList.add(dto);
				result = true;
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
	 * @return returnList
	 */
	public ArrayList<GoReturnDTO> getReturnList() {
		return returnList;
	}

	/**
	 * @param returnList セットする returnList
	 */
	public void setReturnList(ArrayList<GoReturnDTO> returnList) {
		this.returnList = returnList;
	}
}
