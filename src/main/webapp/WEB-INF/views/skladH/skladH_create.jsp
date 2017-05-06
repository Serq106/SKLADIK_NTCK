<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css" />
</head>
<body>
	<div id="header">
		<div id='header_items'>
			<div id="text-left">
				<img alt=""
					src="${pageContext.request.contextPath}/resources/img/ntck.png">
			</div>
			<span><h2>Оформление прихода</h2></span>  
			<span> <a
				href="${pageContext.servletContext.contextPath}/sklad/sklad_kladovschik/${id_klad}"
				class="botton">Главная</a> <c:if
					test="${role.equals('ADMINISTRATOR')}">
					<a
						href="${pageContext.servletContext.contextPath}/historyOperation/historyOperations"
						class="botton">История</a>
				</c:if> <a
				href="${pageContext.servletContext.contextPath}/kladovshik/login"
				class="botton">Выход</a>
			</span>
		</div>
	</div>
	<div class="main-sklad">
		<form class="subform"
			action="${pageContext.servletContext.contextPath}/skladH/add"
			method="post">
			<div class="form-center">
				<input type="hidden" name="id" value="0" /> <input type="hidden"
					name="operthiya" value="in" />

				<p>
					<login for="kol_vo" class="label">Количество</login>
					<input type="text" name="kol_vo" />
				</p>
				<p>
					<login for="data_oper" class="label">Дата операции</login>
					<input type="date" name="data_oper" />
				</p>
				<p>
					<!-- <login for="ttn" class="label">номер документа</login>-->
					<input type="hidden" name="ttn" value="0" />
				</p>
				<login for="postavhik" class="label">Поставщик</login>
				<input type="text" name="postavhik" />
				</p>
				<p>
					<!-- <login for="data_zayavki" class="label">Дата создания заявки</label>  -->
					<input type="hidden" name="data_zayavki" value="0" />
				</p>
				<p>
					<login for="data_ttn" class="label">Дата документа</login>
					<input type="date" name="data_ttn" />
				</p>
				<p>
					<!--<login for="kod_zatrat" class="label">код затрат</label>-->
					<input type="hidden" name="kod_zatrat" value="0" />
				</p>
				<!-- p>
					<login for="naim" class="label">наименование</login>
					 <input type="text" name="naim" value="${qwe}"/>
				</p-->
				<p>
					<login for="ttni" class="label">Вид документа</login>
					<input type="text" name="ttni" />
				</p>
				<p>
					<login for="fio_zakazchika" class="label">ФИО заказчика</login>
					<input type="text" name="fio_zakazchika" />
				</p>
				<p>
					<!--<login for="isdel" class="label">YES- операция удаления</login>-->
					<input type="hidden" name="isdel" value="0" />
				</p>
				<p>
					<!--<login for="is_del" class="label">признак удаление заявки</label>-->
					<input type="hidden" name="is_del" value="0" />
				</p>
				<p>
					<!--<login for="kol_vo_old" class="label">Количество до проведения операции</label>-->
					<input type="hidden" name="kol_vo_old" value="0" />
				</p>
				<p>
					<!--<login for="obrabotano" class="label">выданно/не выданно</label>-->
					<input type="hidden" name="obrabotano" value="0" />
				</p>
				<p>
					<!--<login for="naim_doc" class="label">Наименование из документа</label>-->
					<input type="hidden" name="naim_doc" value="0" />
				</p>
				<p>
					<!--<login for="rep_in" class="label">Признак передачи из 1с</label>-->
					<input type="hidden" name="rep_in" value="0" />
				</p>
				<p>
					<!--<login for="tab_nom_mol" class="label">Табельный номер мат. ответсвенного</label>-->
					<input type=hidden name="tab_nom_mol" value="0" />
				</p>
				<p>
					<!--<login for="sklad_out_key" class="label">ключ склада отправителя</label>-->
					<input type="hidden" name="sklad_out_key" value="0" />
				</p>
				<p>
					<!--<login for="sklad_in_key" class="label">ключ склада получателя</label>-->
					<input type="hidden" name="sklad_in_key" value="0" />
				</p>
				<p>
					<!--<login for="rep_status" class="label">статус</label>-->
					<input type="hidden" name="rep_status" value="0" />
				</p>
				<p>
					<!--<login for="imports" class="label">импорт</login>-->
					<input type="hidden" name="imports" value="0" />
				</p>
				<p>
					<!--<login for="id_zayavka" class="label">ид заявки</label>-->
					<input type="hidden" name="id_zayavka" value="0" />
				</p>
				<p>
					<!--<login for="id_ord" class="label">ид заявки</label>-->
					<input type="hidden" name="id_ord" value="0" />
				</p>
				<p>
					<login for="alt_edin" class="label">Альтернативная ед.
					измерения</login>
					<input type="text" name="alt_edin" />
				</p>
				<p>
					<!--<login for="alt_kol_vo" class="label">пересчет на альт</label>-->
					<input type="hidden" name="alt_kol_vo" value="0" />
				</p>
				<p>
					<!--<login for="rep_status" class="label">статус</lavel>-->
					<input type="hidden" name="rep_status" value="0" />
				</p>
				<p>
					<!--<login for="real_data_oper" class="label">real_data_oper</label>-->
					<input type="hidden" name="real_data_oper" value="0" />
				</p>
				<p>
					<!--<login for="link" class="label">link</label>-->
					<input type="hidden" name="link" value="0" />
				</p>
				<p>
					<!--<login for="master" class="label">master</label>-->
					<input type="hidden" name="master" value="0" />
				</p>
				<div class="button-create-center">
					<button type="submit" class="botton">Добавить</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
