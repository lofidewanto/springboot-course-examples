<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Neuen Kunde anlegen</title>
</head>
<body>
	<form:form modelAttribute="userForm" method="post">
		<table>
			<tr>
				<td>Nutzername:</td>
				<td><form:input path="userName" /> <form:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Vorname:</td>
				<td><form:input path="firstName" /> <form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>Nachname:</td>
				<td><form:input path="lastName" /> <form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /> <form:errors path="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">${msg}</td>
			</tr>
		</table>
	</form:form>
	<p align="center">
		<a href="<c:url value="/helloWorld"/>">Home</a>
	</p>
</body>
</html>