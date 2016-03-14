<!doctype html>
<%@tag description="Main Page template" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


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


<link href="<c:url value="/resources/vendor/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/vendor/css/plugins/timeline.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/vendor/css/sb-admin-2.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/vendor/css/plugins/morris.css"/>" rel="stylesheet">

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
		<t:nav></t:nav>
		
		<div id="page-wrapper">
			<jsp:doBody/>
		</div>

	</div>

	<!-- jQuery Version 1.11.0 -->
	<script src="<c:url value="/resources/vendor/js/jquery-1.11.0.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/vendor/js/bootstrap.min.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->

	<!-- Morris Charts JavaScript -->
	<script src="<c:url value="/resources/vendor/js/plugins/morris/raphael.min.js"/>"></script>
	<script src="<c:url value="/resources/vendor/js/plugins/morris/morris.min.js"/>"></script>
	<script src="<c:url value="/resources/vendor/js/plugins/morris/morris-data.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/resources/vendor/js/sb-admin-2.js"/>"></script>
</body>


</html>