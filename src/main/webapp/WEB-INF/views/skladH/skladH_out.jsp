<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<script>
	function out(kol_vo) {
		var x = document.forms[0].kol_vo.value;
		if (kol_vo < x) {
			alert("Недостаточно изделий");
			 document.getElementById('botton').disabled = true;
		}else{
			document.getElementById('botton').disabled = false;
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
			<span><h2>Оформление списания</h2></span>  
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
		<form action="${pageContext.servletContext.contextPath}/skladH/adds"
			method="get">
				<div id = "pos_centr" style="text-align: center;">
				<select name="id" id="select" style="margin-left: 70px;">
					<option name="id" value=0>Выберите нужное изделие </option>
					<c:forEach items="${skladHList}" var="list">	
						<c:if test="${(list.operthiya == 'in') && (list.kol_vo > 0)}">					
							<option name="id" value="${list.id}">${list.id}</option>
						</c:if>
					</c:forEach>
				</select>
			
				Количество <input type="text"  name="kol_vo" onkeyup="out(${count })"/>
				<p>Кому/Куда <input type="text"  name="fio_zakazchika" />
				Описание <input type="text"  name="tab_nom_mol" /></p>
				
				<button type="submit" id="botton" class="botton" value="sdf">Списать изделие</button>
				</div>
			
		</form>
		<p>Доступное количество для списания ${count }</p>
		<table class="tg">
			<tr>
				<th width="80">Ид</th>
				<th width="120">Количество</th>
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
	</div>
</body>
</html>