<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="shortcut icon" href="images/i2i.png" />
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
      <META HTTP-EQUIV="Expires" CONTENT="-1">
            <jsp:include page="access.jsp"/>
   </head>
   <body>
         <jsp:include page="Header.jsp"/>
      <center>
         <h1>Hospital Management System</h1>
      </center>
     <div class="row">
     <div class="col-xs-6">
     <form action="createPatient" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Patient</button>
     </form>
     </div>
     <div class="col-xs-6">
     <form action="displayPatients" method="get">
     <button type="submit" class="btn btn-primary spacing leftpadding">Display All Patient</button>
     </form>
     </div>
     </div>
<form action="searchPatient" method="post">
  <input type="number" class="search" name="id" placeholder="Search Patient By Id">
</form>
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
                  <th>FIRST NAME</th>
                  <th>LAST NAME</th>
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
                     <c:out value="${patient.firstName}" />
                  </td>
                  <td>
                     <c:out value="${patient.lastName}" />
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
        Address 
      <table border="1" cellpadding="5" class="table">
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
      </table>
     </div>
    </c:if>

      </div>
                      </c:otherwise>
                     </c:choose>
   </body>
         <jsp:include page="footer.jsp"/>
   
</html>
