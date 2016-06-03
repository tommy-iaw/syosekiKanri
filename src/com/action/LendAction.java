/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.LendDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 利用順番になり、本借りる為のクラス
 * @author S.Sugimoto
 *
 */
public class LendAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 5309583680655796629L;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * 借出登録をする為のメソッド
	 * @return result
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		int number = (int) session.get("number");
		String lendDate = (String) session.get("lendDate");
		String returnDate = (String) session.get("returnDate");
		String reservationGain = "☆";
		LendDAO dao = new LendDAO();

		//予約履歴の更新
		if((dao.update(number, reservationGain, lendDate, returnDate)) != 0){
			session.remove("number");
			session.remove("bookTitle");
			session.remove("lendDate");
			session.remove("returnDate");
			session.remove("lendDay");
			message = "手続きが完了しました。期間になったら書籍を御利用下さい。";
			result = SUCCESS;
		}else{
			message = "何らかのエラーがありました";
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
