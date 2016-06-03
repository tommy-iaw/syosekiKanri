/**
 *
 */
package com.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 貸出、予約を確認するクラス
 * @author S.Sugimoto
 *
 */
public class ConfirmReservationAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 1183295577269012176L;

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
	 * 返却予定日
	 */
	private String  returnDate;

	/**
	 * 予約件数
	 */
	private int count;

	/**
	 * 借出、予約をする為のメソッド
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		int day2 = 0;

		if(count == 0){

			/*
			 * 借出日数のバリデーション
			 */
			try{
				day2 = Integer.parseInt(day);
			}catch(Exception e){
				e.printStackTrace();
				message = "1～30の半角数字を入力して下さい。";
				return result;
			}

			if(day2 < 1 || day2 > 30){
				message = "1～30の半角数字を入力して下さい。";
				return result;
			}

			Calendar date = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String date2 = sdf.format(date.getTime());
			session.put("date", date2);
			session.put("lendDay", day2);

			date.add(Calendar.DATE, day2);
			returnDate = sdf.format(date.getTime());
			session.put("returnDate", returnDate);
		}

		result = SUCCESS;
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

	/**
	 * @return day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day セットする day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return returnDate
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate セットする returnDate
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
