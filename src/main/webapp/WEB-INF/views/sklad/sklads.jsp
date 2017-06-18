<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				$(function() {
					$("#naim").autocomplete({
						source : function(request, response) {
							$.ajax({
								url : "${pageContext.request.contextPath}/ControllerAutocompleteAJAX/doc-ajax-autocomplete-naimenovanie",
								type : "GET",
								data : {
									term : request.term
								},
								dataType : "json",
								success : function(data) {
									response(data);
								}
							});
						}
					});
				});
			});
		</script>
		
		<script>
			function del(id){
				var path= "${pageContext.servletContext.contextPath}/sklad/remove/" + id; 
				if (confirm("Вы действительно хотите удалить?")){
					document.location.replace(path);
				}		 
			}			
		</script>
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
			
			<c:if test="${view_edit == 1 }">
				<span><h2>Склад кладовщика</h2></span>
			</c:if>  
			<c:if test="${view_edit == 0 }">
				<span><h2>Просмотр складов кладовщиков</h2></span>
			</c:if>  
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
		<div id='header_items'>	
			<span> 
				<a href="${pageContext.servletContext.contextPath}/sklad/view_edit" class="botton">Просмотр складов</a>
				<a href="${pageContext.request.contextPath}/sklad/sklad_create" class="botton">Создать склад</a>
			</span>
		</div>
		<br></br>
		<form class="subform" action="${pageContext.servletContext.contextPath}/sklad/search/${id_klad}" method="get">
				<div class="form-center" style="border: 2px solid black;">
					
						<label for="naim" >Наименование</label>
						<input type="text" id="naim" name="naim" style="width: 200px;"/>				
						<button type="submit" id="botton" class="botton" >Поиск</button>

				</div>
		</form>	
		
		<br></br>

		<table class="tg">
			<tr>
				<th width="120">Ид</th>
				<th width="120">Наименование</th>
				<th width="120">Единица измерения</th>
				<th width="120">Общее количество</th>
				<th width="60">Признак б/y</th>
				<th width="60">Средняя цена</th>
				<c:if test="${role.equals('ADMINISTRATOR')}">
					<th width="60">Редактировать</th>
					<th width="60">Удалить</th>
				</c:if>
			</tr>
			<c:forEach items="${listKladovschikSklad}" var="list">
				<tr>
					<c:if test="${list.isdel != 1}">
						<td>${list.id_sklad}</td>
						<td><a
							href="${pageContext.servletContext.contextPath}/skladH/skladsH/${list.id_sklad}">${list.naim}</a></td>
						<td>${list.edin}</td>
						<td>${list.kolvo}</td>
						<td>${list.used}</td>
						<td>${list.price}</td>
						<c:if test="${role.equals('ADMINISTRATOR')}">
							<td><a
								href="${pageContext.servletContext.contextPath}/sklad/cklad_edit/${list.id_sklad}">Редактировать</a></td>
							<td><span><button type="submit" class="botton"
										onclick="del(${list.id_sklad})">Удалить</button></span></td>
						</c:if>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>