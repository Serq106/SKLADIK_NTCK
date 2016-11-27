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
	<title>Списание</title>
</head>
<body>
	<table class="tg">
        <tr>
        	<th width="80">ID</th>
            <th width="120">количество</th>
            <th width="120">Название</th>         
        </tr>
        <c:forEach items="${skladHList}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.kol_vo}</td>
                <td>${list.naim}</td>
             </tr>
        </c:forEach>
    </table> 
    
    <form action="${pageContext.servletContext.contextPath}/skladH/adds" method="post">
    	<select name="id">	
		<c:forEach items="${skladHList}" var="list">
			<option value="${list.id}">${list.id}</option>
			<option value="${list.kol_vo}">${list.kol_vo}</option>
		</c:forEach>
		<p>Количество<input type="text" name="kol_vo" /></p>
		<button type="submit">Add</button>
	</select>
    </form> 
</body>
</html>