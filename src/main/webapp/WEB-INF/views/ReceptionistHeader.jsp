<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button>
    <form action="searchPatient" method="POST"><input type="hidden" name="id" value="${sessionScope.patient.id}"/>
      <a class="navbar-brand" href="#">${sessionScope.patient.id}</a>
    </form>
  </div>
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li><a href="#">${sessionScope.patient.firstName} ${sessionScope.patient.lastName}</a></li>
      <li><a href="#">${sessionScope.patient.emailId}</a></li>
    </ul>
    <div class="col-sm-3 col-md-3  navbar-right">
      <form class="navbar-form" action="searchPatient" method="POST" role="search">
        <div class="input-group">
          <input type="number" required="required" class="form-control" placeholder="Search Patient By Id" name="id">
          <div class="input-group-btn">
            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
          </div>
        </div>
      </form>
    </div>
  </div>
</nav>
