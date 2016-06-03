/**
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.ItemDTO;
import com.util.DBConnector;

/**
 * 本の一覧を取得する為の接続クラス
 * @author S.Sugimoto
 *
 */
public class ItemDAO {

	/**
	 * 本の一覧を取得する為のリスト
	 */
	private ArrayList<ItemDTO> itemList = new ArrayList<>();

	/**
	 * 本の一覧を取得する為のメソッド
	 * @return result
	 */
	public boolean select(){

		boolean result = false;;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT title,img_path FROM book WHERE delete_check = ? order by title_kana";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			//delete_checkがされていないもの
			ps.setString(1, "×");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDTO dto = new ItemDTO();
				dto.setTitle(rs.getString("title"));
				dto.setImgPath(rs.getString("img_path"));
				itemList.add(dto);
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
	 * @return itemList
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList セットする itemList
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}

}
