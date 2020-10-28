<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h1>index.jsp</h1>
	<div>
		<span>${loginStaff}</span>관리자님
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/LogoutServlet">로그아웃</a>
	</div>
</body>
</html> -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>IndexPage</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="/sakila/mainStyle.css" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    </head>
<body>
	<div id="bg">
		<div id="outer">
			<div id="main">
				<jsp:include page="/menu/menu.jsp"></jsp:include>
				<div id="content">
					<h2>index</h2>
					<p>index 페이지 입니다.</p>
					<br class="clear" />
				</div>
				<br class="clear" />
			</div>
			<br class="clear" />
		</div>
	</div>
</body>
</html>