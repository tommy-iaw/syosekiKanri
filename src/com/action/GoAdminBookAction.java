/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.GoAdminBookDAO;
import com.dto.GoAdminBookDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 本管理画面へ遷移する為のクラス
 * @author S.Sugimoto
 *
 */
public class GoAdminBookAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 8974850968556892841L;

	/**
	 * 本の一覧を格納する為のリスト
	 */
	private ArrayList<GoAdminBookDTO> bookList = new ArrayList<>();

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 本の一覧を取得する為のメソッド
	 * return result
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName2")){
			return "loginError";
		}

		//本一覧の取得
		GoAdminBookDAO dao = new GoAdminBookDAO();

		if(dao.select()){
			bookList = dao.getBookList();
			result = SUCCESS;
		}else{
			message = "本のデータを取得出来ませんでした。";
			return result;
		}

		return result;
	}

	/**
	 * @return bookList
	 */
	public ArrayList<GoAdminBookDTO> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList セットする bookList
	 */
	public void setBookList(ArrayList<GoAdminBookDTO> bookList) {
		this.bookList = bookList;
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
