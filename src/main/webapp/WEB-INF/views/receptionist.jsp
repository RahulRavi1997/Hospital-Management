<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Receptionist page</title>

      <jsp:include page="access.jsp"/>
</head>
<body>
      <jsp:include page="header.jsp"/>
                       <div id="wrapper">
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="index">
                        Home
                    </a>
                </li>
                <li >
             <a href="createVisit">Create Visit </a> 
                </li>
             <li>
              <a href="displayVisits">Display Visits</a> 
                </li>
                <li>
	           <a href="createPatient">Create Patient</a>
                </li>
                <li>
	           <a href="displayPatients">Display Patients</a>
                </li>
            </ul>
        </div>
        <div id="page-content-wrapper">
            <h4>Welcome to Receptionist Page-${email}</h4>
        </div>
        </div>
</body>
      <jsp:include page="footer.jsp"/>


</html>
