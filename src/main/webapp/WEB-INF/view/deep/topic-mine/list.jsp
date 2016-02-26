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
					<input class="form-control" id="weibo-url"	placeholder="多媒体微博url" type="text">
				</div>
				<button id="btn-topic-mine" class="btn btn-default">主题挖掘</button>
			</form>
			
			<div class="note note-success">
				<p>
					Duis mollis, est non commodo luctus, nisi erat mattis consectetur purus sit amet porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.
				</p>
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
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->

	<script type="text/javascript">
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			$("#btn-topic-mine").on("click", function(e) {
				e.preventDefault();

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
						alert(data);
					},
					error : function(errorMSG) {
						alert("fail!");
					}
				})
			});
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
</html>