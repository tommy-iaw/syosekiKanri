/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.CompleteDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 削除処理（非表示）をする為のクラス
 * @author S.Sugimoto
 *
 */
public class CompleteDeleteAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -7088811821295509370L;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 本を削除する為のメソッド
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName2")){
			return "loginError";
		}

		ArrayList<Object> deleteList = new ArrayList<>();
		deleteList = (ArrayList<Object>) session.get("deleteList");

		CompleteDeleteDAO dao = new CompleteDeleteDAO();

		//削除処理
		if(dao.delete(deleteList) != 0){
			session.remove("deleteList");
			message = "削除完了しました！";
			result = SUCCESS;
		}else{
			message = "エラーがありました。";
		}

		return result;
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

}
