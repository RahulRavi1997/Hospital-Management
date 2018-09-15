<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>
  <link rel="stylesheet" href="static/css/font-awesome.min.css">
  <link rel="stylesheet" href="static/css/hms.css">
  <div class="navbar">
    <div class="left" >
    Hospital Management System
  </div>
  <div class="dropdown">
    <button class="dropbtn " style="font-family:'Righteous';"><i class="fa fa-user-md font18px"></i>&nbsp;&nbsp;${email}&nbsp;&nbsp;&nbsp;
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#"><i class="fa fa-lock"></i>&nbsp;&nbsp;Change Password</a>
      <a href="logout"><i class="fa fa-sign-out"></i>&nbsp;&nbsp;Logout</a>
    </div>
  </div>
</div>

<div class="left_div">
   <a href="createUser"><button class="sidebar-btn">Create User</button> </a> 
   <a href="createPhysician"><button class="sidebar-btn">Add Doctor</button> </a> 
	  <a href="displayPhysicians"><button class="sidebar-btn">Display Doctor </button></a>

</div>
<div class="right_div">
  <!--Content-->

	Dear <strong>${email}</strong>, Welcome to Admin Page.

</div>
</body>
</html>
