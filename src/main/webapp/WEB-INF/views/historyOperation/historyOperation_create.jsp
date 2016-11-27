<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

<html>
<head>    
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/historyOperation/add" method="post">
	<input type="text" name="tableName" />имя
	<input type="text" name="id_row" />ид
	<input type="text" name="date" />дата
	<input type="text" name="operation" />оп
	<input type="hidden" name="id" value="0" />	
	<button type="submit">Add</button>
</form>

</body>
</html>
