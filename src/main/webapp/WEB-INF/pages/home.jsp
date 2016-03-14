<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<h1>Tableau de bord de Béatrice</h1>
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
							<div class="huge">${dashboard.globalLevel}%</div>
							<div>${dashboard.message}</div>
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left">Voir l'historique du mois</span>
						<span class="pull-right">
							<i class="fa fa-arrow-circle-right"></i>
						</span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-9">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-arrow-circle-down fa-fw"></i> Ajouter une dépense
				</div>
				<div class="panel-body">
					<form:form>
						<div class="row">
							<div class="col-lg-6">
								<label> Catégorie </label>
								<select class="form-control">
									<option>Repas</option>
								</select>
							</div>
							<div class="col-lg-6">
								<label> Montant </label>
								<div class="form-group input-group">
									<input class="form-control" type="text" />
									<span class="input-group-addon">
										<i class="fa fa-eur"></i>
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
					<i class="fa fa-bar-chart-o fa-fw"></i> Budget courant par catégorie
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
					<i class="fa fa-bell fa-fw"></i> Dernières dépenses
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="list-group">
						<a href="#" class="list-group-item">
							<i class="fa fa-comment fa-fw"></i> New Comment
							<span class="pull-right text-muted small">
								<em>4 minutes ago</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-twitter fa-fw"></i> 3 New Followers
							<span class="pull-right text-muted small">
								<em>12 minutes ago</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-envelope fa-fw"></i> Message Sent
							<span class="pull-right text-muted small">
								<em>27 minutes ago</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-tasks fa-fw"></i> New Task
							<span class="pull-right text-muted small">
								<em>43 minutes ago</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-upload fa-fw"></i> Server Rebooted
							<span class="pull-right text-muted small">
								<em>11:32 AM</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-bolt fa-fw"></i> Server Crashed!
							<span class="pull-right text-muted small">
								<em>11:13 AM</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-warning fa-fw"></i> Server Not Responding
							<span class="pull-right text-muted small">
								<em>10:57 AM</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-shopping-cart fa-fw"></i> New Order Placed
							<span class="pull-right text-muted small">
								<em>9:49 AM</em>
							</span>
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-money fa-fw"></i> Payment Received
							<span class="pull-right text-muted small">
								<em>Yesterday</em>
							</span>
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
</t:main>