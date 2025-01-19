CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,              -- Identificador único del usuario
    nombre VARCHAR(100) NOT NULL,                   -- Nombre del usuario
    correo_electronico VARCHAR(150) UNIQUE NOT NULL, -- Correo electrónico único
    contrasena VARCHAR(255) NOT NULL,               -- Contraseña del usuario
    perfil VARCHAR(255) UNIQUE
);