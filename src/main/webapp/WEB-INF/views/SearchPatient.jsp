<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="shortcut icon" href="images/i2i.png" />
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
            <a href="searchVisitByPatientId">Visit
            <input type="hidden" name="patientId" value="${sessionScope.patient.id }">
            </a> 
          </li>
          <li>
            <a href="displayVisits">Display Visit</a> 
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
        <c:choose>
          <c:when test="${empty patient}">
            <h2>Patient not Found</h2>
          </c:when>
          <c:otherwise>
            <div align="center">
              <table class="table">
              <thead>
                <caption>
                  <h2>${patient.firstName} Details</h2>
                </caption>
                <tr>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>MOBILE NUMBER</th>
                  <th>EMAIL ID</th>
                  <th>DATE OF BIRTH</th>
                  <th>GENDER</th>
                  <th></th>
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>
                    <c:out value="${patient.id}" />
                  </td>
                  <td>
                    <c:out value="${patient.firstName} ${patient.lastName}" />
                  </td>
                  <td>
                    <c:out value="${patient.mobileNumber}" />
                  </td>
                  <td>
                    <c:out value="${patient.emailId}" />
                  </td>
                  <td>
                    <c:out value="${patient.birthDate}" />
                  </td>
                  <td>
                    <c:out value="${patient.gender}" />
                  </td>
                  <c:choose>
                    <c:when test="${patient.active == true}">
                      <td>
                        <form  action="searchVisitByPatientId" method="get" >
                          <input type="submit" value="Create Visit" class="btn btn-info">
                        </form>
                      </td>
                      <td>
                        <form  action="modifyPatient" method="post" >
                          <input type="hidden" name="id" value="${patient.id}" />
                          <input type="submit" value="Edit" class="btn btn-primary">
                        </form>
                      </td>
                      <td>
                        <form  action="deletePatient" method="post" >
                          <input type="hidden" name="id" value="${patient.id}" />
                          <input type="submit" value="Delete" class="btn btn-danger" onclick= "return confirm('Are you sure want to delete Employee :${employee.id} ?') ">
                        </form>
                      </td>
                    </c:when>
                    <c:otherwise>
                      <td>
                        <form  action="activatePatient" method="post" >
                          <input type="submit" value="Active" class="btn btn-info">
                          <input type="hidden" name="id" value="${patient.id}" />
                        </form>
                      </td>
                    </c:otherwise>
                  </c:choose>
                </tr>
              </tbody>
              <c:if test="${not empty patient.addresses}">
                <div align="center">
                  <table class="table">
                    <tr>
                      <th>Address Line 1</th>
                      <th>Address Line 2</th>
                      <th>Country</th>
                      <th>Pin-Code</th>
                    </tr>
                    <c:forEach items="${patient.addresses}" var="address">
                      <tr>
                        <td>
                          <c:out value="${address.addressLine1}"/>
                        </td>
                        <td>
                          <c:out value="${address.addressLine2}"/>
                        </td>
                        <td>
                          <c:out value="${address.country}"/>
                        </td>
                        <td>
                          <c:out value="${address.pinCode}"/>
                        </td>
                      </tr>
                    </c:forEach>
                </div>
              </c:if>
              </table>
            </div>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </body>
  <jsp:include page="Footer.jsp"/>
</html>
