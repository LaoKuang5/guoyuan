<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>test</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
	<form >
		<input id="tel" name="tel" type="tel"> <br>
		<input id="checkSMSCode" name="checkSMSCode" type="number">
		<button onclick="">注册</button>
	</form>
</body>
	<script type="text/javascript">
		$("button").click(function(){
			$.ajax({
				type:"post",
				url:"user/smsCode.action",
				data:"tel:'13152533129'",
				async:true
			});
		})
		function check(){
			
		}
	</script>
</html>