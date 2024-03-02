/*
Ejercicios

1. Crar una nueva base de datos llamada "Taller SQL"
2. Crear una tabla llamada "Cientes", considerar los atributos:
ID, Nombre, Apellido,  Telefono, Direccion, Email.}
3. Insertar 10 registros en la tabla creada anteriormente.
4. Mostrar todos los registros insertados.
5. Actualizar 5 registros de la tabla aneriormente creada utlizando WHERE
6. Eliminar 2 registros utilizando WHERE
7. Guardar todo tu trabajo en tu repositorio github
*/

CREATE DATABASE TallerSQL
CREATE TABLE Clientes(
Id char (10) primary key,
Nombre varchar (15) not null,
Apellido varchar (15) not null,
Telefono char (9) not null,
Direccion varchar (25) null,
Email varchar (25) null
);

Insert into Clientes values ('1537786', 'Diego', 'Teheran', '999347545', 'Puente Piedra', '1537786@senati.pe')
Insert into Clientes values ('1422569', 'Daniel', 'Escudero', '965418625', 'Los Olivos', '1422569@senati.pe')
Insert into Clientes values ('1277584', 'Shandler', 'Moscoso', '952867428', 'Independencia', '1277584@senati,pe')
Insert into Clientes values ('1344578', 'Mirko', 'Ramos', '953126742', 'Puente Piedra', '1344578@senati.pe')
Insert into Clientes values ('1786559', 'Rossana', 'Gurtierrez', '976542170', 'Los Olivos', '1786559@senati.pe')
Insert into Clientes values ('1244578', 'Camila', 'Fuentes', '965245713', 'Comas', '1244578@senati.pe')
Insert into Clientes values ('1568242', 'Jhoat', ' Borda', '962348612', 'Ancon', '1568242@senati.pe')
Insert into Clientes values ('1425365', 'Jose', 'Paredes', '957211320', 'Los Olivos', '1425365@senati.pe')
Insert into Clientes values ('1728396', 'Andres', 'Mendoza', '924100634', 'Puente Piedra', '1728396@senati.pe')
Insert into Clientes values ('1537864', 'Joselyn', 'Fernandez', '968142003', 'Puente Piedra', '1537864@senati.pe')

SELECT * FROM Clientes

UPDATE Clientes set Nombre = 'Diego'
WHERE Id = '1537786'

UPDATE Clientes set Nombre = 'Daniel'
WHERE Id = '1422569'

UPDATE Clientes set Nombre = 'Shandler'
WHERE Id = '1277584'

UPDATE Clientes set Nombre = 'Mirko'
WHERE Id = '1344578'

UPDATE Clientes set Nombre = 'Rossana'
WHERE Id = '1786559'

DELETE FROM Clientes
WHERE Nombre = 'Diego'

DELETE FROM Clientes
WHERE Nombre = 'Daniel'
