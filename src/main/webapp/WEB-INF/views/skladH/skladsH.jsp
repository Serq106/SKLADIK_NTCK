<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Карточка</title>
</head>
<body>
	<p><a href="/weew/">Back to main menu</a></p>
	
	<table class="tg">
        <tr>
        	<th width="80">ID</th>
            <th width="80">in out</th>
            <th width="120">количество</th>
            <th width="120">Дата операции</th>
            <th width="60">Поставщик</th>
            <th width="80">Дата документа</th>
            <th width="120">Название</th>
            <th width="120">Вид документа</th>
            <th width="60">ФИО заказчика</th>
            <th width="120">Еденица измерения</th>            
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${skladsH}" var="list">
            <tr>
                <td>${list.id}</a></td>
                <td>${list.operthiya}</td>
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
	
	<p><a href="/weew/skladH/skladH_in">Офирмить приход</a></p>
	<p><a href="/weew/skladH/skladH_out">Офирмить списание</a></p>
</body>
</html>