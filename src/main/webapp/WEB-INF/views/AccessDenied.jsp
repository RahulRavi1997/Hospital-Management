<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AccessDenied page</title>
  </head>
  <body>
    <img src="static/images/AccessDenied.jpg"/>
    </br>
    <strong> ${message} </strong>
    <a href="
    <c:url value="/index" />
    ">Home</a>
    <a href="
    <c:url value="/logout" />
    ">Logout</a>
  </body>
</html>