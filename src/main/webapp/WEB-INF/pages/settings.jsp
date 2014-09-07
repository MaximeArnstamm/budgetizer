<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Budgetizer</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" />

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<link href="<c:url value="/resources/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/plugins/timeline.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/sb-admin-2.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/plugins/morris.css"/>" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">Budgetizer</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li>
					<a href="">
						<i class="fa fa-sign-out fa-fw"></i>
						Déconnexion
					</a>
				</li>
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li>
							<a href="${pageContext.request.contextPath}">
								<i class="fa fa-dashboard fa-fw"></i>
								Dashboard
							</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/history">
								<i class="fa fa-table fa-fw"></i>
								Historique
							</a>
						</li>
						<li>
							<a class="active" href="${pageContext.request.contextPath}/settings">
								<i class="fa fa-wrench fa-fw"></i>
								Préférences de budget
							</a>
						</li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
		<div id="page-wrapper">
			<div class="row">
				<h1>Préférences</h1>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-arrow-circle-down fa-fw"></i>
							Ajouter un budget
						</div>
						<div class="panel-body">
							<form:form method="post" action="settings/budget/add" commandName="budget">
								<div class="row">
									<div class="col-lg-6">
										<div class="form-group">
											<form:label path="budgetLimit">Limite de budget : </form:label>
											<div class="form-group input-group">
												<form:input path="budgetLimit" class="form-control" placeholder="ex : 800 " />
												<span class="input-group-addon"> <i class="fa fa-eur"></i>
												</span>
											</div>
											<form:errors path="budgetLimit" class="has-error" />
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<form:label path="expenseCategory">Catégorie : </form:label>
											<form:input path="expenseCategory" class="form-control" placeholder="ex : Repas " />
										</div>
										<form:errors path="expenseCategory" class="has-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-lg-1">
										<button type="submit" class="btn btn-primary">Ajouter</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>

				<div class="col-lg-6">
					<div class="panel panel-info">
						<div class="panel-heading">
							<i class="fa fa-table fa-fw"></i>
							Limites de budget par catégorie
						</div>
						<div class="panel-body">
							<table class="table table-bordered">
								<tr>
									<th>Catégorie</th>
									<th>Budget</th>
								</tr>
								<c:forEach items="${budgets}" var="bubu">
									<tr>
										<td>${bubu.expenseCategory}</td>
										<td>${bubu.budgetLimit}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>