<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="row">
	<div class="col-4">
		오늘 접속자 수 : ${map["returnStats"].cnt} / 총 접속자 수 : ${map["totalStats"]}
	</div>
	<form method="post" class="form-group col-md-4" action="${pageContext.request.contextPath}/LoginServlet">
		<table style="margin : auto; width : 300px;">
			<tr>
				<td style="padding-buttom : 20px; text-align : center;">
					<i class='fa fa-user-circle' style='font-size:96px; color : gray;'></i>
				</td>
			</tr>
			<tr>
				<td style="padding-buttom : 20px;">
					<input class="form-control" type="text" name="id" placeholder="ID">
				</td>
			</tr>
			<tr>
				<td style="padding-buttom : 20px;">
					<input class="form-control" type="password" name="password" placeholder="PW">
				</td>
			</tr>
			<tr>
				<td>
					<button class="form-control btn btn-success" type="submit" id="">Log-in</button>
				</td>
			</tr>
		</table>
	</form>
</div>
	
</body>
</html>