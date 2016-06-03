/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.GoUpdateBookDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 本更新画面へ遷移する為のクラス
 * @author S.Sugimoto
 *
 */
public class GoUpdateBookAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -7046667599444714543L;

	/**
	 * 本の登録番号
	 */
	private int bookNumber;

	/**
	 * 本のタイトル
	 */
	private String title;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/** )
	 * 本更新画面へ遷移する為のメソッド
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName2")){
			return "loginError";
		}

		//本のデータ取得
		GoUpdateBookDAO dao = new GoUpdateBookDAO();

		if(dao.select(title)){

			String titleKana = dao.getTitleKana();
			String author = dao.getAuthor();
			String contents = dao.getContents();
			String imgPath = dao.getImgPath();

			session.put("bookNumber", bookNumber);
			session.put("title", title);
			session.put("titleKana", titleKana);
			session.put("author", author);
			session.put("contents", contents);
			session.put("imgPath", imgPath);

			result = SUCCESS;

		}else{
			message = "DBとの接続エラーです。";
		}

		return result;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
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
	 * @return bookNumber
	 */
	public int getBookNumber() {
		return bookNumber;
	}

	/**
	 * @param bookNumber セットする bookNumber
	 */
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
}
