/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.ExtensionDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約延長をする為のクラス
 * @author S.Sugimoto
 *
 */
public class ExtensionAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 6430851267528488781L;

	/**
	 * ユーザー名
	 */
	private String name;

	/**
	 * 本のタイトル
	 */
	private String bookTitle;

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
	private String day;

	/**
	 * 本の借出を延長する為のメソッド
	 * @return ressult
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		int day2 = 0;

		//借出日数のバリデーション
		try{
			day2 = Integer.parseInt(day);
		}catch(Exception e){
			e.printStackTrace();
			message = "1～30の数字を入力して下さい。";
			return result;
		}

		if(day2 < 1 || day2 > 30){
			message = "1～30の数字を入力して下さい。";
			return result;
		}

		String reservationGain = "×";
		ExtensionDAO dao = new ExtensionDAO();

		//延長できるか判定
		if(!(dao.judge(bookTitle))){
			reservationGain = "☆";
			dao.update(name,bookTitle,reservationGain,day2);
			result = SUCCESS;
			message = "手続きが完了しました。引き続き書籍を御利用下さい。";
			return result;
		}
		message = "予約が入っている為、延長する事が出来ませんでした。";
		return result;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * @return
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param
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
	 * @param day セットする day
	 */
	public void setDay(String day) {
		this.day = day;
	}

}