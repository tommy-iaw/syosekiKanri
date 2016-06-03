/*
 * タイトル：本詳細を格納する為の処理
 * 説明    ：本詳細を格納する
 * 著作権  ：Copyright(c) 2016 Syscom Technology inc.
 * 会社名  ：株式会社シスコム・テクノロジー
 * 変更履歴：
 *
 */
package com.dto;

/**
 * 本詳細を格納する為のクラス
 * @author S.Sugimoto
 * @since 1.0
 * @version 1.0
 */
public class ItemDTO {

	/**
	 * 本のタイトル
	 */
	private String title;

	/**
	 * 画像パス
	 */
	private String imgPath;

	/**
	 * @return title
	 */
	public String getTitle() {
		//System.out.println(title);
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return img_path
	 */
	public String getImgPath() {
		//System.out.println(imgPath);
		return imgPath;
	}

	/**
	 * @param img_path セットする img_path
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
