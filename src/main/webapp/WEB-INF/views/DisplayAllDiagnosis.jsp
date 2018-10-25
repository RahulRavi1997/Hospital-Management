<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="/static/css/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="http://cdn.phpoll.com/css/animate.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/static/css/app.css" />

</head>
<style>
#myInput {
  width:100%;
  height:50px;
}
</style>
<body>
	<br>
	<jsp:include page="Header.jsp" />
	            <br>
	            <input id="myInput" type="text" placeholder="Search..">
	            
	               <div class="row">
		           <div class="col-sm-4">
		            <br>
					<form>
		            &ensp;&ensp;&ensp;&ensp;&ensp;
			    	<button type="submit" class="btn btn-danger"
						onclick="this.form.action='/index';this.form.method='get'">
						<i class="fa fa-arrow-left" aria-hidden="true"></i>
</i> &nbsp;Back
                    </button>
                    </form>
					</div>
				</div>
	<div style="overflow-x: auto;" class="w3-container animated flipInX">
	<table class="w3-table-all w3-hoverable ui-widget ui-widget-content" id="myTable">
                <tr>
                	<th><b>ID</b></th>
                    <th><b>Date Of Diagnosis</b></th>
                    <th><b>BloodGroup</b></th>
                    <th><b>Height</b></th>
                    <th><b>Weight</b></th>
                    <th><b>Blood Sugar</b></th>
                    <th><b>Body Temperature</b></th>
					<th><b>Action</b></th>
                  </tr>
                  
                <c:forEach items="${diagnosis}" var="nextItem">
                <tr id="mycontent">
                <td><input type="hidden" value="${nextItem.id}" />
                        <c:out value="${nextItem.id}" /></td>
                <td> ${nextItem.date}</td>
                <td>${nextItem.bloodGroup}</td>
                <td> ${nextItem.height}</td>
                <td> ${nextItem.weight}</td>
                <td>${nextItem.bloodSugar}</td>
                <td> ${nextItem.bodyTemperature}</td>
                <td><form  action="edit_diagnosis" method="post" >
                     <input type="hidden" name="id" value="${nextItem.id}" />
                     <button type="submit"  class="btn btn-primary"><i class="fa fa-edit"></i>&ensp;Update</button>
                    </form></td>	
                </tr>
                </c:forEach>
                </table>
                </div>
	     </div>
	     </body>
<script src="static/script/jquery.min.js"></script>
<script src="/static/script/jquery-1.10.2.js"></script>
<script src="/static/script/bootstrap.min.js"></script>
<script src="/static/script/jquery-ui.js"></script>
<script src="static/script/script.js"></script>
<script src="static/script/script2.js"></script>
<script>
$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable #mycontent").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
</script>
</html>
