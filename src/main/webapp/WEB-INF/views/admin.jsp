<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>

	Dear <strong>${email}</strong>, Welcome to Admin Page.
	<br>
	


  <jsp:include page="header.jsp"/>
     <div id="snackbar">
     <c:out value="${message}"/>
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
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                      Dear <strong>${sessionScope.email}</strong>, Welcome to Admin Page.
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <jsp:include page="footer.jsp"/>

</body>
</html>
