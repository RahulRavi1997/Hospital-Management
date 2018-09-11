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
            <c:set var="value" value="addpatient"/>
         </c:when>
         <c:otherwise>
            <c:set var="value" value="updatepatient"/>
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
                     <label class="col-sm-2 control-label" for="gender">Gender</label>
                     <div class="col-sm-10">
                        <form:input  path="gender" class ="form-control spacing" />
                     </div>
                  </div>
                  <c:if test="${not empty patient.id}">
                     <input type="hidden" name="id" value="${patient.id}" />
                  </c:if>
            </div>
            <div class="col-md-6">
            <br>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="addressLine1">Address Line 1</label>
            <div class="col-sm-10">
            <form:input path="address.addressLine1" class="form-control spacing"/>
            <form:errors path="address.addressLine1" placeholder="addressLine1"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="addressLine2">Address Line 2</label>
            <div class="col-sm-10">
            <form:input path="address.addressLine2" class="form-control spacing"/>
            <form:errors path="address.addressLine2" placeholder="addressLine2"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="Postcode">Postcode</label>
            <div class="col-sm-10">
            <form:input path="address.pinCode" class="form-control spacing"/>
            <form:errors path="address.pinCode" placeholder="Post Code"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="country">Country</label>
            <div class="col-sm-10">
            <form:input path="address.country" class="form-control spacing"/>
            <form:errors path="address.country" placeholder="Country"/>
            </div>
            </div>
            </div>
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
   </body>
</html>