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
<link rel="stylesheet" type="text/css" href="/static/css/app.css" />
</head>
<body>
	<br>
	<jsp:include page="Header.jsp" />
	<div class="row">
<<<<<<< HEAD
		<form:form commandName="diagnosis" action = "displayVisits" >
=======
		<form:form commandName="diagnosis" action = "index" >
>>>>>>> 1146a4ff88dc08992293823ca57a4a2c1b635bea
			<form:input path="id" type="hidden" />
			<div class="col-sm-4">
			</div>
			<div class="col-sm-1">
				<div class="row">
				<div class="col">
				<p style="color:white">Visit Id:</p>
			    </div>
	            </div>
	            <div class="row">
				<div class="col">
				<p style="color:white">Date:</p>
			    </div>
	            </div>
	            <div class="row">
				<div class="col">
				<p style="color:white">BloodGroup</p>
			    </div>
	            </div>
	            <div class="row">
				<div class="col">
				<p style="color:white">Height(cm)</p>
			    </div>
	            </div>
	            <div class="row">
				<div class="col">
				<p style="color:white">Weight(Kg)</p>
			    </div>
	            </div>
	            <div class="row">
				<div class="col">
				<p style="color:white">BloodSugar(mg/dL)</p>
			    </div>
	            </div>
	            <div class="row">
				<div class="col">
				<p style="color:white">BodyTemperature</p>
			    </div>
	            </div>
	        </div>
	        <div class="col-sm-4">
	        <table>
	        <tr>
	       	<td><c:out value="${diagnosis.visitId}" /></td>
			<form:input path="visitId" style="color:white" type="hidden" />
			</tr>
			<br>
			<tr>
			<td><c:out value="${diagnosis.date}" /></td>
			<form:input path="date" type="hidden" />
			</tr>
			<br>
	         <c:out value="${diagnosis.bloodGroup}" />
			<form:input path="bloodGroup" type="hidden" />
			<br>
        
	         
	       <c:out value="${diagnosis.height}" />
			<form:input path="height" type="hidden" />
			<br>
	        
	        <c:out value="${diagnosis.weight}" />
			<form:input path="weight" type="hidden" />
			<br>
	        
		<c:out value="${diagnosis.bloodSugar}" />
			<form:input path="bloodSugar" type="hidden" />
			<br>
	         <c:out value="${diagnosis.bodyTemperature}" />
			<form:input path="bodyTemperature" type="hidden" />
			<br>
            </div>
	        <div class="col-sm-2">		
	
            </div>
	        <div>
		
     </div>

    
	<div style="overflow-x: auto;" class="w3-container"></div>
	<br>
	
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
		<br><br>
			<form:button type="submit" class="btn btn-primary">
				<i class="fa fa-plus"></i> &nbsp;Visit Page
    </form:button>
		
		</div>
	</div>
	</form:form>
		</div>
	</div>
</body>
<script src="static/script/jquery.min.js"></script>
<script src="/static/script/jquery-1.10.2.js"></script>
<script src="/static/script/bootstrap.min.js"></script>
<script src="/static/script/jquery-ui.js"></script>
<script src="static/script/script.js"></script>
<script src="static/script/script2.js"></script>
</html>
