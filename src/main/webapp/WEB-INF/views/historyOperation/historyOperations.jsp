<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	  <title>История</title>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>	
	</head>
	<body>
		<div class="main-sklad">
			<table class="tg">
		        <tr>
		            <th width="80">Ид</th>
		            <th width="120">имя таблице</th>
		            <th width="120">ид_строки</th>
		            <th width="120">дата операции</th>
		            <th width="60">операция</th>
		            <th width="60">пользователь</th>
		            <th width="60">количество</th>
		        </tr>
		        <c:forEach items="${listHistory}" var="list">
		            <tr>
		                <td>${list.id_historyOperation}</td>
		                <td>${list.tableName}</td>
		                <td>${list.id_row}</td>
		                <td>${list.date}</td>
		                <td>${list.operation}</td>
		                <td>${list.kladovshik}</td>
		                <td>${list.kol_vo_old}</td>
		             </tr>
		        </c:forEach>
		    </table>		
		</div>
	</body>
</html>