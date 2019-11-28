<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../util/scripts.jsp"%>
</head>
<body>
<%@ include file="../util/navbar.jsp"%>
	<div class="container-fluid">
		<form action="" method="POST">
			<div class="form-row">
				<div class="col-lg-12">
					<div class="form-group">
						<label for="latitud">Latitud</label> 
						<input id="latitud" name="latitud" type="text" value="${dto.latitud}" class="form-control">
					</div>
				</div>
				
				<div class="col-lg-12">
					<div class="form-group">
						<label for="longitud">Longitud</label> 
						<input id="longitud" name="longitud" type="text" value="${dto.longitud}" class="form-control">
					</div>
				</div>
				
				<div class="col-lg-12">
					<div class="form-group">
						<label for="time">Tiempo</label> 
						<input id="time" name="time" type="number" value="${dto.time}" class="form-control">
					</div>
				</div>
				

				<div class="col-lg-12">
					<div class="form-group">
						<label for="status">Estado</label> 
						<select
							id="status" name="status.id" class="form-control">
							<option value="" selected disabled>Estado</option>
							<c:forEach var="i" items="${statuss}">
								<option value="${i.id}"
									${dto.status.id == i.id?"selected":""}>${i.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="col-lg-12">
					<div class="form-group">
						<label for="callecarre">Calle</label><br/> 
						<input id="callecarre" name="callecarre" type="checkbox" value="1">
						<label>Seleccione este campo si el semaforo es de una calle de lo contrario sera tomado como semaforo de carrera</label>
					</div>
				</div>
				
				
				<div class="col-lg-12">
					<div class="form-group">
						<input type="submit" value="Guardar" class="btn btn-success float-left">
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>