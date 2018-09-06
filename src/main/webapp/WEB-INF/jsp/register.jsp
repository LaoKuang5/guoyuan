<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>注册</title>
		<script src="js/mui.min.js"></script>
		<link href="css/mui.min.css" rel="stylesheet" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>

		<link rel="stylesheet" href="css/fruitLuck.css" />

	</head>

	<body>
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：注册页面
    -->
		<table id="registerTable">
			<tr>
				<td>
					<p>用户名：</p>
				</td>
				<td>
					<input id="registerTel" type="tel" placeholder="请输入注册手机号码" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input id="getRegisterSMS" type="button" value="获取短信验证码" />
				</td>
			</tr>
			<tr>
				<td>
					<p>验证码：</p>
				</td>
				<td>
					<input id="getSMS" type="text" />
				</td>
			</tr>
			<tr>
				<td>
					<p>密码：</p>
				</td>
				<td>
					<input id="registerPassword" type="password" placeholder="请输入6-12位密码" />
				</td>
			</tr>
			<tr>
				<td>
					<p>确认密码：</p>
				</td>
				<td>
					<input id="ensurePassword" type="password" />
				</td>
			</tr>
		</table>
		<input id="registerBtn" type="button" value="注册" />
	</body>

</html>