<!--Cabecero -->
<header id="main-header" class="py-2 bg-info text-white">
    <div class="container">            
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-info bg-info">
                    <h1>
                        <i class="fas fa-store"></i> Punto de venta
                    </h1>
                    <div class="nav-item dropdown">
                        <a style="color: white" href="" class="nav-link dropdown-toggle" data-toggle="dropdown">Sesion</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item">${us.getCorreo()}</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Cerrar sesion</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>