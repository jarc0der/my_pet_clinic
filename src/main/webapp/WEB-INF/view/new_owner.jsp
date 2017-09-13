<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PetClinic - Owners</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
   <!-- Header -->
    <div class="container">
        <%@include file="./template/header.jsp" %>
        
        <!-- Content -->
        <div class="row">
            <div class="col-lg-4">
				<form:form modelAttribute="owner" method="POST" cssClass="center">
					<div class="form-group">
					    <label for="email">First name:</label>
					    <form:input path="firstName" cssClass="form-control"/>
					    <form:errors path="firstName" />
				  	</div>
				  	
				  	<div class="form-group">
					    <label for="fname">Last name:</label>
					    <form:input path="lastName" cssClass="form-control"/>
					    <form:errors path="lastName" />
				  	</div>
				  	
				  	<div class="form-group">
					    <label for="fname">Address:</label>
					    <form:input path="address" cssClass="form-control"/>
					    <form:errors path="address" />
				  	</div>
				  	
				  	<div class="form-group">
					    <label for="fname">City:</label>
					    <form:input path="city" cssClass="form-control"/>
					    <form:errors path="city" />
				  	</div>
				  	
				  	<div class="form-group">
					    <label for="fname">Telephone:</label>
					    <form:input path="telephone" cssClass="form-control"/>
					    <form:errors path="telephone" />
				  	</div>

					<input type="submit" value="Submit" class="btn btn-default">
				</form:form>
			 </div>
        </div>
        
       	<!-- Footer -->
		<%@include file="./template/footer.jsp" %>
    </div>
</body>
</html>