/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.ItemDAO;
import com.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 本の一覧を表示させる為のクラス
 * @author S.Sugimoto
 *
 */
public class ItemAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 1393825909783695256L;

	/**
	 * 本の一覧を格納する為のリスト
	 */
	private ArrayList<ItemDTO> itemList = new ArrayList<>();

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * 本の一覧を取得する為のメソッド
	 * return result
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		//登録してある本のデータをｊ持って来る
		ItemDAO dao = new ItemDAO();

		if(dao.select()){
			itemList = dao.getItemList();
			result = SUCCESS;
		}else{
			message = "本のデータを取得出来ませんでした。";
			return result;
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

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
