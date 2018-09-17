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
            <jsp:include page="access.jsp"/>
   </head>
   <body>
         <jsp:include page="Header.jsp"/>
     <div class="row">
     <div class="col-sm-10">
     <form action="createVisit" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Visit</button>
     </form>
     </div>
     <div class="col-sm-10">
     <form action="displayVisit" method="get">
      <input type="submit" class="btn btn-primary spacing leftpad" value="DisplayAllVisit">
     </form>
     </div>
     </div>
      <div align="center" >
         <table class ="table">
            <thead>
               <tr>
                  <th>ID</th>
                  <th>ADMIT DATE</th>
                  <th>DISCHARGE DATE</th>
                  <th>PATIENT TYPE</th>
               </tr>
            </thead>
            <tbody>
                  <tr>
                     <td>
                        <c:out value="${visit.id}" />
                     </td>
                     <td>
                        <c:out value="${visit.admitDate}" />
                     </td>
                     <td>visit
                        <c:out value="${visit.dischargeDate}" />
                     </td>
                     <td>
                        <c:out value="${visit.patientType}" />
                     </td>
                  </tr>
            </tbody>
         </table>
         <table class ="table">
            <thead>
               <tr>
                  <th>PATIENT ID</th>
                  <th>PATIENT NAME</th>                  
                  <th>PATIENT EMAILID</th>
                  <th>PATIENT GENDER</th>
                  <th>PATIENT MOBILENUMBER</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                 <td>
                     <c:out value="${visit.patient.id}" />
                </td>
                <td>
                     <c:out value="${visit.patient.firstName} ${visit.patient.lastName}" />
                </td>
                <td>
                     <c:out value="${visit.patient.emailId}" />
                </td>
                <td>
                     <c:out value="${visit.patient.gender}" />
                </td>
                <td>
                     <c:out value="${visit.patient.mobileNumber}" />
                </td>
                </tr>
                </tbody>
                </table>
         <table class ="table">
            <thead>
               <tr>
                  <th>PHYSICIAN ID</th>
                  <th>PHYSICIAN NAME</th>
                  <th>PHYSICIAN EMAILID</th>
                  <th>PHYSICIAN MOBILENUMBER</th>
                  <th>PHYSICIAN SPECIALIS	ATION</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                     <td>
                       <c:out value="${visit.physician.id}" />
                     </td>
                     <td>
                        <c:out value="${visit.physician.firstName} ${visit.physician.lastName}" />
                     </td>
                <td>
                     <c:out value="${visit.physician.email}" />
                </td>
                <td>
                     <c:out value="${visit.physician.mobileNumber}" />
                </td>
                <td>
                     <c:out value="${visit.physician.specialisation}" />
                </td>
                </tr>
                </tbody>
                </table>
      </div>
   </body>
         <jsp:include page="footer.jsp"/>
</html>