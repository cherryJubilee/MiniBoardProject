<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<style>
/* 전체 레이아웃 */
.container {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
}

/* 입력 필드 레이아웃 */
.form-group {
	margin-bottom: 20px;
}

/* 라벨 스타일 */
label {
	display: block;
	margin-bottom: 5px;
}

/* 입력 필드 스타일 */
input[type=text], textarea {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

/* 버튼 스타일 */
.btn {
	display: inline-block;
	padding: 10px 20px;
	border-radius: 5px;
	background-color: #007bff;
	color: #fff;
	text-decoration: none;
	cursor: pointer;
}

.btn-cancel {
	background-color: #ccc;
}

/* 입력 필드 간격 조절 */
.form-group>* {
	margin-bottom: 10px;
}

/* 가운데 정렬 */
.text-center {
	text-align: center;
}
</style>
</head>
<body>

	<%
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String formattedDate = sdf.format(now);
	%>
	<div class="container">
		<h1 class="text-center">게시물 작성</h1>
		<form action="posts" method="post"> <!-- 저장 누르면 posts경로로 이동 -->

			<label for="title">제목</label> <input type="text" name="postTitle">

			<label for="author">작성자 </label> <input type="text" name="postWriter"
				value="${MYID}" readonly="readonly"> <label for="content">내용</label>
			<textarea name="content" rows="5"></textarea>
			
			

			<label for="created-at">작성일 </label> <input type="text"
				name="created-at" value=<%=formattedDate%> readonly="readonly">

			<button type="submit" class="btn">저장</button>
			<a href="boardList" class="btn btn-cancel">취소</a>
		</form>
	</div>
</body>
</html>