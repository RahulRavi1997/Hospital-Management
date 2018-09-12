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
         <c:when test="${empty visit.id}">
            <c:set var="value" value="addVisit"/>
         </c:when>
         <c:otherwise>
            <c:set var="value" value="updateVisit"/>
         </c:otherwise>
      </c:choose>
      <div class="row">
         <form:form  action="${value}" commandName="visit">
            <div class="col-md-6">
                     <c:if test="${empty visit.id}">
                        Add Visit Details
                     </c:if>
                     <c:if test="${not empty visit.id}">
                        Modify Visit Details
                     </c:if>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="admitDate">Date of Admit</label>
                     <div class="col-sm-10">
                        <form:input type="date" id="admitDate" path="admitDate" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="patientId">Patient ID</label>
                     <div class="col-sm-10">
                        <form:input type="number" id="patientId" path="patientId" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="physicianId">Physician ID</label>
                     <div class="col-sm-10">
                        <form:input type="number" id="physicianId" path="physicianId" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  <c:if test="${not empty visit.id}">
                     <input type="hidden" name="id" value="${visit.id}" />
                  </c:if>
            </div>
      <br>
      <div style="text-align:center">
      <c:choose>
      <c:when test="${empty visit.id}">
      <input type="submit" class="btn btn-info center" value="ADD VISIT" >
      </c:when>
      <c:otherwise>
      <input type="submit" class="btn btn-info center" value="MODIFY VISIT DETAILS" onclick= "return confirm('Sure want to make changes on the Visit?')" >
      </c:otherwise>
      </c:choose>
            </div>
      </form:form>
            </div>
   </body>
</html>
