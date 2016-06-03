<!-- 本詳細画面 -->
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
<title>本詳細画面</title>
</head>
<body>
        <div class="header2">
            <h2>書籍詳細</h2>
            <br>
            <h3 class="aka"><strong><s:property value="message" /></strong></h3>
        </div>
        <br>
        <br>
        <div class="side_bar">
        <img src="<s:property value="imgPath"/>" width="350" height="400">
        </div>
        <div class="main">
            <table border="1" width="auto" cellspacing="10" cellpadding="10" bordercolor="#333333">
            <tr>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">タイトル</font></h3>
	            </th>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">著者名</font></h3>
	            </th>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">出版社</font></h3>
	            </th>
            </tr>
            <tr>
	            <td bgcolor="#FFFFFF" align="center" >
	            	<h4><%=session.getAttribute("title")%></h4>
	            </td>
	            <td bgcolor="#FFFFFF" align="center">
	            	<h4><s:property value="author"/></h4>
	            </td>
	            <td bgcolor="#FFFFFF" align="center">
	            	<h4><s:property value="contents"/></h4>
	            </td>
            </tr>
            </table>
            <br>
            <s:if test="%{#session.count > 0}">
            	<h2 class="aka" ><strong><s:property value="count"/> 件予約待ちとなります！</strong></h2>
	        	<h4>   現在の予約件数 <s:property value="count"/> 件</h4>
	  			<br>
	  			<h3>予約をするのみとなります。</h3>
	  			<h4>＊予約だけの場合、利用順番が回った際に「借出日数」を指定出来ます！</h4>
	            <form method="post" action="ConfirmReservationAction">
	                <input type="submit" value="予約" class="btn btn-primary"/>
	                <input type="hidden" name="count" value="<s:property value="count"/>"/>
	            </form>
	            <br>
            </s:if>
            <s:else>
        	<h2 class="aka" ><strong>直ぐに利用出来ます！</strong></h2>
  			<br>
  			<h4>借出日数入力欄</h4>
            <form method="post" action="ConfirmReservationAction">
            	<input type="text" value="" name="day" placeholder="1～30を入力して下さい">日間
            	<br>
            	<h4><strong>＊入力フォームに1～30以外を入力すると予約出来ず、エラーになります。</strong></h4>
            	<h4>＊最大30日間　(ex)30日間→30</h4>
                <input type="submit" value="借出" class="btn btn-primary"/>
                <input type="hidden" name="count" value="<s:property value="count"/>"/>
            </form>
            <br>
            </s:else>
        </div>
    <div class="footer3">
    	  <s:a href="BackAction"><input type="button" value="戻る"></s:a>
    </div>
</body>
</html>



