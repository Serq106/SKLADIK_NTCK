<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

<html>
<head>    
</head>
<body>
<a href="/weew/book/books">Back to main menu</a>
<h1>Book List</h1>

<form action="${pageContext.servletContext.contextPath}/sklad/add" method="post">
	<input type="text" name="naim" />
	<input type="text" name="naim2" />
	<input type="text" name="edin" />
	<input type="text" name="kolvo" />
	<input type="text" name="sklad_key" />
	<input type="text" name="isdel" />
	<input type="text" name="stelach" />
	<input type="text" name="yatheika" />
	<input type="text" name="used" />
	<input type="text" name="karta" />
	<input type="text" name="price" />
	<input type="text" name="in_bd" />
	<input type="text" name="tolling" />
	<input type="text" name="testing" />
	<input type="text" name="imports" />
	<input type="text" name="close_kadr" />
	<input type="text" name="sap_kod" />
	<input type="text" name="bismt" />
	<input type="hidden" name="id" value="0" />	
	
	<select name="user_id">	
		<c:forEach items="${kladovshikList}" var="kladovshikListItem">
			<option value="${kladovshikListItem.id}">${kladovshikListItem.login}</option>
		</c:forEach>
	</select>
	<button type="submit">Add</button>
</form>

</body>
</html>
