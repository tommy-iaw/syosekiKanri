<!-- ホーム画面 -->
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
<title>社員ホーム画面</title>
</head>
<body>
    <div class="header2">
        <h1><strong>社員ページ</strong></h1>
    </div>
    <div class="main2">
    	<h3 class="aka"><strong><s:property value="message" /></strong></h3>
        <form action="" class="first">
            <input type="submit" value="自己紹介へ" />
        </form>
        <form action="ItemAction" class="first">
            <input type="submit" value="本貸出へ" />
        </form>
        <form action="" class="first">
            <input type="submit" value="勉強会へ" />
        </form>
        <form action="" class="first">
            <input type="submit" value="サークル活動へ" />
        </form>
    </div>
    <div class="footer2">
        <input type="button" value="管理者ログイン" data-toggle="modal" data-target="#sampleModal"/>
        <div class="modal fade" id="sampleModal" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="text-center" >
                                <h3 style="font-weight:bold">管理者ログイン</h3>
                            </div>
                        </div>

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
                            <div class="text-center">
                                <form action="AdminLoginAction" method="post">
	                                <table>
	                                    <tr>
	                                    	<th>管理者ID</th>
	                                    	<td><input type="text" name="id" placeholder="管理者ID"></td>
	                                    </tr>
	                                    <tr>
	                                    	<th>パスワード</th>
	                                    	<td><input type="password" name="password" placeholder="パスワード"></td>
	                                    </tr>
	                                </table>
	                                <input type="submit" value="ログイン" class="btn btn-primary"/>
	                                <br>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <br>
        <br>
        <s:form action="LogoutAction" class="second">
            <input type="submit" value="ログアウト" />
        </s:form>
    </div>
</body>
</html>