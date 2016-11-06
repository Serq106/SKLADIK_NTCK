<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>

<html>
<head>
  <title>BookData</title>

</head>
<body>
<a href="/weew/book/books">Back to main menu</a>
<h1>Book Details</h1>

<p>eee</p> 
<table class="tg">
  <tr>
    <th width="80">ID</th>
    <th width="120">Title</th>
    <th width="120">Author</th>
    <th width="120">Price</th>
  </tr>
  <tr>
    <td>${findBook.id}</td>
    <td>${findBook.bookTitle}</td>
    <td>${findBook.bookAuthor}</td>
    <td>${findBook.price/100}${findBook.price%100}</td>
  </tr>
</table>
</body>
</html>