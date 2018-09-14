<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>
	Dear <strong>${email}</strong>, Welcome to Admin Page.
	
	<a href="createPhysician">Add Doctor </a>
	<a href="AddWard">Add Ward </a>
	<a href="displayPhysicians">Display Doctor </a>
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
