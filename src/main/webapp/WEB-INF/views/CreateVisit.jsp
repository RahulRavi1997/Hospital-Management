<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
   <link rel="stylesheet" 
  href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
   </head>
   <body>
      <center>
         <h1>Hospital Management</h1>
      </center>
      <c:choose>
         <c:when test="${empty visit.id}">
            <c:set var="value" value="addVisit"/>
         </c:when>
         <c:otherwise>
            <c:set var="value" value="updateVisit"/>
         </c:otherwise>
      </c:choose>
      <div class="row">
         <form:form  action="${value}" commandName="visit">
            <div class="col-md-6">
                     <c:if test="${empty visit.id}">
                        Add Visit Details
                     </c:if>
                     <c:if test="${not empty visit.id}">
                        Modify Visit Details
                     </c:if>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="admitDate">Date of Admit</label>
                     <div class="col-sm-10">
                        <form:input type="date" id="admitDate" path="admitDate" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="patientId">Patient Name</label>
                     <div class="col-sm-10">
                     <input type="text" id="search" name="name" class="search" onselect=""/>
                      <input type="hidden" name="patientId" id="patientId"/>
                     </div>
                  </div>
                    <label class="col-sm-2 control-label" for="Specialisation">Specialisation</label>
                     <div class="col-sm-10">
                      <select id='specialisation'>
                      <c:forEach items="${specialisations}" var="specialisation">
                        <c:if test="${specialisation != selected}">
                         <option value="${specialisation}">${specialisation}</option>
                          </c:if>
                           </c:forEach> 
                           </select>
                     </div>
                     <div class="form-group">
                    <label class="col-sm-2 control-label" for="Physician">Physician</label>
                     <div class="col-sm-10">
                        <select id="sel_user">
                        <option value="0">- Select -</option>
                       </select>
                      <input type="hidden" name="physicianId" id="physicianId"/>
                  </div>
                  
                  <div class="form-group">
                    <label class="col-sm-2 control-label" for="PatientType">Patient Type</label>
                     <div class="col-sm-10">
                       <form:select path="patientType" items="${types}" />
                     </div>
                  </div>
                  <c:if test="${not empty visit.id}">
                     <input type="hidden" name="id" value="${visit.id}" />
                  </c:if>
            </div>
      <br>
      <div style="text-align:center">
      <c:choose>
      <c:when test="${empty visit.id}">
      <input type="submit" class="btn btn-info center" value="ADD VISIT" >
      </c:when>
      <c:otherwise>
      <input type="submit" class="btn btn-info center" value="MODIFY VISIT DETAILS" onclick= "return confirm('Sure want to make changes on the Visit?')" >
      </c:otherwise>
      </c:choose>
            </div>
      </form:form>
            </div>
   </body>
   <script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
   <script>
   $(document).ready(function() {
	   $(function() {
	       $("#search").autocomplete({     
	           source : function(request, response) {
	             $.ajax({
	           headers: { 
	                'Accept': 'application/json',
	                'Content-Type': 'application/json' 
	            },
	                  url : "searchPatientByName",
	                  type : "GET",
	                  data : {
                          name : request.term
	                  },
	                  dataType : "json",
	                  success : function(data) {


	           response($.map(data, function (value, key) {
	               console.log(value);
                   $("#patientId").val(value.id);
                   var id = value.id;
	               return {
	                   label: value.firstName +" - [" +  id  + "]",
	                   value: value.firstName,
	               };
	           }));

	                  }
	           });
	        }
	    });
	 });
	});
   $(document).ready(function(){

	    $("#specialisation").change(function(){
	        var specialisation = $(this).val();

	        $.ajax({
		           headers: { 
		                'Accept': 'application/json',
		                'Content-Type': 'application/json' 
		            },
	            url: 'displayPhysiciansBySpecialisation',
	            type: 'GET',
	            data: {
	            	specialisationName : specialisation
	            	},
	            dataType: 'json',
	            success:function(response){
	                var len = response.length;

	                $("#sel_user").empty();
	                for( var i = 0; i<len; i++) {
	                    var id = response[i]['id'];
	                    var name = response[i]['firstName'];
	                    $("#physicianId").val(id);
	                    $("#sel_user").append("<option value='"+id+"'>"+name+"</option>");

	                }
	            }
	        });
	    });

	});

   </script>
</html>
