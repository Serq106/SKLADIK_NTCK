<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
<html>
<head>

</head>
<body>
<a href="/weew/">Back to main menu</a>

<br/>
<br/>

<h1>Book List</h1>
<h2>${kladovshik}</h2>

<form action="${pageContext.servletContext.contextPath}/sklad/sklads" method="post">
	<p><input type="text" name="login" value="Rasputin" }/></p>
	<p><input type="password" name="password" value="1234567" /></p>
	<p><button type="submit">signin</button></p>
</form>



</body>
</html>
