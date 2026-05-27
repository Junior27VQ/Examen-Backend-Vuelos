create table vuelos(
	id serial primary key,
	codigo varchar(10) not null unique,
	precio_boleto numeric(10, 2) not null check (precio_boleto >= 0),
	asientos_disponibles integer not null check (asientos_disponibles >= 0)
);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles) VALUES 
('AA-101', 150.50, 45),
('LA-202', 200.00, 2),
('IB-303', 450.75, 0),
('AV-404', 120.00, 10),
('EK-505', 499.99, 3),
('LH-606', 320.50, 25),
('AF-707', 280.00, 1),
('UA-808', 190.25, 0),
('DL-909', 210.00, 30),
('BA-111', 350.00, 4),
('KL-222', 275.40, 15),
('AF-333', 410.00, 2),
('LA-444', 130.00, 0),
('AA-555', 225.50, 8),
('IB-666', 380.00, 3),
('AV-777', 155.00, 20),
('EK-888', 480.00, 4),
('LH-999', 290.00, 12),
('UA-123', 310.00, 1),
('DL-456', 240.00, 6);

SELECT * FROM vuelos WHERE asientos_disponibles < 5;

UPDATE vuelos 
SET precio_boleto = precio_boleto * 1.15 
WHERE id = 5;

DELETE FROM vuelos WHERE asientos_disponibles = 0;