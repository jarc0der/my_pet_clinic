<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Looking for owners</title>
</head>
<body>
	<form:form modelAttribute="owner" action="/owners" method="POST" >
		<form:input path="lastName"/>
		
		<input type="submit" value="Find"> 
	</form:form>
	
	<div>
		<a href="/owners/new">Add new</a>
	</div>
	
	
</body>
</html>