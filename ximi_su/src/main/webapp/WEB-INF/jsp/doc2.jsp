<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Document</title>
</head>
<body>	
	<hr>
	<h2>下载进件统计excel</h2>
	<br>
	<form action="../statisticalForm/downInAStatisticalExcel" method="post">
		startTime:<input type="text" name="startTime" class="textField" /><br>
		endTime:<input type="text" name="endTime" class="textField" /><br>
		loanVoucher:<input type="text" name="loanVoucher" class="textField" /><br>
		aBaseName:<input type="text" name="aBaseName" class="textField" /><br>
		<div style="margin-top: 15px;">
			<input type="submit" value="保存Excel文档" />
		</div>
	</form>
	
	<hr>
	<h2>下载excel</h2>
	<br>
	<form action="../statisticalForm/downExcel" method="post">
		loanId:<input type="text" name="loanId" class="textField" /><br>
		serialNo:<input type="text" name="serialNo" class="textField" /><br>
		startTime:<input type="text" name="startTime" class="textField" /><br>
		endTime:<input type="text" name="endTime" class="textField" /><br>
		<div style="margin-top: 15px;">
			<input type="submit" value="保存Excel文档" />
		</div>
	</form>
	<hr>
	<h2>下载word</h2>
	<br>
	<form action="wordService" method="post">
 		<div id="file" align="center">
			合同编号： <input type="text" name="contractNum" class="textField" /> <br>
			<hr>
			甲方<br> 
			法定代表人：<input type="text" name="AlegalPerson" class="textField" /> <br>
			<hr>
			 乙方<br>
			借款人1： <input type="text" name="Bborrower1" class="textField" /> <br>
			证件类型： <input type="text" name="BpassType1" class="textField" /> <br>
			证件号码： <input type="text" name="BidNum1" class="textField" /> <br>
			住所地： <input type="text" name="Babode1" class="textField" /> <br>
			通讯地址： <input type="text" name="Baddress1" class="textField" /><br>
			 联系电话： <input type="text" name="Btel1" class="textField" /><br>
			 <hr>
			 借款人2： <input type="text" name="Bborrower2" class="textField" /> <br>
			证件类型： <input type="text" name="BpassType2" class="textField" /> <br>
			证件号码： <input type="text" name="BidNum2" class="textField" /> <br>
			住所地： <input type="text" name="Babode2" class="textField" /> <br>
			通讯地址： <input type="text" name="Baddress2" class="textField" /><br>
			 联系电话： <input type="text" name="Btel2" class="textField" /><br>
			 <hr>
			丙方<br>
			 抵押人1： <input type="text" name="Cpledger1" class="textField" /> <br>
			证件类型： <input type="text" name="CpassType1" class="textField" /> <br>
			证件号码： <input type="text" name="CidNum1" class="textField" /> <br>
			住所地： <input type="text" name="Cabode1" class="textField" /> <br>
			通讯地址： <input type="text" name="Caddress1" class="textField" /><br>
			 联系电话： <input type="text" name="Ctel1" class="textField" /><br>
			 <hr>
			 抵押人2： <input type="text" name="Cpledger2" class="textField" /> <br>
			证件类型： <input type="text" name="CpassType2" class="textField" /> <br>
			证件号码： <input type="text" name="CidNum2" class="textField" /> <br>
			住所地： <input type="text" name="Cabode2" class="textField" /> <br>
			通讯地址： <input type="text" name="Caddress2" class="textField" /><br>
			 联系电话： <input type="text" name="Ctel2" class="textField" /><br>
			 <hr>
			 抵押人3： <input type="text" name="Cpledger3" class="textField" /> <br>
			证件类型： <input type="text" name="CpassType3" class="textField" /> <br>
			证件号码： <input type="text" name="CidNum3" class="textField" /> <br>
			住所地： <input type="text" name="Cabode3" class="textField" /> <br>
			通讯地址： <input type="text" name="Caddress3" class="textField" /><br>
			 联系电话： <input type="text" name="Ctel3" class="textField" /><br>
			<hr>
			附则<br>
			合同总份数：<input type="text" name="maxContract" class="textField" /><br>
			甲方持有份数：<input type="text" name="Acontract" class="textField" /><br>
			乙方持有份数：<input type="text" name="Bcontract" class="textField" /><br>
			丙方持有份数：<input type="text" name="Ccontract" class="textField" /><br>
			<hr>
			抵押物清单<br>
			抵押物1<br>
			抵押物名称：<input type="text" name="pawnName1" class="textField" /><br>
			权属证书及编号：<input type="text" name="pawnNum1" class="textField" /><br>
			抵押物所在地：<input type="text" name="pawnAddress1" class="textField" /><br>
			抵押物的评估价值（元）：<input type="text" name="pawnValue1" class="textField" /><br>
			抵押物担保的债权数额（元）：<input type="text" name="pawnClaim1" class="textField" /><br>
			已为其他债权设定抵押金额（如有）：<input type="text" name="pawnOther1" class="textField" /><br>
			<hr>
			抵押物2<br>
			抵押物名称：<input type="text" name="pawnName2" class="textField" /><br>
			权属证书及编号：<input type="text" name="pawnNum2" class="textField" /><br>
			抵押物所在地：<input type="text" name="pawnAddress2" class="textField" /><br>
			抵押物的评估价值（元）：<input type="text" name="pawnValue2" class="textField" /><br>
			抵押物担保的债权数额（元）：<input type="text" name="pawnClaim1" class="textField" /><br>
			已为其他债权设定抵押金额（如有）：<input type="text" name="pawnOther2" class="textField" /><br>
			<hr>
			抵押物3<br>
			抵押物名称：<input type="text" name="pawnName3" class="textField" /><br>
			权属证书及编号：<input type="text" name="pawnNum3" class="textField" /><br>
			抵押物所在地：<input type="text" name="pawnAddress3" class="textField" /><br>
			抵押物的评估价值（元）：<input type="text" name="pawnValue3" class="textField" /><br>
			抵押物担保的债权数额（元）：<input type="text" name="pawnClaim3" class="textField" /><br>
			已为其他债权设定抵押金额（如有）：<input type="text" name="pawnOther3" class="textField" /><br>
			<hr>
			抵押物4<br>
			抵押物名称：<input type="text" name="pawnName4" class="textField" /><br>
			权属证书及编号：<input type="text" name="pawnNum4" class="textField" /><br>
			抵押物所在地：<input type="text" name="pawnAddress4" class="textField" /><br>
			抵押物的评估价值（元）：<input type="text" name="pawnValue4" class="textField" /><br>
			抵押物担保的债权数额（元）：<input type="text" name="pawnClaim4" class="textField" /><br>
			已为其他债权设定抵押金额（如有）：<input type="text" name="pawnOther4" class="textField" /><br>
			<hr>
			抵押物5<br>
			抵押物名称：<input type="text" name="pawnName5" class="textField" /><br>
			权属证书及编号：<input type="text" name="pawnNum5" class="textField" /><br>
			抵押物所在地：<input type="text" name="pawnAddress5" class="textField" /><br>
			抵押物的评估价值（元）：<input type="text" name="pawnValue5" class="textField" /><br>
			抵押物担保的债权数额（元）：<input type="text" name="pawnClaim5" class="textField" /><br>
			已为其他债权设定抵押金额（如有）：<input type="text" name="pawnOther5" class="textField" /><br>
			<hr>
		</div> 
		<div style="margin-top: 15px;">
			<input type="submit" value="保存Word文档" />
		</div>
	</form>

</body>
</html>