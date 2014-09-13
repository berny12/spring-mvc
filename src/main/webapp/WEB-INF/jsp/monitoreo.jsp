<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monitoreo</title>
<link href="<c:url value='/css/smoothness/jquery-ui-1.8.18.custom.css' />" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.timers.js"></script>
<script language="javascript">

	var secondsToRefresh=<c:out value='${tiempo}'/>;
	var procesoTerminado=false;

	//Inicia el monitoreo en cuanto el documento esta listo.
	$(document).ready(function() {
		$(this).everyTime(1000, revisaMonitoreo);
	});

	/**
	 * Hace la peticion .
	 */
	function revisaMonitoreo() {
		if (secondsToRefresh <= 0) {
			secondsToRefresh = <c:out value='${tiempo}'/> ;
			waitToRefresh();
		} else {
			$("#secondsToRefresh").html(
					'<b>' + secondsToRefresh + '</b> Segs.');
			secondsToRefresh--;
		}
	}
	
	/**
	 *Actualiza el segundero en la pantalla y al llegar a 0 solicita la peticion al server.
	 */
	function waitToRefresh(){
		updateView("resources/getMonitoreo");
	 	revisaTerminoProceso();
	}
	
	
	
	function updateView(url) {
		$.getJSON(url, function(data){
			//itera sobre la lista de posibles errores
			$('#total').html(data.total);
			$('#procesados').html(data.procesadas);
			$('#porProcesar').html(data.porProcesar);
			var porcentaje = (data.procesadas/data.total)*100;
			var porcentajeInt = Math.round(porcentaje);
			$('#progressbar').progressbar({
				value: porcentajeInt
			});		
			$("#porcentajeAvance").html('<b>'+porcentaje.toFixed(2)+'<b/>%');
			var arreglo = $.makeArray(data.errores);
			$('#tablaErrores tr:not(:first)').remove();
			$.each(arreglo,function(index,element){
				var row;
				row = 
	       	 	'	<tr><td><div align="right">'+element.idCausaError+'</div></td>'+
	        	'   <td><div align="center">'+element.error+'</div></td></tr>';
	        	
	        	$('#tablaErrores tr:last').after(row);
			});//for
			if ( (data.total - data.procesadas) ==0 ) {
				procesoTerminado=true;
			}
	});
	}	
	
	
	function revisaTerminoProceso() {
		if(procesoTerminado){
			$(document).stopTime();
			$("#estatusProceso").html("CONCLUIDO");
			alert("El proceso ha concluido");
		}
	}
	
</script>
</head>
<body>
	<table>
		<tr>
			<td colspan="2">Monitoreando el proceso</td>
		</tr>
		<tr>
			<td colspan="2"><table width="400" border="0">
					<tr>
						<td width="208"><div align="right">Estatus del proceso</div></td>
						<td width="282"><div align="center" id="estatusProceso">EN
								EJECUCI&Oacute;N</div></td>
					</tr>
					<tr>
						<td><div align="right">Actualizando pantalla en</div></td>
						<td><div align="center" id="secondsToRefresh"></div></td>
					</tr>
					<tr>
						<td><div align="right">Total de procesos</div></td>
						<td><div align="center" id="total"></div></td>
					</tr>

					<tr>
						<td><div align="right">Procesados</div></td>
						<td><div align="center" id="procesados"></div></td>
					</tr>

					<tr>
						<td><div align="right">Por Procesar</div></td>
						<td><div align="center" id="porProcesar"></div></td>
					</tr>
				</table></td>

		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td width="400"><div id="progressbar"></div></td>
			<td width="50"	id="porcentajeAvance"></td>
		</tr>

		<tr>
			<td colspan="2">Erorres registrados</td>
		</tr>

		<tr>
			<td colspan="2"><div align="center">
					<table width="300" border="0" id="tablaErrores">

						<tr class="titulo_celda">
							<td width="150"><div align="center">Identificador</div></td>
							<td width="150"><div align="center">Error</div></td>
						</tr>
					</table>
				</div></td>
		</tr>
		</tr>
	</table>
</body>
</html>