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
<%@ include file="../util/navbar.jsp"%>
	<div class="container-fluid">
		<form action="" method="POST">
			<div class="form-row">
				<div class="col-lg-12">
					<div class="form-group">
						<label for="nombre">Nombre</label> 
						<input id="nombre" name="nombre" type="text" value="${dto.nombre}" class="form-control">
					</div>
				</div>
				
				<div class="col-lg-12">
					<div class="form-group">
						<label for="email">Email</label> 
						<input id="email" name="email" type="email" value="${dto.email}" class="form-control">
					</div>
				</div>
				
				<div class="col-lg-12">
					<div class="form-group">
						<label for="contrasena">Contraseña</label> 
						<input id="contrasena" name="contrasena" type="password" value="${dto.contrasena}" class="form-control">
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