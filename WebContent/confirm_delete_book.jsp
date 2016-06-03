<!-- 管理者 本削除確認画面 -->
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
<title>本削除確認画面</title>
</head>
<body>
   <div class="header2">
        <h1><strong>削除確認ページ</strong></h1>
    </div>
    <div class="main2">
    	<h3 class="aka"><strong><s:property value="message" /></strong></h3>
        <form action="CompleteDeleteAction" class="first">
            <table>
            	<s:iterator value="deleteList" >
                	<tr>
                		<th></th>
                		<th><h4><s:property /></h4></th>
                		<th></th>
                	</tr>
                </s:iterator>
            </table>
            <br>
            <h3 class="aka">本当に削除しますか？</h3>
            <input type="submit" value="削除" />
        </form>
    </div>
    <div class="footer3">
        <s:a href="BackAction5"><input type="button" value="戻る"></s:a>
    </div>
</body>
</html>