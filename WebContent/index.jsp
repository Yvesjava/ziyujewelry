<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>紫瑜商品管理</title>



</head>
<body>

	<div class="container">

		<h1 class="text-center bg-primary">紫瑜商品管理系统</h1>

		<div class="row">
			<div class="col-md-6 text-center">
				<button class="btn btn-warning btn-block">查	删	改</button>
			</div>
			<div class="col-md-6 bg-warning">
				<!-- Split button -->
				<div class="btn-group btn-block">
				  <button type="button" class="btn btn-danger btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">录入<span class="caret"></span></button>
				  <ul class="dropdown-menu dropdown-menu-right">
				    <li><a href="#">商品表</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">材质表</a></li>
				    <li><a href="#">商品类型表</a></li>
				    <li><a href="#">镶嵌表</a></li>
				  </ul>
				</div>
			</div>
		</div>

		<div class="row" id="form-content">
			<div class="col-md-12 text-center">

				<ul class="nav nav-tabs">
				  <li role="presentation" class="active"><a href="#">商品表</a></li>
				  <li role="presentation"><a href="#">材质表</a></li>
				  <li role="presentation"><a href="#">商品类型表</a></li>
				  <li role="presentation"><a href="#">镶嵌表</a></li>
				</ul>
				
				<!-- 商品表form表单区域 -->
				<div id="productForm_area">
					<form role="form" class="form-horizontal" id="form_product" action="product" method="post" enctype="multipart/form-data">
						<!-- 商品名字 -->
					    <div class="form-group">
					        <label for="product-name" class="col-sm-2 control-label">商品名字</label>
					        <div class="col-sm-8">
					            <input type="text" class="form-control" id="product-name" name="product-name" placeholder="请输入商品名字">
					        </div>
					    </div>
						

						<!-- Pid id的选择 -->
					    <div class="form-group">
					        <label for="Pid" class="col-sm-2 control-label">商品ID</label>
					      	<div class="col-sm-2">
						    	<select class="form-control" name="Pid1">
								  <option value="0">请选择商品类型：</option>
								  <option>2</option>
								  <option>3</option>
								  <option>4</option>
								  <option>5</option>
								</select>
						   </div>
						   <div class="col-sm-2">
						    	<select class="form-control" name="Pid2">
								  <option value="0">请选择商品材质：</option>
								  <option>2</option>
								  <option>3</option>
								  <option>4</option>
								  <option>5</option>
								</select>
						   </div>
						   <div class="col-sm-2">
						    	<select class="form-control" name="Pid3">
								  <option value="0">请选择镶嵌类型：</option>
								  <option>2</option>
								  <option>3</option>
								  <option>4</option>
								  <option>5</option>
								</select>
						   </div>
						   <!-- 随机编号 -->
						   <div class="col-sm-2">
							    <div class="input-group">
							      <input type="text" class="form-control" placeholder="随机编号" readonly>
							      <span class="input-group-btn">
							        <button class="btn btn-default" type="button">缘</button>
							      </span>
							    </div>
						   </div>
					    </div>
						
						<!-- 成本 -->
						<div class="form-group">
					        <label for="cost" class="col-sm-2 control-label">商品成本</label>
					      	<div class="col-sm-2">
							      <input type="text" id="cost" class="form-control" placeholder="总成本" name="cost">
						   </div>
						<!-- 售价 -->
						   <label for="price" class="col-sm-2 control-label">商品售价</label>
					      	<div class="col-sm-2">
							      <input type="text" id="price" class="form-control" placeholder="售价" name="price">
						   </div>
						</div>
						
						<!-- 售价 -->
						<!-- <div class="form-group">
					        
						</div> -->
						<!-- 文件 -->
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<label for="uploadFile" class="form-control col-sm-2">选择商品图片</label>
								<div class="col-sm-4">
								    <input type="file" name="uploadFile" id="uploadFile" accept="image/*,audio/*,video/*" multiple />
								</div>
						    </div>
						</div>
						
						<!-- 商品描述 -->
						<div class="form-group">
					        <label for="pro-desc" class="col-sm-2 control-label">商品描述</label>
					      	<div class="col-sm-8">
							     <textarea class="form-control" id="pro-desc" name="pro-desc" rows="5" cols="12" style="resize: none;"></textarea>
						   </div>
						</div>


					    <div class="form-group">
					        <div class="col-sm-offset-2 col-sm-8">
					            <button type="submit" class="btn btn-default">提交 <span id="submitInfoNum" class="badge">8</span></button>
					        </div>
					    </div>
					</form>
				</div>



			</div>
		</div>

	</div>





</body>

	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7/css/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.js"></script>


</html>



