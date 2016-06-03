<!-- 管理者　本管理画面 -->
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
<title>本管理画面</title>
</head>
<body>
        <div class="header2">
            <h2>本管理画面</h2>
            <h3 class="aka"><strong><s:property value="message" /></strong></h3>
        </div>
        <div class="main2">
            <a href="insert_book.jsp"><input type="button" value="本を追加"></a>
            <br>
            <br>
            <s:form action="GoDeleteAction" method="post" class="red">
            	<input type="submit" value="削除画面へ">
            </s:form>
            <br>
            <br>
	            <table border="1" width="70%" cellspacing="10" cellpadding="10" bordercolor="#333333">
	                    <tr>
	                        <th class="text-center"><h4>登録番号</h4></th>
	                        <th class="text-center"><h4>タイトル</h4></th>
	                        <th class="text-center"><h4>最終編集者</h4></th>
	                        <th class="text-center"><h4>編集</h4></th>
	                    </tr>
	           		<s:iterator value="bookList">
		                <tr>
	                        <td><h4><s:property value="bookNumber" /></h4></td>
	                        <td><h4><s:property value="title" /></h4></td>
	                        <td><h4><s:property value="editPerson" /></h4></td>
	                        <td>
	                        	<form action="GoUpdateBookAction" method="post">
	                        		<div class="adminEdit">
	                        			<input type="submit" value="編集">
	                        		</div>
	                        		<input type="hidden" name="title" value="<s:property value="title" />"/>
	                        		<input type="hidden" name="bookNumber" value="<s:property value="bookNumber" />"/>
	                        	</form>
	                        </td>
	                    </tr>
	                </s:iterator>
	            </table>
	        <br>
            <br>
        </div>
       	<div class="footer3">
       		<s:form action="AdminLogoutAction" class="third">
            	<input type="submit" value="管理者ログアウト" />
        	</s:form>
        	<br>
   			<a href="admin_home.jsp"><input type="button" value="管理者ホームへ戻る"></a>
    	</div>
</body>
</html>