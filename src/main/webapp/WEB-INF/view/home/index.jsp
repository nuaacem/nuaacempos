<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

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

<%@ include file="../shared/importCss.jsp"%>
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="<c:url value='/css/miaov_style.css'/>" rel="stylesheet"
	type="text/css" />
<!-- END PAGE LEVEL PLUGIN STYLES -->

<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">

	<%@ include file="../shared/pageHeader.jsp"%>

	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">

		<%@ include file="../shared/sidebarMenu.jsp"%>

		<!-- BEGIN PAGE -->
		<div class="page-content">

			<%@ include file="../shared/styleSet.jsp"%>

			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						欢迎使用 <small>Welcome</small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><i class="icon-home"></i> 欢迎使用 <i
							class="icon-angle-right"></i></li>
						<li>首页</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->

			<div class="clearfix"></div>
			<div class="row">
				<div class="col-lg-4 col-md-4">
					<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-reorder"></i> 舆情小组动态
							</div>
							<div class="actions">
								<a href="#" class="btn blue mini"><i class="icon-plus"></i>
									More</a>
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a> <a
									href="javascript:;" class="reload"></a>
							</div>
						</div>
						<div style="display: block;" class="portlet-body">
							<div class="scroller" data-height="290px" data-always-visible="1"
								data-rail-visible="0">
								<ul class="feeds">
									<c:forEach items="${feedList }" var="item">
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<c:choose>
															<c:when test="${item.type eq 1 }">
																<div class="label label-success">
																	<i class="icon-bell"></i>
																</div>
															</c:when>
															<c:when test="${item.type eq 2 }">
																<div class="label label-info">
																	<i class="icon-bullhorn"></i>
																</div>
															</c:when>
															<c:when test="${item.type eq 3 }">
																<div class="label label-important">
																	<i class="icon-user"></i>
																</div>
															</c:when>
															<c:otherwise>
																<div class="label label-warning">
																	<i class="icon-plus"></i>
																</div>
															</c:otherwise>
														</c:choose>
													</div>
													<div class="cont-col2">
														<div class="desc">${item.desc }</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">${item.feedTime }</div>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>

					<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-reorder"></i> 采集站点舆情动态
							</div>
							<div class="actions">
								<a href="/nuaacempos/website/list" class="btn blue mini"><i
									class="icon-plus"></i> More</a>
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a> <a
									href="javascript:;" class="reload"></a>
							</div>
						</div>
						<div style="display: block;" class="portlet-body">
							<div class="scroller" data-height="290px" data-always-visible="1"
								data-rail-visible="0">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>站点名称</th>
											<th class="hidden-480">站点URL</th>
											<th>最新舆情</th>
											<th>更新时间</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${websiteList }" var="item">
											<tr>
												<td>${item.name }</td>
												<td>${item.url }</td>
												<td>${item.updateNum }</td>
												<td>${item.updateTime }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-reorder"></i> 关注舆情最新动态
							</div>
							<div class="actions">
								<a href="/nuaacempos/observe/list" class="btn blue mini"><i
									class="icon-plus"></i> More</a>
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a> <a
									href="javascript:;" class="reload"></a>
							</div>
						</div>
						<div id="miaov" class="portlet-body">
							<c:forEach items="${keywordList }" var="item">
								<a href="${item.url }" class="${item.color }">${item.name }</a>
							</c:forEach>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-4">
					<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-reorder"></i> 舆情专题动态
							</div>
							<div class="actions">
								<a href="/nuaacempos/subject/list" class="btn blue mini"><i
									class="icon-plus"></i> More</a>
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a> <a
									href="javascript:;" class="reload"></a>
							</div>
						</div>
						<div style="display: block;" class="portlet-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>专题名称</th>
										<th>专题描述</th>
										<th>更新舆情</th>
										<th>更新时间</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${subjectList }" var="item">
										<tr>
											<td>${item.name }</td>
											<td>${item.desc }</td>
											<td>${item.updateNum }</td>
											<td>${item.updateTime }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-reorder"></i> 最新舆情分析
							</div>
							<div class="actions">
								<a href="#" class="btn blue mini"><i class="icon-plus"></i>
									More</a>
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a> <a
									href="javascript:;" class="reload"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div id="site_statistics_loading">
								<img src="media/image/loading.gif" alt="loading" />
							</div>
							<div id="site_statistics_content" style="display:none;">
								<div id="site_statistics" class="chart"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<%@ include file="../shared/pageFooter.jsp"%>
	<!-- END FOOTER -->

	<%@ include file="../shared/importJs.jsp"%>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="<c:url value='/js/miaov.js'/>" type="text/javascript"></script>
	<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<c:url value='/plugins/flot/jquery.flot.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/plugins/flot/jquery.flot.resize.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/index.js'/>" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->

	<script type="text/javascript">
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.initCharts();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
</html>