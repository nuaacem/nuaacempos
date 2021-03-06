<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--><html lang="en" class="no-js"><!--<![endif]-->
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
<link href="<c:url value='/plugins/select2/select2_conquer.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/plugins/data-tables/DT_bootstrap.css'/>" rel="stylesheet" type="text/css"/>
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
						舆情专题管理 <small>Subject Management</small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><i class="icon-home"></i> <a href="/home/index">首页</a> <i
							class="icon-angle-right"></i></li>
						<li>定制管理</li>
						<li>专题舆情管理</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->

			<div class="clearfix"></div>

			<div class="btn-group bottom-10">
				<a href="add" class="btn green"> Add New Website<i
					class="icon-plus"></i>
				</a>
			</div>

			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="portlet box green">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-globe"></i>站点管理
							</div>
							<div class="actions">
								<a id="edit_btn" href="javascript:;" class="btn yellow mini">
									<i class="icon-pencil"></i>Edit
								</a>
								<a id="delete_btn" href="javascript:;" class="btn purple mini">
									<i class="icon-trash"></i> Delete
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<table
								class="table table-striped table-bordered table-hover"
								id="website_table">
								<thead>
									<tr>
										<th class="table-checkbox"><input type="checkbox"
											class="group-checkable" data-set="#website_table .checkboxes" />
										</th>
										<th>站点名称</th>
										<th>站点URL</th>
										<th>站点类型</th>
										<th class="hidden-480">更新数量</th>
										<th class="hidden-480">最后更新时间</th>
										<th>站点来源</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${contentModel }" var="item">
										<tr>
											<td><input type="checkbox" class="checkboxes" value="${item.id }"/></td>
											<td>${item.name }</td>
											<td>${item.url }</td>
											<td><c:choose>
													<c:when test="${item.type eq '微博' }">
														<span class="label label-success">微博</span>
													</c:when>
													<c:when test="${item.type eq '博客' }">
														<span class="label label-warning">博客</span>
													</c:when>
													<c:when test="${item.type eq '论坛' }">
														<span class="label label-important">论坛</span>
													</c:when>
													<c:otherwise>
														<span class="label label-info">新闻</span>
													</c:otherwise>
												</c:choose></td>
											<td class="hidden-480">${item.updateNum }</td>
											<td class="hidden-480">${item.updateTime }</td>
											<td><c:if test="${item.isPublic eq true }">
													<span class="label label-default">内置</span>
												</c:if> <c:if test="${item.isPublic eq false }">
													<span class="label label-primary">自建</span>
												</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
	<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
	<script src="<c:url value='/plugins/select2/select2.min.js'/>"
		type="text/javascript"></script>
	<script
		src="<c:url value='/plugins/data-tables/jquery.dataTables.min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/plugins/data-tables/DT_bootstrap.js'/>"
		type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/table-managed.js'/>"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->

	<script type="text/javascript">
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			TableManaged.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
</html>