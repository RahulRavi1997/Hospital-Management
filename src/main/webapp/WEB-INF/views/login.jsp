<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Hospital Management</title>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/jquery-ui.css">
    <title>Sign-Up/Login Form</title>
    <meta name="_csrf" content="${_csrf.token}" />
    <link
      href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
      rel='stylesheet' type='text/css'>
    <link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link href="<c:url value='/static/css/bootstrap.css' />"
      rel="stylesheet">
    </link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
    </link>
    <link rel="stylesheet" type="text/css"
      href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    <link rel="stylesheet" href="static/css/index.css">
  </head>
  <style></style>
  <body>
    <c:out value="${loginFail}" />
    <c:out value="${signinFail}" />
    <c:out value="${signUpFail}" />
    <label>
      <c:out value="${userFail}" />
    </label>
    <c:url var="loginUrl" value="/j_spring_security_check" />
    <div class="form">
      <h1 align="center">Hospital Management</h1>
      <ul class="tab-group">
        <li class="tab active"><a href="#login">Log In</a></li>
        <li class="tab"><a href="#signup">Sign Up</a></li>
      </ul>
      <div class="tab-content">
        <div id="login">
          <h1>Welcome Back!</h1>
          <form action="${loginUrl}" method="post" class="form-horizontal">
            <div class="field-wrap">
              <label class="active"> Email Address </label> <input type="email"
                name="email" value="${signinEmail}" required autocomplete="off" />
            </div>
            <div class="field-wrap">
              <label class="active"> Password </label> <input type="password"
                name="password" class="pwd" id="passwd" required
                autocomplete="off" />
              <button id="reveal" class="btn btn-default reveal" type="button">
              <i class="glyphicon glyphicon-eye-open"></i>
              </button>
              <font color="red">
                <input type="hidden"
                  name="${_csrf.parameterName}" value="${_csrf.token}" /> 
                <c:if
                  test="${param.error != null}">
                  <div>
                    <p class="errorCustomLogin">Login failed. Please try your
                      username/password again.
                    </p>
                  </div>
                </c:if>
                <c:if test="${param.logout != null}">
                  <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                  </div>
                </c:if>
              </font>
              <font color="green">
                <label>
                  <c:out
                    value="${signUpSuccess}" />
                </label>
              </font>
            </div>
            <button type="submit" class="button button-block" />
            Login
            </button>
            <input type="hidden" name="${_csrf.parameterName}"
              value="${_csrf.token}" />
          </form>
        </div>
        <div id="signup">
          <form role="form" action="signup" method="post">
            <div class="field-wrap ">
              <label class="active"> Email Address<span class="req">*</span>
              </label> <input type="email" id="signupemail" name="email" required
                autocomplete="off" />
            </div>
            <div class="field-wrap">
              <label> Password<span class="req">*</span>
              </label> <input type="password" name="password" id="password" required
                autocomplete="off" />
            </div>
            <div class="field-wrap">
              <label> Confirm Password<span class="req">*</span>
              </label> <input type="password" name="confirmPassword"
                id="confirmPassword" required autocomplete="off" />
            </div>
            <button id="register" class="button button-block" />
            Get Started
            </button>
          </form>
          <div style="font-size: 27px;" id="nonUniqueEmail"></div>
        </div>
      </div>
    </div>
    <script
      src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="static/script/jquery.min.js"></script>
    <script src="static/script/bootstrap.min.js"></script>
    <script src="/static/script/jquery-1.10.2.js"></script>
    <script src="/static/script/bootstrap.min.js"></script>
    <script src="/static/script/jquery-1.9.1.min.js"></script>
    <script src="/static/script/jquery-ui.js"></script>
    <script src="/static/script/index.js"></script>
  </body>
</html>