<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>物流信息</title>
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
    	描述：物流信息 - abu
    -->
		<div id="myTreeListTitle" class="mui-row">
			<div class="mui-col-sm-1 mui-col-xs-1">
				<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			</div>
			<div class="mui-col-sm-2 mui-col-xs-2">
				<p>已采摘</p>
			</div>
			<div class="mui-col-sm-3 mui-col-xs-3">
				<p>邮寄中</p>
			</div>
			<div class="mui-col-sm-3 mui-col-xs-3">
				<p>苹果</p>
			</div>
			<div class="mui-col-sm-3 mui-col-xs-3">
				<p>20kg</p>
			</div>
		</div>

		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：
    -->
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：收获地址
    -->
		<div id="logisticsMesDiv">
			<table id="logisticsMes">
				<tr>
					<td>
						<p><b>顺丰快递</b></p>
					</td>
				</tr>
				<tr>
					<td>
						<p><b>快递单号：62666222415213888</b></p>
					</td>
				</tr>
				<tr>
					<td>
						<p><b>邮寄地址：上海市闵行区 620大街 </b></p>
					</td>
				</tr>
				<tr>
					<td>
						<p><b>联系电话：18288886442 </b></p>
					</td>
				</tr>
			</table>
		</div>

		<p id="logisticsMesTitle">物流信息</p>

		<div id="logisticsMesDivLoading">
			<table>
				<tr>
					<td>
						<p class="mui-icon mui-icon-paperplane"></p>
					</td>
					<td>
						<p><b>到达杭州转运中心</b></p>
					</td>
				</tr>
				<tr>
					<td>
						<p class="mui-icon mui-icon-paperplane"></p>
					</td>
					<td>
						<p><b>已发货</b></p>
					</td>
				</tr>
				<tr>
					<td>
						<p class="mui-icon mui-icon-paperplane"></p>
					</td>
					<td>
						<p><b>装箱 明日15:00 发货 </b></p>
					</td>
				</tr>
				<tr>
					<td>
						<p class="mui-icon mui-icon-paperplane"></p>
					</td>
					<td>
						<p><b>采摘中</b></p>
					</td>
				</tr>
			</table>
		</div>

		<p class="touch">因果APP QQ客服：13265447965</p>
		<p class="touch">因果APP 咨询电话：072 – 65232546</p>

	</body>

</html>