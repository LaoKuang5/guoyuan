<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>登录</title>
		<script src="js/mui.min.js"></script>
		<link href="css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/fruitLuck.css" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
	</head>

	<body>
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：登录 - abu
    -->

		<table id="loginTable">
			<tr>
				<td>
					<p>用户名：</p>
				</td>
				<td>
					<input id="loginName" type="text" placeholder="请输入注册手机号码" />
				</td>
			</tr>
			<tr>
				<td>
					<p>密码：</p>
				</td>
				<td>
					<input id="loginPassword" type="password" placeholder="请输入6-12位密码" />
				</td>
			</tr>
		</table>
		<input id="loginBtn" type="button" value="登录" />
	</body>

</html>