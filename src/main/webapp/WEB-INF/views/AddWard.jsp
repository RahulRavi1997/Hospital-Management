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
                 <form:form action = "AddWardInDB" commandName = "ward" method ="post">
                Enter the Ward Name :
               <form:input path="name"  pattern="[A-Za-z]*"  placeholder= "Ward Name " maxlength= "20"  title="Enter a valid Name " required = "required"/>
               Enter the Number of rooms :
               <input type="text" pattern =[0-9]* name = "noOfRooms" placeholder= "Number of Rooms " maxlength= "2"   title="Enter a valid number "  required = "required"/>
               <input class = "addWard" type="submit" name="AddWard" value="Add Ward"/>
                </form:form>
                  	 
                  </div>
               </div>
            </div>
         </div>
         <!-- /#page-content-wrapper -->
      </div>
      <jsp:include page="footer.jsp"/>
   </body>
</html>

