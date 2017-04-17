<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
	<script>		
		if(${note} == -1){
			alert("Неправильный логин или пароль.")
			
		}				
	</script>
</head>
<body>
    <div class="login">
      <h1>Войти в личный кабинет</h1>
      <form action="${pageContext.servletContext.contextPath}/kladovshik/auth" method="post">
        <p><input type="text" name="login" value="" placeholder="Логин или Email" required pattern="[a-zA-Z0-9]+"></p>
        <p><input type="password" name="password" value="" placeholder="Пароль" required pattern="[a-zA-Z0-9]+"></p>  
        
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Запомнить меня
          </label>
        </p>
        <p class="submit">
        	<button type="submit" class="botton" >Войти</button>
        </p>
      </form>
    </div>
</body>
</html>
