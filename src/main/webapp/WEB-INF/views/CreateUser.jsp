<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin page</title>
    <jsp:include page="Access.jsp"/>
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
          <li>
            <a href="DisplayAllWards">Display Wards</a><br>
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
              <c:set var="action" value="signup"/>
              <c:if test="${not empty user.email}">
                <c:set var="operation" value="Edit"/>
                <c:set var="action" value="updateUser"/>
              </c:if>
              <form:form commandName="user" action="${action}" method="post">
               <form:hidden path="id"/>
               <form:hidden path="active"/>
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
                  <label class="required">
                    Role
                  </label>
                  <form:select path="role" class="form-control width200px" required="required">
                    <option  selected disabled hidden value="">Select</option>
                    <form:options items="${roles}" />
                  </form:select>
                </div>
                <button id="register" class="btn btn-success"/>${operation} User</button>
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
