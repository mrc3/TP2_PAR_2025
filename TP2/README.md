
# Sistema de Gestión Comercial - TP2

Este proyecto es parte del trabajo práctico 2 para la materia de Programación en Redes. Consiste en el desarrollo de un sistema de gestión de ventas, compras, clientes, productos y proveedores utilizando el patrón MVC en Java con JSP, Servlets y MySQL.

## 🧩 Módulos desarrollados

- ✔️ Clientes
- ✔️ Proveedores
- ✔️ Productos
- ✔️ Compras
- ✔️ Ventas
- ✔️ Auditoría (estructura base)
- ❌ Reportes (inventario, movimientos financieros): *implementados pero no probados*

> 🟡 **Nota importante:**  
Durante el proceso de desarrollo se realizaron múltiples ajustes directamente sobre la base de datos para resolver errores. Por esta razón, los archivos SQL proporcionados en el proyecto pueden estar desfasados con respecto al estado actual de la base de datos.

## ⚙️ Requisitos

- JDK 8+
- Apache Tomcat 9+
- MySQL 8+
- Maven

## 🚀 Instrucciones de despliegue

1. Clonar o descomprimir el proyecto.
2. Crear la base de datos `tp2` y ejecutar los scripts en `base de datos/` (puede requerir ajustes según el estado final de las tablas).
3. Configurar conexión en la clase `Conexion.java`.
4. Compilar y empaquetar con:

   ```bash
   mvn clean package
   ```

5. Desplegar el `.war` generado (`target/parMVC.war`) en Tomcat.

6. Iniciar el servidor y acceder a `http://localhost:8080/parMVC`.
http://localhost:8080/parMVC/Controlador*.
Donde * seria la extension de los modulos desarrollados.
Ejemplo "*"
- Auditoria
- Clientes 
- Compras
- Productos
- Proveedores
- Ventas

## 🔍 Tests

Se incluyeron tests automatizados **a nivel de código** (DAO) para Clientes, Compras y Ventas usando JUnit 4. No se realizaron pruebas funcionales a nivel de interfaz por cuestiones de tiempo.

## 📌 Comentario Final

Debido a varios problemas durante el desarrollo (compatibilidad, errores de despliegue y ajustes en la DB), no se logró probar completamente los módulos de reportes ni realizar validaciones QA a nivel funcional.

Sin embargo, la lógica está implementada completamente en los módulos mencionados. Sería muy amable considerar estos desarrollos como válidos en base al esfuerzo demostrado y a los tests agregados.

Gracias por su comprensión.

© Facultad Politécnica - UNA | LEC-PRO
