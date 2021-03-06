<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<title>update Emp</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"
		  href="${path}/css/style.css" />
	<script src="${path}/js/jquery-3.3.1.min.js"></script>
	<script>
		$(function () {
			$.ajax({
				url:"${path}/user/showDep",
				dataType:"JSON",
				type:"POST",
				success:function (data) {
					$.each(data,function (i,p) {
						var opt = $("#opt").val();
						if(opt!=(p.id+","+p.name)){
							var option = $("<option>").text(p.name).val(p.id+","+p.name);
							$("#dep").append(option);
						}
					})
				}
			})
		})
	</script>
</head>

<body>
<div id="wrap">
	<div id="top_content">
		<div id="header">
			<div id="rightheader">
				<p>
					2009/11/20
					<br />
				</p>
			</div>
			<div id="topheader">
				<h1 id="title">
					<a href="#">Main</a>
				</h1>
			</div>
			<div id="navigation">
			</div>
		</div>
		<div id="content">
			<p id="whereami">
			</p>
			<h1>
				update Emp info:
			</h1>
			<form action="${path}/user/updateUser" method="post" enctype="multipart/form-data">
				<table cellpadding="0" cellspacing="0" border="0"
					   class="form_table">
					<tr>
						<td valign="middle" align="right">

						</td>
						<td valign="middle" align="left">
							<input type="hidden" name="user1.id" value="${user.id}" readonly>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							头像:
						</td>
						<td valign="middle" align="left">
							<img width="40px" height="40px" src="${path}/img/${user.src}" />
							<input type="file" name="upload" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							用户名:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="user1.name" value="${user.name}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							工资:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="user1.salary" value="${user.salary}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							年龄:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="user1.age" value="${user.age}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							部门:
						</td>
						<td valign="middle" align="left">
							<select id="dep" name="depId">
								<option id="opt" value="${user1.dId},${user1.dName}" selected="selected">${user.dName}</option>
							</select>
						</td>
					</tr>
				</table>
				<p>
					<input type="submit" class="button" value="修改" />
				</p>
			</form>
		</div>
	</div>
	<div id="footer">
		<div id="footer_bg">
			ABC@126.com
		</div>
	</div>
</div>
</body>
</html>
