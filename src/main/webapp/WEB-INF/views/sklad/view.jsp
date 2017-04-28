<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<meta http-equiv="Content-Type" Content="text/html; charset=utf-8">
<title>Склад</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css" />
</head>
<body>
	<div id="header">
		<div id='header_items'>
			<div id="text-left">
				<img alt=""
					src="${pageContext.request.contextPath}/resources/img/ntck.png">
			</div>
			<span> <a
				href="${pageContext.servletContext.contextPath}/sklad/view"
				class="botton">Главная</a> <c:if
					test="${role.equals('ADMINISTRATOR')}">
					<a
						href="${pageContext.servletContext.contextPath}/historyOperation/historyOperations"
						class="botton">История</a>
				</c:if> <a
				href="${pageContext.servletContext.contextPath}/kladovshik/login"
				class="botton">Выход</a>
			</span>
		</div>
	</div>

	<div class="main-sklad">
		<div id='header_items'>
			<h1>Склад кладовщика</h1>
			
		</div>

		<table class="tg">
			<tr>
				<th width="120">Ид</th>
				<th width="120">Наименование</th>
				<th width="120">Единица измерения</th>
				<th width="120">Общее количество</th>
				<th width="60">Признак б/y</th>
				<th width="60">Средняя цена</th>
				
			</tr>
			<c:forEach items="${listSklads}" var="list">
				<tr>
					<td>${list.id_sklad}</td>
					<td><a
						href="${pageContext.servletContext.contextPath}/skladH/skladsH_view/${list.id_sklad}">${list.naim}</a></td>
					<td>${list.edin}</td>
					<td>${list.kolvo}</td>
					<td>${list.used}</td>
					<td>${list.price}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>