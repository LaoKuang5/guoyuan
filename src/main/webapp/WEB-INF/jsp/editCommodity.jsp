<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑商品</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/kindeditor-4.1/themes/default/default.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/kindeditor-4.1/plugins/code/prettify.css" />
<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor-4.1/kindeditor-all-min.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor-4.1/lang/zh-CN.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor-4.1/plugins/code/prettify.js"></script>
<style type="text/css">
.uploadBox{
    width:560px;
    padding:10px;
    border:2px solid #317ef3;
    margin:50px auto;
    display: none
}
#uploadBtn {
    width: 100px;
    height: 100px;
    cursor: pointer;
    position: relative;
    background: url("../img/add.png") no-repeat;
    -webkit-background-size: cover;
    background-size: cover;
    float: left;
}
#uploadBtn input {
    position: absolute;
    right: 0;
    top:0;
    width: 100%;
    height: 100%;
    opacity: 0;
    cursor: pointer;
}
.pic{
    float: left;
    width: 100px;
    height: 100px;
    margin-right: 10px;
  }
.pic img {
    width: 100%;
    height: 100%;
}
#upload{
    width: 100px;
    height: 30px;
    line-height: 30px;
    background: cornflowerblue;
    border: 1px solid cornflowerblue;
    color: white;
    cursor: pointer;
    margin: 30px auto;
    text-align: center;
    border-radius: 5px;
}
.clear {
    clear:both;
}
.hide{
    display: none;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form id="commoditySaveForm" method="post">
		商品名称：<input type="text" name="commodityName"/><br/>
		商品分类ID：<input type="text" name="cid"/><br/>
		果苗种植期限（天）：<input type="text" name="commodityTerm"/><br/>
		商品价格：<input type="text" name="commodityPrice"/><br/>
		商品产量：<input type="text" name="commodityProduct"/><br/>
		商品数量：<input type="text" name="commodityNum"/><br/>
		商品状态：<select name="commodityStatus">
				  <option value ="1">在售</option>
				  <option value ="3">下架</option>
			  </select><br/>
		商品图片（第一张为主图）：
		<a href="javascript:void(0)" id="skipphotoUploadBtn">上传商品图片</a>	
	    <input type="hidden" name="photos"/>
		<div class="uploadBox" id="uploadBoxId">
		    <div id="uploadBtn">
		        <input type="file" id="tempfile" multiple="multiple"/>
		    </div>
		    <div class="clear"></div>
		    <div id="upload">
		        <span>上传</span>
		    </div>
		</div>
		<br/>
		商品详情：<textarea name="detail" style="width:700px;height:300px;">
		</textarea><br/>
	</form>
	<a href="javascript:void(0)" id="addCommodityBtn">添加商品</a>	
</body>
<script type="text/javascript">
	 
	 $(function(){
		 var imgArr = []; //保存每次的选择的文件对象
         var totalfile  = 0;  //记录选择的个数
         //初始化富文本编辑器
	     var detailEditor = KindEditor.create("#commoditySaveForm [name=detail]",{
	    	//指定上传文件参数名称
		     filePostName : "uploadFile",
		    //指定上传文件请求的url。
		    uploadJson : '${pageContext.request.contextPath}/pic/uploadRichImg.action',
		    //上传类型，分别为image、flash、media、file
		    dir : "image"
	     });    
        $("#tempfile").change(function () {
            var files = this.files;
            var temp = totalfile;
            totalfile = totalfile + files.length;
            if(totalfile>5){
                totalfile = temp;
                alert("只能上传5张图片,你还可以选择："+(5-totalfile)+"张");
                return;
            }
            $.each(files,function(key,value){
                var reader = new FileReader(),
                    imgDiv = document.createElement("div"),
                    img = document.createElement("img");
                $(imgDiv).addClass("pic");
                reader.onload = function (e) {
                    img.src = e.target.result;
                    imgDiv.appendChild(img);
                    $("#uploadBtn").before(imgDiv);
                };
                reader.readAsDataURL(value);//读取文件
                imgArr.push(value);
            });
            console.log(imgArr);
        });
        $("#skipphotoUploadBtn").click(function () {
            $("#uploadBoxId").show();
        });
        $("#upload").click(function () {
      	  var formData = new FormData();
      	  for(var i=0;i<imgArr.length;i++){
                if(imgArr[i]!=null){
                    formData.append("uploadFiles",imgArr[i]);
                }
            }
      		imgArr = null;  //清空存储的图片文件存储数组
            $.ajax({ //申请加盟
                type: "post", //请求方式
                dataType: 'json',
                url: '${pageContext.request.contextPath}/pic/upload.action', //请求接口
                data: formData, //请求参数（这里将参数都保存在formData对象中）
                processData: false, //因为data值是FormData对象，不需要对数据做处理。
                contentType: false, //默认为true,不设置Content-type请求头
                success: function (data) {
                	console.log(data);
                	if(data.error == 0){
                		//上传成功
                		$("input[name=photos]").val(data.imgUrls);
                		alert("上传成功");
                	}else{
                		alert("上传失败");
                	}
                	$("#uploadBoxId").hide();
                }
            });

        });
        $("#addCommodityBtn").click(function(){
        	//验证商品表单
        	//同步富文本框中的商品描述
    		detailEditor.sync();
        	$.post("${pageContext.request.contextPath }/manager/commodity/save.action",
    				$("#commoditySaveForm").serialize(), function(data){
        				console.log(data);
    				if(data.status == 0){				
    					alert(data.msg);
    				}else if(data.status == 1){
    					alert(data.msg);
    				}
    		});
        });
     });
</script>
</html>