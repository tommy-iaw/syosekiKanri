/**
 *
 */
package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.GoReturnDAO;
import com.dto.GoReturnDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 延長・返却画面へ遷移する為のクラス
 * @author S.Sugimoto
 *
 */
public class GoReturnAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 7997732178731780118L;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 借出している本の一覧を格納する為のリスト
	 */
	private ArrayList<GoReturnDTO> returnList = new ArrayList<>();

	/**
	 * 借出している本の一覧を取得する為のメソッド
	 * @return result
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		String reservationGain = "☆";
		GoReturnDAO dao = new GoReturnDAO();

		//借出している本の一覧を取得
		if(dao.select(name, reservationGain)){
			returnList = dao.getReturnList();
			result = SUCCESS;
		}else{
			try{
				if(message.isEmpty()){
					message = "該当する書籍はありません。もし、ありましたら管理まで問合せ下さい。";
				}
			}catch(Exception e){
				e.printStackTrace();
				message = "該当する書籍はありません。もし、ありましたら管理まで問合せ下さい。";
			}
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
	 * @return returnList
	 */
	public ArrayList<GoReturnDTO> getReturnList() {
		return returnList;
	}

	/**
	 * @param returnList セットする returnList
	 */
	public void setReturnList(ArrayList<GoReturnDTO> returnList) {
		this.returnList = returnList;
	}
}
