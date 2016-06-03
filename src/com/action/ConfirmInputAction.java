/**
 *
 */
package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 本追加画面、本更新画面の入力内容をバリデーションする為のクラス
 * @author S.Sugimoto
 *
 */
public class ConfirmInputAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 6925376213626474176L;

	/**
	 * タイトル
	 */
	private String title;

	/**
	 * タイトルのフリガナ
	 */
	private String titleKana;

	/**
	 * 著者名
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
	 * タイトル入力のエラーメッセージ
	 */
	private String titleError;

	/**
	 * タイトルフリガナ入力のエラーメッセージ
	 */
	private String titleKanaError;

	/**
	 * 著者名入力のエラーメッセージ
	 */
	private String authorError;

	/**
	 * 出版社入力のエラーメッセージ
	 */
	private String contentsError;

	/**
	 * 画像パス入力のエラーメッセージ
	 */
	private String imgPathError;

	/**
	 * 表示メッセージ
	 */
	private String message;

	/**
	 * セッション
	 */
	private Map<String, Object> session;


	/**
	 * バリデーションチェックする為のメソッド
	 * @return loginError ホーム画面へ遷移
	 *         inputConfirm 追加確認画面へ遷移
	 *         updateConfirm 更新確認画面へ遷移
	 *         inputError 本追加画面へ返し、エラー表示
	 *         updateError 本更新画面へ返し、エラー表示
	 *
	 */
	public String execute(){

		String result = "";

		//セッション確認
		if(!session.containsKey("userName2")){
			return "loginError";
		}

		//本追加か本更新か、本の登録番号をセッションされているか判定し、checkカウント
		int check = 0;
		if(session.get("bookNumber") != null){
			check++;
		}

		int count = 0; //入力エラーを数える

		if(title.length() > 100 || title.isEmpty()){
			titleError = "100文字以内でタイトルを入力して下さい。";
			count++;
		}

		if(titleKana.length() > 200 || titleKana.isEmpty() || (!titleKana.matches("^[ァ-ヶー]*$"))){
			titleKanaError = "200文字以内の全角カタカナでタイトルを入力して下さい。";
			count++;
		}

		if(author.length() > 100 || author.isEmpty()){
			authorError = "100文字以内で著者名を入力して下さい。";
			count++;
		}

		if(contents.length() > 100 || contents.isEmpty()){
			contentsError = "100文字以内で出版社を入力して下さい。";
			count++;
		}

		if(imgPath.length() > 255 || imgPath.isEmpty()){
			imgPathError = "255文字以内で画像パスを入力して下さい。";
			count++;
		}

		//count件数の判定
		if(count == 0){

			session.put("title", title);
			session.put("titleKana", titleKana);
			session.put("author", author);
			session.put("contents", contents);
			session.put("imgPath", imgPath);

			//checkで遷移先を判定
			if(check == 0){
				result = "inputConfirm";
			}else{
				result = "updateConfirm";
			}
		}else{
			//checkで遷移先を判定
			if(check == 0){
				result = "inputError";
			}else{
				result = "updateError";
			}
		}

		return result;
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
	 * @return titleKana
	 */
	public String getTitleKana() {
		return titleKana;
	}

	/**
	 * @param titleKana セットする titleKana
	 */
	public void setTitleKana(String titleKana) {
		this.titleKana = titleKana;
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
	 * @return imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath セットする imgPath
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * @return titleError
	 */
	public String getTitleError() {
		return titleError;
	}

	/**
	 * @param titleError セットする titleError
	 */
	public void setTitleError(String titleError) {
		this.titleError = titleError;
	}

	/**
	 * @return titleKanaError
	 */
	public String getTitleKanaError() {
		return titleKanaError;
	}

	/**
	 * @param titleKanaError セットする titleKanaError
	 */
	public void setTitleKanaError(String titleKanaError) {
		this.titleKanaError = titleKanaError;
	}

	/**
	 * @return authorError
	 */
	public String getAuthorError() {
		return authorError;
	}

	/**
	 * @param authorError セットする authorError
	 */
	public void setAuthorError(String authorError) {
		this.authorError = authorError;
	}

	/**
	 * @return imgPathError
	 */
	public String getImgPathError() {
		return imgPathError;
	}

	/**
	 * @param imgPathError セットする imgPathError
	 */
	public void setImgPathError(String imgPathError) {
		this.imgPathError = imgPathError;
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
	 * @return contentsError
	 */
	public String getContentsError() {
		return contentsError;
	}

	/**
	 * @param contentsError セットする contentsError
	 */
	public void setContentsError(String contentsError) {
		this.contentsError = contentsError;
	}

}
