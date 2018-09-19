<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin page</title>
  </head>
  <body>
    <jsp:include page="Header.jsp"/>
    <div id="wrapper">
      <!-- Sidebar -->
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <li class="sidebar-brand">
            <a href="index">
            Home
            </a>
          </li>
          <li class="highlight">
            <a href="createUser">Create User </a> 
          </li>
          <li>
            <a href="displayUsers">Display Users</a>
          </li>
          <li>
            <a href="createPhysician">Create Physician</a> 
          </li>
          <li>
            <a href="displayPhysicians">Display Physician</a>
          </li>
        </ul>
      </div>
      <!-- /#sidebar-wrapper -->
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-12">
              <c:set var="operation" value="Create"/>
              <c:if test="${not empty user.email}">
                <c:set var="operation" value="Edit"/>
              </c:if>
              <form:form commandName="user" action="signup" method="post">
                <div class="form-group">
                  <label class="required">
                  Email Address
                  </label>
                  <form:input class="form-control width200px" type="email" path="email" required="required" autocomplete="off" />
                </div>
                <div class="form-group">
                  <label class="required">
                  Password
                  </label>
                  <form:password class="form-control width200px" path="password" id="password" required="required" autocomplete="off"/>
                </div>
                <div class="form-group">
                  <label class="active">
                  Role
                  </label>
                  <form:select class="form-control width200px" path="role" items="${roles}"/>
                </div>
                <button id="register" class="button button-block"/>${operation} User</button>
              </form:form>
            </div>
          </div>
        </div>
      </div>
      <!-- /#page-content-wrapper -->
    </div>
    <jsp:include page="Footer.jsp"/>
  </body>
</html>