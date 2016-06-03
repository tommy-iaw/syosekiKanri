/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.ItemDetailDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 本の詳細を表示するクラス
 * @author S.Sugimoto
 *
 */
public class ItemDetailAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 2002312737271040824L;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 本のタイトル
	 */
	private String title;

	/**
	 * 著者
	 */
	private String author;

	/**
	 * 出版社
	 */
	private String contents;

	/**
	 * 画像パス
	 */
	private String imgPath;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * 予約件数
	 */
	private int count;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 本の詳細を取得する為のメソッド
	 * @return result
	 */
	public String execute(){

		String result = ERROR;

		//セッション確認
		if(!session.containsKey("userName")){
			return "loginError";
		}

		//自ら予約してあるかどうか確認
		ItemDetailDAO dao = new ItemDetailDAO();

		if(dao.judge(name,title)){
			message = "その本はあなたの貸出番、あるいは既に予約済です。予約履歴を確認して下さい。";
			return result;
		}

		try{
			if(title.equals("0")){
				title = (String) session.get("title");
			}else{
				session.put("title", title);
			}
			}catch(Exception e){
				e.printStackTrace();
				title = (String) session.get("title");
		}

		//本の詳細を持ってくる
		if(dao.select(title)){
			author = dao.getAuthor();
			contents = dao.getContents();
			imgPath = dao.getImgPath();
		}else{
			message = "本のデータを取得できませんでした。";
			session.remove("title");
			return result;
		}

		//該当書籍の予約件数の確認
		dao.select2(title);
		count = dao.getCount();
		session.put("count", count);
		result = SUCCESS;

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
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author セットする author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents セットする contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * @return img_path
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param img_path セットする img_path
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
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