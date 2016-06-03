<!-- 管理者ホーム画面 -->
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
<title>管理者ホーム画面</title>
</head>
<body>
   <div class="header2">
        <h1><strong>管理者ページ</strong></h1>
    </div>
    <div class="main2">
    	<h3 class="aka"><strong><s:property value="message" /></strong></h3>
        <form action="" class="first">
            <input type="submit" value="自己紹介管理へ" />
        </form>
        <form action="GoAdminBookAction" class="first">
            <input type="submit" value="書籍管理へ" />
        </form>
        <form action="" class="first">
            <input type="submit" value="勉強会管理へ" />
        </form>
        <form action="" class="first">
            <input type="submit" value="サークル活動管理へ" />
        </form>
    </div>
    <div class="footer2">
        <s:form action="AdminLogoutAction" class="second">
            <input type="submit" value="管理者ログアウト" />
        </s:form>
    </div>
</body>
</html>