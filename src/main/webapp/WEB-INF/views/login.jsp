<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!DOCTYPE html>

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
            <a	href="${pageContext.servletContext.contextPath}/sklad/view" 
			class="botton">Просмотр</a>
          </label>
        </p>
        <p class="submit">
        	<button type="submit" class="botton" >Войти</button>
        </p>
      </form>
    </div>
</body>
</html>
