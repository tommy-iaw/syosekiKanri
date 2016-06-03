/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.MyReservationDAO;
import com.dto.MyReservationDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約履歴を表示する為のクラス
 * @author shin
 *
 */
public class MyReservationAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 2679045497454077905L;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * セッション
	 */
	private Map<String, Object>session;

	/**
	 * 表示させるメッセージ
	 */
	private String message;

	/**
	 * 予約履歴を格納する為のリスト
	 */
	private ArrayList<MyReservationDTO> historyList = new ArrayList<>();

	/**
	 * 予約履歴を取得する為のメソッド
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		MyReservationDAO dao = new MyReservationDAO();

		//予約履歴があるかどうか判定
		if(dao.show(name)){
			historyList = dao.getHistoryList();
			result = SUCCESS;
		}else{
			message = "予約履歴が一件もない為、遷移出来ませんでした。";
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
