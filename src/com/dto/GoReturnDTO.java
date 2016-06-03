/*
 * タイトル：延長・返却画面に必要な情報を格納する為のクラス
 * 説明    ：延長・返却画面に必要な情報を格納する
 * 著作権  ：Copyright(c) 2016 Syscom Technology inc.
 * 会社名  ：株式会社シスコム・テクノロジー
 * 変更履歴：
 *
 */
package com.dto;

/**
 * 延長・返却画面に必要な情報を格納する為のクラス
 * @author S.Sugimoto
 * @since 1.0
 * @version1.0
 */
public class GoReturnDTO {

	/**
	 * 本のタイトル
	 */
	private String bookTitle;

	/**
	 * 借出日
	 */
	private String lendDate;

	/**
	 * 返却予定日
	 */
	private String returnDate;

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

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
