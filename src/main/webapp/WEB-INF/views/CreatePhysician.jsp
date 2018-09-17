<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>PhysicianForm</title>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
  </head>
  <body>
  <jsp:include page="header.jsp"/>
     <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="index">
                        Home
                    </a>
                </li>
                <li>
             <a href="createUser">Create User </a> 
                </li>
                <li  class="highlight">
              <a href="createPhysician">Add Physician</a> 
                </li>
                <li>
	           <a href="displayPhysicians">Display Physician</a>
                </li>
                <li>
	           <a href="displayUsers">Display Users</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">

    <c:set var="value" value="Add"/>
    <c:set var="operation" value="addPhysician"/>
    <c:if test="${not empty physician.firstName}">
      <c:set var="value" value="Edit"/>
      <c:set var="operation" value="updatePhysician"/>
    </c:if>
    <jsp:useBean id="now" class="java.util.Date"/>
    <form:form commandName="physician" action="${operation}" method="post" onsubmit="submit_form(this.form)">
      <form:hidden path="id" value="${physician.id}"/>
      <form:hidden path="active" value="${physician.isActive()}"/>
      <div class="container bg-input-container">
        <legend align="center"  class="bg-blue"><b>${value} Physician Details</b></legend>
        <div class="row">
          <c:if test="${empty physician.firstName}" var="noName"/>
          <c:if test="${empty physician.email}" var="noEmail"/>
          <div class="col-sm-6 col-xs-6 create-col-padding">
            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="name">First Name</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="text" path="firstName" placeholder="First Name" aria-describedby="basic-addon1" required="required" maxLength="25"/>
                <br/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="name">Last Name</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="text" path="lastName" placeholder="Last Name" aria-describedby="basic-addon1" required="required" maxLength="25"/>
                <br/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 col-xs-3">
                <label for="birthDate">Birth Date</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="date" class="date-width" id="birthDate" path="birthDate" placeholder="Birth Date" aria-describedby="basic-addon1" min="${minBirthDate}" max="${maxBirthDate}"/>
              </div>
            </div>

            <div class="row">
              <div class="col-sm-3 col-xs-3">
                <label for="name">Mobile Number:</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="number" path="mobileNumber" placeholder="Mobile Number" aria-describedby="basic-addon1" maxLength="10"/>
                <br/>
              </div>
            </div>

            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="email">Email-Id</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:input type="email" path="email" placeholder="Email-Id" aria-describedby="basic-addon1" maxLength="20" required="required"/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 col-xs-3 required">
                <label for="role">Specialisation</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:select path="specialisation" items="${specialisations}" />
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 col-xs-3">
                <label for="salary">Gender</label>
              </div>
              <div class="col-sm-3 col-xs-3">
                <form:select path="gender" items="${genders}" />
              </div>
            </div>
          </div>
           <div class="col-sm-6 col-xs-6">
            <c:forEach items="${physician.addresses}" varStatus="vs">
              <c:if test="${vs.index+1 eq 1}"> <c:set var="addrstype" value="Permanent"/></c:if>
              <c:if test="${vs.index+1 eq 2}"> <c:set var="addrstype" value="Temporary"/></c:if>
              <div class="row">
                <div class="col-sm-6 col-xs-6"> 
                  <b>${addrstype} Address</b>
                </div>
              </div>
               <form:hidden path="addresses[${vs.index}].type" value="${addrstype}"/>
              <div class="row">
                <div class="col-sm-3 col-xs-3 required">
                  <form:label class="color-black" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid">Address Line 1</form:label>
                </div>
                <div class="col-sm-3 col-xs-3">
                  <div class="input">
                    <form:input type="TEXT" placeholder="Address Line 1" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid " required="required"/>
                    <form:label path="addresses[${vs.index}].addressLine1" cssErrorClass="icon invalid" />
                    <form:errors path="addresses[${vs.index}].addressLine1" cssClass="inline_invalid" />
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-3 col-xs-3">
                  <form:label class="color-black" path="addresses[${vs.index}].addressLine2" cssErrorClass="invalid">Address Line 2</form:label>
                </div>
                <div class="col-sm-3 col-xs-3">
                  <div class="input">
                    <form:input placeholder="Address Line 2" path="addresses[${vs.index}].addressLine2" cssErrorClass="invalid" maxLength="50"/>
                    <form:label path="addresses[${vs.index}].addressLine2" cssErrorClass="icon invalid" />
                    <form:errors path="addresses[${vs.index}].addressLine2" cssClass="inline_invalid" />
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-3 col-xs-3 required">
                  <form:label class="color-black" path="addresses[${vs.index}].country" cssErrorClass="invalid">Country</form:label>
                </div>
                <div class="col-sm-3 col-xs-3">
                  <div class="input">
                    <form:input placeholder="Country" path="addresses[${vs.index}].country" cssErrorClass="invalid " maxLength="50" required="required" />
                    <form:label path="addresses[${vs.index}].country" cssErrorClass="icon invalid" />
                    <form:errors path="addresses[${vs.index}].country" cssClass="inline_invalid" />
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-3 col-xs-3">
                  <form:label class="color-black" path="addresses[${vs.index}].pinCode" cssErrorClass="invalid">PinCode</form:label>
                </div>
                <div class="col-sm-3 col-xs-3">
                  <div class="input">
                    <form:input placeholder="Pin Code" type="number" min="0" path="addresses[${vs.index}].pinCode" cssErrorClass="invalid" maxLength="10"/>
                    <form:label path="addresses[${vs.index}].pinCode" cssErrorClass="icon invalid" />
                    <form:errors path="addresses[${vs.index}].pinCode" cssClass="inline_invalid" />
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
         Add User Login For Physician : 
	    <input type="text"  id="autocomplete" value="" name="UserEmail" placeHolder="Enter User Email"/>
        <div class="row" align="center">
          <input class="btn margin-format" type="reset" value="Reset"/>     
          <input class="btn-primary" type="submit" value="Submit"/>     
        </div>
      </div>
    </form:form>
    </br>
    </br>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <jsp:include page="footer.jsp"/>
  </body>
</html>
