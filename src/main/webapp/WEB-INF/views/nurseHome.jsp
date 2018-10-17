<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    right: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}

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
   <script type="text/javascript">
$(document).ready(function(){
    $("select.hello").change(function(){
        var selectedCountry = $(".hello option:selected").val();
        alert("You have selected the country - " + selectedCountry);
    });
});
</script>
   <body>
      <jsp:include page="header.jsp"/>
      
      <div id="mySidenav" class="sidenav"">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>









 <div class="form-group">
                    <label class="col-sm-2 control-label" for="Specialisation">Ward Number</label>
                    <div class="col-sm-10">
                      <select class="inputtext" id='warddd'>
                                                  <option value="0">- Select -</option>
                      
                        <c:forEach items="${wards}" var="ward">
                          <c:if test="${ward != selected}">
                          
                            <option value="${ward.wardNumber}">${ward.wardNumber}</option>
                          </c:if>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <label class="col-sm-2 control-label" for="Physician">Room Number</label>
                    <div class="col-sm-10">
                      <select class="inputtext" id="seluser">
                        <option value="0">- Select -</option>
                      </select>
                      <input type="hidden" id="roomid">
                    </div>
                  </div>
                  
                   <div class="form-group">
                    <label class="col-sm-2 control-label" for="Physician">Bed Number</label>
                    <div class="col-sm-10">
                      <select class="hello" id="bedss">
                        <option value="0">- Select -</option>
                        
                      </select>
                       
                      
                    </div>
                  </div>

</div>


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
                              
                              <button type="submit" style="width:55%; "  class="btn btn-success">Admit</button>
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
      <script>
      <c:if test="${sideBar == 'Yes'}"> 
    document.getElementById("mySidenav").style.width = "50%";
        document.getElementById("page-content-wrapper").style.width = "50%";
    
    </c:if>


function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
            document.getElementById("page-content-wrapper").style.width = "100%";
    
}
</script>
      <jsp:include page="footer.jsp"/>
   </body>
</html>