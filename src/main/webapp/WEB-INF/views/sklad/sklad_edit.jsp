<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
	    <title>Books Page</title>    
	</head>
	<body>	
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
						<label for="kolvo" class="label">Общее количество</label>
						<input type="text" name="kolvo" value="${findSklad.kolvo }"/>
					</p>
				
					<p>
						<label for="used" class="label">Признак б/y</label>
						 <input type="text" name="used" value="${findSklad.used }"/>
					</p>	
					<p>
						<label for="price" class="label">Средняя цена</label>
						<input type="text" name="price" value="${findSklad.price }"/>
					</p>
					<input type="hidden" name="id" value="${findSklad.id }" />	
					
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