<%-- 
    Document   : index
    Created on : 20/11/2022, 9:58:40 p. m.
    Author     : Juan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <script src="https://kit.fontawesome.com/def6500153.js" crossorigin="anonymous"></script>
                     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
                    <title>JSP Page</title>
                </head>
                <body>
             <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
              <div class="container-fluid">
                <a class="navbar-brand" href="#">Tienda</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                      <a class="nav-link active" aria-current="page" href="Controlador?accion=home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=Carrito"><i class ="fas fa-cart-plus">(<label style="color: orange">${contador}</label>)</i>Carrito De Compras</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link ">Categoria</a>
                    </li>
                  </ul>
                  <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Buscar</button>
                  </form>
                    <ul class= "navbar-nav">
                     <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${cl.getNombre()}
                      </a>
                      <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                      </ul>
                    </li>
                    </ul>
                </div>
              </div>
            </nav>
        
                    <div class="container mt-2">
                        <div class="row">
                            <c:forEach var ="p" items="${productos}">
                                <div class ="col-sm-4">
                                <div class="card">
                                    <div class = "card-header">
                                        <label>${p.getNombre()}</label>
                                    </div>
                                    <div class = "card-body">
                                        <i>${p.getPrecio()}</i>
                                        <img>
                                    </div>
                                    <div class = "card-footer text-center">
                                        <label>Descripcion Producto</label>
                                        <div> 
                                        <a href="Controlador?accion=Agregar&id=${p.getId()}" class="btn btn-outline-info">Agregar</a>
                                        <a href="Controlador?accion=Comprar&id=${p.getId()}"class="btn btn-danger">Comprar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>  
                            </c:forEach>           
                        </div>   
                    </div>
        
        
        
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
