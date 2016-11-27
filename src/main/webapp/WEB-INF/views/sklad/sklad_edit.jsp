<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

<html>
<head>
    <title>Books Page</title>    
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/sklad/edit" method="post">
	<p>Наименование <input type="text" name="naim" value="${findSklad.naim }"/></p>
	<p>Единица измерения <input type="text" name="edin" value="${findSklad.edin }"/></p>	
	<p>Общее количество<input type="text" name="kolvo" value="${findSklad.kolvo }"/></p>

	<p>Признак б/y <input type="text" name="used" value="${findSklad.used }"/></p>	
	<p>Средняя цена <input type="text" name="price" value="${findSklad.price }"/></p>

	<p><input type="hidden" name="id" value="${findSklad.id }" />	
	

	<button type="submit">Редактировать</button>
</form>

</body>
</html>