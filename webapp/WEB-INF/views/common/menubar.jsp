<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap" rel="stylesheet">
<style>
	h1{	color:#f2aabc;	font-family: "Single Day", cursive;  font-weight: 700; font-size:40px;}
	tr, td, input, button{font-family: "Single Day", cursive; font-size : 16px;}
	.login-area a{
		color : black;
		text-decoration: none;
		font-size : 16px;
		font-family: "Single Day", cursive;
	}
	.nav-area{
		background:#ffd9e5; color:white; height:50px;
	}
	.menu{display: table-cell; width: 250px; height: 50px;
		font-family: "Single Day", cursive; 
		vertical-align:middle; font-size:26px; font-weight:500;}
	.menu:hover{background:#ffccdc; cursor:pointer;}
	/*공통적으로 사용되는 css*/
	.outer{
		width: 1000px;
		background: #ffd9e5;
		color: white;
		margin: auto;
		margin-top:50px
	}
</style>
</head>
<body>
	<h1 align="center">Welcome to Mybatis World</h1>
	<br>
	<div class="login-area" align="right">
		<!-- 로그인 전 표시할 부분 -->
		<form>
			<c:if test="${loginUser == null}">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userId"></td>
						<td rowspan="2"><button type="submit" style="height:50px;">로그인</button></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="userPwd"></td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<a href="">회원가입</a>
							<a href="">아이디/비번찾기</a>
						</td>
					</tr>
				</table>
			</c:if>
		</form>
		<!-- 로그인 후 표시할 부분 -->
		<c:if test="${loginUser != null}">
			<div>
				<table>
					<tr>
						<td colspan="2"><h3>@@@님 환영합니다.</h3></td>
					</tr>
					<tr aligin="center">
						<td><a href="">마이페이지</a></td>
						<td><a href="">로그아웃</a></td>
					</tr>
				</table>
			</div>
		</c:if>
	</div>
	<br>
	<div class="nav-area" align="center">
		<div class="menu">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu">게시판</div>
		<div class="menu">ETC</div>
	</div>
</body>
</html>