INSERT INTO AEROLINEA (NOMBRE) VALUES ('birdarilnes');
INSERT INTO AEROLINEA (NOMBRE) VALUES ('runair');
INSERT INTO AVION (FK_AEROLINEA_ID,CAPACIDAD,MODELO) VALUES (1,150,'Boeing 737');
INSERT INTO AVION (FK_AEROLINEA_ID,CAPACIDAD,MODELO) VALUES (1,200,'Airbus A320');
INSERT INTO AVION (FK_AEROLINEA_ID,CAPACIDAD,MODELO) VALUES (1,100,'Airbus 300');
INSERT INTO AVION (FK_AEROLINEA_ID,CAPACIDAD,MODELO) VALUES (1,300,'Airbus 600');
INSERT INTO AVION (FK_AEROLINEA_ID,CAPACIDAD,MODELO) VALUES (1,225,'Maverick 121');
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Madrid',null,null,1,1);
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Sevilla','2023-03-15 17:19:29.944',null,1,2); 
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Praga','2023-03-07 11:31:47.434',null,1,3); 
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Tokyo','2023-03-12 10:05:12.937',null,1,4);
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Londres',null,null,1,2);
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Chicago','2023-03-15 17:19:29.944','2023-03-29 12:07:27.777',1,1); 
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Dublin','2023-03-16 15:19:29.944','2023-03-23 14:07:27.777',1,4); 
INSERT INTO VUELO (DESCRIPCION,PENDIENTE,SALIDA,FK_AEROLINEA_ID,FK_AVION_ID) VALUES ('Vuelo Murcia-Santiago','2023-03-16 16:19:29.944','2023-03-23 15:07:27.777',1,3);
