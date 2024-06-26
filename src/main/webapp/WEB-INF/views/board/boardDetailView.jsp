<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="outer" align="center">
		<div class="title">게시판 상세조회</div>
		<br>
		<table border="1">
			<tr>
				<td width="100">글번호</td>
				<td width="500">${board.boardNo }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${board.boardTitle}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.boardWriter }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${board.count }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${board.createDate }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td height="100">${board.boardContent }</td>
			</tr>
		</table>
		<br>
		<table border="1">
			<tr>
				<td width="100">댓글작성</td>
				<td width="400">
					<textarea></textarea>
				</td>
				<td width="100">
					<button>등록</button>
				</td>
			</tr>
			<tr>
				<%-- 댓글 총 수 표시 --%>
				<td colspan="3"><b>댓글(@@)</b></td>
			</tr>
			<%-- 댓글 목록 --%>
			<c:forEach var="reply" items="${list}">
				<tr>
					<td>${reply.replyWriter }</td>
					<td>${reply.replyContent }</td>
					<td>${reply.createDate }</td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
	</div>
</body>
</html>