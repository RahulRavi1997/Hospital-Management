<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Physician Details</title>


    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <jsp:include page="Access.jsp"/>
  </head>
  <body>
    <jsp:include page="Header.jsp" />
    <div id="wrapper">
      <!-- Sidebar -->
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <li class="sidebar-brand"><a href="index"> Home </a></li>
          <li><a href="createUser">Create User </a></li>
          <li><a href="displayUsers">Display Users</a></li>
          <li><a href="createPhysician">Create Physician</a></li>
          <li class="highlight"><a href="displayPhysicians">Display
            Physicians</a>
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
              <c:if test="${not empty message}">
                <div id="snackbar">${message}</div>
              </c:if>
              <jsp:useBean id="now" class="java.util.Date" />
              <fmt:formatDate var="currentyear" value="${now}" pattern="yyyy" />
              <div class="row full-width">
                <div class="col-sm-4 col-xs-4 text-align-center">
                </div>
                <form action="searchPhysician" method="GET">
                <div class="col-sm-4 col-xs-4 search-bar-display">
                  <form  autocomplete="off" class="form-inline" action="searchPhysician" method="get">
                    <input name="id"  type="number" class="form-control mr-sm-2 width-search" placeholder="Search"  required>
                    <button class="glyphicon glyphicon-search"  type="submit">Search</button>    
                  </form>
                </div>
                  <div class="col-sm-4 col-xs-4 text-align-center">
                    <h4>
                      Filter : 
                      <select id="filterChoice">
                        <option value>All</option>
                        <option value="Delete">Active</option>
                        <option value="Restore">Inactive</option>
                      </select>
                    </h4>
                  </div>
                </form>
              </div>
              <c:if test="${empty physicians}">
                <h2 align="center">No Physicians are available/present at
                  the moment. Sorry!
                </h2>
              </c:if>
              <c:if test="${not empty physicians}">
                <div class="row full-width">
                  <div class="col-xs-9 margin-left-30">
                    <b>Physician Details        </b><button id="createButton" class="fa fa-close fa-plus btn-success large" onclick="displayCreate();"></button>
                  </div>
                  <div class="col-xs-2">
                    <b>Number Of Physicians- [${numberOfPhysicians}]</b>
                  </div>
                </div>
                <div class="scrollable">
                  <table cellpadding="10" border="1"
                    class=" assign-table table sortable table-hover">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Specialisation</th>
                        <th>DOB</th>
                        <th>Mobile Number</th>
                        <th>Age</th>
                        <th>Action</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody id="myTable">
                      <jsp:useBean id="physician" class="com.ideas2it.hospitalmanagement.physician.model.Physician" scope="request"/>
                      <form:form commandName="physician" action="addPhysician" method="post">
                      <tr id="createTr" class="hidden">
                          <td>#
                          </td>
                          <td>
                   <form:input type="text" path="firstName" placeHolder="First Name"/>
                      <form:input type="text" path="lastName" placeHolder="Last Name"/>
                          </td>
                          <td>
                          <form:input type="email" path="email" placeHolder="Email"/>
                           </td>
                          <td>
                          <form:select path="gender">
                            <form:option value="Male">Male</form:option>
                            <form:option value="Female">Female</form:option>
                            <form:option value="Other">Other</form:option>
                          </form:select>
                          </td>
                          <td>
                          <form:select path="specialisation">
                            <form:option value="Cardiologist">Cardiologist</form:option>
                            <form:option value="Neurologist">Neurologist</form:option>
                            <form:option value="Ophthalmologist">Ophthalmologist</form:option>
                            <form:option value="Surgeon">Surgeon</form:option>
                            <form:option value="Pediatrician">Pediatrician</form:option>
                            <form:option value="Dermatologist">Dermatologist</form:option>
                            <form:option value="Immunologist">Immunologist</form:option>
                            <form:option value="Psychiatrist">Psychiatrist</form:option>
                          </form:select>
                          </td>
                          <td>
                          <form:input type="date" id="birthDate" path="birthDate" placeHolder="Birthdate"/>
                          </td>
                          <td>
                          <form:input type="number" path="mobileNumber" placeHolder="Mobile Number"/>
                          </td>
                         <td>
                          <input type="text" id="age" placeHolder="Age" readOnly/>
                          </td>
                           <td colspan="2" class="type">
                                <button type="submit" class="btn btn-success">Add</button>
                            </td>
                      </tr>
                       <input type="hidden" name="UserEmail" value=""/>
                      </form:form>
                        <c:forEach var="physician" items="${physicians}">
                         <tr>
                          <td>${physician.id}</td>
                          <td>
                            <form action="searchPhysician" method="get"
                              id="search-form">
                              <input type="hidden" name="id" value="${physician.id}" />
                              <button class="button-as-link" type="submit">${physician.firstName}
                              ${physician.lastName}</button>
                            </form>
                          </td>
                          <td>${physician.email}</td>
                          <td>${physician.gender}</td>
                          <td>${physician.specialisation}</td>
                          <td>${physician.birthDate}</td>
                          <td>${physician.mobileNumber}</td>
                          <c:choose>
                            <c:when test="${not empty physician.birthDate}">
                              <td>${physician.age} years</td>
                            </c:when>
                            <c:otherwise>
                              <td>-</td>
                            </c:otherwise>
                          </c:choose>
                          <c:if test="${!physician.isActive()}">
                            <td colspan="2" class="type">
                              <form action="restorePhysician" method="POST">
                                <input type="hidden" name="id" value="${physician.id}" />
                                <button type="submit" class="btn-margin-format">Restore</button>
                              </form>
                            </td>
                          </c:if>
                          <c:if test="${physician.isActive()}">
                            <form action="modifyPhysician" method="GET">
                              <input type="hidden" name="id" value="${physician.id}" />
                              <td><input type="submit" class="btn btn-primary"
                                value="Update"></td>
                            </form>
                            <form action="deletePhysician" method="POST">
                              <input type="hidden" name="id" value="${physician.id}" />
                              <td class="type"><button type="submit"
                                class="btn btn-danger"
                                onclick="return confirm('Delete physician id : ${physician.id} ?')">Delete
                                </button>
                              </td>
                            </form>
                          </c:if>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </c:if>
              </td>
              </table>
            </div>
          </div>
        </div>
      </div>
      <!-- /#page-content-wrapper -->
    </div>
    <jsp:include page="Footer.jsp" />
  </body>

</html>
