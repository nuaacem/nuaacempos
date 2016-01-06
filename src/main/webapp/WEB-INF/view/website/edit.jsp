<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
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
   <link href="<c:url value='/plugins/bootstrap-select/bootstrap-select.min.css'/>" rel="stylesheet" type="text/css"/>
   
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
                  	舆情专题编辑 <small>Edit Subjects/Keywords</small>
               </h3>
               <ul class="page-breadcrumb breadcrumb">
                  <li>
                     <i class="icon-home"></i>
						<a href="/home/index">首页</a>
                     <i class="icon-angle-right"></i>
                  </li>
                  <li>定制管理</li>
                  <li>专题舆情管理</li>
                  <li>编辑专题舆情</li>
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         
         <div class="clearfix"></div>
         
         <div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="portlet">
                  <div class="portlet-title">
                    <div class="caption"><i class="icon-sitemap"></i>专题编辑栏</div>
                  </div>
                  <div class="portlet-body form">
					<form:form modelAttribute="contentModel" class="form-horizontal" method="POST">
					  <form:input path="id" type="hidden" value="${id }"/>
					  <div class="form-body">
						<div class="form-group">
							<label class="col-md-3 control-label">站点名称</label>
							<div class="col-md-9">
								<form:input path="name" placeholder="站点名称" class="form-control" /><br>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">站点类型</label>
							<div class="col-md-9">
								<form:select path="type" class="form-control bs-select">
									<form:option value="微博">微博</form:option>
									<form:option value="博客">博客</form:option>
									<form:option value="网页">网页</form:option>
									<form:option value="论坛">论坛</form:option>
								</form:select>
							</div>
						</div><br>						
						<div class="form-group">
							<label class="col-md-3 control-label">站点URL</label>
							<div class="col-md-9">
								<form:input path="url" placeholder="站点URL" class="form-control" /><br>
							</div>
						</div>
					  </div>  
					  <div class="form-actions fluid">
						<div class="col-md-offset-3 col-md-9">
						  <form:button type="submit" class="btn green">保存</form:button>  
						  <button type="button" class="btn">取消</button>                               
						</div>
					  </div>
					</form:form>  
                </div>
				</div>
			</div>
	</div>
      </div>
      <!-- END PAGE -->
   </div>
   <!-- END CONTAINER -->
   <!-- BEGIN FOOTER -->
   <%@ include file="../shared/pageFooter.jsp" %>
   <!-- END FOOTER -->
   
   <%@ include file="../shared/importJs.jsp"%>
   <!-- BEGIN PAGE LEVEL PLUGINS -->
   <!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
   <script src="<c:url value='/plugins/bootstrap-select/bootstrap-select.min.js'/>" type="text/javascript"></script>
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
   <!-- END PAGE LEVEL SCRIPTS -->  

   <script type="text/javascript">
      jQuery(document).ready(function() {    
         App.init(); // initlayout and core plugins
         $('.bs-select').selectpicker({
             iconBase: 'fa',
             tickIcon: 'fa-check'
         });
      });
   </script>
   <!-- END JAVASCRIPTS -->
</body>
</html>