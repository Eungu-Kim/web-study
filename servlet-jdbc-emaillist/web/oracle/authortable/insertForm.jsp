<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>저자 정보 입력 양식</title>
</head>
<body>
	<h2>저자 정보 입력 양식</h2>
<form action="insertAuthorTable.jsp" method="post">
<table >
	<tr>
		<td>저자명</td>
		<td><input type="text" name="author_name" size="20"></td>
	</tr>
	<tr>
		<td>저자번호</td>
		<td><input type="text" name="author_id" size="20"></td>
	</tr>
	<tr>
		<td>설명</td>
		<td><input type="text" name="author_desc" size="20"></td>
	</tr>
	<tr>
		<td><input type="submit" value="전송" ></td>
		<td><input type="reset" value="초기화" ></td>
	</tr>
</table>
</form>


</body>
</html>