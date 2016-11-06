
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>BookData</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

</head>
<body>
<a href="/weew/">Back to main menu</a>
<h1>Кладовщик</h1>
			${listSkladKladovschik} 
<p>dfdf</p>
asd
${listSkladKladovschik}
<br />
	<c:forEach items="${listSkladKladovschik}" var="list">	
		
			
					${list.login} 		
					<br />	
			
		
	</c:forEach>

	

</body>
</html>