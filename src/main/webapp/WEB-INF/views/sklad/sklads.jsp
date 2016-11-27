<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Склад</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

</head>
<body>
<a href="/weew/">Back to main menu</a>
<h1>Склад кладовщика</h1>


<p></p>
<p></p>

<table class="tg">
        <tr>
            <th width="80">Ид</th>
            <th width="120">Наиминование</th>
            <th width="120">Еденица измерения</th>
            <th width="120">Общее количество</th>
            <th width="60">Признак б/y</th>
            <th width="60">Средняя цена</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
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
                <td><a href="${pageContext.servletContext.contextPath }/sklad/cklad_edit/${list.id}">Edit</a></td>
                <td><a href ="${pageContext.servletContext.contextPath}/sklad/remove/${list.id}">Delete</a></td> 
				
</c:if>
             </tr>
        </c:forEach>
    </table>    

    <!--<p>${kladovshik.login}</p>-->   

	<a href="/weew/sklad/sklad_create">create  |</a>
	

</body>
</html>