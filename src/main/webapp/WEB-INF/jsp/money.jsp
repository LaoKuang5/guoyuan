<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>钱包</title>
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
    	描述：钱包 - 制作人.
    -->

		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：钱包 title
    -->
		<header class="mui-bar mui-bar-nav mui-bar-transparent">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">钱包</h1>
		</header>
		<div class="mui-content">
			<p>VIP4</p>
			<img id="moneyIcon" src="img/胡萝卜.png" />
			<span id="overage">400</span><br />
			<img class="head" src="img/阿布.jpg" />

			<a href="spendHistory.html">
				<div id="200" class="mui-row myTreeList">
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>2018-10-04</p>
					</div>
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>芒果一期F区</p>
					</div>
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>2株</p>
					</div>
				</div>

			</a>
			<a href="spendHistory.html">
				<div id="201" class="mui-row myTreeList">
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>2018-10-04</p>
					</div>
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>芒果一期F区</p>
					</div>
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>2株</p>
					</div>
				</div>
			</a>

			<a href="spendHistory.html">
				<div id="202" class="mui-row myTreeList">
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>2018-10-04</p>
					</div>
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>芒果一期F区</p>
					</div>
					<div class="mui-col-sm-4 mui-col-xs-4">
						<p>2株</p>
					</div>
				</div>
			</a>

			<div id="sumMoneyBottom" class="mui-row myTreeList">
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>总支出 - </p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>2000,000</p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>收入 - </p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>4000,000</p>
				</div>
			</div>
		</div>
	</body>

</html>