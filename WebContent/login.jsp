<!-- 予備のログイン画面 -->
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
</head>
<body>
    <div id="container">
        <div class="header">
            <h2>書籍貸出</h2>
        </div>
        <br>
        <br>
        <div class="text-center">
            <h3>ログイン入力</h3>
            <br>
            <s:actionmessage />
            <s:form action="LoginAction" method="post" class="text-center">
            <label for="name">ID</label>
            <s:textfield name="id" placeholder="ID" id="name" value=""/>
            <label for="password">パスワード</label>
            <s:textfield name="password" placeholder="パスワード" id="password" value="" />
            <s:submit value="ログイン" class="btn btn-primary"/>
            </s:form>
            <br>
            <a href="https://www.google.co.jp">googleへ戻る</a>
        </div>
        <br>
        <br>

    </div>
</body>
</html>



