<h1>ForoHub API Rest</h1>

<div align="center">
    <img src="https://img.shields.io/badge/Estado-En desarrollo-green">
    <img src="https://img.shields.io/badge/Java-v17-blue">
    <img src="https://img.shields.io/badge/Framework-Spring Boot 3-green">
    <img src="https://img.shields.io/badge/Base de Datos-MySQL-blue">
    <img src="https://img.shields.io/badge/ORM-Hibernate-blue">
    <img src="https://img.shields.io/badge/Autenticación-JWT-blue">
    <img src="https://img.shields.io/badge/Versión-v1.0.0-green">
</div>

# Contenido

- [Insignias](#insignias)

- [Descripción del proyecto](#descripción-del-proyecto)

- [Estado del proyecto](#estado-del-proyecto)

- [Demostración de funcionalidades](#demostración-de-funcionalidades)

    - [Funcionalidades del proyecto](#funcionalidades-del-proyecto)

    - [Uso del proyecto](#uso-del-proyecto)

- [Acceso al proyecto](#acceso-al-proyecto)

- [Teconologías utilizadas](#teconologías-utilizadas)

- [Persona Desarrolladora del Proyecto](#persona-desarrolladora-del-proyecto)

# Descripción del proyecto 📄

¡Bienvenido/a a ForoHub!
Es una aplicación API Rest CRUD en la que puedes crear un tópico, leer todos los tópicos creados por paginación y en cada pagina 10 tópicos, leer un tópico en específico, actualizar datos de un tópico y eliminar un tópico. Para poder hacer algo en la API rest se tendrá que estar logeando y cada consulta tendra que contener un TOKEN valido.

# Estado del proyecto

✅ CRUD de Tópicos 100%.

✅ Login de Usuarios 100%

✅ CRUD de Cursos 100%

🔧 CRUD de respuestas

🔧 Conexión de Cursos con Topicos

🔧 Conexión de Respuestas con Tópicos y Usuarios

# Demostración de funcionalidades

## Funcionalidades del proyecto 🔧

1. **Registrar tópico**: Registra en la base de datos un tópico con los siguientes datos: título, mensaje, fecha de creación, estado, ID de autor.

    ⚠️ Importante: no puede un tópico con el mismo titulo.

2. **Listar tópicos**: Muestra de manera páginada los tópicos activos.
3. **Listar un tópico**: Muestra sólo un tópico pasando el ID como parámetro en la URL.
4. **Actualizar un tópico**: Actualiza los campos Titulo, Mensaje y Status de un Tópico.
5. **Eliminar un tópico**: Elimina un tópico pasando el ID como parámetro en la URL.
6. **Conexión a la base de datos**: Toda la información se guarda en una base de datos de MySQL.


    ⚠️ Importante: Es necesario tener configuradas las siguientes variables de entorno:

    ${DB_HOST}, ${DB_USER}, ${DB_PASSWORD} y ${JWT_SECRET}

    En ${DB_HOST} debe detener la direción IP más el puerto de la base de datos`. Esta base de datos tiene que tener una base de datos con el nombre de forohub-java
    
    En ${DB_USER} nombre de usuario de la base de datos.

    En ${DB_PASSWORD} contraseña del usuario de la base de datos.

    Y en JWT_SECRET puede poner uno que guste con esta podra verificar el JWT en la pagina https://jwt.io/.


# Teconologías utilizadas 🔨

- Java 17
- Spring Boot 3
- Maven
- Spring Web
- Spring Data JPA
- Spring Boot DevTools
- Flyway Migration
- Validation
- Spring Security
- Postman o Insomnia
