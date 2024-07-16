
-- Tabla Curso
CREATE TABLE Curso (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(255) NOT NULL,
                       categoria VARCHAR(255) NOT NULL
);


-- Tabla Usuario
CREATE TABLE Usuario (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         contrasena VARCHAR(255) NOT NULL


);

-- Tabla Tópico
CREATE TABLE Topico (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fecha DATETIME NOT NULL,
                        autor INT,
                        curso INT,
                        FOREIGN KEY (autor) REFERENCES Usuario(id),
                        FOREIGN KEY (curso) REFERENCES Curso(id)
);

INSERT INTO Curso (nombre, categoria) VALUES
                                          ('Curso de Java', 'Programación'),
                                          ('Curso de Spring', 'Frameworks'),
                                          ('Curso de Angular', 'Frontend'),
                                          ('Curso de MySQL', 'Bases de Datos');

-- Insertar datos en la tabla Usuario
INSERT INTO Usuario (nombre, email, contrasena) VALUES
                                                                ('Gabriel Steven', 'legard@example.com', '$2y$10$mK162jOBgugfqgqHVzxzV.cJ1gX6rBXlBCRu1zcfbcNjgtFMA5df2'),
                                                                ('Ana Gomez', 'ana.gomez@example.com', '$2y$10$x8wMkXwQZHGQrdayAV0Hw.JZqYq7iBca6t1E82/JyEhXMMh7DXv4e')





