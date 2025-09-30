<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Detalle Canción</title>
</head>
<body>
    <h1>Detalle Canción</h1>

    <p><strong>Título:</strong> ${cancion.titulo}</p>
    <p><strong>Artista:</strong> ${cancion.artista}</p>
    <p><strong>Álbum:</strong> ${cancion.album}</p>
    <p><strong>Género:</strong> ${cancion.genero}</p>
    <p><strong>Idioma:</strong> ${cancion.idioma}</p>


    <form method="get" action="/canciones/formulario/editar/${cancion.id}">
        <button type="submit">Editar Canción</button>
    </form>

    <form method="post" action="/canciones/eliminar/${cancion.id}">
    <input type="hidden" name="_method" value="DELETE"/>
    <button type="submit">
        Eliminar Canción
    </button>
    </form>

    <nav>
        <a href="/canciones">Volver a lista de canciones</a>
    </nav>
</body>
</html>

