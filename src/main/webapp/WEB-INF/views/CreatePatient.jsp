<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html>
<html>
  <head>
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
            <a href="displayVisits">Display Visits</a> 
          </li>
          <li  class="highlight">
            <a href="createPatient">Create Patient</a>
          </li>
          <li>
            <a href="displayPatients">Display Patients</a>
          </li>
        </ul>
      </div>
      <div id="page-content-wrapper">
        <c:choose>
          <c:when test="${empty patient.id}">
            <c:set var="value" value="addPatient"/>
          </c:when>
          <c:otherwise>
            <c:set var="value" value="updatePatient"/>
          </c:otherwise>
        </c:choose>
        <div class="row">
          <form:form  action="${value}" commandName="patient">
            <legend>
              <c:if test="${empty patient.id}">
                Add Patient Details
              </c:if>
              <c:if test="${not empty patient.id}">
                Modify Patient Details
              </c:if>
            </legend>
            <div class="col-md-4 ">
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="name">FirstName</label>
                <div class="col-sm-8">
                  <form:input path="firstName" pattern="^[a-zA-Z]{1,20}$" class ="form-control inputtext spacing" required="required" maxLength="25" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="name">LastName</label>
                <div class="col-sm-8">
                  <form:input path="lastName" pattern="^[a-zA-Z]{1,20}$" class ="form-control inputtext spacing" required="required" maxLength="25" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="emailid">EmailId</label>
                <div class="col-sm-8">
                  <form:input type="email" path="emailId" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" required="required" class ="form-control inputtext spacing" maxLength="25" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="birthdate">DOB</label>
                <div class="col-sm-8">
                  <form:input type="date" id="DOB" path="birthDate" required="required" class ="form-control inputtext spacing" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label" for="mobileNumber">PhoneNumber</label>
                <div class="col-sm-8">
                  <form:input path="mobileNumber" pattern="^[0-9]{10}$" maxLength="10" class ="form-control spacing inputtext"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label" for="Gender">Gender</label>
                <div class="col-sm-8">
                  <form:select class ="inputtext" path="gender" items="${genders}" />
                </div>
              </div>
              <c:if test="${not empty patient.id}">
                <input type="hidden" name="active" value="${patient.active}" />
                <input type="hidden" name="id" value="${patient.id}" />
              </c:if>
            </div>
            <c:forEach items="${patient.addresses}" varStatus="vs">
              <div class="col-md-4">
                <c:if test="${vs.index+1 eq 1}">
                  <c:set var="addrstype" value="Permanent"/>
                </c:if>
                <c:if test="${vs.index+1 eq 2}">
                  <c:set var="addrstype" value="Temporary"/>
                </c:if>
                <div class="row">
                  <div class="col-sm-6 col-xs-6"> 
                    <b>${addrstype} Address</b>
                  </div>
                </div>
                <br>
                <form:hidden path="addresses[${vs.index}].type" value="${addrstype}"/>
                <div class="row">
                  <div class="col-sm-3 col-xs-3">
                    <form:label class="color-black" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid">Address Line 1</form:label>
                  </div>
                  <div class="col-sm-3 col-xs-3">
                    <div class="input">
                      <form:input type="TEXT" placeholder="Address Line 1" class ="form-control spacing inputtext" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid " />
                      <form:label path="addresses[${vs.index}].addressLine1" cssErrorClass="icon invalid" />
                      <form:errors path="addresses[${vs.index}].addressLine1" cssClass="inline_invalid" />
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-3 col-xs-3">
                    <form:label class="color-black" path="addresses[${vs.index}].addressLine2" cssErrorClass="invalid">Address Line 2</form:label>
                  </div>
                  <div class="col-sm-3 col-xs-3">
                    <div class="input">
                      <form:input placeholder="Address Line 2" class ="form-control spacing inputtext" path="addresses[${vs.index}].addressLine2" cssErrorClass="invalid"/>
                      <form:label path="addresses[${vs.index}].addressLine2" cssErrorClass="icon invalid" />
                      <form:errors path="addresses[${vs.index}].addressLine2" cssClass="inline_invalid" />
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-3 col-xs-3">
                    <form:label class="color-black" path="addresses[${vs.index}].country" cssErrorClass="invalid">Country</form:label>
                  </div>
                  <div class="col-sm-3 col-xs-3">
                    <div class="input">
                      <form:input placeholder="Country" class ="form-control spacing inputtext" path="addresses[${vs.index}].country" cssErrorClass="invalid " maxLength="50" />
                      <form:label path="addresses[${vs.index}].country" cssErrorClass="icon invalid" />
                      <form:errors path="addresses[${vs.index}].country" cssClass="inline_invalid" />
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-3 col-xs-3">
                    <form:label class="color-black" path="addresses[${vs.index}].pinCode" cssErrorClass="invalid">PinCode</form:label>
                  </div>
                  <div class="col-sm-3 col-xs-3">
                    <div class="input">
                      <form:input placeholder="Pin Code" class ="form-control spacing inputtext" type="number" min="0" path="addresses[${vs.index}].pinCode" cssErrorClass="invalid" maxLength="10"/>
                      <form:label path="addresses[${vs.index}].pinCode" cssErrorClass="icon invalid" />
                      <form:errors path="addresses[${vs.index}].pinCode" cssClass="inline_invalid" />
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
        </div>
        <br>
        <div style="text-align:center">
        <c:choose>
        <c:when test="${empty patient.id}">
        <input type="submit" class="btn btn-info center" value="ADD PATIENT" >
        </c:when>
        <c:otherwise>
        <input type="submit" class="btn btn-info center" value="MODIFY PATIENT DETAILS" onclick= "return confirm('Sure want to make changes for Patient :${patient.id} ?')" >
        </c:otherwise>
        </c:choose>
        </form:form>
        </div>
      </div>
    </div>
  </body>
  <jsp:include page="Footer.jsp"/>
</html>
