<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
	  <title>BookData</title>	
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
	</head>
	<body>
		<div class="main-sklad">
			<table class="tg">
		        <tr>
		            <th width="80">Ид</th>
		            <th width="120">имя</th>
		            <th width="120">edin</th>
		            <th width="120">kolvo</th>
		            <th width="60">sklad_key</th>
		            <th width="60">isdel</th>
		            <th width="80">stelach</th>
		            <th width="120">yatheika</th>
		            <th width="120">used</th>
		            <th width="120">price</th>
		            <th width="60">in_bd</th>
		            <th width="60">tolling</th>
		            <th width="120">testing</th>
		            <th width="120">imports</th>
		            <th width="120">close_kadr</th>
		            <th width="60">sap_kod</th>
		            <th width="60">bismt</th>
		        </tr>
		        <tr>
		            <td>${sklads.id}</td>
		            <td>${sklads.naim}</td>
		            <td>${sklads.edin}</td>
		            <td>${sklads.kolvo}</td>
		            <td>${sklads.sklad_key}</td>
		            <td>${sklads.isdel}</td>
		            <td>${sklads.stelach}</td>
		            <td>${sklads.yatheika}</td>
		            <td>${sklads.used}</td>
		            <td>${sklads.price}</td>                
		            <td>${sklads.in_bd}</td>
		            <td>${sklads.tolling}</td>
		            <td>${sklads.testing}</td>
		            <td>${sklads.imports}</td>
		            <td>${sklads.close_kadr}</td>
		            <td>${sklads.sap_kod}</td>
		            <td>${sklads.bismt}</td>
		         </tr>
		    </table>  
	    </div>
	</body>
</html>