<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Update and add pets</h2>
	${owner.id }
	
	<form:form modelAttribute="pet" method="POST">
		<form:hidden path="id" />
 		Name: <form:input path="name"/>
 		<form:errors path="name"/>
 		<br>
 		Birthday: <form:input path="birthDate"/>
 		<form:errors path="birthDate"/>
 		<br>
 		Type: 
 		
	 	<form:select path="petType">
			 <form:options items="${types}" itemLabel="name" itemValue="name"/>
		</form:select> 
 		
 		<input type="submit" value="Submit">
 	</form:form>
	
</body>
</html>