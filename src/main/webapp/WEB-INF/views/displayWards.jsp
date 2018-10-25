<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="static/css/displayWards.css">
      <title>Admin page</title>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
      <div id="wrapper">
         <!-- Sidebar -->

        <div id="sidebar-wrapper">
            <ul class="sidebar-nav" style = "display: inline-flex; font-size:16px; color: white">
                <li class="sidebar-brand highlight">
                    <a href="index">
                        Home
                    </a>
                </li>

<c:if test="${role == 'Admin'}">
                <li>
             <a href="createUser">Create User </a> 
                </li>
               <li>
	           <a href="displayUsers">Display Users</a>
                </li>
                <li>
              <a href="createPhysician">Create Physician</a> 
                </li>
                <li>
	           <a href="displayPhysicians">Display Physicians</a>
                </li>

<li>
<a href="DisplayAllWards">Display Wards</a><br>
</li>
</c:if>
<c:if test="${role == 'Nurse'}">
  <li>
                    <a href="index">
                        Home
                    </a>
                </li>
               <li>
               	  <a href="nurseHome">Display In Patients</a>
               </li></c:if>
            </ul>
         </div>
         <!-- /#sidebar-wrapper -->
         <!-- Page Content -->
         <div id="page-content-wrapper">
          <c:if test="${role == 'Nurse'}">
          <br>
          </c:if>
            <div class="container-fluid">
               <div class="row">
                  <div class="col-lg-12">
                   <c:if test="${role == 'Admin'}">
                    <form:form action="AddWardInDB" class = "float-right" method="post">
                    <input type = "text" name= "wardName" placeholder="Enter ward name.." >
                  	<button class="btn btn-success" type="submit" >Add Ward</button><br>
                    </form:form>
					</c:if>                    

                    
                   
                  	<div class="div-content"> 
                  	<h1 class="text-align-center">Ward Informations</h1><br>
                    <c:choose>
					    <c:when test="${admitButton == 'Yes'}">
					    	
							<c:forEach items="${wards}" var="ward">
		          			<form action="searchWard" method="post" class="display-inline">
	          				 <button>
	          				 <input type="hidden" value="${visitId}" name="visitId">
	          				 <input type="hidden" value="${ward.wardNumber}" name="wardNumber">
	          				 <input type="hidden" value="Yes" name="admitButton">
		        			 <div class="foo blue" class="text-align-center" >
		        			 <span style="margin-top:15px;">Ward</span>
		        			 <br><h1>${ward.wardNumber}</h1><h5>${ward.name}</h5>
		        			 </div></button>
		        			</form></c:forEach>
		   				
					    </c:when>
				    <c:otherwise>
				   
         			<div>
         			<c:forEach items="${wards}" var="ward">
	          			<form action="searchWard" method="post" class="display-inline">
          				 <button>
          				 <input type="hidden" value="${ward.wardNumber}" name="wardNumber">
	        			 <div class="foo blue" class="text-align-center" >
	        			 <span style="margin-top:15px;">Ward</span><br>
	        			 <h1>${ward.wardNumber}</h1><h5>${ward.name}</h5></div></button>
	        			</form></c:forEach>
	   				
					</div>
				    </c:otherwise>
				</c:choose>

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

