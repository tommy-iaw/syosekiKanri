/*
 * タイトル：予約入力画面に必要な情報を格納する為の処理
 * 説明    ：予約入力画面に必要な情報を格納する
 * 著作権  ：Copyright(c) 2016 Syscom Technology inc.
 * 会社名  ：株式会社シスコム・テクノロジー
 * 変更履歴：
 *
 */
package com.dto;

/**
 * 予約入力画面に必要な情報を格納する為のクラス
 * @author S.Sugimoto
 * @since 1.0
 * @version 1.0
 */
public class LoginDTO {

	/**
	 * 予約履歴番号
	 */
	private int number;

	/**
	 * 本のタイトル
	 */
	private String bookTitle;

	/**
	 * 前の人が本を返した日
	 */
	private String lendDate;

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

}