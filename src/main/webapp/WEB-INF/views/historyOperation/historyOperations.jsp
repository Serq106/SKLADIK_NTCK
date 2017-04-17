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
		            <th width="120">имя</th>
		            <th width="120">edin</th>
		            <th width="120">kolvo</th>
		            <th width="60">sklad_key</th>
		            <th width="60">user_id</th>
		        </tr>
		        <c:forEach items="${listHistory}" var="list">
		            <tr>
		                <td>${list.id_historyOperation}</td>
		                <td>${list.tableName}</td>
		                <td>${list.id_row}</td>
		                <td>${list.date}</td>
		                <td>${list.operation}</td>
		                <td>${list.kladovshik}</td>
		             </tr>
		        </c:forEach>
		    </table>		
		</div>
	</body>
</html>