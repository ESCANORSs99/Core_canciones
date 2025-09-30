<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción</title>
</head>
<body>
    <h1>Agregar Canción</h1>
    <form:form action="/canciones/procesa/agregar" method="post" modelAttribute="nuevaCancion">

        <div>
            <form:label path="titulo">
                Título:
            </form:label>
            <form:input path="titulo"/>
            <form:errors path="titulo" type="text"/>
        </div>

        <div>
            <form:label path="artista">
                Artista:
            </form:label>
            <form:input path="artista"/>
            <form:errors path="artista" type="text"/>
        </div>

        <div>
            <form:label path="album">
                Álbum:
            </form:label>
            <form:input path="album"/>
            <form:errors path="album" type="text"/>
        </div>

        <div>
            <form:label path="genero">
                Género:
            </form:label>
            <form:input path="genero"/>
            <form:errors path="genero" type="text"/>
        </div>

        <div>
            <form:label path="idioma">
                Idioma:
            </form:label>
            <form:input path="idioma"/>
            <form:errors path="idioma" type="text"/>
        </div>
        <button type="submit">Agregar Canción</button>
    </form:form>
    <nav>
    <a href="/canciones">Volver a lista de canciones</a>
    </nav>
</body>
</html>