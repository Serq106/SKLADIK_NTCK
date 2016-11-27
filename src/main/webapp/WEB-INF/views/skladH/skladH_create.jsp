<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>    
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/skladH/add" method="post">
	
	<p><input type="hidden" name="id" value="0"/>	
	<input type="hidden" name="operthiya" value="in" />
	<p>количество <input type="text" name="kol_vo" /></p>
	<p>Дата операции<input type="text" name="data_oper" /></p>	
	<p><!-- номер документа--><input type="hidden" name="ttn" value="0"/></p>
	<p>поставщик <input type="text" name="postavhik"/></p>
	<p><!-- Дата создания заявки  --><input type="hidden" name="data_zayavki" value="0"/></p>
	<p>дата документа<input type="text" name="data_ttn"/></p>
	<p><!--код затрат--> <input type="hidden" name="kod_zatrat" value="0"/></p>
	<p>наименование <input type="text" name="naim"/></p>
	<p>Вид документа<input type="text" name="ttni"/></p>
	<p>ФИО заказчика <input type="text" name="fio_zakazchika"/></p>
	<p><!-- YES- операция удаления--><input type="hidden" name="isdel" value="0"/></p>
	<p><!-- признак удаление заявки--> <input type="hidden" name="is_del" value="0"/></p>
	<p><!-- Количество до проведения операции--> <input type="hidden" name="kol_vo_old" value="0"/></p>
	<p><!-- выданно/не выданно--> <input type="hidden" name="obrabotano" value="0"/></p>
	<p><!--Наименование из документа--><input type="hidden" name="naim_doc" value="0"/></p>
	<p><!--Признак передачи из 1с--> <input type="hidden" name="rep_in" value="0" /></p>
	<p><!--Табельный номер мат. ответсвенного--><input type=hidden name="tab_nom_mol" value="0"/></p>
	<p><!--ключ склада отправителя--> <input type="hidden" name="sklad_out_key" value="0"/></p>
	<p><!--ключ склада получателя--><input type="hidden" name="sklad_in_key" value="0"/></p>
	<p><!--статус--> <input type="hidden" name="rep_status" value="0"/></p>
	<p><!--импорт--> <input type="hidden" name="imports" value="0"/></p>
	<p><!--ид заявки--><input type="hidden" name="id_zayavka" value="0"/></p>
	<p><!--ид заявки--> <input type="hidden" name="id_ord" value="0"/></p>
	<p>альтернативная ед. измерения <input type="text" name="alt_edin"/></p>
	<p><!--пересчет на альт--><input type="hidden" name="alt_kol_vo" value="0"/></p>
	<p><!--статус--> <input type="hidden" name="rep_status" value="0"/></p>
	<p><!--real_data_oper--> <input type="hidden" name="real_data_oper" value="0"/></p>
	<p><!--link--><input type="hidden" name="link" value="0" /></p>
	<p><!--master--> <input type="hidden" name="master" value="0"/></p>		
		
	
	<button type="submit">Add</button>
</form> 

</body>
</html>
