<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="/input.message">
		<tr>
			<th>InputForm
		</tr>
		<tr>
			<input type=text name="writer" placeholder="작성자를 입력해주세요.">
		</tr>
		<tr>
			<input type=text name="message" placeholder="메세지를 입력해주세요.">
		</tr>
		<tr>
			<td><button>보내기</button> <a href="index.jsp"><button
						type=button>나가기</button></a>
		</tr>
	</form>

</body>
</html>