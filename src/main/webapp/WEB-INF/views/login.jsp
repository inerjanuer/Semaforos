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
		<div class="row">

			<h1 class="title">Iniciar Sesión</h1>


			<form action="" method="post" class="needs-validation">

				<div class="form-row">
					<div class="col-md-12">
						<label for="username">Nombre</label> 
						<input type="text"
							id="username" name="username" class="form-control" />
					</div>

					<div>
						<label for="password">Contraseña</label> <input type="password"
							id="password" name="password" />
					</div>

					<button type="submit" class="btn">Log in</button>
				</div>


			</form>

		</div>
	</div>

</body>
</html>
