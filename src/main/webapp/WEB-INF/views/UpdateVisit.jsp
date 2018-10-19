<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <jsp:include page="Access.jsp" />
  </head>
  <body>
    <jsp:include page="Header.jsp" />
    <div id="wrapper">
    <div id="sidebar-wrapper">
      <ul class="sidebar-nav">
        <li class="sidebar-brand"><a href="index"> Home </a></li>
        <li><a href="searchVisitByPatientId">Visit
          </a>
        </li>
        <li><a href="displayVisits">Display Visits</a></li>
        <li><a href="createPatient">Create Patient</a></li>
        <li><a href="displayPatients">Display Patients</a></li>
      </ul>
    </div>
    <div id="page-content-wrapper">
      <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse"
            data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span> <span
            class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
          </button>
          <form action="searchPatient" method="POST">
            <input type="hidden" name="id" value="${sessionScope.patient.id}" />
            <a class="navbar-brand" href="#"><button class="button-as-link"
              type=submit>${sessionScope.patient.id}</button></a>
          </form>
        </div>
        <div class="collapse navbar-collapse"
          id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li><a href="#">${sessionScope.patient.firstName}
              ${sessionScope.patient.lastName}</a>
            </li>
            <li><a href="#">${sessionScope.patient.emailId}</a></li>
          </ul>
          <div class="col-sm-3 col-md-3  navbar-right">
            <form class="navbar-form" action="searchVisitForPatient" method="POST"  role="search">
              <div class="input-group">
                <input type="number" required="required" class="form-control"
                  placeholder="Search Visit By Patient Id" name="id">
                <div class="input-group-btn">
                  <button class="btn btn-default" type="submit">
                  <i class="glyphicon glyphicon-search"></i>
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </nav>
      <c:choose>
        <c:when test="${empty sessionScope.patient}">
          <h2>No Patient Selected.</h2>
          <h2>Search Patient to create Visit</h2>
        </c:when>
        <c:otherwise>
          <div class="row">
                <form:form action="updateVisit" commandName="visit">
                  <legend>
                      Modify Visit Details
                  </legend>
                  <div class="form-group">
                    <label class="col-sm-2 control-label" for="Specialisation">Specialisation</label>
                    <div class="col-sm-10">
                      <select class="inputtext" id='specialisation'>
                        <c:forEach items="${specialisations}" var="specialisation">
                          <c:if test="${specialisation != selected}">
                            <option value="${specialisation}">${specialisation}</option>
                          </c:if>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label" for="Physician">Physician</label>
                    <div class="col-sm-10">
                      <select class="inputtext" id="sel_user">
                        <option value="0">- Select -</option>
                      </select>
                      <input type="hidden" name="physicianId" id="physicianId" />
                    </div>
                  </div>
                  <label class="col-sm-2 control-label" for="PatientType">Patient
                  Type</label>
                  <div class="col-sm-10">
                    <form:select class="inputtext" path="patientType"
                      items="${types}" />
                  </div>
                    <input type="hidden" name="id" value="${visit.id}" />
                    <input type="hidden" name="admitDate" value="${visit.admitDate}" />
                    <input type="hidden" name="dischargeDate" value="${visit.dischargeDate}" />
                    <input type="hidden" name="patientId" value="${visit.patient.id}" />
                    <input type="submit" class="btn btn-info center buttn"
                        value="MODIFY VISIT DETAILS"
                        onclick="return confirm('Sure want to make changes on the Visit?')">
                </form:form>
    </div>
    </c:otherwise>
    </c:choose>
    </div>
    </div>
  </body>
  <jsp:include page="Footer.jsp" />
</html>