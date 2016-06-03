<!-- 管理者　本削除画面 -->
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
<title>本削除画面</title>
</head>
<body>
        <div class="header2">
            <h2>本削除画面</h2>
            <h3 class="aka"><strong><s:property value="message" /></strong></h3>
        </div>
        <div class="main2">
        	<form action="ConfirmDeleteAction" method="post">
	            <table border="1" width="70%" cellspacing="5" cellpadding="5" bordercolor="#333333">
	                    <tr>
	                    	<th class="text-center"><h4>削除チェック</h4></th>
	                        <th class="text-center"><h4>登録番号</h4></th>
	                        <th class="text-center"><h4>タイトル</h4></th>
	                    </tr>
	           		<s:iterator value="bookList">
		                <tr>
		                	<td><input type="checkbox" name="title" value="<s:property value="title" />"></td>
	                        <td><h4><s:property value="bookNumber" /></h4></td>
	                        <td><h4><s:property value="title" /></h4></td>
	                    </tr>
	                </s:iterator>
	            </table>
	        <br>
	        <input type="submit" value="確認画面へ">
	       	</form>
	        <br>
            <br>
        </div>
       	<div class="footer3">
   			<s:a href="GoAdminBookAction"><input type="button" value="戻る"></s:a>
    	</div>
</body>
</html>