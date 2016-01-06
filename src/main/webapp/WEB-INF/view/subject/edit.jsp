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
   <link href="<c:url value='/plugins/data-tables/DT_bootstrap.css'/>" rel="stylesheet" type="text/css"/>
   <link href="<c:url value='/plugins/jquery-multi-select/css/multi-select.css'/>" rel="stylesheet" type="text/css"/>
   
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
         	<div class="col-lg-8 col-md-8">
				<div class="portlet">
                	<div class="portlet-title">
                    	<div class="caption"><i class="icon-sitemap"></i>专题编辑栏</div>
                  	</div>
                  	<div class="portlet-body form">
						<form:form modelAttribute="contentModel" class="form-horizontal" method="POST">
							<form:input path="id" type="hidden"/>
					  		<div class="form-body">
								<div class="form-group">
									<label class="col-md-2 control-label">专题名称</label>
									<div class="col-md-10">
										<form:input path="name" placeholder="专题名称" class="form-control" /><br>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">专题描述</label>
									<div class="col-md-10">
										<form:input path="desc" placeholder="专题描述" class="form-control" /><br>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">编辑关键词</label>
									<div class="col-md-10">
										<div class="portlet">
											<div class="portlet-title">
												<div class="caption">
													<i class="icon-edit"></i>关键词列表
												</div>
												<div class="actions">
													点此添加关键词
													<a href="#" id="keyword_editable_new" class="add btn mini blue"><i class="icon-pencil"></i>Add</a>
												</div>
											</div>
											<div class="portlet-body">
												<table class="table table-striped table-hover" id="keyword_editable">
													<thead>
														<th></th>
														<th></th>
														<th></th>
													<thead>
													<tbody>
         	 											<c:set var="count" scope="page" value="0"/>
														<c:forEach items="${contentModel.keywords }" var="keyword">
															<tr class="">
																<td>${keyword.key }</td>
																<td>
																	<a class="edit btn mini purple" href="javascript:;"><i class="icon-edit"></i>Edit</a>
																</td>
																<td>
																	<a class="delete btn mini black" href="javascript:;"><i class="icon-trash"></i>Delete</a>
																</td>
																<form:input path="keywords['${keyword.key }'].name" type="hidden" value="${keyword.value.name }" />
																<form:input path="keywords['${keyword.key }'].id" type="hidden" value="${keyword.value.id }" />
															</tr>
															<c:set var="count" scope="page" value="${count+1 }"/>
														</c:forEach>														
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-2">采集站点</label>
									<div class="col-md-10">
										<form:select multiple="true" class="multi-select" id="website_select" path="websites">
											<c:forEach items="${websiteSelectModel }" var="item">
												<c:if test="${item.isSelected == true }">
													<option value="${item.id }" selected>${item.name }&nbsp;${item.url }</option>													
												</c:if>
												<c:if test="${item.isSelected == false }">
													<option value="${item.id }">${item.name }&nbsp;${item.url }</option>													
												</c:if>
											</c:forEach>
										</form:select>
									</div>
								</div>
						  </div>  
						  <div class="form-actions fluid">
							<div class="col-md-offset-5 col-md-3">
							  <input type="submit" class="btn green" value="保存"/>       
							  <input type="button" class="btn default" value="返回"/>                      
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
   <script src="<c:url value='/plugins/data-tables/jquery.dataTables.min.js'/>" type="text/javascript"></script>   
   <script src="<c:url value='/plugins/data-tables/DT_bootstrap.js'/>" type="text/javascript"></script>   
   <script src="<c:url value='/plugins/jquery-multi-select/js/jquery.multi-select.js'/>" type="text/javascript"></script>   
   <!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
   <script src="<c:url value='/js/table-editable.js'/>" type="text/javascript"></script>
   <!-- END PAGE LEVEL SCRIPTS -->  

   <script type="text/javascript">
      jQuery(document).ready(function() {    
         App.init(); // initlayout and core plugins
         TableEditable.init();
         $("#website_select").multiSelect();
      });
   </script>
   <!-- END JAVASCRIPTS -->
</body>
</html>