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
	<h3>Add new visit for ${pet.name}</h3>
	<form:form modelAttribute="visit" method="POST">
		Date: <form:input path="visitDate"/>
		<br>
		Description: <form:input path="description"/>
		
		<input type="submit" value="Submit">
	</form:form>
	
	
</body>
</html>