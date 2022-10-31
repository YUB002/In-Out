<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
</head>
<body>
	<table border=1>
		<tr>
			<th>Seq
			<th>Writer
			<th>message
		</tr>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach var="i" items="${list}">
					<tr>
						<td>${i.seq}
						<td>${i.writer }
						<td>${i.contents}
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan=3>출력할 내용이 없습니다.
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>