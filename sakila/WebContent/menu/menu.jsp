<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Menu</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="/sakila/mainStyle.css" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
	<div id="sidebar">
		<h3>Sakila Movie</h3>
		
		<table id="staff">
			<tr>
				<td rowspan="2"><a href="#" id="alink" class='fas fa-user-circle' style='font-size:60px'></a></td>
				<td>서울 지점</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/auth/StaffInfoServlet">${loginStaff}관리자님</a></td>
			</tr>
		</table>
		
		<div>
			<a class="btn btn-sm btn-secondary" id="abtn" href="${pageContext.request.contextPath}/auth/LogoutServlet">로그아웃</a>
		</div>

		<h3>Menu</h3>
			<ul class="linkedList">
				<li class="line">
					<a href="${pageContext.request.contextPath}/auth/IndexServlet">홈</a>
				</li>
				<li>
					<a href="#">영화 반납</a>
				</li>
				<li class="line">
					<a href="#">회원목록 관리</a>
				</li>
				<li>
					<a href="#">영화재고 관리</a>
				</li>
				<li>
					<a href="#">영화배우 관리</a>
				</li>
				<li>
					<a href="#">영화 출연배우 등록</a>
				</li>
				<li class="line">
					<a href="#">매장 통계</a>
				</li>
				<li class="last">
					<a href="#">MVP</a>
				</li>
			</ul>
	</div>
</body>
</html>