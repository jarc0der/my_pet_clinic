<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Onwer creation form</title>
</head>
<body>
	<form:form modelAttribute="owner" method="POST">
		<!--   TestID : <form:input path="id"/> -->
		<br>
		First name: <form:input path="firstName"/>
		<form:errors path="firstName" />
		
		<br>
		Last name: <form:input path="lastName"/>
		<br>
		Address: <form:input path="address"/>
		<form:errors path="address" />
		<br>
		City: <form:input path="city"/>
		<br>
		Telephone: <form:input path="telephone"/>
		<form:errors path="telephone" />
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>