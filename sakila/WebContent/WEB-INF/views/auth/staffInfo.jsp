<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>StaffInfo</title>
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
					<h2>관리자 상세정보</h2>
					<table>
						<tr>
							<td>별명 : </td>
							<td>${staffInfo.username}</td>
						</tr>
						<tr>
							<td>이름 : </td>
							<td>${staffInfo.fullname}</td>
						</tr>
						<tr>
							<td>연락처 : </td>
							<td>${staffInfo.phone}</td>
						</tr>
						<tr>
							<td>주소 : </td>
							<td>${staffInfo.address}, ${staffInfo.city}, ${staffInfo.country}</td>
						</tr>
						<tr>
							<td colspan = "2">${staffInfo.city}, ${staffInfo.country}</td>
						</tr>
						<tr>
							<td>E-mail : </td>
							<td>${staffInfo.email}</td>
						</tr>
					</table>
					<br class="clear" />
				</div>
				<br class="clear" />
			</div>
			<br class="clear" />
		</div>
	</div>
</body>
</html>