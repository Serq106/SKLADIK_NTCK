<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Карточка</title>
	</head>
	<body>	
		<div id="header">
			<div id='header_items'>
			    <div id="text-left">
			    	<img alt="" src="${pageContext.request.contextPath}/resources/img/ntck.png">	
			    </div>	    
			    <span>
			    	<a href="${pageContext.servletContext.contextPath}/sklad/sklad_kladovschik/${id_klad}" class="botton">Главная</a>
			    		<c:if test="${role.equals('ADMINISTRATOR')}">
				           <a href="${pageContext.servletContext.contextPath}/historyOperation/historyOperations" class="botton" >История</a>
			            </c:if>
			    			<a href="${pageContext.servletContext.contextPath}/kladovshik/login" class="botton">Выход</a>
			    </span>			    
		    </div>
		</div>	
		
		<div class="main-sklad">
		<a href="/weew/skladH/skladH_in" class="botton">Оформить приход</a>
		<a href="/weew/skladH/skladH_out" class="botton">Оформить списание</a>
		<a href="/weew/sklad/pdf" class="botton">Отчет прихода</a>
		<br />
		<br />
		<table class="tg">
		        <tr>
		        	<th width="80">ID</th>
		            <th width="80">in out</th>
		            <th width="120">Исходное количество</th>
		            <th width="120">остаток</th>
		            <th width="120">Дата операции</th>
		            <th width="60">Поставщик</th>
		            <th width="80">Дата документа</th>
		            <th width="120">Название</th>
		            <th width="120">Вид документа</th>
		            <th width="60">ФИО заказчика</th>
		            <th width="120">Единица измерения</th>  
		        </tr>
		        <c:forEach items="${skladsH}" var="list">
		            <tr>
		                <td>${list.id}</a></td>
		                <td>${list.operthiya}</td>
		                <td>${list.kol_vo_old}</td>
		                <td>${list.kol_vo}</td>
		                <td>${list.data_oper}</td>
		                <td>${list.postavhik}</td>
		                <td>${list.data_ttn}</td>
		                <td>${list.naim}</td>                
		                <td>${list.ttni}</td>
		                <td>${list.fio_zakazchika}</td>
		                <td>${list.alt_edin}</td>                
		             </tr>
		        </c:forEach>
		    </table>  
		</div>
	</body>
</html>