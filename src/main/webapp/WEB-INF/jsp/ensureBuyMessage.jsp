<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>订单确认</title>
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
    	描述：订单确认信息 - 制作人
    -->

		<div class="mui-content">
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：title
    -->
			<div class="mui-col-xs-12 treeListTitle">
				<header class="mui-bar mui-bar-nav mui-bar-transparent">
					<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
					<h1 class="mui-title">确认订单</h1>
				</header>
			</div>

			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：收获地址
    -->
			<div id="ensureMesAddressDiv">
				<table id="ensureMesAddress">
					<tr>
						<td>
							<p>收件人：<b>Domo</b></p>
						</td>
						<td>
							<p><b>18078454542</b></p>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<p>收货地址：新疆维吾尔自治区自治区直辖县级行政区划阿拉尔市阿拉尔星旗舰店</p>
						</td>
					</tr>
				</table>
			</div>

			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：果苗信息
    -->
			<div id="ensureMesTreeDiv" class="mui-row treeListDiv">
				<div class="mui-col-sm-4 mui-col-xs-4">
					<p>￥ 600.00</p>
				</div>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<p>芒果二期A区</p>
				</div>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<p>10 株</p>
				</div>
			</div>

			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：详情和工厂
   -->

			<div class="mui-row ensureMesBuy">
				<table class="mui-col-sm-12 mui-col-xs-12">
					<tr>
						<td>
							<p>商品总价</p>
						</td>
						<td class="MesTableRight">
							<p>￥6，000.00</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>运费</p>
						</td>
						<td class="MesTableRight">
							<p>￥15.00</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>运费险</p>
						</td>
						<td class="MesTableRight">
							<p>卖家免费赠送</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>果币</p>
						</td>
						<td class="MesTableRight">
							<p> - ￥20.00</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>订单总价</p>
						</td>
						<td class="MesTableRight">
							<p>￥6，015.00</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>需付款</p>
						</td>
						<td class="MesTableRight">
							<p>￥5，995.00</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>订单编号</p>
						</td>
						<td class="MesTableRight">
							<p>1947693688886127226</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>交易号</p>
						</td>
						<td class="MesTableRight">
							<p>20180126211002012365542133652</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>时间</p>
						</td>
						<td class="MesTableRight">
							<p>2018 – 10 – 20 14:30：31</p>
						</td>
					</tr>
				</table>
			</div>
			<hr />
			<div id="ensureMesBtn">
				<a href="buyMessage.html"><button>取消订单</button></a>
				<a href="paySuccess.html"><button>付款</button></a>
			</div>
		</div>

	</body>

</html>