<!-- 予約期間確認画面 -->
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
<title>管理者本追加確認画面</title>
</head>
<body>
   <div class="header2">
        <h1><strong>追加確認ページ</strong></h1>
    </div>
    <div class="main2">
    	<h3 class="aka"><strong><s:property value="message" /></strong></h3>
        <form action="LendAction" class="first">
            <table width="50%" cellspacing="20" cellpadding="20" border="1" bordercolor="#333333">
                <tr>
                    <th><h4>借出人</h4></th>
                    <td><h4><%=session.getAttribute("userName")%></h4></td>
                </tr>
                <tr>
                    <th><h4>タイトル</h4></th>
                    <td><h4><%=session.getAttribute("bookTitle")%></h4></td>
                </tr>
                <tr>
                    <th><h4>借出日</h4></th>
                    <td><h4><%=session.getAttribute("lendDate")%></h4></td>
                </tr>
                <tr>
                    <th><h4>返却予定日</h4></th>
                    <td><h4 class="aka"><%=session.getAttribute("returnDate")%></h4></td>
                </tr>
                <tr>
                    <th><h4>借出日数</h4></th>
                    <td><h4><%=session.getAttribute("lendDay")%></h4></td>
                </tr>
            </table>
            <br>
            <br>
            <input type="submit" value="確定" />
        </form>
    </div>
    <div class="footer3">
        <s:a href="BackAction6"><input type="button" value="戻る"></s:a>
    </div>
</body>
</html>