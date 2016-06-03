/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.GoDeleteDAO;
import com.dto.GoDeleteDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 本削除画面」へ遷移する為のクラス
 * @author S.Sugimoto
 *
 */
public class GoDeleteAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -6733879650167206198L;

	/**
	 * 本の一覧を格納する為のリスト
	 */
	private ArrayList<GoDeleteDTO> bookList = new ArrayList<>();

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

		//本の一覧の取得
		GoDeleteDAO dao = new GoDeleteDAO();

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
	public ArrayList<GoDeleteDTO> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList セットする bookList
	 */
	public void setBookList(ArrayList<GoDeleteDTO> bookList) {
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
