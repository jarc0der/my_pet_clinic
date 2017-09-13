<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pet Clinic - Owners list</title>
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
            <div class="col-lg-12">
                Owners lists
				<table class="table table-striped">
					<tr>
						<th>Link</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>City</th>
						<th>Address</th>
						<th>Telephone</th>
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
								<p>Pets List:</p>
								
								<c:forEach var="pet" items="${owner.pets }">
									${pet.name}
								</c:forEach>
							</td>
						</tr>
					</c:forEach>
				</table>
            </div>
        </div>
        
        <!-- Footer -->
		<%@include file="./template/footer.jsp" %>
    </div>
</body>
</html>