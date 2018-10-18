<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Physician Details</title>
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
                <li>
	           <a href="displayUsers">Display Users</a>
                </li>
                <li>
              <a href="createPhysician">Create Physician</a> 
                </li>
                <li  class="highlight">
	           <a href="displayPhysicians">Display Physicians</a>
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
    <jsp:useBean id="now" class="java.util.Date"/>
    <fmt:formatDate var="currentyear" value="${now}" pattern="yyyy" />
      <div class="row full-width">
        <div class="col-sm-4 col-xs-4 text-align-center"> 
          <a href="createPhysician">
          <button class="btn-margin-format add-button">
          Add New Physician
          </button>
          </a>
        </div>
        <form action="searchPhysician" method="GET">
        <div class="col-sm-4 col-xs-4"> 
          <input name="id" autocomplete="off" id="myInput" class="form-control mr-sm-2" placeholder="Search" type="number" required/>
              <button class="glyphicon glyphicon-search"  type="submit">Search</button>    
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
      <h2 align="center">No Physicians are available/present at the moment. Sorry!</h2>
    </c:if>
    <c:if test="${not empty physicians}">
      <div class="row full-width">
          <div class="col-xs-9 margin-left-30">
          <b>Physician Details</b>
        </div>
          <div class="col-xs-2">
          <b>Number Of Physicians- [${numberOfPhysicians}]</b>
        </div>
      </div>
      <div class="scrollable">
      <table cellpadding="10" border="1" class=" assign-table table sortable table-hover" >
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
            <th>#</th>
            <th>#</th>
          </tr>
        </thead>
        <tbody id="myTable">
          <tr>
            <c:forEach var="physician" items="${physicians}">
              <td>
                ${physician.id}
              </td>
              <td>
                  <form action="searchPhysician" method="get" id="search-form">
                    <input type="hidden" name="id" value="${physician.id}"/>
                    <button class="button-as-link" type="submit">${physician.firstName} ${physician.lastName}</button>
                  </form>
              </td>
              <td>
                ${physician.email}
              </td>
              <td>
                ${physician.gender}
              </td>
              <td>
                ${physician.specialisation}
              </td>
              <td>${physician.birthDate}</td>
              <td>${physician.mobileNumber}</td>
              <td>${physician.age} years</td>
              <c:if test="${!physician.isActive()}">
                  <td colspan="2" class="type">
                    <form action ="restorePhysician" method="POST">
                      <input type="hidden" name="id" value="${physician.id}"/>
                      <button type="submit" class="btn-margin-format">Restore</button>
                    </form>
                  </td>
              </c:if>
              <c:if test="${physician.isActive()}">
                  <form action = "modifyPhysician" method = "GET">
                    <input type="hidden" name="id" value="${physician.id}"/>
                    <td><input type="submit" class="btn btn-primary" value="Update"></td>
                  </form>
                  <form action ="deletePhysician" method="POST">
                    <input type="hidden" name="id" value="${physician.id}"/>
                    <td class="type"><button type="submit"  class="btn-danger" onclick="return confirm('Delete physician id : ${physician.id} ?')" >Delete </button></td>
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
    <jsp:include page="footer.jsp"/>


  </body>
</html>
