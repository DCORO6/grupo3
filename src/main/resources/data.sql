MERGE INTO pintor (id, nombre, nacionalidad) VALUES (1, 'Pablo Picasso', 'Española');
MERGE INTO pintor (id, nombre, nacionalidad) VALUES (2, 'Vincent van Gogh', 'Holandesa');
MERGE INTO pintor (id, nombre, nacionalidad) VALUES (3,'Claude Monet', 'Francesa');
MERGE INTO pintor (id, nombre, nacionalidad) VALUES (4,'Salvador Dalí', 'Española');
MERGE INTO pintor (id, nombre, nacionalidad) VALUES (5,'Frida Kahlo', 'Mexicana');

MERGE INTO cuadro (id, titulo, ano, pintor_id) VALUES (1, 'Guernica', 1937, 1);
MERGE INTO cuadro (id, titulo, ano, pintor_id) VALUES (2, 'La noche estrellada', 1889, 2);
MERGE INTO cuadro (id, titulo, ano, pintor_id) VALUES (3, 'Impresión, sol naciente', 1872, 3);
MERGE INTO cuadro (id, titulo, ano, pintor_id) VALUES (4, 'La persistencia de la memoria', 1931, 4);
MERGE INTO cuadro (id, titulo, ano, pintor_id) VALUES (5, 'Las dos Fridas', 1939, 5);