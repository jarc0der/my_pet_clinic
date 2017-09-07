<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3> Vets of petclinic</h3>
	
	<table border="1">
		<tr>
			<td>Vet</td>
			<td>Specialties</td>
		</tr>
		<c:forEach var="vet" items="${vets}">
			<tr>
				<td>${vet.firstName}  ${vet.lastName}</td>
				<td>
					<c:forEach var="specialty" items="${vet.specialties}">
						${ specialty.name }
					</c:forEach>
					<c:if test="${vet.nrOfSpecialties == 0}">none</c:if>
				</td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>