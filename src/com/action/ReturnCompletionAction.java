/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.ReturnCompletionDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 返却処理をする為のクラス
 * @author S.Sugimoto
 *
 */
public class ReturnCompletionAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -6745960604149105215L;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 本のタイトル
	 */
	private String bookTitle;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * 表示メッセージ表示メッセージ2
	 */
	private String message2;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 返却処理をする為のメソッド
	 */
	public String execute(){

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		String result = ERROR;
		String reservationGain = "○";
		ReturnCompletionDAO dao  = new ReturnCompletionDAO();

		/*
		 * 返却処理
		 */
		if(dao.update(reservationGain, name, bookTitle) == 0){
			message = "返却処理に失敗しました。";
			return result;
		}

		/*
		 * 次の予約者がいるか調べる
		 */
		if(!(dao.select(bookTitle))){
			result = SUCCESS;
			message = "返却処理をしました。有難うございます。";
			return result;
		}

		int number = dao.getNumber();
		String nextName = dao.getNextName();
		reservationGain = "△";

		/*
		 * 次の予約者が借出処理を出来るようにする
		 */
		if(dao.update2(reservationGain, number) > 0){
			result = SUCCESS;
			message = "返却処理をしました。";
			message2 = "次の予約者である" + nextName + "さんに、社員ページへログインをし、借出期間の入力をする旨、御連絡をお願い致します。";
		}else{
			message = "返却処理に失敗しました。";
		}

		return result;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle セットする bookTitle
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
	 * @return message2
	 */
	public String getMessage2() {
		return message2;
	}

	/**
	 * @param message2 セットする message2
	 */
	public void setMessage2(String message2) {
		this.message2 = message2;
	}

}
