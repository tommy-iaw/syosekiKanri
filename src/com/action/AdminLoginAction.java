/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.AdminLoginDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理者ログインする為のクラス
 * @author S.Sugimoto
 *
 */
public class AdminLoginAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -8880590163213086174L;

	/**
	 * 管理者ID
	 */
	private String id;

	/**
	 * 管理者パスワード
	 */
	private String password;

	/**
	 * 管理者名
	 */
	private String adminName;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 管理者ログインする為のメソッド
	 */
	public String execute(){

		String result = ERROR;

		/*
		 * IDとパスワードのバリデーション
		 */
		if(id.length() > 4){
			message = "IDまたはパスワードが違います。";
			return result;
		}

		if(password.length() > 11){
			message = "IDまたはパスワードが違います。";
			return result;
		}

		int id2 = 0;

		try{
			id2 = Integer.parseInt(id);
		}catch(Exception e){
			e.printStackTrace();
			message = "IDまたはパスワードが違います。";
			return result;
		}


		/*
		 * ログイン判定
		 */
		AdminLoginDAO dao = new AdminLoginDAO();

		if(dao.check(id, password)){
			adminName = dao.getAdminName();
			String userName = (String) session.get("userName") ;
			if(userName.equals(adminName)){
				session.put("userName2", adminName);
				message = "管理者にログインしました！";
				result = SUCCESS;
			}else{
				message = "IDまたはパスワードが違います。";
			}
		}else{
			message = "IDまたはパスワードが違います。";
		}

		return result;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName セットする adminName
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
