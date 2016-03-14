<%@tag description="Nav template" pageEncoding="UTF-8"%>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="">Budgetizer</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li><a href="">
				<i class="fa fa-sign-out fa-fw"></i> Déconnexion
			</a></li>
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li><a class="${requestScope['javax.servlet.forward.servlet_path'] eq '/' ? ' active' : ''}" 
						href="${pageContext.request.contextPath}">
						<i class="fa fa-dashboard fa-fw"></i> Dashboard
					</a></li>
				<li><a class="${requestScope['javax.servlet.forward.servlet_path'] eq '/history' ? ' active' : ''}"
						href="${pageContext.request.contextPath}/history">
						<i class="fa fa-table fa-fw"></i> Historique
					</a></li>
				<li><a class="${requestScope['javax.servlet.forward.servlet_path'] eq '/settings' ? ' active' : ''}" 
						href="${pageContext.request.contextPath}/settings">
						<i class="fa fa-wrench fa-fw"></i> Préférences de budget 
					</a></li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
