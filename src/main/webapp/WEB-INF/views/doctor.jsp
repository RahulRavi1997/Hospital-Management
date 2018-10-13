
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
 <head>
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" type="text/css" href="/css/doctor.css">
</head>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
   <script src ="./sortable.js"></script>
<body>
    Dear <strong>${email}</strong>, Welcome to Doctor Page.
	<a href="<c:url value="/logout" />">Logout</a>
	<div class = "row" > 
       <div class ="col-sm-2">
       </div>
       <div class ="col-sm-4">
       <form action ="display" method="get"> 
       <button class="btn btn-success" type = "submit"> <i class="fa fa-refresh" aria-hidden="true"></i>Refresh</button>
       </form>
       </div>
       <div class ="col-sm-4">
       <form action ="search" method="post">  
       <input class = "searchBar" type="number"  placeholder="Search.." name ="id" max= "100000000">
       <button type="submit"  class="btn btn-info"><i class="fa fa-search"></i> 
       Search</button>
       </form>
       </div>
       <br>
    </div>
</body>
    

</html>
