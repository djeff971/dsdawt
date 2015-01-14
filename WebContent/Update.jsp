<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.css" />
<link type="text/css" rel="stylesheet"
	href="css/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<style>.navbar-fixed-top, .navbar-fixed-bottom {position:inherit;}</style>
<title>Home</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">Awt Client</a>
		</div>
		<div id="navbar" class="">
			<ul class="nav navbar-nav">
				<li><a href="home">User's list</a></li>
				<li class=""><a href="userTweet">User tweet</a></li>
				<li><a href="listalltweet">All tweets</a></li>
				<li class="active"><a href="update">Update</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<br />
	<div class="container">
		<div class="page-header">
			<h3>Update database with default values</h3>
		</div>
		<form method="post" action="update">
			<input type="submit" value="Update" class="btn btn-lg btn-success" />
		</form>
		<div class="container" style="margin-top: 20px;">
			<%
				menu.BusinessLogic message = (menu.BusinessLogic) request
						.getAttribute("message");
				if (message.getValue() == 1) {
					out.println("<p>The database has been updated.</p>");
				}
			%>
		</div>
	</div>

	<footer class="footer">
	<div class="container">
		<p class="text-muted">Group : Doriane - Sarah - Djeffrey</p>
	</div>
	</footer>



</body>
</html>