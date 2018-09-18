<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <jsp:include page="access.jsp"/>
  </head>
  <body>
    <jsp:include page="header.jsp"/>
    <div id="wrapper">
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <li class="sidebar-brand">
            <a href="index">
            Home
            </a>
          </li>
          <li  class="highlight">
            <a href="createVisit">Create Visit </a> 
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
        <c:choose>
          <c:when test="${empty visit.id}">
            <c:set var="value" value="addVisit"/>
          </c:when>
          <c:otherwise>
            <c:set var="value" value="updateVisit"/>
          </c:otherwise>
        </c:choose>
        <div class="row">
          <form:form  action="${value}" commandName="visit">
            <legend>
              <c:if test="${empty visit.id}">
                Add Visit Details
              </c:if>
              <c:if test="${not empty visit.id}">
                Modify Visit Details
              </c:if>
            </legend>
            <div class="form-group">
              <label class="col-sm-2 control-label" for="admitDate">Admit Date</label>
              <div class="col-sm-10">
                <form:input type="date" id="admitDate"  path="admitDate" required="required" class ="form-control spacing inputtext" />
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label" for="patientId">Patient Name</label>
              <div class="col-sm-10">
                <input type="text" id="search" name="name" class="inputtext" onselect=""/>
                <input type="hidden" name="patientId" id="patientId"/>
              </div>
            </div>
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
                <input type="hidden" name="physicianId" id="physicianId"/>
              </div>
            </div>
            <label class="col-sm-2 control-label" for="PatientType">Patient Type</label>
            <div class="col-sm-10">
              <form:select class="inputtext" path="patientType" items="${types}" />
        </div>
        <c:if test="${not empty visit.id}">
        <input type="hidden" name="id" value="${visit.id}" />
        </c:if>
                </div>
      <c:choose>
      <c:when test="${empty visit.id}">
      <input type="submit" class="btn btn-info center buttn" value="ADD VISIT" >
      </c:when>
      <c:otherwise>
      <input type="submit" class="btn btn-info center buttn" value="MODIFY VISIT DETAILS" onclick= "return confirm('Sure want to make changes on the Visit?')" >
      </c:otherwise>
      </c:choose>
          </form:form>
      </div>
    </div>
  </body>
  <jsp:include page="footer.jsp"/>
</html>