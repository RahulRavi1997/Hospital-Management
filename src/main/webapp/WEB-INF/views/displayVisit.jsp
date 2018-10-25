<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<link href='https://fonts.googleapis.com/css?family=Righteous' rel='stylesheet'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="http://cdn.phpoll.com/css/animate.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/static/css/app.css" />
	<style>
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
	text-align: center;
	background-color: #333;
	position: fixed;
	width: 100%;
	bottom: 0px;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	border-radius: 10px 10px 10px 10px;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 1s;
	animation: animatezoom 1s
}

@-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

#myInput {
  width:100%;
  height:50px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

.content {
	width: auto;
	height: auto;
	display: none;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp" />${sessionScope.id}
	<div class="left_div">
		<form action="/physicianVisit" method="get">
			<input type="hidden" name="id" value=${sessionScope.id}>
			<button class="btn btn-success"> Display Visits </button>
		</form>
		<c:if test="${visits.size() == 0 }">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
					<img src="https://lh3.googleusercontent.com/-PTH5AmaGw6o/W5DCxX6xZ9I/AAAAAAAAACE/kDeOnh2-sRwncQh3cvs94UteY8-id2K6QCL0BGAYYCw/h450/Layer%2B0.png" />
				</div>
			</div>
		</c:if>
		<input id="myInput" type="text" placeholder="Search..">
		<div style="overflow-x: auto;" class="w3-container animated flipInX">
			<c:choose>
				<c:when test="${not empty visits}">
					<div class="row">
						<div class="col-sm-5"></div>
						<div class="col-sm-4">
							<h3 style="color: white">Patients</h3>
						</div>
					</div>
					<table id="myTable" class="w3-table-all w3-hoverable ui-widget ui-widget-content" id="resizable">
						<thead>
							<br>
							<tr class="ui-widget-header">
								<th>Visit ID</th>
								<th>Admit Date</th>
								<th>Discharge Date</th>
								<th>PatientId</th>
								<th>Visit Type</th>
								<th>&ensp;&ensp;&ensp;&ensp;Action</th>
								<th>&ensp;&ensp;&ensp;&ensp;Action</th>
								<th>&ensp;&ensp;&ensp;&ensp;Action</th>
								<th>&ensp;&ensp;&ensp;&ensp;Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${visits}" var="visit">
								<tr id="mycontent">
									<td>${visit.id}</td>
									<td>${visit.admitDate}</td>
									<td>${visit.dischargeDate}</td>
									<td>${visit.patient.id}</td>
									<td>${visit.patientType}</td>
									<td>
										<c:if test="${visit.patientType=='Out Patient'}">
											<form action="/createPrescription" method="post">
												<input type="hidden" name="visitId" value="${visit.id}">
												<input type="hidden" name="visitType" value="${visit.patientType}">
												<button class="btn btn-primary Out" type="submit">
													<i class="fa fa-plus"></i>&nbsp;Add Prescription
												</button>
											</form>
										</c:if>
										<c:if test="${visit.patientType!='Out Patient'}">
											<form action="/createPrescription" method="post">
												<input type="hidden" name="visitId" value="${visit.id}">
												<input type="hidden" name="visitType" value="${visit.patientType}">
												<button class="btn btn-primary" type="submit">
													<i class="fa fa-plus"></i>&nbsp;Add Prescription
												</button>
											</form>
										</c:if>
									</td>
									<td>
										<form action="ViewPrescriptions" method="post">
											<input type="hidden" name="visitId" value="${visit.id}">
											<button class="btn btn-success" type="submit" />
											<i class="fa fa-eye"></i>&nbsp;View Prescription
											</button>
										</form>
									</td>
									<td>
										<form action="/create_diagnosis?id=${prescription.id}" method="post">
											<input type="hidden" name="visitId" value="${visit.id}">
											<button class="btn btn-primary" type="submit" />
											<i class="fa fa-plus"></i>&nbsp;Add Diagnosis
											</button>
										</form>
									</td>
									<td>
										<form action="/viewAllDiagnosis" method="post">
											<input type="hidden" name="visitId" value="${visit.id}">
											<button class="btn btn-success" type="submit" />
											<i class="fa fa-eye"></i>&nbsp;View Diagnosis
											</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
			</c:choose>
		</div>
	</div>
	<div class="right_div"></div>
	<div id="id01" class="modal">
		<form class="modal-content" action="index" method="get">
			<button type="submit" onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</button>
			<div style="height: 400px; overflow: auto;" class="w3-container">
				<table class="w3-table-all w3-hoverable ui-widget ui-widget-content">
					<thead>
						<tr id="ui-widget-header">
							<th>PrescriptionId</th>
							<th>PrescriptionDate</th>
							<th>Action</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${prescriptions}" var="prescription">
							<div>
								<tr>
									<td>${prescription.id}</td>
									<td>${prescription.prescriptionDate}</td>
									<td>
										<button type="button" class="w3-button w3-white w3-border w3-border-red w3-round-large view">View</button>
									</td>
									<td><button type="submit" class="btn btn-info" onclick="this.form.action='editPrescription?id=${prescription.id}';this.form.method='post'">
											<i class="fa fa-edit"></i> &nbsp;Edit
										</button></td>
								</tr>
								<tr class="content">
									<td colspan="6">
										<div style="overflow-x: auto;" class="w3-container">
											<c:choose>
												<c:when test="${prescription.prescriptionDetails != null}">
													<h5>Prescritpion Detials</h5>
													<table class="w3-table-all w3-hoverable ui-widget ui-widget-content" id="choose-address-table">
														<thead>
															<tr class="ui-widget-header">
																<th>ID</th>
																<th>Medicine Name</th>
																<th>Dosage</th>
																<th>Days</th>
																<th>Quantity</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${prescription.prescriptionDetails}" var="prescriptionDetails">
																<tr>
																	<td>${prescriptionDetails.id}</td>
																	<td>${prescriptionDetails.item.itemName}</td>
																	<td>${prescriptionDetails.dosage.dosage}</td>
																	<td>${prescriptionDetails.days}</td>
																	<td>${prescriptionDetails.dosage.quantity}</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</c:when>
											</c:choose>
											<div>
									</td>
								</tr>
							</div>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
	</div>
	<div id="snackbar">${message}</div>
</body>
<jsp:include page="Footer.jsp" />
<script src="static/script/jquery.min.js"></script>
<script>

	<c: choose>
		<c: when test="${prescriptions != null}">
    window.onload = function() {
			document.getElementById('id01').style.display = 'block';
		}
</c: when >
</c: choose >


		$(document).ready(function () {
			$(".view").click(function () {
				$(this).closest('tr').next('tr').toggle();
			});
		});

	$(document).ready(function () {
		$(".Out").click(function () {
			$(this).css('pointer-events', 'none');
		});
	});

	$(document).ready(function () {
		$("#myInput").on("keyup", function () {
			var value = $(this).val().toLowerCase();
			$("#myTable #mycontent").filter(function () {
				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			});
		});
	});
	<c: if test="${message !=null }">
		var x = document.getElementById("snackbar");
		x.className = "show";
setTimeout(function(){x.className = x.className.replace("show", ""); }, 3000);
</c: if>
</script>

</html>