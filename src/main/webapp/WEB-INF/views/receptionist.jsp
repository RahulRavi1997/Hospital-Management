<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Receptionist page</title>
      <jsp:include page="access.jsp"/>
</head>
<body>
      <jsp:include page="Header.jsp"/>
	<form action="createPatient" method="get">
	  <input type="submit" class="btn btn-info" value="CreatePatient">
	</form>
    <form action="displayPatients" method="get">
	  <input type="submit" class="btn btn-info" value="DisplayPatient">
	</form>
	<form action="createVisit" method="get">
	  <input type="submit" class="btn btn-info" value="CreateVisit">
	</form>
	<form action="displayVisits" method="get">
	  <input type="submit" value="DisplayVisit" class="btn btn-info">
	</form>
</body>
      <jsp:include page="footer.jsp"/>

</html>
