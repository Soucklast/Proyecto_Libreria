# Librería de Gestión de Ventas de Libros 📚

Esta es una **librería para gestionar ventas de libros**, que incluye características como generación automática de comprobantes en formato PDF y envío por correo al cliente. Además, incluye herramientas para gestionar clientes, usuarios y libros, así como un componente personalizado para la gestión de contraseñas.

---

## **Descripción del Proyecto**

Esta librería está diseñada para simplificar y automatizar los procesos de una librería o tienda de libros. Ofrece las siguientes funcionalidades principales:

- **Ventas de libros:**  
  - Al realizar una venta, se genera automáticamente un archivo PDF con el resumen de la transacción.
  - El PDF se envía automáticamente al correo electrónico del cliente.

- **Componente personalizado para contraseñas:**  
  - Incluye una celda con campo de entrada de texto y un botón que permite ocultar o mostrar la contraseña.

- **Gestión de clientes:**  
  - Se pueden agregar, actualizar y administrar los datos de los clientes.

- **Gestión de usuarios:**  
  - Permite registrar nuevos usuarios, como cajeros o administradores, con distintos roles y permisos.

- **Gestión de inventario:**  
  - Funcionalidad para agregar libros, con detalles como título, autor, precio, y cantidad disponible.

- **Reporte de ventas:**  
  - Visualización de las ventas realizadas, con información detallada como fecha, cliente, productos vendidos y total de la transacción.

---

## **Características Técnicas**

1. **Generación de PDFs:**  
   - Usa librerías de generación de documentos PDF para crear comprobantes de venta.  
   - Personalización del contenido del PDF con el logo y detalles de la tienda.

2. **Envío de correos electrónicos:**  
   - Integración con servicios de correo para enviar automáticamente el comprobante de venta a los clientes.

3. **Componente personalizado de contraseñas:**  
   - Mejora la experiencia del usuario al permitir visualizar o ocultar contraseñas en los formularios de registro y login.

4. **Base de datos:**  
   - Almacena información de clientes, usuarios, libros e historial de ventas.  
   - Diseñada para soportar grandes volúmenes de datos con consultas eficientes.


### Loging.java


![image](https://github.com/user-attachments/assets/ee60b325-6abe-42b0-b26c-6ce094cd2b0e)


El archivo `Loging.java` es responsable de gestionar la interfaz gráfica del **inicio de sesión de usuarios** en el sistema de la librería. Este componente permite a los usuarios autenticarse según su rol, con validación de credenciales y redirección al menú principal en caso de éxito.

#### **Características principales:**

1. **Validación de credenciales:**  
   - Verifica que el usuario, contraseña y tipo de usuario (Administrador o Cajero) sean correctos antes de otorgar acceso.  
   - Muestra mensajes de error en caso de credenciales incorrectas o datos incompletos.

2. **Gestión de usuarios activos:**  
   - Los datos del usuario autenticado (nombre y tipo de usuario) se almacenan temporalmente en la clase `SesionUsuario`.

3. **Interfaz gráfica personalizada:**  
   - Utiliza componentes como botones, campos de texto y un combo box para manejar la interacción del usuario.
   - Incluye un **componente personalizado de contraseña** (`Contraseña`), que permite ocultar o mostrar la contraseña para mejorar la seguridad.  

4. **Roles de usuario:**  
   - Permite seleccionar entre roles de **Administrador** o **Cajero** antes de iniciar sesión.

5. **Redirección al menú principal:**  
   - Tras una autenticación exitosa, redirige al usuario al componente `Menu`.

#### **Componentes principales:**

- **Campos de texto:**  
  - `usuario`: Campo donde el usuario ingresa su nombre.  
  - `contraseña1`: Componente personalizado para manejar contraseñas.

- **Combo box:**  
  - `combousuario`: Permite seleccionar el rol del usuario, entre Administrador o Cajero.

- **Botones:**  
  - `Ingresar`: Valida las credenciales y permite el acceso si son correctas.  
  - `Salir`: Cierra la aplicación.

- **Diseño visual:**  
  - Incluye imágenes (`img`) y fondos (`fondo`) personalizados para mejorar la experiencia del usuario.

#### **Flujo de validación:**

1. El usuario selecciona un tipo de usuario válido desde el combo box (`Administrador` o `Cajero`).  
2. Ingresa sus credenciales en los campos correspondientes (`usuario` y `contraseña1`).  
3. Se valida la información ingresada:  
   - Si faltan datos o el tipo de usuario no es válido, se muestra un mensaje de error.  
   - Si las credenciales son correctas, se almacena la sesión del usuario y se redirige al menú principal.  

#### **Ejemplo de uso:**

1. **Inicio de sesión exitoso:**  
   - Ingresa las credenciales correctas y selecciona el rol adecuado para acceder al sistema.  
2. **Error en credenciales:**  
   - Si los datos son incorrectos o incompletos, el sistema mostrará mensajes indicando el problema y no permitirá el acceso.


### Menu.java


![image](https://github.com/user-attachments/assets/8943f8f7-0fbb-4ee6-8bee-a9f79424b805)


#### **Características principales:**

1. **Acceso basado en roles:**  
   - Si el usuario es **Cajero**, se deshabilita el botón para la gestión de usuarios.  
   - Los **Administradores** tienen acceso completo a todas las funcionalidades.

2. **Opciones del menú:**  
   El menú principal incluye botones para:
   - **Nueva Venta:** Permite iniciar una nueva transacción de venta.  
   - **Libros:** Gestiona el inventario de libros (agregar, actualizar, o eliminar).  
   - **Usuarios:** Permite gestionar los usuarios del sistema (solo disponible para Administradores).  
   - **Clientes:** Registra y administra los datos de los clientes.  
   - **Registro de ventas:** Muestra un historial detallado de las transacciones realizadas.

3. **Interfaz gráfica personalizada:**  
   - Incluye íconos y botones con estilo visual consistente.  
   - Diseñado para ofrecer una experiencia de usuario intuitiva y profesional.

4. **Conexión con la base de datos:**  
   - Utiliza la clase `conexion` para mantener una conexión activa con la base de datos.  
   - Permite consultar y actualizar la información en tiempo real.

#### **Componentes principales:**

- **Botones del menú:**  
  - `btnNuevaVenta`: Abre el módulo para iniciar una nueva venta.  
  - `btnProductos`: Redirige al módulo de gestión de libros.  
  - `btnUsuarios`: Gestiona los usuarios del sistema (solo Administradores).  
  - `btnUsuarios1`: Abre el módulo de gestión de clientes.  
  - `btnUsuarios2`: Muestra el registro de ventas.  
  - `jButton2`: Cierra la aplicación y la conexión a la base de datos.

- **Etiquetas:**  
  - `LabelVendedor`: Muestra el nombre del usuario autenticado.  
  - `tipo`: Indica el rol del usuario actual (Administrador o Cajero).


# Ventas2

![image](https://github.com/user-attachments/assets/7e50f979-60ad-4513-9af3-a8fa86efcf9f)


## Funcionalidades

- **Gestión de ventas**: Permite seleccionar libros del inventario y registrar las ventas realizadas.
- **Cálculo del total**: Calcula automáticamente el total a pagar en tiempo real.
- **Generación de recibos en PDF**: Crea recibos detallados con información del cliente, libros comprados y el monto total.
- **Envío de recibos por correo**: Envía automáticamente los recibos generados al correo electrónico del cliente.
- **Actualización de inventario**: Reduce el stock de los libros vendidos en la base de datos.
- **Validación de stock**: Asegura que haya suficiente stock antes de completar la venta.
- **Interfaz gráfica**: Incluye una interfaz amigable creada con `Swing` para facilitar la interacción del usuario.

## Tecnologías utilizadas

- **Java Swing**: Para la creación de la interfaz gráfica.
- **JDBC**: Para la conexión y gestión de la base de datos.
- **iText**: Para la generación de recibos en formato PDF.
- **JavaMail API**: Para el envío de correos electrónicos.
- **Base de datos SQL**: Para almacenar y gestionar información sobre clientes, libros e inventarios.

#CRUD del sistema

Este proyecto presenta el patron CRUD, que nos ayudara a la administracion de libros, clientes, usuarios(cajero y administrador).

# Libro Inventario

![image](https://github.com/user-attachments/assets/8fe5fd9e-56f0-4139-ab15-d2657320a8ea)

# Registro Usuario

![image](https://github.com/user-attachments/assets/c4aaad01-da72-4b43-b7e6-633647a057c6)

# Registro Cliente

![image](https://github.com/user-attachments/assets/89f96fbd-1e85-4bb4-8f5b-0f548efcc4df)

# Registro Usuario

![image](https://github.com/user-attachments/assets/05940771-5c75-4717-8eb9-a44e18ecf9b5)


Este proyecto implementa un sistema de gestión de inventario de libros, Usuarios y Clientes mediante una interfaz gráfica en Java. Permite registrar, consultar, editar y eliminar información de libros almacenados en una base de datos. Las principales funcionalidades incluyen:

- **Validación de datos**: Asegura que la información ingresada sea consistente (ISBN, stock, título, autor, etc.).
- **Roles de usuario**: Restringe accesos a funciones específicas según el tipo de usuario (Cajero, Administrador, etc.).
- **Operaciones CRUD**: Soporta operaciones para manejar el ciclo de vida de los datos de los libros.
- **Conexión con base de datos**: Usa JDBC para interactuar con una base de datos SQL.


## Demostración del Proyecto

https://github.com/user-attachments/assets/5f0303dd-4c0b-4e9d-929b-b2bfa1e4565a
