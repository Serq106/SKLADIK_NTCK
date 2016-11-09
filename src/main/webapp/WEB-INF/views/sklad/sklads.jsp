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
            <th width="120">имя</th>
            <th width="120">edin</th>
            <th width="120">kolvo</th>
            <th width="60">sklad_key</th>
            <th width="60">isdel</th>
            <th width="80">stelach</th>
            <th width="120">yatheika</th>
            <th width="120">used</th>
            <th width="120">price</th>
            <th width="60">in_bd</th>
            <th width="60">tolling</th>
            <th width="120">testing</th>
            <th width="120">imports</th>
            <th width="120">close_kadr</th>
            <th width="60">sap_kod</th>
            <th width="60">bismt</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listKladovschikSklad}" var="list">
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/sklad/sklad_data/${list.id}">${list.id}</a></td>
                <td>${list.naim}</td>
                <td>${list.edin}</td>
                <td>${list.kolvo}</td>
                <td>${list.sklad_key}</td>
                <td>${list.isdel}</td>
                <td>${list.stelach}</td>
                <td>${list.yatheika}</td>
                <td>${list.used}</td>
                <td>${list.price}</td>                
                <td>${list.in_bd}</td>
                <td>${list.tolling}</td>
                <td>${list.testing}</td>
                <td>${list.imports}</td>
                <td>${list.close_kadr}</td>
                <td>${list.sap_kod}</td>
                <td>${list.bismt}</td>
                <td><a href="${pageContext.servletContext.contextPath }/sklad/cklad_edit/${list.id}">Edit</a></td>
                <td><a href ="${pageContext.servletContext.contextPath}/sklad/remove/${list.id}">Delete</a></td> 
             </tr>
        </c:forEach>
    </table>    

    	<p>${kladovshik.login}</p>    

	<a href="/weew/sklad/sklad_create">create  |</a>
	

</body>
</html>