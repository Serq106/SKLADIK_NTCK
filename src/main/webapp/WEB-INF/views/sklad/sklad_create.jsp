<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>    
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/sklad/add" method="post">

	<p>Наименование <input type="text" name="naim" /></p>
	<p><!--naim2  --> <input type="hidden" name="naim2" value="0"/></p>
	<p>Единица измерения <input type="text" name="edin" /></p>
	
	<p>Общее количество<input type="text" name="kolvo" /></p>
	<p><!--sklad_key --><input type="hidden" name="sklad_key" value="0"/></p>
	<p><!--isdel --><input type="hidden" name="isdel" value="0"/></p>
	
	<p><!--stelach --><input type="hidden" name="stelach" value="0"/></p>
	<p><!--yatheika --><input type="hidden" name="yatheika" value="0"/></p>
	<p>Признак б/y <input type="text" name="used" /></p>
	
	<p><!-- Номер карточки учета  --><input type="hidden" name="karta" value="0"/></p>
	<p>Средняя цена <input type="text" name="price" /></p>
	<p><!-- Признак наличия наиминования в базах --><input type="hidden" name="in_bd" value="0"/></p>
	
	<p><!--давальческое сырье --><input type="hidden" name="tolling" value="0"/></p>
	<p><!--позиция на испытания --><input type="hidden" name="testing" value="0"/></p>
	<p><!--импортная позия--> <input type="hidden" name="imports" value="0"/></p>
	
	<p><!--Карточка заблокирована 1; 0 разблокирования--><input type="hidden" name="close_kadr" value="0"/>
	<p><!--sap_kod --><input type="hidden" name="sap_kod" value="0"/>
	<p><!--bismt--><input type="hidden" name="bismt" value="0"/></p>
	
	<p><input type="hidden" name="id" value="0" />	
	
	<select name="user_id">	
		<c:forEach items="${kladovshikList}" var="kladovshikListItem">
			<option value="${kladovshikListItem.id}">${kladovshikListItem.login}</option>
		</c:forEach>
	</select>
	
	<button type="submit">Add</button>
</form>

</body>
</html>
