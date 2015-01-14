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
				<li class=""><a href="home">User's list</a></li>
				<li><a href="userTweet">User tweet</a></li>
				<li class="active"><a href="listalltweet">All tweets</a></li>
				<li><a href="update">Updtate</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<br />
	<div class="container">
		<div class="page-header">
			<h3>Retrieve all users with their tweets</h3>
		</div>
		<form class="col-sm-12 col-md-12" method="post" action="ListAllTweet">
			<br /> <input type="submit" value="Retrieve"
				class="btn btn-lg btn-success raw"
				style="margin-top: 20px; margin-bottom: 5px;" />
		</form>
		<div class="container" style="margin-top: 150px;">
			<%@page import="java.util.Set" import="java.util.Iterator"
				import="java.util.Map"%>
			<%
				menu.BusinessLogic informations = (menu.BusinessLogic) request
						.getAttribute("informations");

				if (informations != null) {
					Set set = informations.getDonnees().entrySet();
					Iterator i = set.iterator();
					while (i.hasNext()) {
						Map.Entry me = (Map.Entry) i.next();
						String user = me.getKey().toString();
						String tweet = me.getValue().toString();
						tweet = tweet.substring(1,tweet.length()-2);
						String[] mesTweets = tweet.split(",");
						out.println(

						"<ul>" + "<li>" + me.getKey() + "<ul><li>" + me.getValue()
								+ "</li></ul></li>" + "</ul>");
					}
					/* String user = me.getKey().toString();
					String tweet = me.getValue().toString();
					tweet = tweet.substring(1,tweet.length()-2);
					String[] mesTweets = tweet.split(",");
					out.println("<ul>" + "<li>" + me.getKey()+"</li><ul>");
						for(int j=0; j < mesTweets.length;j++){
							out.println("<li>"+mesTweets[j]+"</li>");
					}
						out.println("</ul>"); */

					/* for (String informations : informations.getDonnees()) {
						out.println(

						"<ul>" + "<li>" + informations + "</li>" + "</ul>");
					} */
				} else {
					out.println("<p>Please, push on display button.</p>");
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