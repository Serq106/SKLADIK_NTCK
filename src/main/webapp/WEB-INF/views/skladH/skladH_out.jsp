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
<script>
	function out(kol_vo) {
		var x = document.forms[0].kol_vo.value;
		if (kol_vo < x) {
			alert("Недостаточно изделий");
			 document.getElementById('submit').disabled = true;
		}else{
			document.getElementById('submit').disabled = false;
		}
	}
</script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Списание</title>
</head>
<body>
	<div id="header">
		<div id='header_items'>
			<div id="text-left">
				<img alt=""
					src="${pageContext.request.contextPath}/resources/img/ntck.png">
			</div>
			<span> <a
				href="${pageContext.servletContext.contextPath}/sklad/sklad_kladovschik/${id_klad}"
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
		${count }
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">количество</th>
				<th width="120">Название</th>
			</tr>
			<c:if test="${list.operthiya != 'out'}">
				<c:forEach items="${skladHList}" var="list">
					<c:if test="${list.operthiya != 'out' && list.kol_vo > 0}">
						<tr>
							<td>${list.id}</td>
							<td>${list.kol_vo}</td>
							<td>${list.naim}</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</table>

		<form action="${pageContext.servletContext.contextPath}/skladH/adds"
			method="get">
			
				<p>
					Количество <input type="text"  name="kol_vo" onkeyup="out(${count })"/>
				</p>
				
				<button type="submit" class="botton">Списать изделие</button>

			
		</form>
	</div>
</body>
</html>