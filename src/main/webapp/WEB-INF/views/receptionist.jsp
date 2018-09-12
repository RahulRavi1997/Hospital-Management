<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Receptionist page</title>
</head>
<body>
	Dear <strong>${email}</strong>, Welcome to Receptionist Page.
	<a href="<c:url value="/logout" />">Logout</a>
	<form action="createpatient" method="get">
	  <input type="submit" value="CreatePatient">
	</form>
    <form action="searchpatient" method="get">
	  <input type="submit" value="SearchPatient">
	</form>
</body>
</html>
