CREATE TABLE respuestas (
    id INT AUTO_INCREMENT PRIMARY KEY,               -- Identificador único de la respuesta
    mensaje TEXT NOT NULL,                           -- Mensaje de la respuesta
    topico INT NOT NULL,                             -- Relación con la tabla Tópico
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    autor INT NOT NULL,                              -- Relación con la tabla Usuario
    solucion BOOLEAN DEFAULT FALSE,                  -- Indica si es la solución del tópico
    FOREIGN KEY (topico) REFERENCES topicos(id),      -- Llave foránea hacia Tópico
    FOREIGN KEY (autor) REFERENCES usuarios(id)       -- Llave foránea hacia Usuario
);