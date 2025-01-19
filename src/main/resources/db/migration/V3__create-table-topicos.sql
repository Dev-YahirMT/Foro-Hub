CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,           -- Identificador único del tópico
    titulo VARCHAR(255) NOT NULL,                -- Título del tópico
    mensaje TEXT NOT NULL,                       -- Mensaje del tópico
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    status ENUM('activo', 'inactivo', 'archivado') DEFAULT 'activo', -- Estado del tópico
    autor INT NOT NULL,                          -- Relación con la tabla usuarios
    FOREIGN KEY (autor) REFERENCES usuarios(id)  -- Llave foránea hacia usuarios
);