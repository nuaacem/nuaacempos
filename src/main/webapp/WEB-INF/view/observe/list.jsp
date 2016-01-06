<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="nuaa.ggx.pos.frontend.util.UrlHelper"%>
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
<title>NuaaCem | Public Sentiment System</title>
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
						观测舆情 <small>Observe Public Sentiments</small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><i class="icon-home"></i> <a href="/home/index">首页</a> <i
							class="icon-angle-right"></i></li>
						<li>观测舆情</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->

			<div class="clearfix"></div>
			<div class="row">
				<div class="col-lg-2 col-md-2">
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-sitemap"></i>专题列表
							</div>
						</div>
						<div class="portlet-body">
							<div id="treeData-list"></div>
						</div>
						<div class="portlet-title tool-bottom"></div>
					</div>
				</div>
				<div class="col-lg-10 col-md-10">
					<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-globe"></i>舆情列表
							</div>
						</div>
						<div class="portlet-body">
							<table class="table table-striped table-bordered table-hover"
								id="consensus-table">
								<thead>
									<tr>
										<th></th>
										<th>标题</th>
										<th>URL</th>
										<th>来源站点</th>
										<th>采集时间</th>
										<th class="hidden">summary</th>
										<th class="hidden">click_num</th>
										<th class="hidden">emotion_pole</th>
										<th class="hidden">tagwords</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
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
	<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
	<script src="<c:url value='/plugins/select2/select2.min.js'/>"
		type="text/javascript"></script>
	<script
		src="<c:url value='/plugins/data-tables/jquery.dataTables.min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/plugins/data-tables/DT_bootstrap.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/plugins/data-tables/fnReloadAjax.js'/>"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
	<script type="text/javascript"
		src="<c:url value='/js/jquery.treeLite.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/js/jquery.toolbarlite.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/js/table-advanced.js'/>"></script>
	<!-- END PAGE LEVEL SCRIPTS -->

	<script type="text/javascript">
      jQuery(document).ready(function() {    
         App.init(); // initlayout and core plugins
         $("#treeData-list").treeLite({
         	items: <c:out value="${contentModel }" escapeXml="false"></c:out>
         });
         $(".tool-bottom").toolbarLite({
             items: [       
   			 	{ link: true, display: "专题/关键词", css: "icon-plus", showIcon: true, url: "javascript:;", 
                  click: function() {
                      	location.href = "<%=UrlHelper.resolveWithReturnUrl("/subject/add",
						request.getAttribute("requestUrl"), pageContext)%>";
                      	return false;
                    } 
                 },
                  { splitter: true }, 
                  { link: true, display: "编辑专题", css: "icon-edit", showIcon: true, url: "javascript:;",
                   click: function() {
                	  var parentId = $('#treeData-list').treeLite('parentId');
                      var selectedId = $('#treeData-list').treeLite('selectedId');
                      if (parentId != undefined)
                   	  {
                   	  	selectedId = parentId
                   	  }
                      if(selectedId != undefined) 
                      	location.href = "<%=UrlHelper.resolveWithReturnUrl("/subject/edit/{0}",
					request.getAttribute("requestUrl"), pageContext)%>".replace("{0}", selectedId);
                      else
                          alert("必须选择择一个专题！");
                      return false;
                      } 
                  },
                  { splitter: true }, 
                  { link: true, display: "删除专题", css: "icon-trash", showIcon: true, url: "javascript:;",
                   click: function() {
                	  var parentId = $('#treeData-list').treeLite('parentId');
                      var selectedId = $('#treeData-list').treeLite('selectedId');
                      if (parentId != undefined)
                   	  {
                   	  	selectedId = parentId
                   	  }
                      if(selectedId && selectedId != undefined) 
                      {
                        if($.modal.confirm("确认删除所选节点？"))
                          	location.href = "<%=UrlHelper.resolveWithReturnUrl("/subject/delete/{0}",request.getAttribute("requestUrl"),request.getAttribute("requestQuery"), "expanded={1}",pageContext)%>"
													.replace("{0}",selectedId);
                        else
							alert("必须选择择一个节点！");
						return false;
                      } 
                   }
                  }
               ]
           });          
           TableAdvanced.init("${ajaxSource }");          
       });							
	</script>
	<!-- END JAVASCRIPTS -->
</body>
</html>