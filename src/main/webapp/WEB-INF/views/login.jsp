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

<section class="container">
    <div class="login">
      <h1>Войти в личный кабинет</h1>
      <form action="${pageContext.servletContext.contextPath}/kladovshik/auth" method="post">
        <p><input type="text" name="login" value="" placeholder="Логин или Email"></p>
        <p><input type="password" name="password" value="" placeholder="Пароль"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Запомнить меня
          </label>
        </p>
        <p class="submit"><button type="submit">Войти</button></p>
      </form>
    </div>

    <!-- <div class="login-help">
      <a href="index.html">Забыли пароль?</a> Восстановите его!
    </div>-->
  </section>



</body>
</html>
