<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
	    <title>Редактирование склада</title>    
	</head>
	<body>	
		<div id="header">
			<div id='header_items'>
			    <div id="text-left">
			    	<img alt="" src="${pageContext.request.contextPath}/resources/img/ntck.png">	
			    </div>
			    <span><h2>Редактирование склада</h2></span>  	    
			    <span>
			    	<a href="${pageContext.servletContext.contextPath}/sklad/sklad_kladovschik/${id_klad}" class="botton">Главная</a>
			    		<c:if test="${role.equals('ADMINISTRATOR')}">
				           <a href="${pageContext.servletContext.contextPath}/historyOperation/historyOperations" class="botton" >История</a>
			            </c:if>
			    		 <a href="${pageContext.servletContext.contextPath}/kladovshik/login" class="botton">Выход</a>
			    </span>			    
		    </div>
		</div>
		<div class="main-sklad">	
			<form class="subform" action="${pageContext.servletContext.contextPath}/sklad/edit" method="post">
				<div class="form-center">
					<p>
						<label for="naim" class="label">Наименование</label>
						<input type="text" name="naim" value="${findSklad.naim }"/>
					</p>
					<p>
						<label for="edin" class="label">Единица измерения</label>
						<input type="text" name="edin" value="${findSklad.edin }"/>
					</p>
					<p>
						<label for="used" class="label">Сап-код</label>
						 <input type="text" name="used" value="${findSklad.used }"/>
					</p>	
					<input type="hidden" name="id_sklad" value="${findSklad.id_sklad }" />	
					
					<div class="button-create-center">		
						<p>
							<button type="submit" class="botton">Редактировать</button>
						</p>
					</div>
				</div>
			</form>	
		</div>
	</body>
</html>