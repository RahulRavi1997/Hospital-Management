<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Receptionist page</title>
    <jsp:include page="Access.jsp"/>
  </head>
  <body>
    <jsp:include page="Header.jsp"/>
    <div id="wrapper">
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <li class="sidebar-brand">
            <a href="index">
            Home
            </a>
          </li>
          <li >
            <a href="searchVisitByPatientId">Visit
            <input type="hidden" name="id" value="${sessionScope.patient.id }">
            </a> 
          </li>
          <li>
            <a href="displayVisits">Display Visits</a> 
          </li>
          <li>
            <a href="createPatient">Create Patient</a>
          </li>
          <li>
            <a href="displayPatients">Display Patients</a>
          </li>
        </ul>
      </div>
      <div id="page-content-wrapper">
        <jsp:include page="ReceptionistHeader.jsp"/>
        <c:choose>
         <c:when test="${PatientInActive == null}">
                 <h4>Welcome to ${role} Page-${email}</h4>
         </c:when>
        <c:otherwise>
           <h3> <c:out value=" ${PatientInActive}"/></h3>
        </c:otherwise>
        </c:choose>
      </div>
    </div>
  </body>
  <jsp:include page="Footer.jsp"/>
</html>
