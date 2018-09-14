<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="format.css"/>
   <body>
     
      <center> Project Information </center>

      <form:form action = "WardOperation" commandName = "project" method ="post">
      
  <input type="submit" name="AddWard" value="AddWard"/>

</form:form>


   </body>
</html>
