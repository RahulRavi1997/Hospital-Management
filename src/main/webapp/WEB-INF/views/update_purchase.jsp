<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<title>modify</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
        <form action="display_purchase" method="post">
        <div align="left">
        <button class="btn">Home</button>
        </div>
        </form>   
                </li>
            </ul>
        </div>   
<h2 align="center">Update Purchase</h2>

<form:form method="post" action="modify_purchase" modelAttribute="purchase">

<form:hidden path="id" value="${purchase.id}"/>
<form:hidden path="active" value="${purchase.active}"/>

<div class="container">
	<div class="row"> 
	  <form role="form">
        <h3>Purchase</h3> 
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="dealerName">Dealer Name</form:label>
            <form:input type="text" class="form-control" path="dealerName" placeholder="Dealer Name" minlength="1" maxlength="20" value= "${purchase.dealerName}" required="required"/>
        </div>
<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="dateOfPurchase">Date Of Purchase</form:label>
            <form:input type="date" class="form-control" path="dateOfPurchase"  placeholder="Date Of Purchase" 
value= "${purchase.dateOfPurchase}" required="required"/>
        </div>

<div class="clearfix"></div>
        <h3>Medicines</h3> 

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
<div class="clearfix"></div>
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple"> Update </button>
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

