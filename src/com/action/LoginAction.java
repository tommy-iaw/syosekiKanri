/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.LoginDAO;
import com.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログインする為のクラス
 * @author S.Sugimoto
 *
 */
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -578531068131930836L;

	/**
	 * ID
	 */
	private String id;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * エラーメッセージ
	 */
	private String message;

	/**
	 * 順番が回ってきた予約本を格納したリスト
	 */
	private ArrayList<LoginDTO> bookList = new ArrayList<>();

	/**
	 * ログイン判定をし、通常成功ならSUCCESS、成功し、予約本の利用順番が来ていた場合inputLendPeriod、
	 * 失敗ならばERRORを返すメソッド
	 * @return result
	 */
	public String execute(){

		String result = ERROR;

		/*
		 * LendActionからチェインした際の判定if文
		 */
		if(session.containsKey("userName")){
			String userName = (String)session.get("userName");
			String reservationGain = "△";
			LoginDAO dao = new LoginDAO();

			if(dao.select(userName,reservationGain)){
				bookList = dao.getBookList();
				result = "inputLendPeriod";
				return result;
			}else{
				result = SUCCESS;
				return result;
			}
		}

		/*
		 * IDとパスワードのバリデーション
		 */
		if(id.length() > 4){
			message = "IDまたはパスワードが違います。";
			return result;
		}

		if(password.length() > 6){
			message = "IDまたはパスワードが違います。";
			return result;
		}

		int id2 = 0;

		try{
			id2 = Integer.parseInt(id);
		}catch(Exception e){
			e.printStackTrace();
			message = "IDまたはパスワードが違います。";
			return result;
		}

		/*
		 * ログイン判定
		 */
		LoginDAO dao = new LoginDAO();

		if(dao.check(id, password)){
			name = dao.getName();
			session.put("userName", name);
			String reservationGain = "△";

			/*
			 * 利用順番の来た本があるかどうか判定
			 */
			if(dao.select(name,reservationGain)){
				bookList = dao.getBookList();
				result = "inputLendPeriod";
				return result;
			}
			result = SUCCESS;

		}else{
			message = "IDまたはパスワードが違います！";
			return result;
		}
		return result;

	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return bookList
	 */
	public ArrayList<LoginDTO> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList セットする bookList
	 */
	public void setBookList(ArrayList<LoginDTO> bookList) {
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

}
