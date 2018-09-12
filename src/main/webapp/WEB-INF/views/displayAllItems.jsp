<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
   
    </head>
    <body>        
        <br><br>
        <div id="item">
            <table id = "item_list">
                <tr>
                    <th><b>Id</b></th>
                    <th><b>Name</b></th>
                    <c:forEach items="${allItems}" var="nextItem">
                <tr>
                <td>${nextItem.id}</td>
                <td>${nextItem.itemName}</td>             
                </tr>
                           
                </c:forEach>
            </table>
            <br>
        </div>
        <br>
         <div class="footer">
  <p>Ideas2it. All rights reserved</p>
</div>
           </body>
</html>