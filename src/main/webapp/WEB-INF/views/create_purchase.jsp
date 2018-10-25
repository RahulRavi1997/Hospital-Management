<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create purchase</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
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
    <jsp:include page="Access.jsp"/>
</head>
<body>
<script>

function chgAction( action_name )
    {
        if( action_name=="add_purchase" ) {
            document.forms[0].action = "/add_purchase";
        }
        else if( action_name=="add_more_medicine" ) {
            document.forms[1].action = "/add_more_medicine";
        }
        else if( action_name=="remove_medicine" ) {
            document.forms[2].action = "/remove_medicine";
        }
    }
</script>

<jsp:include page="header.jsp"/>
     <div id="wrapper">
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
        <form action="display_purchase" method="post">
        <div align="left">
        <button class="btn">Home</button>
        </div>
        </form>   
                </li>
            </ul>
        </div>        
<h2 align="center">Purchase Management</h2>

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
        <h3>Order Medicine</h3> 

<c:forEach items="${purchase.listOfMedicines}" varStatus="vs">

<div class="clearfix"></div>

<form:hidden path="listOfMedicines[${vs.index}].active" value="1"/>

<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
<form:label path="listOfMedicines[${vs.index}].medicineName">Medicine Name</form:label>
        <form:input id="searchMedicine" placeholder="Medicine Name" type="text" path="listOfMedicines[${vs.index}].medicineName"  required="required"/>                    
                </div>
    
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
<form:label  path="listOfMedicines[${vs.index}].quantity">Quantity</form:label>
                    <form:input placeholder="Quantity" type="number" path="listOfMedicines[${vs.index}].quantity"  required="required"/>
                  </div>

</c:forEach>

<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple" value="add_more_medicine" onclick="chgAction(this.value);"> Add more medicine </button>
</p>
            
<div class="clearfix"></div>
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple" value="add_purchase" type=
"submit" > Add </button>
</p>
<br/><br/>
	</div>
</div>
</form:form>

</body>
   <jsp:include page="footer.jsp"/>
</html>
