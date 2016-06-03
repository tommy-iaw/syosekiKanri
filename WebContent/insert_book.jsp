<!-- 管理者　本追加画面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" http-equiv="X-UA-Compatible" content="IE-edge">
<!-- Bootstrap -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<script src="js/back.js"></script>
<title>本追加画面</title>
</head>
<body>
   <div class="header2">
        <h1><strong>本追加ページ</strong></h1>
    </div>
    <div class="main2">
    	<h3 class="aka"><strong><s:property value="message" /></strong></h3>
    	<h3>＊全て必須入力となります。</h3>
        <form action="ConfirmInputAction" class="first" method="post">
            <table width="50%" cellspacing="5" cellpadding="5">
                <tr>
                    <th class="text-center"><h4>タイトル</h4></th>
                    <td class="text-center">
                    	<input type="text" name="title" placeholder="ex)スッキリわかるJava入門 入門編"
                    	size="40">
                    </td>
                </tr>
                <tr>
                	<th></th>
                	<td><h3 class="aka"><s:property value="titleError"/></h3></td>
                </tr>
                <tr>
                    <th class="text-center"><h4>本のフリガナ</h4></th>
                    <td class="text-center">
                    	<input type="text" name="titleKana"
                    	placeholder="ex)スッキリワカルジャヴァニュウモンニュウモンヘン" size="40">
                    </td>
                </tr>
                <tr>
                	<th></th>
                	<td><h3 class="aka"><s:property value="titleKanaError"/></h3></td>
                </tr>
                <tr>
                    <th class="text-center"><h4>著者名</h4></th>
                    <td class="text-center">
                    	<input type="text" name="author" placeholder="ex)山田太郎" size="40">
                    </td>
                </tr>
                <tr>
                	<th></th>
                	<td><h3 class="aka"><s:property value="authorError"/></h3></td>
                </tr>
                <tr>
                    <th class="text-center"><h4>出版社</h4></th>
                    <td class="text-center">
                    	<input type="text" name="contents" placeholder="ex)集英社" size="40">
                    </td>
                </tr>
                <tr>
                	<th></th>
                	<td><h3 class="aka"><s:property value="contentsError"/></h3></td>
                </tr>
                <tr>
                    <th class="text-center"><h4>画像パス</h4></th>
                    <td class="text-center">
                    	<input type="text" name="imgPath" placeholder="ex)image.jpg" size="40">
                    </td>
                </tr>
                <tr>
                	<th></th>
                	<td><h3 class="aka"><s:property value="imgPathError"/></h3></td>
                </tr>
            </table>
            <br>
            <br>
            <input type="submit" value="確認画面へ" />
        </form>
    </div>
    <div class="footer3">
        <s:a href="GoAdminBookAction"><input type="button" value="戻る"></s:a>
    </div>
</body>
</html>