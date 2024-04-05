<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#list-area{
		width: 500px;
		border:7px double #ffc9d7;
		border-collapse:collapse;
	}
	tr{
		padding:2px;
		border: 2px dashed #ffc9d7;
	}
	td{
		padding:2px;
		text-align:center;
	}
	.td-title {
		padding-left:20px;
		text-align:left;
		text-decoration:none;
	}
	.td-title a{
		text-decoration:none;
		color : #6b6b6b;
	}
	#paging-area a{
		text-decoration:none;
		color: #6b6b6b;
		font-size:18px;
	}
	.selectOption{
		text-align: center;
		width:70px; height: 34px;
		background-color : #fff7e4; color : #6b6b6b;
		border: 2px solid #ffc9d7;
		margin-right: 7px;
		font-size:16px;
	}
	.searchBox{
		width: 200px; height: 28px;
		color : #6b6b6b;
		background-color : #fff7e4;
		border: 2px dashed #ffc9d7;
		margin-right: 3px;
		font-size:16px;
	}
	.searchButton{
		height: 34px;
		width: 45px;
	}
	
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<div class="outer">
		<br>
		<div class="title">게시판</div>
		<div id="searhc-area">
			<form action="search.bo" method="get">
				<input type="hidden" name="cpage" value="1" />
				<select class="selectOption" name="condition">
					<option value="writer">작성자</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="text" class="searchBox" name="keyword">
				<button type="submit" class="searchButton">검색</button>
			</form>
		</div>
		<br>
		<table id="list-area">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.boardNo }</td>
					<td class="td-title"><a href="detail.bo?bno=${board.boardNo}">${board.boardTitle }</a></td>
					<td>${board.boardWriter }</td>
					<td>${board.count }</td>
					<td>${board.createDate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div id="paging-area">
			<c:if test="${pi.currentPage == 1}">
				<a>[이전]</a>
			</c:if>
			<c:if test="${pi.currentPage > 1}">
				<a href="list.bo?cpage=${pi.currentPage-1}">[이전]</a>
			</c:if>
			<c:forEach var="page" begin="1" end="${pi.maxPage}" >
				<a href="list.bo?cpage=${page}">${page}</a>
			</c:forEach>
			<c:if test="${pi.currentPage == pi.maxPage}">
				<a>[다음]</a>
			</c:if>
			<c:if test="${pi.currentPage < pi.maxPage}">
				<a href="list.bo?cpage=${pi.currentPage+1}">[다음]</a>
			</c:if>
		</div>
		<br>
	</div>
</body>
</html>