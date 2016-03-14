<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<h1>Préférences</h1>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-arrow-circle-down fa-fw"></i> Ajouter un budget
				</div>
				<div class="panel-body">
					<form:form method="post" action="settings/budget/add" commandName="budget">
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<form:label path="budgetLimit">Limite de budget : </form:label>
									<div class="form-group input-group">
										<form:input path="budgetLimit" class="form-control" placeholder="ex : 800 " />
										<span class="input-group-addon">
											<i class="fa fa-eur"></i>
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
					<i class="fa fa-table fa-fw"></i> Limites de budget par catégorie
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
</t:main>