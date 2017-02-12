<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>    
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
		<meta http-equiv="Content-Type" Content="text/html; charset=utf-8"> 
	</head>
	<body>
		<div id="header">
			<div id='header_items'>
			    <div id="text-left">
			    	<img alt="" src="${pageContext.request.contextPath}/resources/img/ntck.png">	
			    </div>	    
			    <span>
			    	<a href="${pageContext.servletContext.contextPath}/sklad//sklad_kladovschik//${findUser}">Главная</a>
			    	<a>
			    		Second Link
			    	</a>
			    	<a>
			    		Third Link
			    	</a>
			    </span>			    
		    </div>
		</div>
		<div class="main-sklad">		
			<form class="subform" action="${pageContext.servletContext.contextPath}/sklad/add" method="get">		
				<div class="form-center">
					<p>
						<label for="naim" class="label">Наименование</label>
						<input type="text" name="naim" />
					</p>			
					<p>
						<!--<label for="naim2" class="label">naim2</label>--> 
						<input type="hidden" name="naim2" value="0"/>
					</p>			
					<p>
						<label for="edin" class="label">Единица измерения </label>
						<input type="text" name="edin" />
					</p>			
					<p>
						<label for="kolvo" class="label">Общее количество</label>
						<input type="text" name="kolvo" />
					</p>			
					<p>
						<!--<label for="sklad_key" class="label">sklad_key</label>-->
						<input type="hidden" name="sklad_key" value="0"/>
					</p>			
					<p>
						<!--<label for="isdel" class="label">isdel</label>-->
						<input type="hidden" name="isdel" value="0"/>
					</p>			
					<p>
						<!--<label for="stelach" class="label">stelach</label>-->
						<input type="hidden" name="stelach" value="0"/>
					</p>
					<p>
						<!--<label for="yatheika" class="label">yatheika</label>-->
						<input type="hidden" name="yatheika" value="0"/>
					</p>
					<p>
						<label for="used" class="label">Признак б/y</label>
						<input type="text" name="used" />
					</p>			
					<p>
						<!--<label for="karta" class="label">Номер карточки учета</label>-->
						<input type="hidden" name="karta" value="0"/>
					</p>
					<p>
						<label for="price" class="label">Средняя цена</label>
						<input type="text" name="price" />
					</p>
					<p>
						<!--<label for="in_bd" class="label">Признак наличия наиминования в базах</label>-->
						<input type="hidden" name="in_bd" value="0"/>
					</p>			
					<p>
						<!--<label for="tolling" class="label">давальческое сырье</label>-->
						<input type="hidden" name="tolling" value="0"/>
					</p>
					<p>
						<!--<label for="testing" class="label">позиция на испытания</label>-->
						<input type="hidden" name="testing" value="0"/>
					</p>
					<p>
						<!--<label for="imports" class="label">импортная позия</label>-->
						<input type="hidden" name="imports" value="0"/>
					</p>			
					<p>
						<!--<label for="close_kadr" class="label">Карточка заблокирована 1; 0 разблокирования</label>-->
						<input type="hidden" name="close_kadr" value="0"/>
					</p>
					<p>
						<!--<label for="sap_kod" class="label">sap_kod</label>-->
						<input type="hidden" name="sap_kod" value="0"/>
					</p>
					<p>
						<!--<label for="bismt" class="label">bismt</label>-->
						<input type="hidden" name="bismt" value="0"/>
					</p>			
					<p>
						<input type="hidden" name="id" value="0" />
					</p>						
					<p>
							<label for="bismt" class="label">bismt</label>	
							<select id="select" name="user_id">	
								<c:forEach items="${kladovshikList}" var="kladovshikListItem">
									<option value="${kladovshikListItem.id}">${kladovshikListItem.login}</option>
								</c:forEach>
							</select>
					</p>
					<div class="button-create-center">
						<button type="submit" class="botton" >Создать карточку</button>
					</div>
				</div>
			</form>	
		</div>
	</body>
</html>
