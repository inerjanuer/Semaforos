<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../util/scripts.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<form action="" method="POST">
			<div class="form-row">
				<div class="col-lg-12">
					<div class="form-group">
						<label for="ref">Referencia</label> <input id="ref" name="ref"
							class="form-control">
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
						<label for="typeSensor">Tipo de Sensor</label> 
						<select
							id="typeSensor" name="typeSensor.id" class="form-control">
							<option value="" selected disabled>Tipo de sensor</option>
							<c:forEach var="i" items="${types}">
								<option value="${i.id}"
									${dto.typeSensor.id == i.id?"selected":""}>${i.name}</option>
							</c:forEach>
						</select>
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