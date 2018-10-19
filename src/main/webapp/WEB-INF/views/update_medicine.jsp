<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<title>modify</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
            </ul>
        </div>   
<h2 align="center">Update Medicine</h2>

<form:form method="post" action="modify_medicine" modelAttribute="medicine">

<form:hidden path="id" value="${medicine.id}"/>
<form:hidden path="active" value="${medicine.active}"/>

<div class="container">
	<div class="row"> 
	  <form role="form">
        <h3>Medicine</h3> 
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="name">Name</form:label>
            <form:input type="text" class="form-control" path="name" placeholder="Name" minlength="1" maxlength="20" value= "${medicine.name}" required="required"/>
        </div>
<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="quantity">Quantity</form:label>
            <form:input type="Number" class="form-control" path="quantity"  placeholder="Quantity" 
value= "${medicine.quantity}" required="required"/>
        </div>
<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="amount">Amount</form:label>
            <form:input type="Number" class="form-control" path="amount"  placeholder="Amount" 
value= "${medicine.amount}" required="required"/>
        </div>

<div class="clearfix"></div>
<div id="snackbar">Updated successfully</div>
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple" onclick="myFunction()"> Update </button>
</p>
<br /><br />
	</div>
</div>

</form:form>

</script>
</form>

</body>
   <jsp:include page="footer.jsp"/>
</html> 

