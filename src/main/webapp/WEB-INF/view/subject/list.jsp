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
   <title>NuaaCem | public opinion system</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
   
   <%@ include file="../shared/importCss.jsp"%>
   <!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
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
                  <li>
                     <i class="icon-home"></i>
						<a href="/home/index">首页</a>
                     <i class="icon-angle-right"></i>
                  </li>
                  <li>定制管理</li>
                  <li>专题舆情管理</li>
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         
         <div class="clearfix"></div>
         
         <div class="btn-group bottom-10">
			<a href="add" class="btn green">
				Add New Subject<i class="icon-plus"></i>
			</a>
		 </div>
         
         <div class="row">        
         	<div class="col-lg-12 col-md-12">
         	 	<c:set var="count" scope="page" value="0"/>
				<c:forEach items="${contentModel }" var="item">
         		 	<c:set var="count" scope="page" value="${count+1 }"/>
	         		<div class="portlet box light-grey">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-reorder"></i>
								专题${count }：${item.name }
							</div>			
							<div class="tools">
								<a href="javascript:;" class="reload"></a>		
								<a href="javascript:;" class="collapse"></a>					
							</div>
							<div class="actions">
								<input type="hidden" value="${item.id}" />
								<a href="edit/${item.id}" class="btn yellow mini btn-edit"><i class="icon-pencil"></i> Edit</a>
								<a href="javascript:;" class="btn black mini btn-delete"><i class="icon-trash"></i> Delete</a>
							</div>		
						</div>	
						<div class="portlet-body">
							<div class="tabbable tabs-left">
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="#tab_${count }_1" data-toggle="tab">
											 关键词列表
										</a>
									</li>
									<li>
										<a href="#tab_${count }_2" data-toggle="tab">
										<i class="icon-reorder"></i>采集站点
										</a>
									</li>
									<li>
										<a href="#tab_${count }_3" data-toggle="tab">
										<i class="icon-briefcase"></i>专题描述
										</a>
									</li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab_${count }_1">
										<div class="col-lg-9">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>关键词</th>
														<th>舆情数量</th>
														<th>更新时间</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${item.keywords }" var="keyword">
														<tr>
															<td>${keyword.name }</td>
															<td>${keyword.consensusNum }</td>
															<td>${keyword.updateNum }</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<div class="tab-pane fade" id="tab_${count }_2">
										<div class="col-lg-9">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>采集站点</th>
														<th>站点URL</th>
														<th>站点类型</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${item.websites }" var="website">
														<tr>
															<td>${website.name }</td>
															<td>${website.url }</td>
															<td>${website.type }</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<div class="tab-pane fade" id="tab_${count }_3">
										<div class="col-lg-9">
											<table class="table table-hover">											
												<tbody>
													<tr>
														<td class="highlight">
															<div class="warning"></div>
																<a href="#">专题描述</a>
														</td>
														<td>
															${item.desc }
														</td>
													</tr>
													<tr>
														<td class="highlight">
															<div class="success"></div>
															<a href="#">热度</a>
														</td>
														<td>
															${item.heat }
														</td>
													</tr>
													<tr>
														<td class="highlight">
															<div class="success"></div>
															<a href="#">最热词</a>
														</td>
														<td>
															${item.hotWord }
														</td>
													</tr>												
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
								
						</div>
					</div>
         		</c:forEach>
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
   <script src="<c:url value='/js/miaov.js'/>" type="text/javascript"></script>   
   <!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
   <!-- END PAGE LEVEL SCRIPTS -->  

   <script type="text/javascript">
      jQuery(document).ready(function() {    
         App.init(); // initlayout and core plugins
         $('.btn-delete').live('click', function (e) {
             e.preventDefault();

             if (confirm("确认删除此专题 ?") == false) {
                 return;
             }
             
             var test=$(this).prev().prev().attr("value");
             location.href = "delete/" + test;
         });
      });
   </script>
   <!-- END JAVASCRIPTS -->
</body>
</html>