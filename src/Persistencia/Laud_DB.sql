/**
 * Author:  Camilo
 * Created: 14/03/2019
 */

CREATE DATABASE LAUD_DB;

USE LAUD_DB;

CREATE TABLE usuarios (
  id_doc_usuario INT NOT NULL PRIMARY KEY,
  nom_usuario VARCHAR(80) NOT NULL,
  ape_usuario VARCHAR(80) NOT NULL,
  nick_usuario VARCHAR(120) NOT NULL,
  clave_usuario BLOB(120),
  fec_crea_usuario TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB;

/*INSERCION USUARIOS*/
INSERT INTO usuarios(id_doc_usuario,nom_usuario, ape_usuario, nick_usuario, clave_usuario) VALUES(1111793381, 'CAMILO', 'ACEVEDO', 'ROOT', SHA('TOOR'));

CREATE TABLE clientes (
  id_doc_cliente INT NOT NULL PRIMARY KEY,
  nom_cliente VARCHAR(80) NOT NULL,
  ape_cliente VARCHAR(80) NOT NULL,
  tel_cliente VARCHAR(11),
  email_cliente VARCHAR(120),
  dir_cliente VARCHAR(180),
  clave_cliente VARCHAR(120),
  fec_crea_cliente TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB;

/*INSERCION CLIENTES*/
INSERT INTO clientes(id_doc_cliente,nom_cliente, ape_cliente, tel_cliente, email_cliente, dir_cliente, clave_cliente) VALUES(1, 'CLIENTE', 'PRUEBA', '12345', 'prueba@prueba.com', 'cll 2da', '1234adf');

CREATE TABLE cat_productos (
  id_cat_prod INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nom_cat_prod VARCHAR(120) NOT NULL,
  fec_crea_cat_prod TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB;

/*INSERCION CATEGORIA DE PRODUCTOS*/
INSERT INTO cat_productos(nom_cat_prod)VALUES('AREPAS');
INSERT INTO cat_productos(nom_cat_prod)VALUES('CHULETAS');
INSERT INTO cat_productos(nom_cat_prod)VALUES('SALCHIPAPAS');
INSERT INTO cat_productos(nom_cat_prod)VALUES('PICADAS');
INSERT INTO cat_productos(nom_cat_prod)VALUES('CHUZOZ Y CHORIZO');
INSERT INTO cat_productos(nom_cat_prod)VALUES('ASADOS');
INSERT INTO cat_productos(nom_cat_prod)VALUES('MAIZITOS');
INSERT INTO cat_productos(nom_cat_prod)VALUES('COMBOS Y ADICIONALES');

CREATE TABLE productos (
  id_producto INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nom_producto VARCHAR(120) NOT NULL,
  desc_producto VARCHAR(200) NOT NULL,
  precio_producto_und DECIMAL(9,2),
  fec_crea_producto TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FK_id_cat_prod INT NOT NULL,

  FOREIGN KEY (FK_id_cat_prod) REFERENCES cat_productos (id_cat_prod)

) ENGINE = INNODB;

/*INSERCION PRODUCTOS*/
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA CON CHICHARRON', 'POLLO, CARNE, CHICHARRON, MADURO, RIPIO, QUESO Y SALSAS', '7000', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA CON COSTILLA BBQ', 'POLLO, CARNE, CHICHARRON, COSTILLA, MADURO, RIPIO, QUESO Y SALSAS', '8000', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA PAISA', 'CHICHARRON, MADURO, QUESO, CHORIZO, RIPIO Y SALSAS', '7000', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA CARNIVOROS', 'POLLO, CARNE, COSTILLA CHICHARRON, MADURO, CHORIZO, QUESO, RIPIO Y SALSAS', '9500', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA CON DOBLE QUESO', 'SIN DESCRIPCION INGREDIENTES', '2500', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA POLLO Y QUESO', 'SIN DESCRIPCION', '5000', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA MIXTA', 'POLLO, CARNE, QUESO, RIPIO Y SALSAS', '5500', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA VEGETARIANA', 'MAIZ TIERNO, RIPIO, TOMATE, SALSAS, QUESO, AGUACATE Y MADURO', '5000', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA FEROZ', 'POLLO, CARNE, CHICHARRON, CHORIZO, MADURO, COSTILLA, TOCINETA, AGUACATE, RIPIO, QUESO, SALSAS, MAIZ TIERNO, HUEVO DE CODORNIZ', '11000', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA BESTIA', 'POLLO, CARNE, CHICHARRON, CHORIZO, MADURO, COSTILLA, TOCINETA, AGUACATE, SALCHICHA AHUMADA, RIPIO, MAIZ TIERNO, QUESO, SALSAS, HUEVO CODORNIZ', '12000', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPA CARNIBURGUER', 'POLLO, CARNE, CHICHARRON, CHORIZO, MADURO, COSTILLA, TOCINETA, AGUACATE, SALCHICHA AHUMADA, CARNE DE HAMBURGUESA, MAIZ TIERNO, QUESO, SALSAS, HUEVO DE CODORNIZ, RIPIO', '14500', '1');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('AREPICADA', 'AREPA BBQ + PICADA PERSONAL CON QUESO', '20000', '1');

INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('CHULETA DE POLLO', 'CHULETA DE POLLO CON ENSALADA, PAPAS FRITAS, AREPA FRITA', '14000', '2');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('CHULETA DE POLLO + QUESO', 'CHULETA DE POLLO CON ENSALADA, PAPAS FRITAS, AREPA FRITA Y QUESO', '15000', '2');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('CHULETA DE CERDO', 'CHULETA DE CERDO CON ENSALADA, PAPAS FRITAS, AREPA FRITA', '14000', '2');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('CHULETA DE CERDO + QUESO', 'CHULETA DE CERDO CON ENSALADA, PAPAS FRITAS, AREPA FRITA Y QUESO', '15000', '2');

INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('SALCHI QUESO', 'PAPAS, SALCHICHA, QUESO, RIPIO Y SALAS', '8000', '3');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('SALCHI COSTILLA', 'PAPAS, SALCHICHA, QCOSTILLA, QUESO, RIPIO Y SALSAS', '10000', '3');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('SALCHISUPER', 'PAPAS, SALCHICHA, CHORIZO, COSTILLA BBQ, QUESO, RIPIO Y SALSAS', '12000', '3');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('SALCHICHORIZO', 'PAPAS, SALCHICHA, CHORIZO, QUESO, RIPIO Y SALSAS', '9000', '3');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('SALCHICARNIVOROS', 'PAPAS, SALCHICHA, COSTILLA BBQ, CHORIZO, MADURO, POLLO, CARNE, QUESO, SALSA, RIPIO Y MAIZ', '20000', '3');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('SALCHIMELONA', 'PAPAS, SALCHICHA, COSTILLA BBQ, CHORIZO, MADURO, POLLO, CARNE, CERDO, TOCINETA, QUESO, SALSA, RIPIO, MAIZ TIERNO Y HUEVO DE CODORNIZ', '35000', '3');

INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PICADA PERSONAL', 'TROCITOS DE POLLO, CERDO, COSTILLA, CHORIZO, PAPAS FRITAS, AREPA, ENSALADA Y QUESO', '14000', '4');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PICADA CARNIVOROS', 'TROCITOS DE POLLO, CERDO, COSTILLA, CHORIZO, PAPAS FRITAS, AREPA, ENSALADA, MUCHO QUESO Y MAIZ TIERNO', '19000', '4');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PICADA FAMILIAR', 'TROCITOS DE POLLO, CERDO, COSTILLA, CHORIZO, PAPAS FRITAS, AREPA Y PLATANO', '30000', '4');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PICADA EXTRA FAMILIAR', '2 PORCIONES DE RES, POLLO, CERDO, COSTILLA, CHORIZO, PAPAS FRITAS, AREPA Y PLATANO', '52000', '4');

INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('CHUZO', 'POLLO RES O CERDO', '5000', '5');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('CHORIZO SANTA ROSANO', 'SIN DESC.', '4000', '5');

INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('ASADO CARNE DE RES', '150GR DE CARNE, PAPAS FRITAS, AREPA Y ENSALADA', '11500', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('ASADO CARNE DE RES + QUESO', '150GR DE CARNE, PAPAS FRITAS, AREPA Y ENSALADA', '12500', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('ASADO CARNE DE CERDO', '150GR DE CARNE, PAPAS FRITAS, AREPA Y ENSALADA', '11000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('ASADO CARNE DE CERDO + QUESO', '150GR DE CARNE, PAPAS FRITAS, AREPA Y ENSALADA', '12000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('FILETE DE POLLO', '150GR DE CARNE, PAPAS FRITAS, AREPA Y ENSALADA', '11000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('FILETE DE POLLO + QUESO', '150GR DE CARNE, PAPAS FRITAS, AREPA Y ENSALADA', '12000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('COSTILLA A LA BBQ1/2', '150GR DE COSTILLA, PAPAS FRITAS, AREPA Y ENSALADA', '10000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('COSTILLA A LA BBQ1/2 + QUESO', '150GR DE COSTILLA, PAPAS FRITAS, AREPA Y ENSALADA', '11000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('COSTILLA A LA BBQ', '150GR DE COSTILLA, PAPAS FRITAS, AREPA Y ENSALADA', '18000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('COSTILLA A LA BBQ + QUESO', '150GR DE COSTILLA, PAPAS FRITAS, AREPA Y ENSALADA', '20000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('MIXTA DE LA CASA PERSONAL', 'PORCION DE CARNE, CHORIZO, COSTILLA BBQ, PAPAS FRITAS, AREPA Y ENSALADA', '16500', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('MIXTA DE LA CASA PERSONAL + QUESO', 'PORCION DE CARNE, CHORIZO, COSTILLA BBQ, PAPAS FRITAS, AREPA Y ENSALADA', '18000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('MIXTA 1', 'RES, CERDO, PAPAS FRITAS, AREPA Y ENSALADA', '18000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('MIXTA 1 + QUESO', 'RES, CERDO, PAPAS FRITAS, AREPA Y ENSALADA', '19000', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('MIXTA 2', 'RES, POLLO, COSTILLA BBQ, PAPAS FRITAS, AREPA Y ENSALADA', '26500', '6');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('MIXTA 2 + QUESO', 'RES, POLLO, COSTILLA BBQ, PAPAS FRITAS, AREPA Y ENSALADA', '27500', '6');

INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('MAIZITOS', 'TROZITOS DE POLLO O CERDO PAPAS FRITAS, SALSAS DE LA CASA, MUCHO QUESO Y MAIZ TIERNO', '13000', '7');

INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PAPAS A LA FRANCESA + JUGO HIT 500 ML', 'PAPAS A LA FRANCESA + JUGO HIT 500 ML', '4500', '8');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PAPAS A LA FRANCESA + GASEOSA', 'PAPAS A LA FRANCESA + GASEOSA', '5000', '8');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PORCION DE PAPAS A LA FRANCESA', 'PORCION DE PAPAS A LA FRANCESA', '3000', '8');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PORCION DE AREPA ASADA O FRITA', 'PORCION DE AREPA ASADA O FRITA', '2500', '8');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PORCION DE QUESO', 'PORCION DE QUESO', '2000', '8');
INSERT INTO productos(nom_producto,desc_producto, precio_producto_und, FK_id_cat_prod) VALUES('PORCION DE ENSALADA', 'PORCION DE ENSALADA', '2000', '8');

CREATE TABLE aper_caja (
  id_caja INT(10) UNSIGNED ZEROFILL NOT NULL PRIMARY KEY AUTO_INCREMENT,
  saldo_ape DECIMAL(9,2) NOT NULL,
  fec_ape_caja TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB;

CREATE TABLE cierre_caja (
  id_cierre_caja INT(10) UNSIGNED ZEROFILL NOT NULL PRIMARY KEY AUTO_INCREMENT,
  saldo_cierre DECIMAL(9,2) NOT NULL,

  FK_id_caja INT(10) UNSIGNED ZEROFILL NOT NULL,

  fec_cierre_caja TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

  FOREIGN KEY (FK_id_caja) REFERENCES aper_caja(id_caja)
) ENGINE = INNODB;

CREATE TABLE factura_ventas(
  id_fact_v INT(9) UNSIGNED ZEROFILL PRIMARY KEY AUTO_INCREMENT,
  cantidad_items INT NOT NULL,
  vlr_total_fv DECIMAL(9,2),
  estado_fv BOOLEAN DEFAULT FALSE,
  fec_crea_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB;

CREATE TABLE mesas(
    id_mesa INT(9) UNSIGNED ZEROFILL PRIMARY KEY AUTO_INCREMENT,
    nombre_mesa VARCHAR(15) NOT NULL,
    abr_mesa VARCHAR(5)
) ENGINE = INNODB;

INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('MESA_1', 'M1');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('MESA_2', 'M2');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('MESA_3', 'M3');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('MESA_4', 'M4');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('MESA_5', 'M5');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('MESA_VERDE_1', 'MV1');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('MESA_VERDE_2', 'MV2');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('BARRA', 'BR');
INSERT INTO mesas(nombre_mesa, abr_mesa) VALUES('DOMICILIO', 'DOM');

CREATE TABLE pedidos (
  id_registro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  id_pedido INT NOT NULL,

  FK_id_fact_v INT(9) UNSIGNED ZEROFILL,
  FK_id_producto INT NOT NULL,
  FK_id_doc_usuario INT NOT NULL,
  FK_id_doc_cliente INT NOT NULL,
  FK_aper_caja INT(10) UNSIGNED ZEROFILL NOT NULL,
  FK_id_mesa INT(9) UNSIGNED ZEROFILL NOT NULL,

  precio_producto_und DECIMAL(9,2),
  cantidad_producto INT NOT NULL,
  vlr_total_producto DECIMAL(9,2),
  fec_crea_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  observacion_pedido VARCHAR(50),

  FOREIGN KEY (FK_id_fact_v) REFERENCES factura_ventas(id_fact_v),
  FOREIGN KEY (FK_id_producto) REFERENCES productos (id_producto),
  FOREIGN KEY (FK_id_doc_usuario) REFERENCES usuarios (id_doc_usuario),
  FOREIGN KEY (FK_id_doc_cliente) REFERENCES clientes (id_doc_cliente),
  FOREIGN KEY (FK_aper_caja) REFERENCES aper_caja (id_caja)
) ENGINE = INNODB;

