<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

<html>
<head>
    <title>Books Page</title>    
</head>
<body>
<a href="/weew/book/books">Back to main menu</a>
<h1>Book List</h1>

<form action="${pageContext.servletContext.contextPath}/book/edit" method="post">
	<input type="text" name="bookTitle" value="${findBook.bookTitle }"/>
	<input type="text" name="bookAuthor" value="${findBook.bookAuthor }" />
	<input type="text" name="price" value="${findBook.price }"/>
	<input type="hidden" name="id" value="${findBook.id }" />	
	<button type="submit">edit</button>
</form>

</body>
</html>