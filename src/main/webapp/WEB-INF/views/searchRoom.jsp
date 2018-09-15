<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link rel="stylesheet" type="text/css" href="static/css/Ward.css"/>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

      <h2 class = "wardDetails"> Wards Number : ${wardNumber} </h2>
      <div id="addWard" class="modal">
         <form:form class="modal-content animate" action = "wardOperation" commandName = "ward" method ="post">
            <div class="imgcontainer">
               <span onclick="document.getElementById('addWard').style.display='none'" class="close" title="Close Modal">&times;</span>
            </div>
            
         </form:form>
      </div>

         <div class = "wardBasicInformation">
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
        
         </div>
           </div>
      
            
            
       
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
