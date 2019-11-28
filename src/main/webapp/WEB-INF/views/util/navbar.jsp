<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Avocado</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Semaforos
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        	<a href="/traffic/create" class="dropdown-item">Crear semaforo</a>
          	<a class="dropdown-item" href="/traffic/create/green">crear ola</a>
        </div>
      </li>
      <li class="nav-item">
        <a href="/sensor/create" class="btn">Crear sensor</a>
      </li>
      <li class="nav-item">
        <a href="/user/create" class="btn">Crear Usuario</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
       <button type="submit" class="btn btn-block btn-primary"><em class="ni ni-user-run"></em><span>Cerrar Sesion</span></button>
				   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
  </div>
</nav>
