<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
<html>
<head>

</head>
<body>
<a href="/weew/">Back to main menu</a>

<br/>
<br/>

<h1>Book List</h1>
	
	<p> ddd ddd ${kladovshik}</p>
<c:if test="${!empty listBooks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td><a href="${pageContext.servletContext.contextPath}/book/bookdata/${book.id}">${book.bookTitle}</a></td>
                <td>${book.bookAuthor}</td>
                <td>${book.price/100}${book.price%100}</td>
                <td><a href="${pageContext.servletContext.contextPath }/book/book_edit/${book.id}">Edit</a></td>
                <td><a href ="${pageContext.servletContext.contextPath}/book/remove/${book.id}">Delete</a></td>
             </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
