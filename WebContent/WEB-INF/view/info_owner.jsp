<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		Owner details
		<table border="1">
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>City</td>
				<td>Address</td>
				<td>Telephone</td>
			</tr>
			<tr>
				<td>${findOwner.firstName }</td>
				<td>${findOwner.lastName }</td>
				<td>${findOwner.city }</td>
				<td>${findOwner.address }</td>
				<td>${findOwner.telephone }</td>
			</tr>
		</table>
			
	</div>
	
	<div>
		<a href="/owners/${findOwner.id}/edit">Edit owner</a>
		<a href="${findOwner.id }/pets/new">Add pet</a>
	</div>
	
	<div>
		<h4>Pet list:</h4>
		<table border="1">
			<tr>
				<td>Name</td>
				<td>Birth date</td>
			</tr>
			<c:forEach var="pet" items="${findOwner.pets }">
				<tr>
					<td>${pet.name }</td>
					<td>${pet.birthDate }</td>
				</tr>
				<tr>
					<td colspan="1">
						<c:forEach var="visit" items="${pet.visits }">
							Date: ${visit.visitDate} # ${visit.description } <br>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td><a href="${findOwner.id }/pets/${pet.id}/edit">Edit pet</a></td>
					<td><a href="${findOwner.id }/pets/${pet.id}/visits/new">Add visit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>