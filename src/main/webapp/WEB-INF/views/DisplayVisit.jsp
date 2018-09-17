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
     <form action="searchVisit" method="post">
      <input type="number" class="search" name="id" placeholder="Search Visit By Id">
     </form>
     </div>
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
                     <td>visit
                        <c:out value="${visit.dischargeDate}" />
                     </td>
                     <td>
                        <c:out value="${visit.patient.id}" />
                     </td>
                     <td>
                        <c:out value="${visit.patient.firstName}" />
                     </td>
                     <td>
                        <c:out value="${visit.physician.id}" />
                     </td>
                     <td>
                        <c:out value="${visit.physician.firstName}" />
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
   </body>
         <jsp:include page="footer.jsp"/>
</html>