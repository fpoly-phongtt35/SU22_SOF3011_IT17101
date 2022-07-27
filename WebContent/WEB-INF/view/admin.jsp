<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>For Admin</title>
</head>
<body>
	<h1>Danh sách sản phẩm</h1>
	<table border=1>
		<tr>
			<th> Mã </th>
			<th> Tên </th>
			<th> Giá </th>
			<th> Số lượng </th>
			<th> Hành động </th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td> ${product.id} </td>
				<td> ${product.name} </td>
				<td> ${product.price} </td>
				<td> ${product.quantity} </td>
				<td>
					<a href="#">Sửa</a>
					<a href="#">Xoá</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>