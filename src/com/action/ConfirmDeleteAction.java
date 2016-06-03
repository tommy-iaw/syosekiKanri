/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 削除確認画面へ遷移する為のクラス
 * @author S.Sugimoto
 *
 */
public class ConfirmDeleteAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 2812889618444766897L;

	/**
	 * タイトル
	 */
	private String[] title;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 削除する本一覧リスト
	 */
	private ArrayList<Object> deleteList = new ArrayList<Object>();

	/**
	 * 削除確認画面へ遷移する為のメソッド
	 * @return result
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName2")){
			return "loginError";
		}

		//チェックした本のタイトルをリストに格納
		for(int i=0; i<title.length; i++){
			String book2 = title[i];
			deleteList.add(book2);
		}

		session.put("deleteList", deleteList);
		result = SUCCESS;
		return result;
	}

	/**
	 * @return title
	 */
	public String[] getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String[] title) {
		this.title = title;
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
	 * @return deleteList
	 */
	public ArrayList<Object> getDeleteList() {
		return deleteList;
	}

	/**
	 * @param deleteList セットする deleteList
	 */
	public void setDeleteList(ArrayList<Object> deleteList) {
		this.deleteList = deleteList;
	}

}
