<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
<%@ include file="../views/util/scripts.jsp"%>
</head>
<body>

	<div class="container-fluid">

			
			<div class="p-5 d-flex justify-content-center h-100">
			<div class="card border-primary">
				<div class="card-header">
					<h1 class="title">Iniciar Sesión</h1>
				</div>
				<div class="card-body">
					<form action="" method="post" class="needs-validation">
						<div class="form-row">
							<div class="col-md-12 form-group">
								<label for="username">Nombre</label> 
								<input type="text" id="username" name="username" class="form-control" />
							</div>
							<div class="col-md-12 form-group">
								<label for="password">Contraseña</label> 
								<input type="password" class="form-control"	id="password" name="password" />
							</div>	
							<button type="submit" class="btn btn-success btn-block">Log in</button>
						</div>
					</form>
				</div>
			</div>
			
</div>
		</div>

</body>
</html>
