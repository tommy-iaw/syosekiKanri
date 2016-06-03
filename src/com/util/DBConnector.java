/*
 * タイトル：MySQLの指定したデータベースに接続する為の処理
 * 説明    ：MySQLの指定したデータベースに接続する。
 * 著作権  ：Copyright(c) 2016 Syscom Technology inc.
 * 会社名  ：株式会社シスコム・テクノロジー
 * 変更履歴：
 *
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

 /**
 * MySQLの指定したデータベースに接続する為のクラス
 * @author S.Sugimoto
 * @since 1.0
 * @version 1.0
 */
 public class DBConnector {

 	/**
 	 * MySQLのドライバー名
 	 */
     private static String driverName = "com.mysql.jdbc.Driver";

     /**
 	 * MySQLのkinnosawaというデータベースのURL
 	 */
     private static String url = "jdbc:mysql://localhost/rensyuu";

     /**
 	 * MySQLのユーザー名
 	 */
     private static String user = "root";

     /**
 	 * MySQLのパスワード
 	 */
     private static String pass = "mysql";

     /**
      * 指定したデータベースへのコネクションを取得する為のメソッド
      * @return con 指定したデータベースへのコネクション
      */
     public static Connection getConnection() {

    	 Connection con = null;

    	 try {
    		 Class.forName(driverName);
    		 con = DriverManager.getConnection(url,user,pass);
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 }
    	 return con;
     }

}