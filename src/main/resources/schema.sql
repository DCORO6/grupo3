CREATE TABLE pintor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    nacionalidad VARCHAR(255) NOT NULL
);

CREATE TABLE cuadro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    anio INT NOT NULL,
    pintor_id BIGINT,
    FOREIGN KEY (pintor_id) REFERENCES pintor(id)
);
