<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="shortcut icon" href="images/i2i.png" />
  <head>
    <title>Hospital Management System</title>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
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
          <li>
            <a href="searchVisitByPatientId">Visit </a> 
          </li>
          <li  class="highlight">
            <a href="displayVisits">Display Visits</a> 
          </li>
          <li>
            <a href="createPatient">Create Patient</a>
          </li>
          <li>
            <a href="displayPatients">Display Patient</a>
          </li>
        </ul>
      </div>
      <div id="page-content-wrapper">
        <jsp:include page="ReceptionistHeader.jsp"/>
        <form action="searchVisit" method="post">
          <input type="number" style="margin-left:42%" name="id" required="required" placeholder="Search Visit By Id">
        </form>
        <div class="col-sm-4 col-xs-4 text-align-center">
          <h4>
            Filter : 
            <select id="filterChoice">
              <option value=>All</option>
              <option value="${sessionScope.patient.firstName}${sessionScope.patient.emailId}">Patient Visit</option>
            </select>
          </h4>
        </div>
        <div align="center" >
          <table class ="table">
            <caption>
              <h2>List of Visits</h2>
            </caption>
            <thead>
              <tr>
                <th>ID</th>
                <th>ADMIT DATE</th>
                <th>DISCHARGE DATE</th>
                <th>PATIENT ID</th>
                <th>PATIENT NAME</th>
                <th>PHYSICIAN ID</th>
                <th>PHYSICIAN NAME</th>
                <th>PATIENT TYPE</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="visit" items="${visits}">
                <tr>
                  <td>
                    <c:out value="${visit.id}" />
                  </td>
                  <td>
                    <c:out value="${visit.admitDate}" />
                  </td>
                  <td>
                    <c:out value="${visit.dischargeDate}" />
                  </td>
                  <td>
                    <c:out value="${visit.patient.id}" />
                  </td>
                  <c:if test="${ visit.patient.id == sessionScope.patient.id }">
                    <td style="display:none">
                      <button value="${sessionScope.patient.firstName}${sessionScope.patient.emailId}" />
                    </td>
                  </c:if>
                  <td>
                    <c:out value="${visit.patient.firstName} ${visit.patient.lastName}" />
                  </td>
                  <td>
                    <c:out value="${visit.physician.id}" />
                  </td>
                  <td>
                    <c:out value="${visit.physician.firstName} ${visit.physician.lastName}" />
                  </td>
                  <td>
                    <c:out value="${visit.patientType}" />
                  </td>
                  <td>
                    <form  action="searchVisit" method="post" >
                      <input type="hidden" name="id" value="${visit.id}" />
                      <input type="submit" value="View Details" class="btn btn-info">
                    </form>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
  <jsp:include page="Footer.jsp"/>
</html>