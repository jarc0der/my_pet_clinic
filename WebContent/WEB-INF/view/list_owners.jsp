<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selection results</title>
</head>
<body>
	<h4>Owners lists</h4>
	<table border="1">
		<tr>
			<td>Link</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>City</td>
			<td>Address</td>
			<td>Telephone</td>
		</tr>
		<c:forEach var="owner" items="${selection}">
			<tr>
				<td><a href="/owners/${owner.id }">${owner.id}</a></td>
				<td>${owner.firstName }</td>
				<td>${owner.lastName }</td>
				<td>${owner.city }</td>
				<td>${owner.address }</td>
				<td>${owner.telephone }</td>
			</tr>
			<tr>
				<td colspan="7">
				Pets List: 
					<c:forEach var="pet" items="${owner.pets }">
						${pet.name}
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>