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

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<c:url value="/resources/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">

<!-- Timeline CSS -->
<link href="<c:url value="/resources/css/plugins/timeline.css"/>" rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/sb-admin-2.css"/>" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<c:url value="/resources/css/plugins/morris.css"/>" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">

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
						D�connexion
					</a>
				</li>
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li>
							<a class="active" href="index.html">
								<i class="fa fa-dashboard fa-fw"></i>
								Dashboard
							</a>
						</li>
						<li>
							<a href="tables.html">
								<i class="fa fa-table fa-fw"></i>
								Historique
							</a>
						</li>
						<li>
							<a href="settings">
								<i class="fa fa-wrench fa-fw"></i>
								Pr�f�rences de budget
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
				<h1>Tableau de bord de B�atrice</h1>
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="panel ${dashboard.state}">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-bar-chart-o fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${dashboard.globalLevel} %</div>
									<div>${dashboard.message}</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">Voir l'historique du mois</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-arrow-circle-down fa-fw"></i>
							Ajouter une d�pense
						</div>
						<div class="panel-body">
							<form:form>
								<div class="row">
									<div class="col-lg-6">
										<label> Cat�gorie </label>
										<select class="form-control">
											<option>Repas</option>
										</select>
									</div>
									<div class="col-lg-6">
										<label> Montant </label>
										<div class="form-group input-group">
											<input class="form-control" type="text" />
											<span class="input-group-addon"> <i class="fa fa-eur"></i>
											</span>
										</div>
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
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i>
							Budget courant par cat�gorie
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div id="morris-bar-chart"></div>
							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
				<!-- /.col-lg-8 -->
				<div class="col-lg-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bell fa-fw"></i>
							Derni�res d�penses
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="list-group">
								<a href="#" class="list-group-item">
									<i class="fa fa-comment fa-fw"></i>
									New Comment <span class="pull-right text-muted small"><em>4 minutes ago</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-twitter fa-fw"></i>
									3 New Followers <span class="pull-right text-muted small"><em>12 minutes ago</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-envelope fa-fw"></i>
									Message Sent <span class="pull-right text-muted small"><em>27 minutes ago</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-tasks fa-fw"></i>
									New Task <span class="pull-right text-muted small"><em>43 minutes ago</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-upload fa-fw"></i>
									Server Rebooted <span class="pull-right text-muted small"><em>11:32 AM</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-bolt fa-fw"></i>
									Server Crashed! <span class="pull-right text-muted small"><em>11:13 AM</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-warning fa-fw"></i>
									Server Not Responding <span class="pull-right text-muted small"><em>10:57 AM</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-shopping-cart fa-fw"></i>
									New Order Placed <span class="pull-right text-muted small"><em>9:49 AM</em> </span>
								</a>
								<a href="#" class="list-group-item">
									<i class="fa fa-money fa-fw"></i>
									Payment Received <span class="pull-right text-muted small"><em>Yesterday</em> </span>
								</a>
							</div>
							<!-- /.list-group -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery Version 1.11.0 -->
	<script src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->

	<!-- Morris Charts JavaScript -->
	<script src="<c:url value="/resources/js/plugins/morris/raphael.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins/morris/morris.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins/morris/morris-data.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/resources/js/sb-admin-2.js"/>"></script>
</body>


</html>