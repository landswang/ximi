<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<script src="<%=path%>/resource/script/jquery-1.6.4.js"></script>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


</head>

<body>
	This is my JSP page.




	<br> userName:
	<input type="text" name="userName" id="userName" />
	<br> password:
	<input type="text" name="password" id="password" />
	<br> verificationCode:
	<input type="text" name="verificationCode" id="verificationCode" />
	<br>

	<input type="button" value="提交" id="supp" />


	<br>
	
	
	

</body>
<script>
	$(function() {

		$("#supp").click(function() {
			var sc = {
					userName : $("#userName").attr("value"),
					password : $("#password").val(),
					verificationCode : $("#verificationCode").val()
			};

			$.ajax({
				type : "post",
				dataType : "json",
				contentType : "application/json",
				url : "user/login",
				data : JSON.stringify(sc),
				success : function(msg) {
					alert(msg);
				},
				error : function(data) {
					alert("error");
				}
			});
		});
	});
</script>
</html>


