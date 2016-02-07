<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="utf-8">
	<title>
	</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Le styles -->
	<link href="/assets/css/bootstrap.css" rel="stylesheet"/>
	<link href="/assets/css/bootstrap-switch.css" rel="stylesheet"/>
	<style>
		body {
			padding-top: 60px;
			/* 60px to make the container go all the way
                 to the bottom of the topbar */
		}
	</style>
	<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
	</script>
	<![endif]-->
	<!-- Le fav and touch icons -->
	<link rel="shortcut icon" href="assets/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
	<style>
	</style>
</head>
<body>

<%@include file="header.jsp" %>
		<h1>Send test email</h1>
		<form method="post" action="sendEmail.html">
			<table border="0" width="80%">
				<tr>
					<td>To:</td>
					<td><input type="text" name="recipient" size="65" /></td>
				</tr> 
				<tr>
					<td>Subject:</td>
					<td><input type="text" name="subject" size="65" /></td>
				</tr> 
				<tr>
					<td>Message:</td>
					<td><textarea cols="50" rows="10" name="message"></textarea></td>
				</tr> 
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Send E-mail" />
					</td>
				</tr>
			</table>
		</form>
</body>
</html>