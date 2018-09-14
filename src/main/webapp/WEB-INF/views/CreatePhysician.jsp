<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>PhysicianForm</title>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
  </head>
    <link rel="stylesheet" href="/static/css/jquery-ui.css">
    <link rel="stylesheet" href="/static/css/hms.css">
  <body>
    <c:if test="${not empty message}">
     <script>alert("${message}");</script>
    </c:if>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <c:set var="value" value="Add"/>
    <c:set var="operation" value="addPhysician"/>
    <c:if test="${not empty physician.firstName}">
      <c:set var="value" value="Edit"/>
      <c:set var="operation" value="updatePhysician"/>
    </c:if>
    <jsp:useBean id="now" class="java.util.Date"/>
    <fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd" />
    <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
    <fmt:formatDate var="currentMonth" value="${now}" pattern="MM" />
    <fmt:formatDate var="currentDay" value="${now}" pattern="dd" />
    <fmt:parseDate value="${currentYear-18}-${currentMonth}-${currentDay}" pattern="yyyy-MM-dd" var="maxdob" type="date" />
    <fmt:formatDate value="${maxdob}" var="maxBirthDate" type="date" pattern="yyyy-MM-dd" />
    <fmt:parseDate value="${currentYear-100}-${currentMonth}-${currentDay}" pattern="yyyy-MM-dd" var="mindob" type="date" />
    <fmt:formatDate value="${mindob}" var="minBirthDate" type="date" pattern="yyyy-MM-dd" />
    <form:form commandName="physician" action="${operation}" method="post" onsubmit="submit_form(this.form)">
      <form:hidden path="id" value="${physician.id}"/>
      <form:hidden path="active" value="${physician.isActive()}"/>
      <div class="container bg-input-container">
        <legend align="center"  class="bg-blue"><b>${value} Physician Details</b></legend>
        <div class="row">
          <c:if test="${empty physician.firstName}" var="noName"/>
          <c:if test="${empty physician.email}" var="noEmail"/>
          <div class="col-sm-6 col-xs-6 create-col-padding">
            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="name">First Name</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="text" path="firstName" placeholder="First Name" aria-describedby="basic-addon1" required="required"/>
                <br/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="name">Last Name</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="text" path="lastName" placeholder="Last Name" aria-describedby="basic-addon1" required="required"/>
                <br/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 col-xs-3">
                <label for="birthDate">Birth Date</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="date" class="date-width" id="birthDate" path="birthDate" placeholder="Birth Date" aria-describedby="basic-addon1" min="${minBirthDate}" max="${maxBirthDate}"/>
              </div>
            </div>

            <div class="row">
              <div class="col-sm-3 col-xs-3">
                <label for="name">Mobile Number:</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="number" path="mobileNumber" placeholder="Mobile Number" aria-describedby="basic-addon1"/>
                <br/>
              </div>
            </div>

            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="email">Email-Id</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="email" path="email" placeholder="Email-Id" aria-describedby="basic-addon1" maxLength="20" required="required"/>
              </div>
            </div>

            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="role">Specialisation</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:select path="specialisation" items="${specialisations}" />
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 col-xs-3">
                <label for="salary">Gender</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:select path="gender" items="${genders}" />
              </div>
            </div>
          </div>
        </div>
         Add User Login For Physician
	    <input type="text"  id="autocomplete" value="" name="UserEmail">
        <div class="row" align="center">
          <input class="btn margin-format" type="reset" value="Reset"/>     
          <input class="btn-primary" type="submit" value="Submit"/>     
        </div>
      </div>
    </form:form>
    </br>
    </br>
    <script src="/static/script/jquery.min.js"></script>
<script src="/static/script/jquery-1.10.2.js"></script>
<script src="/static/script/bootstrap.min.js"></script>
<script src="/static/script/sorttable.js"></script>
<script src="/static/script/jquery-1.9.1.min.js"></script>
<script src="/static/script/jquery-ui.js"></script>
<script src="/static/script/script.js"></script>
  </body>
</html>
