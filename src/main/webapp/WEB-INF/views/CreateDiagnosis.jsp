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
    <br>
	<jsp:include page="Header.jsp" />
	<div class="row animated slideInRight">
		
					<div class="col-sm-4">
					<form>
		            &ensp;&ensp;&ensp;&ensp;&ensp;
			    	<button type="submit" class="btn btn-danger"
<<<<<<< HEAD
						onclick="this.form.action='displayVisits';this.form.method='get'">
=======
						onclick="this.form.action='/index';this.form.method='get'">
>>>>>>> 1146a4ff88dc08992293823ca57a4a2c1b635bea
						<i class="fa fa-arrow-left" aria-hidden="true"></i>
</i> &nbsp;Back
                    </button>
                    </form>
					</div>
				</div>
	<div class="row">
		<form:form commandName="diagnosis"  action="add_diagnosis"  method="post">
			<form:input path="id" type="hidden" />
			<div class="col-sm-3">
			</div>
			<div class="col-sm-3">
				<div class="row animated slideInleft">
				<div class="col">
				<h5 style="color:white">Visit Id:</h5>
			    </div>
	            </div>
	            <br>
	            <div class="row animated slideInleft">
				<div class="col">
				<h5 style="color:white">Date:</h5>
			    </div>
	            </div>
	            <br>
	            <div class="row animated slideInleft">
				<div class="col">
				<h5 style="color:white">BloodGroup</h5>
			    </div>
	            </div>
	            <br>
	            <div class="row animated slideInleft">
				<div class="col">
				<h5 style="color:white">Height(cm)</h5>
			    </div>
	            </div>
	            <br>
	            <div class="row animated slideInleft">
				<div class="col">
				<h5 style="color:white">Weight(Kg)</h5>
			    </div>
	            </div>
	            <br>
	            <div class="row animated slideInleft">
				<div class="col">
				<h5 style="color:white">BloodSugar(mg/dL)</h5>
			    </div>
	            </div>
	          
	            <div class="row animated slideInleft">
				<div class="col">
				<h5 style="color:white">BodyTemperature</h5>
			    </div>
	            </div>
	        </div>
	        <div class="col-sm-3">
	        <div class="row animated slideInRight">
		    <div class="col">
	        <h5><c:out value="${diagnosis.visitId}" /></h5>
			<form:input path="visitId"  type="hidden" />
			</div>
			</div>
			<br>
			<div class="row animated slideInRight">
		    <div class="col">
			<h5><c:out value="${diagnosis.date}" /></h5>
			<form:input path="date" type="hidden" />
			</div>
			</div>
			<br>
			<br>
			<div class="row animated slideInRight">
		    <div class="col">
	        <form:input path="bloodGroup" pattern="^(A|B|AB|O)[-+]$" type="text" name="bloodGroup" />
	        </div>
			</div> 
            <br>
	        <div class="row animated slideInRight">
		    <div class="col">
	        <form:input path="height" type="text" name="height" pattern="(300|([1-2][0-9][0-9])|([3-9][0-9]))" /> 
	        </div>
			</div>
	        <br>
	        <div class="row animated slideInRight">
		    <div class="col">
	        <form:input path="weight"  type="text" pattern="(300|([1-2][0-9][0-9])|([1-9][0-9])|[1-9])" name="weight" />
	        </div>
			</div>
	         <br>
	        <div class="row animated slideInRight">
		    <div class="col"> 
	        <form:input path="bloodSugar" type="text" pattern="(([1][0-1][0-9])|([6-9][0-9]))" name="bloodSugar" />
	        </div>
			</div>
	         <br>
	        <div class="row animated slideInRight">
		    <div class="col"> 
	        <form:input path="bodyTemperature" type="text"  pattern="(([1][0-1][0-9])|([9][6-9]))" name="bodyTemperature" />
	        </div>
			</div>
	        <br>
	      </div>
     </div>
	<br>
     <div class="row animated slideInleft">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
		<br>
		<c:if test="${diagnosis.id == 0}">
	    <form:button type="submit" class="btn btn-primary">
				<i class="fa fa-plus"></i> &nbsp;Add Diagnosis
        </form:button>
        </c:if>
        <c:if test="${diagnosis.id != 0}">
        <form:button type="submit" class="btn btn-primary" onclick="this.form.action='updateDiagnosis';this.form.method='post'">
				<i class="fa fa-edit"></i> &nbsp;Update Diagnosis
        </form:button>
        </c:if>
  	   </div>
	</div>
	</form:form>
		</div>
	</div>
	<div id="snackbar">${message}</div>
</body>
<script src="static/script/jquery.min.js"></script>
<script src="/static/script/jquery-1.10.2.js"></script>
<script src="/static/script/bootstrap.min.js"></script>
<script src="/static/script/jquery-ui.js"></script>
<script src="static/script/script.js"></script>
<script src="static/script/script2.js"></script>
<script>
<c:if test= "${message !=null }">
   var x = document.getElementById("snackbar");
   x.className = "show";
   setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
</c:if>
</script>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> 1146a4ff88dc08992293823ca57a4a2c1b635bea
