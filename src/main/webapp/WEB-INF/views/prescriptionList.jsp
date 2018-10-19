<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
   
    </head>
    <body>     
        <br><br>
  <c:set var="value" value="Add"/>
    <c:set var="operation" value="addPrescription"/>   
        <form:form commandName="prescription" action="" method="post">
         <table border="1" cellpadding="5" class="table ">
          <tr>
            <td>
            ID:
              <input type="hidden" name="id" value="${prescription.id}"/>
              <c:out value="${prescription.id}"/>
            </td>
             <td>
             Visit ID:
              <input type="hidden" name="id" value="${prescription.visitId}"/>
              <c:out value="${prescription.visitId}"/>
            </td>
        </tr>
        </table>
        <br>
       <table name ="Prescription Details" border="1" cellpadding="5" class="table ">
       <tr>
       <th><b>Prescription Details</b></th>
       </tr>
       <c:forEach items="${prescription.prescriptions}" var = "details">
       <tr>
       <td>Prescription Detail: ${details.id}</td>
        <td>Item ID</td>
     	<td><a href = "/test">${details.itemId}</a></td>
        <td>Dosage ID</td>
     	<td>${details.dosageId}</td>
        <td>Quantity</td>
     	<td>${details.quantity}</td>
     </tr>
        <br>
        </c:forEach>
        
        </table>
           </body>
</html>