/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.ReservationDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 貸出、予約をするクラス
 * @author S.Sugimoto
 *
 */
public class ReservationAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 1060024652032952167L;

	/**
	 * ユーザー名
	 */
	private String name;

	/**
	 * 本のタイトル
	 */
	private String title;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * 借出日数
	 */
	private int day;

	/**
	 * 借出、予約をする為のメソッド
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		/*
		 * 予約がなければ、貸出にする
		 */
		String reservationGain = "×";
		ReservationDAO dao = new ReservationDAO();

		if(!(dao.judge(title))){
			reservationGain = "☆";
			dao.insert(name,title,reservationGain,day);
			result = SUCCESS;
			message = "手続きが完了しました。書籍を御利用下さい。";

		}else{

			/*
			 * 予約履歴に追加する
			 */
			if(dao.insert2(name,title,reservationGain) != 0){
				result = SUCCESS;
				message = "予約手続きが完了しましたので、順番をお待ち下さい。";
			}else{
				message = "予約手続きが失敗しました。";
			}
		}

		session.remove("title");
		session.remove("date");
		session.remove("lendDay");
		session.remove("returnDate");
		session.remove("count");
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

	/**
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day セットする day
	 */
	public void setDay(int day) {
		this.day = day;
	}

}
