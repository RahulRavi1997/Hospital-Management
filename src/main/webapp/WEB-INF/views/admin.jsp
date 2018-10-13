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
    <a href="createPhysician">Add Doctor </a>
	<a href="displayPhysicians">Display Doctor </a>


          <form role="form" action="signup" method="post">
            <div class="field-wrap">
              <label>
                Email Address<span class="req">*</span>
              </label>
              <input type="email" name="email" required autocomplete="off" />
            </div>
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="password" id="password" required autocomplete="off"/>
          </div> 
            <div class="field-wrap">
              <label class="active">
                 Role
              </label>
              <select name="role" required>
             <option value="NURSE">Nurse</option>
             <option value="PHYSICIAN">Physician</option>
               <option value="RECEPTIONIST">Receptionist</option>
              </select>
            </div>
          </div>
          <button id="register" class="button button-block"/>Create User</button>
          </form>
	<a href="<c:url value="/logout" />">Logout</a>
</body>

</html>


