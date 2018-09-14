<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	      <link rel="stylesheet" type="text/css" href="static/css/Ward.css"/>
	<title>Welcome page</title>
</head>
<body>
<div class = "heading">

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a onclick="document.getElementById('addWard').style.display='block'" style="width:auto;">Add Ward</a>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
 </div>

<h2 class = "wardDetails"> Wards Information </h2>

<div id="addWard" class="modal">
        <form:form class="modal-content animate" action = "wardOperation" commandName = "ward" method ="post">
  
    <div class="imgcontainer">
      <span onclick="document.getElementById('addWard').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
        <h2 class = "wardDetails" >  Create a ward </h2>
    
        Enter the Ward Name :
<form:input path="name"  pattern="[A-Za-z]*"  placeholder= "Ward Name " maxlength= "20"  title="Enter a valid Name " required = "required"/>
Enter the Number of rooms :
<input type="text" pattern =[0-9]* name = "noOfRooms" placeholder= "Number of Rooms " maxlength= "20"   title="Enter a valid number "  required = "required"/>

 <input class = "addWard" type="submit" name="AddWard" value="Add Ward"/>
    </div>

   </form:form>
</div>
            <c:forEach items= "${wards}" var = "ward">
     <h2 class ="wardInformation" > Ward Name : ${ward.name} &nbsp Ward Number : ${ward.wardNumber} </h2>
   
   <div class = "wardBasicInformation">
              <c:forEach items= "${ward.rooms}" var = "room">
     <div class = "roomBasicInformation">
  <h2 class ="wardInformation" >Room Number : ${room.roomNumber} </h2>
                <table>
                <tr>
                <td>
                </td>
                </tr>
                                 
                
                <tr>
                <td>
                    <c:forEach items= "${room.beds}" var = "bed">
                         <button class="bedType"><img src="static/bed.png"><br>
                                             ${bed.bedNumber}</button>
                                              </c:forEach>
                                             </td>
                                             </tr>                
    </table>
        
          
    
         </div>
    
    
     </c:forEach>
   </div>
   <table>

   <tr>
      <button onclick="document.getElementById('addRooms').style.display='block'" style="width:auto;" class="button"><span> s </span></button>
      </tr>
       <tr><form:form action = "ChangeWardToFree" method ="post">
       <input type = "hidden" value = "${ward.wardNumber}" name = "number">
      <button class="button"><span> Free </span></button></form:form>
      </tr>
     <tr><form:form action = "ChangeWardToMaintaince" method ="post">
  	 <input type = "hidden" value = "${ward.wardNumber}" name = "wardNumber">
   	<button class="button"><span> Maintaince </span></button></form:form>
   </tr>
      </table>
   <hr>
   <div id="addRooms" class="modal">
        <form:form class="modal-content animate" action = "wardOperation" commandName = "ward" method ="post">
  
    <div class="imgcontainer">
      <span onclick="document.getElementById('addRooms').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
        <h2 class = "wardDetails" > Add rooms to the ward</h2>
Enter the Number of rooms :
<input type="text" pattern =[0-9]* name = "noOfRooms" placeholder= "Number of Rooms " maxlength= "20"   title="Enter a valid number "  required = "required"/>
<input type = "hidden" value = "${ward.wardNumber}" name = "wardNumber">
 <input class = "addWard" type="submit" name="AddRooms" value="Add Rooms ${ward.wardNumber}"/>
    </div>

   </form:form>
</div>
   </c:forEach>
<script>

// Get the modal
var modal = document.getElementById('addWard');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
        document.getElementById("mySidenav").style.height = "150px";
    
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>

</body>
</html>
