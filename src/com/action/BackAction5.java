/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 削除確認画面から本削除画面へ戻る為のクラス
 * @author syscom_PC
 *
 */
public class BackAction5 extends ActionSupport implements SessionAware{

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
		if(!session.containsKey("userName2")){
			return "loginError";
		}

		session.remove("deleteList");
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