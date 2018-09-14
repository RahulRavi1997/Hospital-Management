<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
  <table cellpadding="10" border="1" class="table" >
        <thead>
          <tr>
            <th>ID</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
              <tr>
              <td>
                ${user.id}
              </td>
              <td>
                ${user.email}
              </td>
          </tr>
          </c:forEach>
        </tbody>
</body>
</html>
