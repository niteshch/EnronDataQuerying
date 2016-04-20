
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<title>Email Details</title>
 
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Email Details</a>
	</div>
  </div>
</nav>
 
<div class="container">
 
  <div class="row">
  	<hr>
	<hr>
	<div>
		<h2>Email List</h2>
		<c:if test="${not empty emailList}">
		<ul>
			<c:forEach var="email" items="${emailList}">
				<li>
					<span>Subject: ${email.subject}</span><br/>
					<span>Content: ${email.content}</span><br/>
					<span>Time Sent: ${email.timeSent}</span><br/>
					<span>Sender Name: ${email.senderName}</span><br/>
					<span>Recepient List: ${email.recepientList}</span><br/>
				</li>
			</c:forEach>
		</ul>
		</c:if>
	</div>
  </div>
 
 
  <hr>
  <footer>
	<p>&copy; TextIQ 2016</p>
  </footer>
</div>
 
<%-- <spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" /> --%>
 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

 
</body>
</html>