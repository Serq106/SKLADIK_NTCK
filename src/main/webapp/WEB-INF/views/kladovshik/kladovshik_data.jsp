<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!DOCTYPE html>

<html>
	<head>
	    <title>Кладовщик</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
	</head>
	<body>
		<a href="${pageContext.request.contextPath}/">Back to main menu</a>
		<h1>Кладовщик</h1>
			<p>${kladovshik }</p>>
			<a href="${pageContext.request.contextPath}/sklad/sklad_kladovschik/${kladovshik.id }"> sklad_kladovschik </a>	
	</body>
</html>