<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
<style>
.foo {
  float: left;
  width: 140px;
  height: 120px;
  margin: 5px;
  border-radius : 10px;
  border: 1px solid rgba(0, 0, 0, .2);
}

.blue {
  background: #13b4ff;
}

.purple {
  background: #ab3fdd;
}

.wine {
  background: #e9ca94;
}
.grey {
  background: #ECF0F1;
}
button{
    background: none;
    
    border: none;
    padding: 0;

}
input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
 
input[type="number"] {
    -moz-appearance: textfield;
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
                <c:if test="${Role == 'Nurse'}">
               <li>
               	  <a href="nurseHome">Display In Patients</a>
               </li></c:if>
            </ul>
         </div>
         <!-- /#sidebar-wrapper -->
         <!-- Page Content -->
            <div id="page-content-wrapper">


                               		<form action="DisplayAllWards" method="post" style="display: inline;">
            		<c:choose>	<c:when test="${admitButton == 'Yes'}">
            			<input type="hidden" name="admitButton" value="Yes">
            			<input type="hidden" name="visitId" value="${visitId}">
            			</c:when> </c:choose>
                    	<button class="btn btn-success" type="submit" style="float:left">Back to Wards</button>
                    	</form>
                    	

<c:set var = "max" scope = "session" value = "${20 - ward.rooms.size()}"/>

</div>
         
         <div id="page-content-wrapper">
            <div class="container-fluid">
               <div class="row">
                  <div class="col-lg-12">	
                  <div style="width:1200px; height:600px;padding: 10px;border: 2px solid black;padding: 10px; border-radius: 25px; overflow: auto;"> 
                  	<h1 style="text-align:center">Ward : ${ward.wardNumber}</h1>
                  	<c:choose>
					    <c:when test="${admitButton == 'Yes'}">
                  
          			<c:forEach items="${rooms}" var="room">
          			     
          				<form action="searchRoom" method="post" style="display: inline;">
          				 <button>
          				 <input type="hidden" name="wardNumber" value="${ward.wardNumber}">
          				 <input type="hidden" name="roomNumber" value="${room.roomNumber}">
          				 <input type="hidden" value="Yes" name="admitButton">
          				 <input type="hidden" value="${visitId}" name="visitId">
	        			 <div class="foo wine" style="text-align:center" >
	        			 Room<br>
	        			 <h1>${room.roomNumber}</h1>
	        			 <c:set var="count" value="0" scope="page"/>
	        			 <c:forEach items="${room.beds}" var="bed">
	        			 	<c:if test="${bed.status == 'Available'}">
	        			 		<c:set var="count" value="${count + 1}" scope="page"/>
	        			 	</c:if>
	   					</c:forEach>
	   					 Available Beds : <c:out value = "${count}"/></div></button></form>
                  	 </c:forEach>
                  	 </c:when>
                  	 <c:otherwise>
                  	 <form action="searchRoom" method="post" style="display: inline;">
                  	 <c:forEach items="${rooms}" var="room">
          			     
          				<form action="searchRoom" method="post" style="display: inline;">
          				 <button>
          				 <input type="hidden" name="wardNumber" value="${ward.wardNumber}">
          				 <input type="hidden" name="roomNumber" value="${room.roomNumber}">
         
          				 <input type="hidden" value="${visitId}" name="visitId">
	        			 <div class="foo wine" style="text-align:center" >
	        			 Room<br>
	        			 <h1>${room.roomNumber}</h1>
	        			 <c:set var="count" value="0" scope="page"/>
	        			 <c:forEach items="${room.beds}" var="bed">
	        			 	<c:if test="${bed.status == 'Available'}">
	        			 		<c:set var="count" value="${count + 1}" scope="page"/>
	        			 	</c:if>
	   					</c:forEach>
	   					 Available Beds : <c:out value = "${count}"/></div></button></form>
                  	 </c:forEach></form>
                  	 <c:if test="${Role == 'Admin'}">
					<c:if test="${max gt 0}">             
                  	 <form method="post" action="AddRooms" style="display: inline;">
                    	<input type="hidden" name="wardNumber" value="${ward.wardNumber}">
                    	<input type="hidden" name="noOfRooms" value="1">
                  	<button title="Add Room">
                  	<div class="foo grey" style="text-align:center" >
                  	<i class="fa fa-plus" style="text-align:center; margin-top:17px;font-size:90px; color:#D2D7D3;" aria-hidden="true">
                  	</i></div></button>
                  	</form>
                  	</c:if></c:if>
                  	 </c:otherwise>
                  	 </c:choose>
                  	 </div>
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
