/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ログアウトする為のクラス
 * @author S.Sugimoto
 *
 */
public class LogoutAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 4474837187221388478L;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * ログアウトする為のメソッド
	 */
	public String execute(){
		session.clear();
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
