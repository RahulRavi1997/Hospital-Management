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
   </head>
   <body >
     <div class="row">
     <div class="col-sm-10">
     <form action="createPatient" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Patient</button>
     </form>
     </div>
     <div class="col-sm-10">
     <form action="searchPatient" method="post">
      <input type="number" class="search" name="id" placeholder="Search Patient By Id">
     </form>
     </div>
     </div>
      <div align="center" >
         <table class ="table">
               <caption>
                  <h2>List of Patients</h2>
               </caption>
            <thead>
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
               <c:forEach var="patient" items="${patients}">
                  <tr>
                     <td style="display:none">
                       <c:choose>
                        <c:when test="${patient.active}">
                          <c:out value="1"/>
                        </c:when>
                        <c:otherwise>
                          <c:out value="0"/>
                        </c:otherwise>
                      </c:choose>   
                     </td>                         
                     <td>
                        <input type="hidden" value="${patient.active}" />
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
                         <td>
                           <form  action="searchPatient" method="post" >
                             <input type="hidden" name="id" value="${patient.id}" />
                              <input type="submit" value="View Details" class="btn btn-info">
                           </form>
                         </td>
                       </c:when>
                       <c:otherwise>
                         <td>
                           <form  action="activatePatient" method="post" >
                             <input type="submit" value="Activate" class="btn btn-primary" onclick= "return confirm('Are you sure want to Activate Employee :${employee.id} ?')"/>
                             <input type="hidden" name="id" value="${patient.id}" />
                           </form>
                         </td>
                       </c:otherwise>
                     </c:choose>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
</html>