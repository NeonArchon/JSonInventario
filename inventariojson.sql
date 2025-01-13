-- DROP DATABASE IF NOT EXISTS inventariojson;

CREATE DATABASE inventariojson;

USE inventariojson;

CREATE TABLE productos (
	codigo VARCHAR(20) PRIMARY KEY,
    categoria VARCHAR(20) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    precio INT NOT NULL,
    fecha_ingreso DATE NOT NULL,
    fstock INT NOT NULL
);

SELECT * FROM productos;
