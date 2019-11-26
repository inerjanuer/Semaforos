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
						<label >crear ola verde</label><br/> 
						<input name="id" type="radio" value="1"><br/>
						<label >crear ola roja</label><br/>
						<input name="id" type="radio" value="0">
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