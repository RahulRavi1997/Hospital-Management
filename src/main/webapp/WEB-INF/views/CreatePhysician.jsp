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
    <jsp:include page="Access.jsp"/>
  </head>
  <body>
    <jsp:useBean id="now" class="java.util.Date"/>
    <fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd" />
    <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
    <fmt:formatDate var="currentMonth" value="${now}" pattern="MM" />
    <fmt:formatDate var="currentDay" value="${now}" pattern="dd" />
    <fmt:parseDate value="${currentYear-18}-${currentMonth}-${currentDay}" pattern="yyyy-MM-dd" var="maxdob" type="date" />
    <fmt:formatDate value="${maxdob}" var="maxBirthDate" type="date" pattern="yyyy-MM-dd" />
    <fmt:parseDate value="${currentYear-100}-${currentMonth}-${currentDay}" pattern="yyyy-MM-dd" var="mindob" type="date" />
    <fmt:formatDate value="${mindob}" var="minBirthDate" type="date" pattern="yyyy-MM-dd" />
    <jsp:include page="Header.jsp"/>
    <div id="wrapper">
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
        <li>
          <a href="displayUsers">Display Users</a>
        </li>
        <li  class="highlight">
          <a href="createPhysician">Create Physician</a> 
        </li>
        <li>
          <a href="displayPhysicians">Display Physicians</a>
        </li>
        <li>
          <a href="DisplayAllWards">Display Wards</a><br>
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
      <form:form commandName="physician" action="${operation}" method="post">
        <form:hidden path="id" value="${physician.id}"/>
        <form:hidden path="active" value="${physician.isActive()}"/>
        <legend align="center"  class="bg-blue"><b>${value} Physician Details</b></legend>
        <div class="row">
          <c:if test="${empty physician.firstName}" var="noName"/>
          <c:if test="${empty physician.email}" var="noEmail"/>
          <div class="row">
            <div class="col-md-4 ">
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="name">FirstName</label>
                <div class="col-sm-8">
                  <form:input path="firstName" pattern="^[a-zA-Z]{1,20}$" class ="form-control inputtext spacing" required="required" maxLength="25" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="name">LastName</label>
                <div class="col-sm-8">
                  <form:input path="lastName" pattern="^[a-zA-Z]{1,20}$" class ="form-control inputtext spacing" required="required" maxLength="25" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label" for="birthdate">BirthDate</label>
                <div class="col-sm-8">
                  <form:input type="date" path="birthDate" id="birthDate" min="${minBirthDate}" max="${maxBirthDate}" class ="form-control inputtext spacing" />
                </div>
              </div>
                <div class="form-group">
                <label class="col-sm-4 control-label">Age</label>
                <div class="col-sm-8">
                  <input type="text" id="age" class ="form-control inputtext spacing" readonly/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label" for="mobileNumber">Mobile Number</label>
                <div class="col-sm-8">
                  <form:input path="mobileNumber" pattern="^[0-9]{10}$" maxLength="10" class ="form-control spacing inputtext"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="email">Email</label>
                <div class="col-sm-8">
                  <form:input type="email" path="email" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" required="required" class ="form-control inputtext spacing" maxLength="25" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label required" for="specialisation">Specialisation</label>
                <div class="col-sm-8">
                  <form:select path="specialisation" class ="form-control spacing inputtext" required="required">
                    <option  selected disabled hidden value="">Select</option>
                    <form:options items="${specialisations}" />
                  </form:select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label" for="Gender">Gender</label>
                <div class="col-sm-8">
                  <form:select path="gender" class ="form-control spacing inputtext">
                    <option  selected disabled hidden value="">Select</option>
                    <form:options items="${genders}" />
                  </form:select>
                </div>
              </div>
              <c:if test="${not empty physician.id}">
                <input type="hidden" name="active" value="${physician.active}" />
                <input type="hidden" name="id" value="${physician.id}" />
              </c:if>
            </div>
            <c:forEach items="${physician.addresses}" varStatus="vs">
              <div class="col-md-4">
                <c:if test="${vs.index+1 eq 1}">
                  <c:set var="addrstype" value="Permanent"/>
                </c:if>
                <c:if test="${vs.index+1 eq 2}">
                  <c:set var="addrstype" value="Temporary"/>
                </c:if>
                <div class="row">
                  <div class="col-sm-6 col-xs-6"> 
                    <b>${addrstype} Address</b>
                  </div>
                </div>
                <br>
                <form:hidden path="addresses[${vs.index}].type" value="${addrstype}"/>
                <div class="row">
                  <div class="col-sm-3 col-xs-3">
                    <form:label class="color-black" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid">Address Line 1</form:label>
                  </div>
                  <div class="col-sm-3 col-xs-3">
                    <div class="input">
                      <form:input type="TEXT" placeholder="Address Line 1" class ="form-control spacing inputtext" path="addresses[${vs.index}].addressLine1" cssErrorClass="invalid " />
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
                      <form:input placeholder="Address Line 2" class ="form-control spacing inputtext" path="addresses[${vs.index}].addressLine2" cssErrorClass="invalid"/>
                      <form:label path="addresses[${vs.index}].addressLine2" cssErrorClass="icon invalid" />
                      <form:errors path="addresses[${vs.index}].addressLine2" cssClass="inline_invalid" />
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-3 col-xs-3">
                    <form:label class="color-black" path="addresses[${vs.index}].country" cssErrorClass="invalid">Country</form:label>
                  </div>
                  <div class="col-sm-3 col-xs-3">
                    <div class="input">
                      <form:input placeholder="Country" class ="form-control spacing inputtext" path="addresses[${vs.index}].country" cssErrorClass="invalid " maxLength="50" />
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
                      <form:input placeholder="Pin Code" class ="form-control spacing inputtext" type="number" min="0" path="addresses[${vs.index}].pinCode" cssErrorClass="invalid" maxLength="10"/>
                      <form:label path="addresses[${vs.index}].pinCode" cssErrorClass="icon invalid" />
                      <form:errors path="addresses[${vs.index}].pinCode" cssClass="inline_invalid" />
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          <div class="row" align="center">
            <div class="col-xs-6 form-group">
             <b> Add User Login For Physician : </b>
            </div>
            <div class="col-xs-6">
              <input class="form-control" type="text"  id="autocomplete" value="" name="UserEmail" placeHolder="Enter User Email"/>
            </div>
          </div>
        </div>
          <br>
          <div style="text-align:center">
            <c:choose>
              <c:when test="${empty physician.id}">
                <input type="submit" class="btn btn-success center" value="Add Physician"/ >
              </c:when>
              <c:otherwise>
                <input type="submit" class="btn btn-success center" value="Modify Physician"/>
              </c:otherwise>
            </c:choose>
           </div>
          </div>
         </div>
        </div>
       </form:form>
      </div>
     </div>
    </div>
    <jsp:include page="Footer.jsp"/>
  </body>
</html>
