/*
 * タイトル：本管理画面の為の格納する処理
 * 説明    ：本管理画面の為の格納する
 * 著作権  ：Copyright(c) 2016 Syscom Technology inc.
 * 会社名  ：株式会社シスコム・テクノロジー
 * 変更履歴：
 *
 */
package com.dto;

/**
 * 本管理画面の為の格納するクラス
 * @author S.Sugimoto
 * @since 1.0
 * @version 1.0
 */
public class GoAdminBookDTO {

	/**
	 * 本の登録番号
	 */
	private int bookNumber;

	/**
	 * タイトル
	 */
	private String title;

	/**
	 * 編集者
	 */
	private String editPerson;

	/**
	 * @return bookNumber
	 */
	public int getBookNumber() {
		return bookNumber;
	}

	/**
	 * @param bookNumber セットする bookNumber
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

	/**
	 * @return editPerson
	 */
	public String getEditPerson() {
		return editPerson;
	}

	/**
	 * @param editPerson セットする editPerson
	 */
	public void setEditPerson(String editPerson) {
		this.editPerson = editPerson;
	}
}
