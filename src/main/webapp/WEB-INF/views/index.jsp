<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
  <title>Меню</title>
</head>
<body>
<h2>Главная </h2>
<br/>

<h2><a href="kladovshik/login" > Авторизация | </a>
<a href="historyOperation/historyOperations"> История| </a></h2>

"${findUser}"+++
<br/>
</body>
</html>