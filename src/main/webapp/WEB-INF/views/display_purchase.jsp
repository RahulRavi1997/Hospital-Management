<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>display</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
table{ 
    width: 65%;
    background-color: white;
    border-collapse: collapse;
}
td, th {
    text-align: center;
    padding: 5px;
}
table, th, td {
    border: 1px;
    border: 1px solid black;
}
th {
    height: 50px;
    border: 1px solid black;
}
tr:hover {
    background-color: #cccccc;
}

button {
    padding: 5px 5px; 
    font-size: 15px;
    cursor: pointer; 
}
</style>
</head>
<body>  
    <jsp:include page="Access.jsp"/>
<jsp:include page="Header.jsp"/>
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
            </ul>
        </div>    

<h2 align="center">Purchase Management</h2>

<h3 class="w3-center" align="center">Purchase</h3>
<table align="center">
<tbody>
<tr>
    <th>ID</th>
    <th>Dealer Name</th>
    <th>Date Of Purchase</th>
</tr>
 
<tr>
    <td><c:out value="${purchase.id}"></c:out></td>
    <td><c:out value="${purchase.dealerName}"></c:out></td>
    <td><c:out value="${purchase.dateOfPurchase}"></c:out></td>
</tr>
</tbody>
</table>

<table align="center">
<tbody>

<h3 class="w3-center" align="center">Medicines</h3>

<tr>
    <th>ID</th>
    <th>Medicine Name</th>
    <th>Quantity</th>
    
</tr>  
<c:forEach var="purchaseDetails" items="${purchase.getListOfMedicines()}">  

    <input type="hidden" name="id" value="${purchase.id}"> 
    <tr>
    <td>${purchaseDetails.id}</td>
    <td>${purchaseDetails.medicineName}</td>
    <td>${purchaseDetails.quantity}</td>
    
</tr>

</c:forEach>
</table>

</body>
   <jsp:include page="Footer.jsp"/>
</html>
