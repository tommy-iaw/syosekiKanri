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

import com.dto.LoginDTO;
import com.util.DBConnector;

/**
 * ログイン判定する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class LoginDAO {

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 借出状況チェック
	 */
	private String reservationGain;

	/**
	 * 利用順番の来た本を格納する為のリスト
	 */
	private ArrayList<LoginDTO> bookList = new ArrayList<>();

	/**
	 * ログイン判定をする為のメソッド
	 * @param id
	 * @param password
	 * @return result
	 */
	public boolean check(String id, String password){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT name FROM user WHERE id = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString("name");
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 利用順番の来た本があるかチェックし、リストに格納する為のメソッド
	 * @param name
	 * @param reservationGain
	 * @return result
	 */
	public boolean select(String name, String reservationGain){

		boolean result = false;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT number,book_title,reservation_gain,lend_date from reservation_list "
				+ "WHERE  borrow_name = ? AND reservation_gain = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, reservationGain);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				reservationGain = rs.getString("reservation_gain");
				LoginDTO dto = new LoginDTO();

				//利用順番の来た本の内容をリストに格納
				if(reservationGain.equals("△")){
					dto.setNumber(rs.getInt("number"));
					dto.setBookTitle(rs.getString("book_title"));
					String lendDate = new SimpleDateFormat("yyyy年MM月dd日").format(rs.getTimestamp("lend_date"));
					dto.setLendDate(lendDate);
					bookList.add(dto);
					result = true;
				}
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
	 * @return bookList
	 */
	public ArrayList<LoginDTO> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList セットする bookList
	 */
	public void setBookList(ArrayList<LoginDTO> bookList) {
		this.bookList = bookList;
	}

}
