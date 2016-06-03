<!-- 予約待ちが回ってきた際に、ログイン画面から遷移する、予約期間入力画面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>予約期間入力画面</title>
</head>
<body>
	<div class="header2">
		<h2>＊借出期間入力画面＊</h2>
		<h3>御手数ですが、1冊ずつ処理を行ってください。</h3>
	</div>
	<div class="main2">
		<h3 class="aka"><strong><s:property value="message" /></strong></h3>
		<br>
		<br>
		<s:iterator value="bookList">
			<h3><strong>タイトル：<s:property value="bookTitle" /></strong></h3>
			<br>
			<h4>借出予定日</h4>
			<br>
			<form method="post" action="ConfirmLendAction">
				<input type="text" value="" name="year" placeholder="ex) 20××">年
				<br>
				<input type="text" value="" name="month" placeholder="ex) 10">月
				<br>
				<input type="text" value="" name="day" placeholder="ex) 30">日
				<br>
				<h4 class="aka"><strong>＊<s:property value="lendDate"/>から、1週間以内の日付を入力して下さい。</strong></h4>
				<br>
				<h4>借出期間</h4>
				<br>
				<input type="text" value="" name="lendDay" placeholder="1～30を入力して下さい">日間
				<br>
	            <h4>＊最大30日間　(ex)30日間→30</h4>
				<br>
				<br>
				<input type="submit" value="入力" class="btn btn-primary"/>
				<input type="hidden" name="number" value="<s:property value="number"/>"/>
                <input type="hidden" name="lendDate" value="<s:property value="lendDate"/>"/>
                <input type="hidden" name="title" value="<s:property value="bookTitle"/>"/>
			</form>
		</s:iterator>
	</div>
	<div class="footer3">
		<a href="home.jsp"><button>ホーム画面へ</button></a>
		<br>
		<br>
		<s:form action="LogoutAction" class="third">
            <input type="submit" value="ログアウト" />
        </s:form>
	</div>
</body>
</html>