

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Admin page</title>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
      <div id="wrapper">
         <!-- Sidebar -->
         <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
               <li class="sidebar-brand highlight">
                  <a href="index">
                  Home
                  </a>
               </li>
               <li>
                  <a href="DisplayAllWards">View Wards</a> 
               </li>
               <li>
               	  <a href="nurseHome">Display In Patients</a>
               </li>
            </ul>
         </div>
         <!-- /#sidebar-wrapper -->
         <!-- Page Content -->
         <div id="page-content-wrapper">
            <div class="container-fluid">
               <div class="row">
                  <div class="col-lg-12">
                  	
                  	                  <table class="w3-table-all w3-hoverable sortable">

                     <thead>
                        <tr>
                           <td> ID </td>
                           <td>Admit Date</td>
                           <td>Discharge Date</td>
                           <td>Type </td>
                           <td>Action </td>
                                                                                 
                        </tr>
                     </thead>
                     <tbody id="myTable">
                        <c:forEach items="${inpatients}" var="inpatient">
                           <tr>
                              <td>${inpatient.id}
                              </td>
                              <td>${inpatient.admitDate}</td>
                              <td>${inpatient.dischargeDate}</td>
                              <td>${inpatient.patientType}</td>
                              <td>
                              <c:if test="${inpatient.patientStatus == 'Admitted'}"> 
                              <form:form action="dischargeButton" method="post">
                              <input type="hidden" name="visitId" value="${inpatient.id}"/>
                              <button type="button" class="btn btn-danger">Discharge</button>
                              </form:form>
                              </c:if>
                              <c:if test="${inpatient.patientStatus == 'Discharged' } "> 
                              <button type="button" class="btn btn-danger" disabled>Patient Discharged</button>
                              </c:if>
                              <c:if test="${inpatient.patientStatus == 'Yet to admit'}"> 
                              <form:form action="admitButton" method="post">
                              <input type="hidden" name="visitId" value="${inpatient.id}"/>
                              <button type="submit" class="btn btn-success">Admit</button>
                              </form:form>
                              </c:if>
                              </td>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
                  	
                  </div>
               </div>
            </div>
         </div>
         <!-- /#page-content-wrapper -->
      </div>
      <jsp:include page="footer.jsp"/>
   </body>
</html>

