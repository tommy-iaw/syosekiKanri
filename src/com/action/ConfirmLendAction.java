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
 * 利用順番になり、本借りる為のクラス
 * @author S.Sugimoto
 *
 */
public class ConfirmLendAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 212205734918227444L;

	/**
	 * 予約履歴番号
	 */
	private int number;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * 入力した年
	 */
	private String year;

	/**
	 * 入力した月
	 */
	private String month;

	/**
	 * 入力した日
	 */
	private String day;

	/**
	 * 借出日数
	 */
	private String lendDay;

	/**
	 * 借出順番が来た日
	 */
	private String lendDate;

	/**
	 * 本のタイトル
	 */
	private String title;

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

		/*
		 *  入力情報のバリデーション
		 */
		int year2 = 0;
		int month2 = 0;
		int day2 = 0;
		int lendDay2 = 0;

		try{
			year2 = Integer.parseInt(year);
			month2 = Integer.parseInt(month);
			day2 = Integer.parseInt(day);
			lendDay2 = Integer.parseInt(lendDay);
		}catch(Exception e){
			e.printStackTrace();
			message = "全ての入力欄に数字を入力して下さい!!";
			return result;
		}

		Calendar calendar = Calendar.getInstance();
	    int thisYear = calendar.get(Calendar.YEAR);

		if(year2 > (thisYear + 1) || year2 < thisYear || month2 > 12 || day2 > 31 || lendDay2 < 1 || lendDay2 > 30){
			message = "規定範囲の数字を入力して下さい！";
			return result;
		}

		/*
		 * 入力された年月日が範囲内かどうか確認
		 */
		String inputDate = year +"年"+ month + "月" + day +"日";
		Calendar inputCalendar = Calendar.getInstance();
		Calendar lendCalendar = Calendar.getInstance();
		Calendar limitCalendar = Calendar.getInstance();
		try {
			inputCalendar.setTime(new SimpleDateFormat("yyyy年MM月dd日").parse(inputDate));
		    lendCalendar.setTime(new SimpleDateFormat("yyyy年MM月dd日").parse(lendDate));
			limitCalendar.setTime(new SimpleDateFormat("yyyy年MM月dd日").parse(lendDate));
		    limitCalendar.add(Calendar.DATE, 7);

		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

		int compare = lendCalendar.compareTo(inputCalendar);
		int compare2 = inputCalendar.compareTo(limitCalendar);

		if(compare <= 0 && compare2 <= 0){

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String lendDate = sdf.format(inputCalendar.getTime());
			inputCalendar.add(Calendar.DATE, lendDay2);
			String returnDate = sdf.format(inputCalendar.getTime());

			session.put("number", number);
			session.put("bookTitle", title);
			session.put("lendDate", lendDate);
			session.put("returnDate", returnDate);
			session.put("lendDay", lendDay2);

			result = SUCCESS;

		}else{
			message = "規定から1週間以内の日付を入力して下さい！";
		}
		return result;
	}

	/**
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number セットする number
	 */
	public void setNumber(int number) {
		this.number = number;
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
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year セットする year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month セットする month
	 */
	public void setMonth(String month) {
		this.month = month;
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
	 * @return lendDay
	 */
	public String getLendDay() {
		return lendDay;
	}

	/**
	 * @param lendDay セットする lendDay
	 */
	public void setLendDay(String lendDay) {
		this.lendDay = lendDay;
	}

	/**
	 * @return lendDate
	 */
	public String getLendDate() {
		return lendDate;
	}

	/**
	 * @param lendDate セットする lendDate
	 */
	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
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
}
