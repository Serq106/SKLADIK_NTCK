<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

<html>
<head>
    <title>Books Page</title>    
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/sklad/edit" method="post">
	<input type="text" name="naim" value="${findSklad.naim }"/>
	<input type="text" name="naim2" value="${findSklad.naim2 }"/>
	<input type="text" name="edin" value="${findSklad.edin }"/>
	<input type="text" name="kolvo" value="${findSklad.kolvo }"/>
	<input type="text" name="sklad_key" value="${findSklad.sklad_key }"/>
	<input type="text" name="isdel" value="${findSklad.isdel }"/>
	<input type="text" name="stelach" value="${findSklad.stelach }"/>
	<input type="text" name="yatheika" value="${findSklad.yatheika }"/>
	<input type="text" name="used" value="${findSklad.used }"/>
	<input type="text" name="karta" value="${findSklad.karta }"/>
	<input type="text" name="price" value="${findSklad.price }"/>
	<input type="text" name="in_bd" value="${findSklad.in_bd }"/>
	<input type="text" name="tolling" value="${findSklad.tolling }"/>
	<input type="text" name="testing" value="${findSklad.testing }"/>
	<input type="text" name="imports" value="${findSklad.imports }"/>
	<input type="text" name="close_kadr" value="${findSklad.close_kadr }"/>
	<input type="text" name="sap_kod" value="${findSklad.sap_kod }"/>
	<input type="text" name="bismt" value="${findSklad.bismt }"/>
	<input type="hidden" name="id" value="${findSklad.id }" />	
	<button type="submit">Add</button>
</form>

</body>
</html>