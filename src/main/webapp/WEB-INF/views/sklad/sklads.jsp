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
		<script>
			function del(id){
				var path= "${pageContext.servletContext.contextPath}/sklad/remove/" + id; 
				alert(path);
				if (confirm("Вы действительно хотите удалить?")){
					document.location.replace(path);
				}		 
			}
			
		</script>
		<meta http-equiv="Content-Type" Content="text/html; charset=utf-8"> 
	  <title>Склад</title>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>	
	</head>
	<body>
	
		<div id="header">
			<div id='header_items'>
			    <div id="text-left">
			    	<img alt="" src="${pageContext.request.contextPath}/resources/img/ntck.png">	
			    </div>	    
			    <span>
			    	<a href="${pageContext.servletContext.contextPath}/sklad//sklad_kladovschik//${findUser}">Главная</a>
			    	<a>
			    		Second Link
			    	</a>
			    	<a>
			    		Third Link
			    	</a>
			    </span>			    
		    </div>
		</div>
		
		<div class="main-sklad">
			<div id='header_items'>
				<h1>Склад кладовщика</h1>	
				<span>
					<a href="/weew/sklad/sklad_create" class="botton" 
						style=" padding: 8px;text-decoration: none;">Создать карточку</a>
				</span>
			</div>
	
			<table class="tg">
			        <tr>
			            <th width="80">Ид</th>
			            <th width="120">Наименование</th>
			            <th width="120">Единица измерения</th>
			            <th width="120">Общее количество</th>
			            <th width="60">Признак б/y</th>
			            <th width="60">Средняя цена</th>
			            <c:if test="${role.equals('ADMINISTRATOR')}">
				            <th width="60">Edit</th>
				            <th width="60">Delete</th>
			            </c:if>
			        </tr>
			        <c:forEach items="${listKladovschikSklad}" var="list">
			            <tr>
			                <td><a href="${pageContext.servletContext.contextPath}/skladH/skladsH/${list.id}">${list.id}</a></td>
			                <td>${list.naim}</td>
			                <td>${list.edin}</td>
			                <td>${list.kolvo}</td>
			                <td>${list.used}</td>
			                <td>${list.price}</td> 		
							<c:if test="${role.equals('ADMINISTRATOR')}">
				                <td><a href="${pageContext.servletContext.contextPath}/sklad/cklad_edit/${list.id}">Edit</a></td>
				                <td><span class="submit"><button type="submit" class="botton" onclick="del(${list.id})">Delete</button></span></td> 						
							</c:if>
			             </tr>
			        </c:forEach>
			    </table>   				
				
		</div>
	</body>
</html>