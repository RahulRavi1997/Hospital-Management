<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Pharmacy</title>
     <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

  </head>
  <body>
<jsp:include page="header.jsp"/>
     <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="index">
                        Home
                    </a>
                </li>
             <li>
	           <a href="pharmacy">Pharmacy</a>
                </li>
            </ul>
        </div>
<div class="topnav">
<h2 align="center">Pharmacy</h2>
<form action="display_medicine" method="post">
<div align="center">
<button class="btn" style="margin-bottom:10px">Items</button>
</div>
</form>

<form action="display_purchase" method="post">
<div align="center">
<button class="btn" style="margin-bottom:10px">Purchases</button>
</div>
</form>

</div>

</body>
   <jsp:include page="footer.jsp"/>
</html>
