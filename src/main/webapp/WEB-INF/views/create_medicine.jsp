<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create medicine</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
h3 {
  font-size: 25px;
}
h3 {
  width: 50%;
  height: 60px;
  margin: 10px;
  padding: 20px;
}

button {
    padding: 5px 5px; 
    font-size: 15px;
      margin: 20px;
    cursor: pointer; 
}
</style>​
</head>
<body>  
 <jsp:include page="header.jsp"/>
     <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
        <form action="display_medicine" method="post">
        <div align="left">
        <button class="btn">Home</button>
        </div>
        </form>   
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
            <a href="pharmacy">Pharmacy</a>
          </li>
<li>
<a href="DisplayAllWards">Display Wards</a><br>
</li>
            </ul>
        </div>    
<h2 align="center">Medicine Management</h2>
 
<form:form method="post" action="add_medicine" modelAttribute="medicine">
<div class="container">
	<div class="row"> 
	  <form role="form">
        <h3>Medicine</h3> 

<form:hidden path="active" value="1"/>    
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
        <form:label path="name">Name</form:label>
        <form:input type="text" class="form-control" path="name" placeholder="Name" minlength="1" maxlength="20" required="required"/>
        </div>

<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
        <form:label path="quantity">Quantity</form:label>
        <form:input type="Number" class="form-control" path="quantity" placeholder="Quantity" required="required"/>
        </div>

<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
        <form:label path="amount">Amount</form:label>
        <form:input type="Number" class="form-control" path="amount" placeholder="Amount" required="required"/>
        </div>
<div class="clearfix"></div>
<div id="snackbar">Added successfully</div>
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple" onclick="myFunction()"> Add </button>
</p>
<br /><br />
	</div>
</div>

</form:form>

</body>
   <jsp:include page="footer.jsp"/>
</html>
