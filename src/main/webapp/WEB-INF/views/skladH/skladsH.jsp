<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<script>
			function del(id){
				var path= "${pageContext.servletContext.contextPath}/skladH/remove/" + id; 
				if (confirm("Вы действительно хотите удалить?")){
					document.location.replace(path);
				}		 
			}			
		</script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Карточка</title>
	</head>
	<body>	
		<div id="header">
			<div id='header_items'>
			    <div id="text-left">
			    	<img alt="" src="${pageContext.request.contextPath}/resources/img/ntck.png">	
			    </div>	
			    <span><h2>Карточка</h2></span>    
			    <span>
			    	<a href="${pageContext.servletContext.contextPath}/sklad/sklad_kladovschik/${id_klad}" class="botton">Главная</a>
			    		<c:if test="${role.equals('ADMINISTRATOR')}">
				           <a href="${pageContext.servletContext.contextPath}/historyOperation/historyOperation/${id}" class="botton" target="_blank" >История</a>
			            </c:if>
			    			<a href="${pageContext.servletContext.contextPath}/kladovshik/login" class="botton">Выход</a>
			    </span>			    
		    </div>
		</div>	

		<div class="main-sklad">
		<c:if test="${view_edit != 0}">
			<a href="${pageContext.servletContext.contextPath}/skladH/skladH_in" class="botton">Оформить приход</a>
			<a href="${pageContext.servletContext.contextPath}/skladH/skladH_out" class="botton">Оформить списание</a>
		</c:if>
		<a href="${pageContext.servletContext.contextPath}/skladH/skladH_report" target="_blank" class="botton">Отчет прихода</a>
		<br />
		<br />
		<span><h3>Карточка прихода</h3></span>
		<table class="tg">
	        <tr>
	        	<th width="80">Ид</th>
	            <th width="80">Приход</th>
	            <th width="60">Исходное количество</th>
	            <th width="60">Остаток</th>
	            <th width="120">Дата операции</th>
	            <th width="60">Поставщик</th>
	            <th width="80">Дата документа</th>
	            <th width="120">Название</th>
	            <th width="120">Вид документа</th>
	            <th width="60">ФИО заказчика</th>
	            <th width="60">Единица измерения</th>  
	            <c:if test="${role.equals('ADMINISTRATOR')}">
					<th width="60">Удалить</th>
				</c:if>
	        </tr>
	        <c:forEach items="${skladsH}" var="list">
	        	<c:if test="${list.operthiya == 'in'}">
		            <tr>
		                <td>${list.id}</td>
		                <td>Приход</td>
		                <td>${list.kol_vo_old}</td>
		                <td>${list.kol_vo}</td>
		                <td>${list.data_oper}</td>
		                <td>${list.postavhik}</td>
		                <td>${list.data_ttn}</td>
		                <td>${list.naim}</td>                
		                <td>${list.ttni}</td>
		                <td>${list.fio_zakazchika}</td>
		                <td>${list.alt_edin}</td>     
		                <c:if test="${role.equals('ADMINISTRATOR')}">
							<td><span><button type="submit" class="botton"
										onclick="del(${list.id})">Удалить</button></span></td>
						</c:if>           
		            </tr>
	            </c:if>
	        </c:forEach>
	    </table>  
		<br></br>
   		<span><h3>Карточка расхода</h3></span>
		<table class="tg">
		        <tr>
		        	<th>Ид</th>
		        	<th>Расход</th>
		            <th>Списанно</th>
		            <th>Дата операции</th>
		            <th>Название</th>
		            <th>Вид документа</th>
		            <th>ФИО заказчика</th>
		            <th>Описание</th>
					<th>Ид карточки</th>
		            <c:if test="${role.equals('ADMINISTRATOR')}">
						<th width="60">Удалить</th>
					</c:if>
		        </tr>
		        <c:forEach items="${skladsH}" var="list">
		        	<c:if test="${list.operthiya == 'out'}">
		        		<c:if test="${list.kol_vo != 0}">
				            <tr>
				                <td>${list.id}</td>
				                <td>Расход</td>
				                <td>${list.kol_vo}</td>
				                <td>${list.data_oper}</td>
				                <td>${list.naim}</td>                
				                <td>${list.ttni}</td>
				                <td>${list.fio_zakazchika}</td>
				                <td>${list.tab_nom_mol}</td>
				                <td>${list.link}</td>     
				                <c:if test="${role.equals('ADMINISTRATOR')}">
									<td><span><button type="submit" class="botton"
												onclick="del(${list.id})">Удалить</button></span></td>
								</c:if>           
				            </tr>
				        </c:if>
		            </c:if>
		        </c:forEach>
		    </table>      
		</div>
	</body>
</html>