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
	<div align="center">
		<form:form action="register" method="post" commandName="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Register new user</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstname" /></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastname" /></td>
				</tr>
				<tr>
					<td>Company:</td>
					<td><form:input path="company" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="emailAddress" /></td>
				</tr>
				<tr>
					<td>Birthday (mm/dd/yyyy):</td>
					<td><form:input path="dateOfBirth" /></td>
				<tr>
				<td>Profession:</td>
				<td><form:select path="profession" items="${professionList}" /></td>
				</tr>
				<tr>
				<td>Public key:</td>
				<td><form:textarea path="publicKey" /></textarea></td>
				</tr>
				</tr>
				<tr>
				<td>Generate public and private key:</td>
				<td><form:checkbox path="generate_publicKey" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>