<!-- 返却・延長画面 -->
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
<title>延長・返却画面</title>
</head>
<body>
    <div id="container">
        <div class="header2">
            <h2>借出一覧</h2>
        </div>
        <br>
        <br>
        <div class="main4">
	        <h3 class="aka"><strong><s:property value="message" /></strong></h3>
	        <strong class="aka"><s:property value="message2"/></strong>
        	<br>
                <table border="1" width="70%" cellspacing="10" cellpadding="10" bordercolor="#333333">
                    <tr>
	                    <th class="text-center" bgcolor="#EE0000" width="auto">
	                    	<font color="#FFFFFF">タイトル</font>
	                    	</th>
	                    <th class="text-center" bgcolor="#EE0000" width="auto">
	                    	<font color="#FFFFFF">貸出日</font>
	                    </th>
	                    <th class="text-center" bgcolor="#EE0000" width="auto">
	                    	<font color="#FFFFFF">返却予定日</font>
	                    </th>
	                    <th class="text-center" bgcolor="#EE0000" width="auto">
	                    	<font color="#FFFFFF">延長・返却</font>
	                    </th>
                    </tr>
                    <s:iterator value="returnList">
	                    <tr>
	                        <td>
	                        	<h4><s:property value="bookTitle"/></h4>
	                        </td>
	                        <td><h4><s:property value="lendDate"/></h4></td>
	                        <td>
	                        	<h4><s:property value="returnDate"/></h4>
	                        	<h4><strong>しっかりと確認して下さい！！</strong></h4>
	                        </td>
	                        <td>
	                        	<form method="post" action="ExtensionAction">
	                        		<input type="text" value="" name="day" placeholder="1～30を入力して下さい">日間
	                        		<br>
	                        		<h5>予約が入っているかどうか、日数を入力し、ボタンを押して試して下さい。
	                        		<br>＊今日を基準に延長日数分が増加します。<br>＊最大30日間　(ex)30日間→30</h5>
	                        		<input type="submit" value="延長" class="btn btn-primary"/>
	                        		<input type="hidden" name="name" value="<%=session.getAttribute("userName")%>"/>
	                        		<input type="hidden" name="bookTitle" value="<s:property value="bookTitle"/>"/>
	                        	</form>
	                        <br>
	                        	<form method="post" action="ReturnCompletionAction">
	                        		<input type="submit" value="返却" class="btn btn-primary"/>
	                        		<input type="hidden" name="name" value="<%=session.getAttribute("userName")%>"/>
	                        		<input type="hidden" name="bookTitle" value="<s:property value="bookTitle"/>"/>
	                        	</form>
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
            <a href="ItemAction"><input type="button" value="戻る" class="btn btn-primary"></a>
        </div>
    </div>
</body>
</html>



