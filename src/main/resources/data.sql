INSERT INTO pintor (nombre, nacionalidad) VALUES ('Pablo Picasso', 'Española');
INSERT INTO pintor (nombre, nacionalidad) VALUES ('Vincent van Gogh', 'Holandesa');
INSERT INTO pintor (nombre, nacionalidad) VALUES ('Claude Monet', 'Francesa');
INSERT INTO pintor (nombre, nacionalidad) VALUES ('Salvador Dalí', 'Española');
INSERT INTO pintor (nombre, nacionalidad) VALUES ('Frida Kahlo', 'Mexicana');

INSERT INTO cuadro (titulo, anio, pintor_id) VALUES ('Guernica', 1937, (SELECT id FROM pintor WHERE nombre = 'Pablo Picasso'));
INSERT INTO cuadro (titulo, anio, pintor_id) VALUES ('La noche estrellada', 1889, (SELECT id FROM pintor WHERE nombre = 'Vincent van Gogh'));
INSERT INTO cuadro (titulo, anio, pintor_id) VALUES ('Impresión, sol naciente', 1872, (SELECT id FROM pintor WHERE nombre = 'Claude Monet'));
INSERT INTO cuadro (titulo, anio, pintor_id) VALUES ('La persistencia de la memoria', 1931, (SELECT id FROM pintor WHERE nombre = 'Salvador Dalí'));
INSERT INTO cuadro (titulo, anio, pintor_id) VALUES ('Las dos Fridas', 1939, (SELECT id FROM pintor WHERE nombre = 'Frida Kahlo'));
