<!-- 本一覧画面 -->
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
<link rel="stylesheet" href="css/pagination_style.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<script src="js/back.js"></script>
<script src="js/jquery.pagination.js"></script>
<title>メイン画面</title>
</head>
<body>
    <div class="header3">
        <h2>書籍一覧</h2>
        <a href="home.jsp"><input type="button" value="ホームへ戻る" class="btn btn-primary"></a>
        <div class="rireki">
        	<form method="post" action="GoReturnAction">
				<input type="submit" value="本を延長・返却する" class="btn btn-primary"/>
				<input type="hidden" name="name" value="<%=session.getAttribute("userName")%>"/>
			</form>
			<br>
        	<form action="MyReservationAction" method="post">
            	<input type="submit" value="予約履歴へ" class="btn btn-primary"/>
            	<input type="hidden" name="name" value="<%=session.getAttribute("userName")%>"/>
        	</form>
        </div>
        <h3 class="aka"><strong><s:property value="message"/></strong></h3>
        <br>
        <h3 class="aka"><strong><s:property value="message2"/></strong></h3>
    </div>
    <div class="main3">
    	<s:iterator value="itemList">
	           <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 li">
	           		<div class="text-center">
		                <h4><s:property value="title"/></h4>
		                <img src="<s:property value="imgPath"/>" width="250" height="300"/>
		                <br>
		                <br>
		                <form action="ItemDetailAction" method="post">
			                <input type="submit" value="予約・詳細へ" class="btn btn-primary">
			                <input type="hidden" name="title" value="<s:property value="title"/>"/>
			                <input type="hidden" name="name" value="<%=session.getAttribute("userName")%>"/>
		                </form>
	                </div>
	            </div>
		</s:iterator>
		<div class="text-center">
				<div class="pager"></div>
			</div>
    </div>
    <div class="footer3">
       <a href="home.jsp"><input type="button" value="ホームへ戻る" class="btn btn-primary"></a>
       <br>
       <br>
       <s:form action="LogoutAction" class="third">
            <input type="submit" value="ログアウト" />
        </s:form>
    </div>
</body>
</html>
