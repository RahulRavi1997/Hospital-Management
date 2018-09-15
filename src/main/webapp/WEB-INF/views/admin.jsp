<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>
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
