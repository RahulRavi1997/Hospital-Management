<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create purchase</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>  
     
<h2 align="center">Purchase Management</h2>
 
<form action="display_purchase" method="post">
<div align="left">
<button class="btn">Home</button>
</div>
</form>

<form:form method="post" action="add_purchase" modelAttribute="purchase">
<div class="container">
	<div class="row"> 
	  <form role="form">
        <h3>Purchase</h3> 


<form:hidden path="active" value="1"/>    
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
        <form:label path="dealerName">Dealer Name</form:label>
        <form:input type="text" class="form-control" path="dealerName" placeholder="Dealer Name" minlength="1" maxlength="20" required="required"/>
        </div>

<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
        <form:label path="dateOfPurchase">Date Of Purchase</form:label>
        <form:input type="date" class="form-control" path="dateOfPurchase" placeholder="Date Of Purchase" required="required"/>
        </div>

<div class="clearfix"></div>
        <h3>Order Item</h3> 


<c:forEach items="${purchase.listOfItems}" varStatus="vs">

<div class="clearfix"></div>

<form:hidden path="listOfItems[${vs.index}].active" value="1"/>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
<form:label  path="listOfItems[${vs.index}].itemName" cssErrorClass="invalid">Item Name</form:label>
                    <form:input placeholder="Item Name" type="text" path="listOfItems[${vs.index}].itemName" cssErrorClass="invalid " required="required" />
                    <form:label path="listOfItems[${vs.index}].itemName" cssErrorClass="icon invalid" />
                    <form:errors path="listOfItems[${vs.index}].itemName" cssClass="inline_invalid" />
                </div>
    
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
<form:label  path="listOfItems[${vs.index}].quantity" cssErrorClass="invalid">Quantity</form:label>
                    <form:input placeholder="Quantity" type="number" path="listOfItems[${vs.index}].quantity" cssErrorClass="invalid "  required="required"/>
                    <form:label path="listOfItems[${vs.index}].quantity" cssErrorClass="icon invalid" />
                    <form:errors path="listOfItems[${vs.index}].quantity" cssClass="inline_invalid" />
                  </div>
</c:forEach>


            
<div class="clearfix"></div>
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple"> Add </button>
</p>

<br /><br />
	</div>
</div>

</form:form>

<form:form method="post" action="add_more_item" modelAttribute="purchase">
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple"> Add more items </button>
</p>
</form:form>

</body>
</html>
