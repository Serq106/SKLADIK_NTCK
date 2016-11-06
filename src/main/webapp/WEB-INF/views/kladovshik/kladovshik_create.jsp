<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

<html>
<head>    
</head>
<body>
<a href="/weew/book/books">Back to main menu</a>
<h1>Book List</h1>

<form action="${pageContext.servletContext.contextPath}/book/add" method="post">
	<input type="text" name="bookTitle" />
	<input type="text" name="bookAuthor" />
	<input type="text" name="price" />
	<input type="hidden" name="id" value="0" />	
	<button type="submit">Add</button>
</form>

</body>
</html>
