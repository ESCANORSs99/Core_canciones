<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
</head>
<body>
    <h1>Lista de Canciones</h1>

    <c:forEach var="cancion" items="${listaCanciones}">
        <p>Título: ${cancion.titulo}</p>
        <p>Artista: ${cancion.artista}</p>
        <p><a href="canciones/detalle/${cancion.id}">Detalle</a></p>
        <hr>
    </c:forEach>
    <form action="/canciones/formulario/agregar" method="get">
        <button type="submit">Agregar Nueva Canción</button>
    </form>
</body>
</html>
