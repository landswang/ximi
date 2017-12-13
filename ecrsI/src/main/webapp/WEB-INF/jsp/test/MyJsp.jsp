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



	<!-- 
	<br> currentPage:
	<input type="text" name="currentPage" id="currentPage" />
	<br> pageSize:
	<input type="text" name="pageSize" id="pageSize" />
	<br> eProduct:
	<input type="text" name="eProduct" id="eProduct" />
	<br> aBaseName:
	<input type="text" name="aBaseName" id="aBaseName" />
	<br>startTime:
	<input type="text" name="startTime" id="startTime" />
	<br>endTime
	<input type="text" name="endTime" id="endTime" />
	<br>需要修改状态的id:
	<input type="text" name="dataIndex" id="dataIndex" />
	<br>（查询的状态码） 修改后的状态码:
	<input type="text" name="status" id="status" />
	<br> loanId:
	<input type="text" name="loanId" id="loanId" />
	<br> -->


	<!-- 	<hr>
	<br> loanId:
	<input type="text" name="loanId" id="loanId" />
	<br> status:
	<input type="text" name="status" id="status" />
	<br> startTime:
	<input type="text" name="startTime" id="startTime" />
	<br> eProduct:
	<input type="text" name="eProduct" id="eProduct" />
 -->

	<hr>
	<br> 修改的id-loanId:
	<input type="text" name="loanId" id="loanId" />
	<br> 介绍信startTime:
	<input type="text" name="startTime" id="startTime" />
	<br> 注销登记申请书endTime:
	<input type="text" name="endTime" id="endTime" />
	<br> 结清证明eProduct:
	<input type="text" name="eProduct" id="eProduct" />
	<br> 其他aBaseName:
	<input type="text" name="aBaseName" id="aBaseName" />
	<br> outRemark:
	<input type="text" name="outRemark" id="outRemark" />

	<br> outReason:
	<input type="text" name="outReason" id="outReason" />
	<br> status:
	<input type="text" name="status" id="status" />
	<br> currentPage:
	<input type="text" name="currentPage" id="currentPage" />


	<br> dataIndex:
	<input type="text" name="dataIndex" id="dataIndex" />


	<input type="button" value="提交" id="supp" />


	<br>
	<!-- 
	<form action="user/sby" method="post">
		<input type="text" name="userId"> <input type="submit"
			value="tijiao">
	</form> -->




</body>
<script>
	$(function() {

		$("#supp").click(function() {
			var sc = {
				loanId : $("#loanId").attr("value"),
				startTime : $("#startTime").val(),
				endTime : $("#endTime").val(),
				eProduct : $("#eProduct").val(),
				aBaseName : $("#aBaseName").val(),
				currentPage : $("#currentPage").val(),
				dataIndex : $("#dataIndex").val(),
				outRemark : $("#outRemark").val(),
				outReason : $("#outReason").val(),
				status : $("#status").val()
			};

			$.ajax({
				type : "post",
				dataType : "json",
				contentType : "application/json",
				url : "Storage/newProducInformationByLoanId",
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


