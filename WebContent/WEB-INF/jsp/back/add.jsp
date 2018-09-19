<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>新增列表内容</title>
<link href="<%=basepath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=basepath%>resources/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="<%=basepath%>resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
	<form action="<%=basepath%>add.action" id="mainForm" method="post">
		<input type="hidden" name="currentPage" id="currentPage"
			value="${page.currentPage}" />
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">内容管理</a>
				&gt; 新增列表内容
			</div>
			<div class="rightCont">
				<table class="tab1">
					<tbody>
						<tr>
						<td width="90" align="right">指令序号：</td>
							<td><input name="addcommandid" type="text" class="allInput"
								value="${addcommandid}" autocomplete="off" /></td>
							<td width="90" align="right">指令名称：</td>
							<td><input name="addcommand" type="text" class="allInput"
								value="${addcommand}" autocomplete="off" /></td>
							<td width="90" align="right">描述：</td>
							<td><input name="adddescription" type="text"
								class="allInput" value="${adddescription}" autocomplete="off" /></td>
							<td width="85" align="right"><input type="submit"
								class="tabSub" value="提交" /></td>
						</tr>
					</tbody>
				</table>
				<div class="zixun fix">
					<table id="add" class="tab2" width="100%">
						<tbody>
							<tr>
								<th>&nbsp;&nbsp;&nbsp;&nbsp;序号</th>
								<th>新增内容详情</th>
								<th>操作&nbsp;&nbsp;&nbsp;&nbsp;</th>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;1</td>
								<td><textarea name="addcontent" cols="100" rows="2"></textarea></td>
								<td><a href="#">撤销</a>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 	<a href="javascript:nextline();">新增行</a> --></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;2</td>
								<td><textarea name="addcontent" cols="100" rows="2"></textarea></td>
								<td><a href="#">撤销</a>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 	<a href="javascript:nextline();">新增行</a> --></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;3</td>
								<td><textarea name="addcontent" cols="100" rows="2"></textarea></td>
								<td><a href="#">撤销</a>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 	<a href="javascript:nextline();">新增行</a> --></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>