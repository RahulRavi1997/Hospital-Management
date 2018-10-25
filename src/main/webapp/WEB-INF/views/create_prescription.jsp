<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

input[type=number]::-webkit-inner-spin-button, 
input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0; 
}

#snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #333;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
}

.footer {
 text-align:center;
 background-color:#333;
 position:fixed;
 width:100%;
 bottom:0px;
}

#snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
    from {bottom: 0; opacity: 0;} 
    to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
    from {bottom: 0; opacity: 0;}
    to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
    from {bottom: 30px; opacity: 1;} 
    to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
    from {bottom: 30px; opacity: 1;}
    to {bottom: 0; opacity: 0;}
}
</style>
<body>
    <jsp:include page ="Header.jsp"/> 
	<br>
	<div class="row">
		<div class="col">
			<form:form commandName="prescription" action="addPrescription" method="post">
			   <form:input path="id" type="hidden" />
			   <input type="text" name="visitType" value="${visitType}"/>
			   <form:input path="visitId" type="hidden" name="visitId"/>
               <table class="w3-table-all w3-hoverable ui-widget ui-widget-content" id="resizable">
				<thead>
					   <tr class="ui-widget-header">
				        <td>&ensp;&ensp;&ensp;&ensp;&ensp;
				        &ensp;&ensp;&ensp;&ensp;&ensp;
				        &ensp;&ensp;&ensp;&ensp;&ensp;
				        &ensp;&ensp;&ensp;&ensp;&ensp;
				         &ensp;&ensp;&ensp;&ensp;&ensp;Visit ID:&ensp;${prescription.visitId}</td>
						<td>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</td>
					    <td>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
					    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;Date:&ensp;${prescription.prescriptionDate}</td>
					   </tr>
				</thead>
				</table>
				<br>
				<c:if test="${prescription.id == 0}">
				<div class="row animated bounceInLeft">
					<div class="col-sm-5"></div>
					<div class="col-sm-2">
					   <form:button type="submit" class="btn btn-primary">
							<i class="fa fa-plus"></i> &nbsp;Save Prescription
	                   </form:button>
	                </div>
	            </div>    
	            </c:if>
	            <c:if test="${prescription.id != 0}">
	            <div class="row animated bounceInLeft">
				   <div class="col-sm-5"></div>
				   <div class="col-sm-2">
				   <form:button type="submit" class="btn btn-primary" onclick="this.form.action='/updatePrescription';this.form.method='post'">
						<i class="fa fa-plus"></i> &nbsp;Update Prescription
                   </form:button>
	            </div>
				</div>
				</c:if>
				<br>
				<div class="w3-container animated flipInX">
					<table
						class="w3-table-all w3-hoverable ui-widget ui-widget-content"
						id="resizable">
						<thead>
							<tr class="ui-widget-header">
								<td>Medicine</td>
								<td>Dosage</td>
								<td>Days</td>
								<td>Quantity</td>
								<td>Action</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${prescription.prescriptionDetails}"
								var="details" varStatus="vs">
								<tr id="rows">
									<td><form:input style="width:200px"
											path="prescriptionDetails[${vs.index}].item.itemName"
											type="text" class="search" placeholder="Search Medicine" maxlength="230" required="required"/></td>
									<td><form:input style="width:150px"
											path="prescriptionDetails[${vs.index}].dosage.dosage"
											type="text" placeholder="1-0-1" class="dosage" maxlength="230" required="required"/></td>
								    <td><form:input style="width:60px"
											path="prescriptionDetails[${vs.index}].days"
											type="text" class ="days" pattern="(([3][0-6][0-9])|([1-2][0-9][0-9])|([1-9][0-9])|[1-9])" required="required"/></td>				
									<td><form:input style="width:60px"
											path="prescriptionDetails[${vs.index}].dosage.quantity"
											type="text" class ="dosageQuantity" readonly="true"/></td>
								    <td>
										<form:button class="btn btn-danger" type="submit"
										onclick="this.form.action='removePrescriptionDetail?index=${vs.index}';this.form.method='post'">
									    <i class="fa fa-window-close"></i>&nbsp;
										</form:button>
								    </td>			
									<form:input path="prescriptionDetails[${vs.index}].id"
										type="hidden"/>
									<form:input
										path="prescriptionDetails[${vs.index}].dosage.dosageId"
										type="hidden" class="dosage" />
								</tr>
							</c:forEach>
						<tbody>
					</table>
				</div>
				<div class="row animated bounceInLeft">
					<div class="col-sm-10"></div>
					<div class="col-sm-2">
			    &ensp;&ensp;&ensp;&ensp;&ensp;		
				<form:button type="submit" class="btn btn-primary"
							onclick="this.form.action='createItem';this.form.method='post'">
		        <i class="fa fa-edit"></i> Add More</form:button>
		        </div>
		        </div>
				<br>
				 </form:form>
				<div class="row animated bounceInRight">
					<div class="col-sm-5"></div>
					<div class="col-sm-4">
					<form>
		            &ensp;&ensp;&ensp;&ensp;&ensp;
			    	<button type="submit" class="btn btn-danger"
						onclick="this.form.action='index';this.form.method='get'">
						<i class="fa fa-trash"></i> &nbsp;Cancel
                    </button>
                    </form>
					</div>
				</div>
		   </div>
		</div>
		<div id="snackbar">${addmsg}</div>
</body>
  <jsp:include page ="Footer.jsp"/> 
<script src="static/script/jquery.min.js"></script>
<script src="/static/script/jquery-1.10.2.js"></script>
<script src="/static/script/bootstrap.min.js"></script>
<script src="/static/script/jquery-ui.js"></script>
<script>

<c:if test= "${addmsg !=null }">
   var x = document.getElementById("snackbar");
   x.className = "show";
   setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
</c:if>

$(document).ready(function(){
	$("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
        if($.isNumeric(value)) {
	      $("#myTable tr").filter(function() {
	        $(this).toggle($(this).find("td:first").text().toLowerCase().indexOf(value) > -1)
	       });
	    } else {
	      $("#myTable tr").filter(function() {
	        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	      });
	    }
    });
});



$(document).ready(function() {
	   $(function() {
	       $(".dosage").autocomplete({     
	           source : function(request, response) { $.ajax({
	           headers: { 
	                'Accept': 'application/json',
	                'Content-Type': 'application/json' 
	            },
	                  url  : "/getAllDosage",
	                  type : "GET",
	                  data : {
	                       dosage : this.term
	                  },
	                  dataType : "json",
	                  success : function(data) {
	                  response($.map(data, function(value, key) {
	                  console.log(value);
	                  $(".days").keyup(function () {
	                	  var dosages = ($(this).closest("tr").find(".dosage").val()).split("-");
	                	  var count = 0;
	                	  for (i = 0; i < dosages.length; i++) {
	                		  count += parseInt(dosages[i]);
	                      } 
	                	  console.log($(this).closest('tr').find(".days").val());
	                	  count = count*parseInt($(this).closest('tr').find(".days").val());
	                	  console.log(count);
	                      $(this).closest('tr').find(".dosageQuantity").val(count);
	                  });
	                  return {
	                  label: value.dosage,
	                  value: value.dosage
	                  };
	                  }));

	                 }
	           });
	        }
	    });
	 });
	});



$(document).ready(function() {
$(function() {
$(".search").autocomplete({ 
source : function(request, response) { $.ajax({
headers: { 
'Accept': 'application/json',
'Content-Type': 'application/json' 
},
url : "/getAllMedicines",
type : "GET",
data : {
search : this.term
},
dataType : "json",
success : function(data) {
response($.map(data, function(value, key) {
console.log(value);
return {
label: value.itemName,
value: value.itemName
};
}));

}
});
}
});
});
});





</script>
</html>
