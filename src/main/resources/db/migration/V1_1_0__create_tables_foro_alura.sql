
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
                         correoElectronico VARCHAR(255) NOT NULL,
                         contrasena VARCHAR(255) NOT NULL


);

-- Tabla Tópico
CREATE TABLE Topico (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fechaCreacion DATETIME NOT NULL,
                        autor INT,
                        curso INT,
                        FOREIGN KEY (autor) REFERENCES Usuario(id),
                        FOREIGN KEY (curso) REFERENCES Curso(id)
);

