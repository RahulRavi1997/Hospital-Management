<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
<style>
#snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #333;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
}

#snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
    from {bottom: 0; opacity: 0;} 
    to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
    from {bottom: 0; opacity: 0;}
    to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
    from {bottom: 30px; opacity: 1;} 
    to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
    from {bottom: 30px; opacity: 1;}
    to {bottom: 0; opacity: 0;}
}
</style>
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
                              <td>
                              <c:if test="${inpatient.patientStatus == 'Admitted'}"> 
                              <form:form action="vacatePatient" method="post">
                              <input type="hidden" name="visitId" value="${inpatient.id}"/>
                              <button type="submit" style="width:55%;" class="btn btn-primary">Vacate</button>
                              </form:form>
                              <form:form action="dischargeButton" method="post">
                              <input type="hidden" name="visitId" value="${inpatient.id}"/>
                              <button type="submit" style="width:55%;"  class="btn btn-danger">Discharge</button> 
                              </form:form>
                              
                              </c:if>
                              <c:if test="${inpatient.patientStatus == 'Discharged'}">
                              <button type="button" style="width:55%;" class="btn btn-warning" disabled>Patient Discharged</button>
                              </c:if>
                              <c:if test="${inpatient.patientStatus == 'Yet to Admit'}"> 
                              <form:form action="admitButton" method="post">
                              <input type="hidden" name="visitId" value="${inpatient.id}"/>
                              <button type="submit" style="width:55%;"  class="btn btn-success">Admit</button>
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
                          <c:choose>
         <c:when test="${not empty successMessage}">
            <div id="snackbar">${successMessage}</div>
            <script type="text/javascript">window.onload = function() {
               var x = document.getElementById("snackbar");
               x.className = "show";
               setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
               }  
            </script>
         </c:when>
      </c:choose>
      <jsp:include page="footer.jsp"/>
   </body>
</html>

