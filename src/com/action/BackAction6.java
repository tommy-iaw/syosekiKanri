/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約期間入力確認画面から予約期間入力画面へ戻る為のクラス
 * @author S.Sugimoto
 *
 */
public class BackAction6 extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -4217331445794684233L;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 名前以外のセッションを消す為のメソッド
	 */
	public String execute(){

		//セッション確認
		if(!session.containsKey("userName")){
			System.out.println(1);
			return "loginError";
		}

		session.remove("number");
		session.remove("bookTitle");
		session.remove("lendDate");
		session.remove("returnDate");
		session.remove("lendDay");

		return SUCCESS;
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