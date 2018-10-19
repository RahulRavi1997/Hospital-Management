<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  <link rel="shortcut icon" href="styles/images/ideas1.jpg"/>
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <META HTTP-EQUIV="Expires" CONTENT="-1">
  </head>
  <body>
    <div align="center">
      <h1>
        -An Error has Occured-${errorMessage}.
        <c:if test="${empty errorMessage}">
          No such URL!
        </c:if>
      </h1>
    </div>
  </body>
</html>