/*
 * タイトル：予約履歴を格納する為の処理
 * 説明    ：予約履歴を格納する
 * 著作権  ：Copyright(c) 2016 Syscom Technology inc.
 * 会社名  ：株式会社シスコム・テクノロジー
 * 変更履歴：
 *
 */
package com.dto;

/**
 * 予約履歴を格納する為のクラス
 * @author S.Sugimoto
 * @since 1.0
 * @version 1.0
 */
public class MyReservationDTO {

	/**
	 * 本のタイトル
	 */
	private String bookTitle;

	/**
	 * 借出状況チェック
	 */
	private String reservationGain;

	/**
	 * 予約をした日
	 */
	private String reservedDate;

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
	 * @return reservationGain
	 */
	public String getReservationGain() {
		return reservationGain;
	}

	/**
	 * @param reservationGain セットする reservationGain
	 */
	public void setReservationGain(String reservationGain) {
		this.reservationGain = reservationGain;
	}

	/**
	 * @return reservedDate
	 */
	public String getReservedDate() {
		return reservedDate;
	}

	/**
	 * @param reservedDate セットする reservedDate
	 */
	public void setReservedDate(String reservedDate) {
		this.reservedDate = reservedDate;
	}

}