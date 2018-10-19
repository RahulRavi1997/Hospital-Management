<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
</head>
<body>
      <form:form action = "wardOperation" commandName = "ward" method ="post">
    <h2>  Create a ward </h2>
      Ward Name :
<form:input path="name"  placeholder= "Name " maxlength= "20"  title="Enter a valid Name "/>
Number of rooms
<input type="text" name = "noOfRooms" placeholder= "no of rooms " maxlength= "20"   title="Enter a valid number "/>

 <input type="submit" name="AddWard" value="AddWard"/>
<br>
    <h2> Shift a  ward to maintaince</h2>

  Ward number :
<form:input path="wardNumber"  placeholder= "ward number " maxlength= "20"  title="Enter a valid Name "/>


 <input type="submit" name="ChangeWardToMaintaince" value="ChangeWardToMaintaince"/>
 
 <br>
    <h2> Search a  ward </h2>
 
 
       <form:form action = "wardOperation" method ="post">
 
<input type="text" name = "number"  placeholder= "no of rooms " maxlength= "20"   title="Enter a valid number "/>


 <input type="submit" name="SearchWard" value="SearchWard"/>
 


</form:form>

    <h2> Shift a  ward to free</h2>

  <form:form action = "wardOperation" method ="post">
 
Ward number :
<input type="text" name = "number"  placeholder= "no of rooms " maxlength= "20"   title="Enter a valid number "/>
<br>

 <input type="submit" name="ChangeWardToFree" value="ChangeWardToFree"/>
 
 <br>

</form:form>
    <h2> Add Rooms to Ward</h2>


 <form:form action = "wardOperation" method ="post">
 
Ward number :
<input type="text" name = "number"  placeholder= "no of rooms " maxlength= "20"   title="Enter a valid number "/>

 
No of rooms to be added :
<input type="text" name = "NoOfRooms"  placeholder= "no of rooms " maxlength= "20"   title="Enter a valid number "/>

<br>



 <input type="submit" name="AddRoomsToWard" value="AddRoomsToWard"/>
 
 <br>

</form:form>
</form:form>

</body>
</html>
