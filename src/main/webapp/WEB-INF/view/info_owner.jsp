<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PetClinic - Owner Info</title>
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
				<h4>Owner details</h4>
				<table class="table table-condensed">
					<tr>
						<th>First Names</th>
						<th>Last Name</th>
						<th>City</th>
						<th>Address</th>
						<th>Telephone</th>
					</tr>
					<tr>
						<td>${findOwner.firstName }</td>
						<td>${findOwner.lastName }</td>
						<td>${findOwner.city }</td>
						<td>${findOwner.address }</td>
						<td>${findOwner.telephone }</td>
					</tr>
				</table>

				<div>
					<a href="/owners/${findOwner.id}/edit">Edit owner</a>
					<a href="${findOwner.id }/pets/new">Add pet</a>
				</div>
				
				<br>
				<h4>Pet list:</h4>
				<table class="table">
					<tr>
						<th>Name</th>
						<th>Birth date</th>
					</tr>
					<c:forEach var="pet" items="${findOwner.pets}">
						<tr>
							<td>${pet.name }</td>
							<td>${pet.birthDate }</td>
						</tr>
						<tr>
							<c:if test="${pet.nrOfVisits > 0 }">
								<td colspan="1">
									<c:forEach var="visit" items="${pet.visits }">
										Date: ${visit.visitDate} # ${visit.description } <br>
									</c:forEach>
							</td>
							</c:if>
						</tr>
						<tr>
							<td><a href="${findOwner.id }/pets/${pet.id}/edit">Edit pet</a></td>
							<td><a href="${findOwner.id }/pets/${pet.id}/visits/new">Add visit</a></td>
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