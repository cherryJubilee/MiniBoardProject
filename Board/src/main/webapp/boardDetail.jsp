<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<title>게시물 수정</title>
<style>
<
style>.title {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 20px;
}

.content {
	font-size: 16px;
	line-height: 1.5;
	margin-bottom: 20px;
}

.btn-like {
	background-color: pink;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.btn-like:hover {
	background-color: #ff69b4;
}

.btn-unlike {
	background-color: #ccc;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.btn-unlike:hover {
	background-color: #999;
}

.btn-like:hover {
	background-color: #ff69b4;
}

.btn-unlike {
	background-color: #ccc;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.btn-unlike:hover {
	background-color: #999;
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
</style>
<script>
	var likeButton = document.querySelector(".btn-like");
	var unlikeButton = document.querySelector(".btn-unlike");
	var clicked = false;

	likeButton.addEventListener("click", function() {
		if (!clicked) {
			likeButton.style.display = "none";
			unlikeButton.style.display = "inline-block";
			clicked = true;
		}
	});

	unlikeButton.addEventListener("click", function() {
		if (clicked) {
			unlikeButton.style.display = "none";
			likeButton.style.display = "inline-block";
			clicked = false;
		}
	});
</script>
</head>
<body>

	<h1>게시물 상세보기</h1>
	<br>

	<div class="title">
		제목: <span>${BOARDVO.boardTitle}</span>
	</div>
	<br>
	<div class="content">
		글내용: <span>${BOARDVO.boardContent}</span>
	</div>
	<div class="content">
		작성자: <span>${BOARDVO.boardWriter}</span>
	</div>
	<div class="content">
		작성일: <span>${BOARDVO.boardPostdate}</span>
	</div>

	<!-- <input type="submit" value="좋아요" class="btn-like"> -->
	<button class="btn-like">좋아요</button>
	<button class="btn-unlike" style="display: none;">좋아요 취소</button>

	<h2>댓글</h2>
	<form method="POST" action="comments">
		<input type="hidden" name="boardId" value="${BOARDVO.boardNum}">
		<label for="comment">댓글 작성:</label>
		<textarea name="content" id="comment" rows="5" cols="50"></textarea>
		<button type="submit" class="btn">댓글추가</button>
		<a href="boardList" class="btn btn-cancel">나가기</a>
	</form>
	
	<div class="table-responsive">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<th scope="col">작성자</th>
					<th scope="col">글내용</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="comment" items="${COMMENTSVO}">
					
					<tr>
						<td>${comment.commentWriter}</td>
						<td>${comment.commentContent}</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
		

</body>
</html>