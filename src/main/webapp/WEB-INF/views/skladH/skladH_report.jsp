<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Отчет расхода</title>
</head>
<body>
	<table class="tg">
    <tr>
		<th>Ид кладовщика</th>
		<th>Ид карточки</th>
		<th>Приход/расход</th>
	    <th>Исходное количество</th>
	    <th>Остаток</th>
	    <th>Дата операции</th>
	    <th>Поставщик</th>
	    <th>Название</th>
	    <th>Описание</th>
	    <th>Вид документа</th>
	    <th>ФИО заказчика</th>	    
    </tr>
    	<c:forEach items="${skladsH}" var="list">
    		<tr>

    			
			    <td>${id_klad}</td>
			    <td>${list.link}</td>
			    <c:if test="${list.operthiya == 'out'}">
			    	<td>Расход</td>
			    </c:if>
			    <c:if test="${list.operthiya == 'in'}">
			    	<td>Приход</td>
			    </c:if>
			    <td>${list.kol_vo_old}</td>
			    <td>${list.kol_vo}</td>
			    <td>${list.data_oper}</td>
			    <td>${list.postavhik}</td>
			    <td>${list.naim}</td>   
			    <td>${list.tab_nom_mol}</td>               
			    <td>${list.ttni}</td>
			    <td>${list.fio_zakazchika}</td>
			</tr>
		
	     </c:forEach> 
    </table>    
	
</body>
</html>