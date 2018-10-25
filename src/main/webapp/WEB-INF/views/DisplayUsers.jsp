<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>User Details</title>
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
          <li class="highlight"><a href="displayUsers">Display Users</a>
          </li>
          <li><a href="createPhysician">Create Physician</a></li>
          <li><a href="displayPhysicians">Display Physicians</a></li>
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
                  <a href="createUser">
                  <button class="btn-margin-format add-button">Add New
                  User</button>
                  </a>
                </div>
                <div class="col-sm-4 col-xs-4"> 
                  <input name="id" autocomplete="off" id="myInput" class="form-control mr-sm-2  " placeholder="Search" required/>
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
              </div>
              <c:if test="${empty users}">
                <h2 align="center">No Users are available/present at the
                  moment. Sorry!
                </h2>
              </c:if>
              <c:if test="${not empty users}">
                <div class="row full-width">
                  <div class="col-xs-9 margin-left-30">
                    <b>Users Details</b>
                  </div>
                  <div class="col-xs-2">
                    <b>Number Of Users- [${numberOfUsers}]</b>
                  </div>
                </div>
                <div class="scrollable">
                  <table cellpadding="10" border="1"
                    class=" assign-table table sortable table-hover">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Action</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody id="myTable">
                      <tr>
                        <c:forEach var="user" items="${users}">
                          <td>${user.id}</td>
                          <td>${user.email}</td>
                          <td>${user.role}</td>
                          <c:if test="${!user.isActive()}">
                            <td colspan="2" class="type">
                              <form action="restoreUser" method="POST">
                                <input type="hidden" name="id" value="${user.id}" />
                                <button type="submit" class="btn-margin-format">Restore</button>
                              </form>
                            </td>
                          </c:if>
                          <c:if test="${user.isActive()}">
                            <form action="modifyUser" method="GET">
                              <input type="hidden" name="id" value="${user.id}" />
                              <td><input type="submit" class="btn btn-primary"
                                value="Update"></td>
                            </form>
                            <form action="deleteUser" method="POST">
                              <input type="hidden" name="id" value="${user.id}" />
                              <td class="type"><button type="submit"
                                class="btn btn-danger"
                                onclick="return confirm('Delete user id : ${user.id} ?')">Delete
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
