<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="outer" align="center">
		<br>
		<h1>게시판 상세조회</h1>
		<br>
		<table border="1">
			<tr>
				<td width="100">글번호</td>
				<td width="500">@@</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>@@@@</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>@@@@</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>@@@@</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>@@@@-@@-@@</td>
			</tr>
			<tr>
				<td>내용</td>
				<td height="100">@@@@</td>
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
			<tr>
				<td>@@@@</td>
				<td>@@@@@!!!###</td>
				<td>@@@@-@@-@@</td>
			</tr>
		</table>
		<br><br>
	</div>
</body>
</html>