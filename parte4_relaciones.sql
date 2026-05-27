CREATE TABLE proyectos (
	id serial primary key,
	nombre varchar(100) not null,
	dias_estimados INTEGER not null
);
INSERT INTO proyectos(nombre,dias_estimados)
VALUES('sofwarw', 20);

CREATE TABLE tecnologias (
	id serial primary key,
	nombre varchar(50) not null,
	categoria varchar(30) not null
);
INSERT INTO tecnologias(nombre,categoria)
VALUES('Java', 'Backend');

CREATE TABLE proyectos_tecnologias (
    id_proyecto INTEGER NOT NULL,
    id_tecnologia INTEGER NOT NULL,
    PRIMARY KEY (id_proyecto, id_tecnologia),
    FOREIGN KEY (id_proyecto) REFERENCES proyectos(id),
    FOREIGN KEY (id_tecnologia) REFERENCES tecnologias(id)
);
SELECT t.nombre, t.categoria
FROM tecnologias t
JOIN proyectos_tecnologias pt ON t.id = pt.id_tecnologia
JOIN proyectos p ON p.id = pt.id_proyecto
WHERE p.nombre = 'sofwarw';

SELECT p.nombre, p.dias_estimados
FROM proyectos p
JOIN proyectos_tecnologias pt ON p.id = pt.id_proyecto
WHERE pt.id_tecnologia = 20;

SELECT t.nombre, COUNT(pt.id_proyecto) AS total_proyectos
FROM tecnologias t
LEFT JOIN proyectos_tecnologias pt ON t.id = pt.id_tecnologia
GROUP BY t.nombre
ORDER BY total_proyectos DESC;
