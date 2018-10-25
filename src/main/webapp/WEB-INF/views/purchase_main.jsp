<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Purchase Management</title>

     <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  
</head>

<body>
<style>
 h2 {
  color: white;
}
table{ 
    width: 90%;
    background-color: white;
    border-collapse: collapse;
}
td, th {
    text-align: center;
    padding: 5px;
}
table, th, td {
    text-align: center;
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
    font-size: 15px;
    cursor: pointer; 
}
</style>
    <jsp:include page="Access.jsp"/>
<jsp:include page="header.jsp"/>
     <div id="wrapper">
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
  <a href="purchase_index">Home</a> 
                    </a>
                </li>
             <li>
  <a href="create_purchase"><i class="fa fa-shopping-cart"></i>Order</a> 
                </li>
            </ul>
        </div>

  <h2 align="center">Purchase Management</h2>
<form action="search_purchase" method="post">
 
<div class="container">
	<div class="row">
	    <div class="col-md-11">
	        <form class="navbar-form navbar-left" role="search">
	         <div class="input-group">
	            <input class="form-control" placeholder="search by id" name="id" type="Number" placeholder="id" min="1" max="100" required>
	            <span class="input-group-btn"><button type="submit" class="btn btn-default">Search</button></span>
	          </div>
	        </form>
	    </div>
	</div>
</div>

</form>

<h3 align="center">Purchases</h3>
<div class="table-responsive">
<table align="center">
<tbody>
<tr>
    <th>ID</th>
    <th>Dealer Name</th>
    <th>Date Of Purchase</th>
    <th></th>
    <th></th>
    <th></th>
 
</tr>
<c:forEach var="purchase" items="${purchases}">    
    <tr>
    <td>${purchase.id}</td>
    <td>${purchase.dealerName}</td>
    <td>${purchase.dateOfPurchase}</td>

   <c:if test="${!purchase.isActive()}">
                 <td class="submission" colspan="2"><div align="center">
                    <form action ="restore_purchase" method="post">
                      <input type="hidden" name="id" value="${purchase.id}"/>
                      <button type="submit" class="btn-warning" onclick="return confirm('Are you sure want to restore Purchase :${purchase.id} ?')">restore</button>
                    </form>
                  </td>
              </c:if>
              <c:if test="${purchase.isActive()}">
    <td class="submission" colspan="1"><div align="center">
    <form action ="search_purchase" method="post">
    <button type="submit"  class="btn-success">view</button></td>
    <input type="hidden" name="id" value=${purchase.id}>
    </form>
    <td class="submission" colspan="1"><div align="center">
    <form action ="update_purchase" method="post">
    <button type="submit"  class="btn-success">update</button></td>
    <input type="hidden" name="id" value=${purchase.id}>
    </form>
     <td class="submission" colspan="2"><div align="center">
    <form action ="delete_purchase" method="post">
    <button type="submit"  class="btn-danger"  onclick= "return confirm('Are you sure want to delete Purchase :${purchase.id} ?')">delete</button></td>
    <input type="hidden" name="id" value=${purchase.id}>
    </form>
                </c:if>
    
</tr>
</c:forEach>
</tbody>
</table>
</div>
   </div>
</body>
   <jsp:include page="footer.jsp"/>
</html>
