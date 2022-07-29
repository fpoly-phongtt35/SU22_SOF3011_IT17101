<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>For User</title>
</head>
<body>
	<h1>Danh sách sản phẩm</h1> <h3>${sessionScope.username}</h3>
	<c:forEach items="${products}" var="product">
		<p>${product.name} - ${product.price} VNĐ </p>
	</c:forEach>
</body>
</html>