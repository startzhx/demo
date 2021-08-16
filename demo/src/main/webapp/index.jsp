<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>注册</h2>
	<form action="regist" method="post">
		<table>
			<tr>
				<td>员工姓名:</td>
				<td><input name="ename" type="text"/>
				</td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td><input name="hiredate"/>
				</td>
			</tr>
			<tr>
				<td>薪水:</td>
				<td><input name="sal"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
</body>
</html>