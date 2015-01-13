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
<title>Home</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Awt Client</a>
		</div>
		<div id="navbar" class="">
			<ul class="nav navbar-nav">
				<li class=""><a href="home">User's list</a></li>
				<li class="active"><a href="userTweet">User tweet</a></li>
				<li><a href="#allTweet">All tweet</a></li>
				<li><a href="#updtate">Updtate</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<br />
	<div class="container">
		<div class="page-header">
			<h3>List of all users</h3>
		</div>
		<form class="col-sm-12 col-md-12" method="post" action="UserTweet" enctype="multipart/form-data">
			<label class="col-sm-12 col-md-12 raw" for="username">Username <span class="requis">*</span></label>
            <input type="text" id="username" name="username" value="" size="20" maxlength="60" />
            <br />
			<input type="submit" value="Search" class="btn btn-lg btn-success raw" style="margin-top:20px;margin-bottom:5px;" />
		</form>
		<div class="container" style="margin-top:20px;">
		<%
		/* menu.BusinessLogic users = (menu.BusinessLogic) request.getAttribute("users");
		if(users != null) {
			String[] userslist = users.getMessage();
			for(int i = 0; i < userslist.length;++i) {
				out.println(

						"<ul>"+
							"<li>" +
						userslist[i] +
							"</li>"+
						"</ul>");
		} 
		
		}else {
			out.println("<p>Please, push on display button.</p>");
		}
		 */
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