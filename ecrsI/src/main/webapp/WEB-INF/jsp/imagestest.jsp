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

<title>My JSP 'imagestest.jsp' starting page</title>

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
	<br>

	上传文件：
	<form action="imagesDo/uploadImages" method="post"
		enctype="multipart/form-data">
		选择文件:<input type="file" name="file"> <br>
		aBaseName-保存地址:<input type="text" name="aBaseName"><br>
		loanId:<input type="text" name="loanId"><br>
		serialNo:<input type="text" name="serialNo"><br>
		eProduct-类型:<input type="text" name="eProduct"><br>
		<input type="submit" value="上传">
	</form>
	<hr>
	<hr>
		删除文件：
	<form action="imagesDo/deleteImages" method="post">
		aBaseName-保存地址:<input type="text" name="aBaseName"><br>
		loanId:<input type="text" name="loanId"><br>
		serialNo:<input type="text" name="serialNo"><br>
		loanVoucher-文件名:<input type="text" name="loanVoucher"><br>
		eProduct-所属类型:<input type="text" name="eProduct"><br>
		<input type="submit" value="提交">
	</form>

	<br><br>
	<a href="wordOp/doc2">To Document Page!</a>
</body>
</html>
