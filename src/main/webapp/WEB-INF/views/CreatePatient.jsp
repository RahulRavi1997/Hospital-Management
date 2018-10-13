<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
   </head>
   <body>
      <center>
         <h1>Hospital Management</h1>
      </center>
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
            <div class="col-md-6">
                     <c:if test="${empty patient.id}">
                        Add Patient Details
                     </c:if>
                     <c:if test="${not empty patient.id}">
                        Modify Patient Details
                     </c:if>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="name">FirstName</label>
                     <div class="col-sm-10">
                        <form:input path="firstName" pattern="^[a-zA-Z]{1,20}$" class ="form-control spacing" required="required" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="name">LastName</label>
                     <div class="col-sm-10">
                        <form:input path="lastName" pattern="^[a-zA-Z]{1,20}$" class ="form-control spacing" required="required" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="emailid">EmailId</label>
                     <div class="col-sm-10">
                        <form:input type="email" path="emailId" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="birthdate">DOB</label>
                     <div class="col-sm-10">
                        <form:input type="date" id="DOB" path="birthDate" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="mobileNumber">MobileNumber</label>
                     <div class="col-sm-10">
                        <form:input path="mobileNumber" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label" for="Gender">Gender</label>
                     <div class="col-sm-10">
                       <form:select path="gender" items="${genders}" />
                     </div>
                  </div>
                  <c:if test="${not empty patient.id}">
                     <input type="hidden" name="active" value="${patient.active}" />
                     <input type="hidden" name="id" value="${patient.id}" />
                  </c:if>
            </div>
<div class="col-sm-6 col-xs-6">
            <c:forEach items="${patient.addresses}" varStatus="vs">
              <c:if test="${vs.index+1 eq 1}"> <c:set var="addrstype" value="Permanent"/></c:if>
              <c:if test="${vs.index+1 eq 2}"> <c:set var="addrstype" value="Temporary"/></c:if>
              <div class="row">
                <div class="col-sm-6 col-xs-6"> 
                  <b>${addrstype} Address</b>
                </div>
              </div>
               <form:hidden path="addresses[${vs.index}].type" value="${addrstype}"/>
              <div class="row">
                <div class="col-sm-3 col-xs-3">
                  <form:label class="color-black" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid">Address Line 1</form:label>
                </div>
                <div class="col-sm-3 col-xs-3">
                  <div class="input">
                    <form:input type="TEXT" placeholder="Address Line 1" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid " required="required"/>
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
                    <form:input placeholder="Address Line 2" path="addresses[${vs.index}].addressLine2" cssErrorClass="invalid"/>
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
                    <form:input placeholder="Country" path="addresses[${vs.index}].country" cssErrorClass="invalid " maxLength="50" required="required" />
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
                    <form:input placeholder="Pin Code" type="number" min="0" path="addresses[${vs.index}].pinCode" cssErrorClass="invalid" required="required" maxLength="10"/>
                    <form:label path="addresses[${vs.index}].pinCode" cssErrorClass="icon invalid" />
                    <form:errors path="addresses[${vs.index}].pinCode" cssClass="inline_invalid" />
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
            </div>
      </form:form>
            </div>
   </body>
</html>
