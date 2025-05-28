CREATE TABLE producto (
	id int auto_increment PRIMARY KEY,
	nombre varchar(50),
	descripcion varchar(50),
	unidades int,
	costo decimal(10, 2),
	precio decimal (10, 2),
	categoria varchar(50)
);

CREATE TABLE usuario (
	id int auto_increment PRIMARY KEY,
	nombre varchar(50),
	contrasenia varchar(50),
	administrador tinyint(1)
);

CREATE TABLE auditoria (
	idAuditoria int auto_increment PRIMARY KEY,
	nombreProducto varchar(50),
	descripcionProducto varchar(50),
	unidadesProducto int,
	costoProducto decimal(10, 2),
	PrecioProducto decimal (10, 2),
	categoriaProducto varchar(50),
	idUsuario int,
	nombreUsuario varchar(50),
	descripcionAccion varchar(20)
);

CREATE TABLE venta (
	idVenta int auto_increment PRIMARY KEY,
	idProducto int,
	nombreProducto varchar(50),
	descripcionProducto varchar(50),
	unidadesProducto int,
	costoProducto decimal(10, 2),
	precioProducto decimal (10, 2),
	categoriaProducto varchar(50),
	idUsuario int,
	nombreUsuario varchar(50),
	fecha datetime
);
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(20)
);
CREATE TABLE venta_cliente (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idVenta INT,
	idCliente INT,
	FOREIGN KEY (idVenta) REFERENCES venta(idVenta),
	FOREIGN KEY (idCliente) REFERENCES cliente(id)
);
CREATE TABLE proveedor (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	direccion VARCHAR(200),
	telefono VARCHAR(20)
);

CREATE TABLE producto_proveedor (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idProducto INT,
	idProveedor INT,
	FOREIGN KEY (idProducto) REFERENCES producto(id),
	FOREIGN KEY (idProveedor) REFERENCES proveedor(id)
);
CREATE TABLE categoria (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL
);
CREATE TABLE producto_categoria (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idProducto INT,
	idCategoria INT,
	FOREIGN KEY (idProducto) REFERENCES producto(id),
	FOREIGN KEY (idCategoria) REFERENCES categoria(id)
);
CREATE TABLE orden_compra (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idProveedor INT,
	fecha DATE,
	total DECIMAL(10, 2),
	FOREIGN KEY (idProveedor) REFERENCES proveedor(id)
);
CREATE TABLE orden_compra_producto (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idOrdenCompra INT,
	idProducto INT,
	cantidad INT,
	precioUnitario DECIMAL(10, 2),
	FOREIGN KEY (idOrdenCompra) REFERENCES orden_compra(id),
	FOREIGN KEY (idProducto) REFERENCES producto(id)
);
CREATE TABLE inventario (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idProducto INT,
	cantidad INT,
	FOREIGN KEY (idProducto) REFERENCES producto(id)
);
CREATE TABLE pago (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idVenta INT,
	monto DECIMAL(10, 2),
	fecha DATE,
	FOREIGN KEY (idVenta) REFERENCES venta(idVenta)
);
CREATE TABLE descuento (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idProducto INT,
	porcentaje DECIMAL(5, 2),
	fechaInicio DATE,
	fechaFin DATE,
	FOREIGN KEY (idProducto) REFERENCES producto(id)
);
CREATE TABLE devolucion (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idVenta INT,
	idProducto INT,
	cantidad INT,
	fecha DATE,
	FOREIGN KEY (idVenta) REFERENCES venta(idVenta),
	FOREIGN KEY (idProducto) REFERENCES producto(id)
);
CREATE TABLE reporte_ventas (
	id INT AUTO_INCREMENT PRIMARY KEY,
	fechaInicio DATE,
	fechaFin DATE,
	totalVentas DECIMAL(10, 2),
	totalUnidadesVendidas INT
);
CREATE TABLE reporte_inventario (
	id INT AUTO_INCREMENT PRIMARY KEY,
	fecha DATE,
	totalProductos INT,
	totalCantidad INT
);
CREATE TABLE auditoria_ventas (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idVenta INT,
	idUsuario INT,
	descripcionAccion VARCHAR(100),
	fecha DATE,
	FOREIGN KEY (idVenta) REFERENCES venta(idVenta),
	FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);
CREATE TABLE auditoria_productos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idProducto INT,
	idUsuario INT,
	descripcionAccion VARCHAR(100),
	fecha DATE,
	FOREIGN KEY (idProducto) REFERENCES producto(id),
	FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);
CREATE TABLE auditoria_usuarios (
	id INT AUTO_INCREMENT PRIMARY KEY,
	idUsuario INT,
	descripcionAccion VARCHAR(100),
	fecha DATE,
	FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);
