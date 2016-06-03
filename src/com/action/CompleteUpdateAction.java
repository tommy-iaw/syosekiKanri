/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.CompleteUpdateDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 更新処理をする為のクラス
 * @author S.Sugimoto
 *
 */
public class CompleteUpdateAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -3940424900097951896L;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * 更新処理をする為のメソッド
	 * @return result
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName2")){
			return "loginError";
		}

		int bookNumber = (int) session.get("bookNumber");
		String title = (String) session.get("title");
		String titleKana = (String) session.get("titleKana");
		String author = (String) session.get("author");
		String contents = (String) session.get("contents");
		String imgPath = (String) session.get("imgPath");
		String name = (String) session.get("userName2");

		CompleteUpdateDAO dao = new CompleteUpdateDAO();

		//本データの更新
		if(dao.update(bookNumber, title, titleKana, author, contents, imgPath, name) != 0){
			message ="本を更新しました！";
			session.remove("bookNumber");
			session.remove("title");
			session.remove("titleKana");
			session.remove("author");
			session.remove("contents");
			session.remove("imgPath");
			result = SUCCESS;
		}else{
			message ="DAOで失敗しました。";
		}

		return result;
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