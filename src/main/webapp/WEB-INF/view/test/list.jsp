<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  

<%@ include file="../shared/taglib.jsp"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
<head>  
<base href="<%=basePath%>">  
  
<title>用户选择</title> 
     <%@ include file="../shared/importCss.jsp"%>
   <!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
   <link href="<c:url value='/plugins/jquery-multi-select/css/multi-select.css'/>" rel="stylesheet" type="text/css"/>
   
</head>  
  
<body>
    <form:form modelAttribute="user" method="post">  
  		<form:select multiple="true" path="ballIds" class="multi-select" items="${ballModel }" ></form:select>  
	    <input type="submit" value="submit"/>
	</form:form>
	<a href="test/add">add</a>
</body>  

   <%@ include file="../shared/importJs.jsp"%>

   <script src="<c:url value='/plugins/jquery-multi-select/js/jquery.multi-select.js'/>" type="text/javascript"></script>   
   <!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <!-- END PAGE LEVEL SCRIPTS -->  

   <script type="text/javascript">
      jQuery(document).ready(function() {    
         $("#ballIds").multiSelect();
      });
   </script>
   <!-- END JAVASCRIPTS -->


</html>  