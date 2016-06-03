<!-- 本詳細画面から遷移する、予約確認画面 -->
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
<title>予約確認画面</title>
</head>
<body>
        <div class="header2">
            <h2>予約確認画面</h2>
            <br>
            <s:if test="%{#session.lendDay == null}">
	 			<h2 class="aka" ><strong><s:property value="count"/> 件予約待ちになります！</strong></h2>
	        </s:if>
            <h3 class="aka"><strong><s:property value="message" /></strong></h3>
        </div>
        <div class="main2">
            <table border="1" width="auto" cellspacing="10" cellpadding="10" bordercolor="#333333">
            <tr>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">ユーザー名</font></h3>
	            </th>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">タイトル</font></h3>
	            </th>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">借出日</font></h3>
	            </th>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">借出日数</font></h3>
	            </th>
	            <th bgcolor="#EE0000" width="auto" class="text-center">
	            	<h3><font color="#FFFFFF">返却日</font></h3>
	            </th>
            </tr>
            <tr>
	            <td bgcolor="#FFFFFF" align="center" >
	            	<h4><%=session.getAttribute("userName")%></h4>
	            </td>
	            <td bgcolor="#FFFFFF" align="center">
	            	<h4><%=session.getAttribute("title")%></h4>
	            </td>
	            <td bgcolor="#FFFFFF" align="center">
	            	<s:if test="%{#session.date != null}">
	            		<h4><%=session.getAttribute("date")%></h4>
	            	</s:if>
	            </td>
	            <td bgcolor="#FFFFFF" align="center">
	            	<s:if test="%{#session.lendDay != null}">
	            		<h4><%=session.getAttribute("lendDay")%></h4>
	            	</s:if>
	            </td>
	            <td bgcolor="#FFFFFF" align="center">
	            	<s:if test="%{#session.returnDate != null}">
	            		<h4><%=session.getAttribute("returnDate")%></h4>
	            	</s:if>
	            </td>
            </tr>
            </table>
            <br>
            <br>
            <form method="post" action="ReservationAction">
            	<s:if test="%{#session.lendDay == null}">
            		<h4><strong>予約だけの場合、利用順番が回った際に「借出日数」を指定出来ます！</strong></h4>
            		<br>
                	<br>
                	<input type="submit" value="予約" class="btn btn-primary"/>
	            </s:if>
                <s:else>
                	<input type="submit" value="借出" class="btn btn-primary"/>
                </s:else>
                <input type="hidden" name="name" value="<%=session.getAttribute("userName")%>"/>
                <input type="hidden" name="title" value="<%=session.getAttribute("title")%>"/>
                <s:if test="%{#session.lendDay != null}">
	 				<input type="hidden" name="day" value="<%=session.getAttribute("lendDay")%>"/>
	            </s:if>
            </form>
        </div>
    <div class="footer3">
    	  <s:a href="BackAction2"><input type="button" value="戻る"></s:a>
    </div>
</body>
</html>



