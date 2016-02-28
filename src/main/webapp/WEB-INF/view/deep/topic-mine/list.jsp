<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../../shared/taglib.jsp"%>

<html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NuaaCem | public opinion system</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<meta name="MobileOptimized" content="320">

<%@ include file="../../shared/importCss.jsp"%>
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<!-- END PAGE LEVEL PLUGIN STYLES -->

<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">

	<%@ include file="../../shared/pageHeader.jsp"%>

	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">

		<%@ include file="../../shared/sidebarMenu.jsp"%>

		<!-- BEGIN PAGE -->
		<div class="page-content">

			<%@ include file="../../shared/styleSet.jsp"%>

			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						多媒体微博主题挖掘 <small>Multimedia Weibo Topic Mine</small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><i class="icon-home"></i> <a href="/home/index">首页</a> <i
							class="icon-angle-right"></i></li>
						<li>深度舆情分析<i class="icon-angle-right"></i></li>
						<li>多媒体微博主题挖掘</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->

			<div class="clearfix"></div>

			<form class="form-inline" role="form">
				<div class="form-group col-lg-6 col-md-6">
					<label class="sr-only" for="weibo-url">weibo url</label>
					<input class="form-control" id="weibo-url" name="weiboUrl" placeholder="多媒体微博url" type="text">
				</div>
				<button id="btn-topic-mine" class="btn btn-default">主题挖掘</button>
			</form>
			<div class="col-lg-7 col-md-7" style="padding: 15px;">
				<div class="portlet yellow box">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-cogs"></i>多媒体微博文本描述模型
						</div>
					</div>
					<div class="portlet-body">		
						<div class="note note-success">
							<h1 class="block">内容标签 : <strong>等待标签生成</strong></h1>	
							<p style="font-size: 25px;">等待特征词生成</p>
						</div>			
						<div class="note note-danger">
							<h1 class="block">情感标签 : <strong>情感</strong></h1>
							<p style="font-size: 25px;">等待特征词生成</p>
						</div>
					</div>
				</div>
			</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<%@ include file="../../shared/pageFooter.jsp"%>
	<!-- END FOOTER -->

	<%@ include file="../../shared/importJs.jsp"%>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
	<script src="<c:url value='/plugins/jumble.min.js'/>" type="text/javascript" ></script>
	
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->

	<script type="text/javascript">
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			$("#btn-topic-mine").on("click", function(e) {
				e.preventDefault();
				$('.note-success strong').text("等待标签生成");
				$('.note-success p').text("等待特征词生成");
				$('.note-danger p').text("等待特征词生成");
				
				if (confirm("确认主题挖掘?") == false) {
					return;
				}

				var weiboUrl = $("#weibo-url").val();

				$.ajax({
					url : 'mine',
					type : "post",
					data : {
						"weiboUrl" : weiboUrl
					},
					success : function(data) {
						var jsonResult = eval("(" + data + ")");
						$('.note-success strong').text(jsonResult.cTag);
						$('.note-success p').text(jsonResult.cWords);
						$('.note-danger p').text(jsonResult.eWords);
					},
					error : function(errorMSG) {
						alert("fail!");
					}
				})
			});
			
			$('p').jumble([190,180,110],[250,20,170],false,true,1000);
			$('strong').jumble([125,240,125],[230,20,130],true,false,2000);
			
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
</html>