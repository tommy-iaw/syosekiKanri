<!-- 予約履歴表示画面 -->
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
<link rel ="stylesheet" href="css/pagination_style.css"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<script src="js/back.js"></script>
<title>予約履歴一覧画面</title>
</head>
<body>
        <div class="header2">
            <h2>予約履歴一覧</h2>
        </div>
        <br>
        <br>
        <div class="main2">
                <table border="1" width="70%" cellspacing="10" cellpadding="10" bordercolor="#333333">
                    <tr>
	                    <th class="text-center" bgcolor="#EE0000" width="auto">
	                    	<h4><font color="#FFFFFF">タイトル</font></h4>
	                    </th>
	                    <th class="text-center" bgcolor="#EE0000" width="auto">
	                    	<h4><font color="#FFFFFF">予約日</font></h4>
	                    </th>
	                    <th class="text-center" bgcolor="#EE0000" width="auto">
	                    	<h4><font color="#FFFFFF">書籍状況<br>☆　借出中<br>△　予約番<br>✕　予約待<br>❍　返却済<br></font></h4>
	                    </th>
                    </tr>
                    <s:iterator value="historyList">
	                    <tr>
	                        <td>
	                        	<h4><s:property value="bookTitle"/></h4>
	                        </td>
	                        <td><h4><s:property value="reservedDate"/></h4></td>
	                        <td>
	                        	<h1><s:property value="reservationGain"/></h1>
	                        	<s:set var="mark" value="%{reservationGain}"/>
	                        </td>
	                    </tr>
					</s:iterator>
                </table>
                <!--<nav class="bottom2">
                <ul class="pagination" >
                    <li> <a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li>
                    <li> <a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
                    </li>
                </ul>
                </nav>-->
        </div>
       	<div class="footer3">
    	  <a href="ItemAction"><input type="button" value="戻る"></a>
    	</div>
</body>
</html>



