/*
 * タイトル：本削除の格納する為の処理
 * 説明    ：本削除の格納する
 * 著作権  ：Copyright(c) 2016 Syscom Technology inc.
 * 会社名  ：株式会社シスコム・テクノロジー
 * 変更履歴：
 *
 */
package com.dto;

/**
 * 本削除の格納する為のクラス
 * @author syscom_PC
 * @since 1.0
 * @version 1.0
 */
public class GoDeleteDTO {

	/**
	 * 登録番号
	 */
	private int bookNumber;

	/**
	 * タイトル
	 */
	private String title;

	/**
	 * @return bookNumber
	 */
	public int getBookNumber() {
		return bookNumber;
	}

	/**
	 * @param i セットする bookNumber
	 */
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
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
