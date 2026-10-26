package menus;
import java.util.Scanner;

public class Main {

        static Scanner sc = new Scanner(System.in);

        // Capacidad maxima de los arreglos
        static final int MAX = 100;

        // Arreglos de usuarios
        static int[] idUsuarios = new int[MAX];
        static String[] nombres = new String[MAX];
        static String[] apellidos = new String[MAX];
        static String[] documentos = new String[MAX];
        static String[] telefonos = new String[MAX];
        static String[] correos = new String[MAX];
        static String[] nombresUsuario = new String[MAX];
        static String[] claves = new String[MAX];

        static int totalUsuarios = 0;
        static int consecutivoUsuario = 1001;

        // Arreglos de productos
        static int[] codProductos = new int[MAX];
        static String[] nomProductos = new String[MAX];
        static String[] catProductos = new String[MAX];
        static String[] descProductos = new String[MAX];
        static double[] precioProductos = new double[MAX];
        static int[] stockProductos = new int[MAX];
        static int totalProductos = 0;

        // Arreglos de servicios
        static int[] codServicios = new int[MAX];
        static String[] nomServicios = new String[MAX];
        static String[] descServicios = new String[MAX];
        static double[] precioServicios = new double[MAX];
        static int totalServicios = 0;

        // Arreglos de ventas y facturas
        static int[] numFacturas = new int[MAX];
        static int[] clienteFactura = new int[MAX];
        static int[] productoFactura = new int[MAX];
        static int[] cantidadFactura = new int[MAX];
        static double[] totalFactura = new double[MAX];
        static int totalVentas = 0;

        static int consecutivoFactura = 1001;

        public static void main(String[] args) {

            cargarDatosIniciales();

            int opcion;

            do {
                System.out.println("\n======================================");
                System.out.println(" HOWLS ACCESORIOS BABY");
                System.out.println(" Sistema de Administracion de Tienda");
                System.out.println("======================================");
                System.out.println("1. Ingresar como administrador");
                System.out.println("2. Ingresar como cliente");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        iniciarSesionAdministrador();
                        break;

                    case 2:
                        menuAccesoCliente();
                        break;

                    case 3:
                        System.out.println("Gracias por utilizar el sistema.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 3);

            sc.close();
        }

        // =========================================
        // DATOS INICIALES
        // =========================================

        static void cargarDatosIniciales() {

            // Productos de ejemplo
            agregarProductoInicial(101, "Sets y Conjuntos", "Dulce Comienzo",
                    "Bodys y mamelucos para crear looks dulces y cómodos", 58000, 20);

            agregarProductoInicial(102, "Pijamas", "Estrellitas Baby",
                    "Prendas para acompañar los momentos de descanso", 42000, 10);

            agregarProductoInicial(103, "Ropa Casual", "Pequeños Exploradores",
                    "Ropa para jugar y descubrir el mundo", 75000, 15);

            // Servicio de ejemplo
            codServicios[0] = 201;
            nomServicios[0] = "Empaque de regalo";
            descServicios[0] = "Empaque especial para regalo";
            precioServicios[0] = 5000;
            totalServicios = 1;

        }

        static void agregarProductoInicial(int codigo, String nombre,
                                           String categoria, String descripcion,
                                           double precio, int stock) {

            codProductos[totalProductos] = codigo;
            nomProductos[totalProductos] = nombre;
            catProductos[totalProductos] = categoria;
            descProductos[totalProductos] = descripcion;
            precioProductos[totalProductos] = precio;
            stockProductos[totalProductos] = stock;
            totalProductos++;
        }

        // =========================================
        // INICIO DE SESION ADMINISTRADOR
        // =========================================

        static void iniciarSesionAdministrador() {

            System.out.print("Usuario administrador: ");
            String usuario = sc.nextLine();

            System.out.print("Contrasena: ");
            String clave = sc.nextLine();

            if (usuario.equals("admin") && clave.equals("admin123")) {
                System.out.println("Inicio de sesion exitoso.");
                menuAdministrador();
            } else {
                System.out.println("Usuario o contrasena incorrectos.");
            }
        }

        // =========================================
        // MENU ADMINISTRADOR
        // =========================================

        static void menuAdministrador() {

            int opcion;

            do {
                System.out.println("\n========== MENU ADMINISTRADOR ==========");
                System.out.println("1. Administrar usuarios");
                System.out.println("2. Administrar productos");
                System.out.println("3. Administrar servicios");
                System.out.println("4. Consultar ventas y facturas");
                System.out.println("5. Informes");
                System.out.println("6. Cerrar sesion");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        menuUsuarios();
                        break;

                    case 2:
                        menuProductos();
                        break;

                    case 3:
                        menuServicios();
                        break;

                    case 4:
                        menuVentasAdministrador();
                        break;

                    case 5:
                        menuInformes();
                        break;

                    case 6:
                        System.out.println("Sesion de administrador cerrada.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 6);
        }

        // =========================================
        // CRUD DE USUARIOS
        // =========================================

        static void menuUsuarios() {

            int opcion;

            do {
                System.out.println("\n========== ADMINISTRAR USUARIOS ==========");
                System.out.println("1. Registrar usuario");
                System.out.println("2. Listar usuarios");
                System.out.println("3. Modificar usuario");
                System.out.println("4. Eliminar usuario");
                System.out.println("5. Regresar");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;

                    case 2:
                        listarUsuarios();
                        break;

                    case 3:
                        modificarUsuario();
                        break;

                    case 4:
                        eliminarUsuario();
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 5);
        }


    static void registrarUsuario() {

        if (totalUsuarios >= MAX) {
            System.out.println("No hay espacio para mas usuarios.");
            return;
        }

        System.out.println("\n========== REGISTRO DE USUARIO ==========");

        System.out.print("Nombres: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Apellidos: ");
        String apellido = sc.nextLine().trim();

        System.out.print("Numero de documento: ");
        String documento = sc.nextLine().trim();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine().trim();

        System.out.print("Correo electronico: ");
        String correo = sc.nextLine().trim();

        System.out.print("Crea un nombre de usuario: ");
        String usuario = sc.nextLine().trim();

        // Verificar que el nombre de usuario no exista
        if (buscarNombreUsuario(usuario) != -1) {
            System.out.println("Ese nombre de usuario ya esta registrado.");
            return;
        }

        // Verificar que el documento no este registrado
        for (int i = 0; i < totalUsuarios; i++) {
            if (documentos[i].equals(documento)) {
                System.out.println("Ese documento ya esta registrado.");
                return;
            }
        }

        System.out.print("Crea una contrasena: ");
        String clave = sc.nextLine();

        if (nombre.isEmpty() || apellido.isEmpty()
                || documento.isEmpty() || telefono.isEmpty()
                || correo.isEmpty() || usuario.isEmpty()
                || clave.isEmpty()) {

            System.out.println("Todos los campos son obligatorios.");
            return;
        }

        // Guardar la informacion
        idUsuarios[totalUsuarios] = consecutivoUsuario;
        nombres[totalUsuarios] = nombre;
        apellidos[totalUsuarios] = apellido;
        documentos[totalUsuarios] = documento;
        telefonos[totalUsuarios] = telefono;
        correos[totalUsuarios] = correo;
        nombresUsuario[totalUsuarios] = usuario;
        claves[totalUsuarios] = clave;

        System.out.println("\n¡Registro exitoso!");
        System.out.println("Tu ID de usuario es: " + consecutivoUsuario);
        System.out.println("Tu nombre de usuario es: " + usuario);

        totalUsuarios++;
        consecutivoUsuario++;
    }

    static int buscarNombreUsuario(String usuario) {

        for (int i = 0; i < totalUsuarios; i++) {
            if (nombresUsuario[i].equalsIgnoreCase(usuario)) {
                return i;
            }
        }

        return -1;
    }


    static void listarUsuarios() {

            System.out.println("\n========== LISTA DE USUARIOS ==========");

             if (totalUsuarios == 0) {
             System.out.println("No hay usuarios registrados.");
             } else {
             for (int i = 0; i < totalUsuarios; i++) {
                System.out.println("------------------------------");
                System.out.println("ID: " + idUsuarios[i]);
                System.out.println("Nombres: " + nombres[i]);
                System.out.println("Apellidos: " + apellidos[i]);
                System.out.println("Documento: " + documentos[i]);
                System.out.println("Telefono: " + telefonos[i]);
                System.out.println("Correo: " + correos[i]);
                System.out.println("Usuario: " + nombresUsuario[i]);
            }
        }
    }

        static void modificarUsuario() {

            System.out.print("Ingrese el ID del usuario: ");
            int id = leerEntero();

            int pos = buscarUsuario(id);

            if (pos == -1) {
                System.out.println("Usuario no encontrado.");
            } else {
                System.out.print("Nuevos nombres: ");
                nombres[pos] = sc.nextLine();

                System.out.print("Nuevos apellidos: ");
                apellidos[pos] = sc.nextLine();

                System.out.print("Nuevo correo: ");
                correos[pos] = sc.nextLine();

                System.out.print("Nueva contrasena: ");
                claves[pos] = sc.nextLine();

                System.out.println("Usuario modificado correctamente.");
            }
        }

        static void eliminarUsuario() {

            System.out.print("Ingrese el ID del usuario: ");
            int id = leerEntero();

            int pos = buscarUsuario(id);

            if (pos == -1) {
                System.out.println("Usuario no encontrado.");
            } else {
                if (idUsuarios[pos] == 1001) {
                    System.out.println("No se puede eliminar el cliente de prueba.");
                    return;
                }

                for (int i = pos; i < totalUsuarios - 1; i++) {
                    idUsuarios[i] = idUsuarios[i + 1];
                    nombres[i] = nombres[i + 1];
                    apellidos[i] = apellidos[i + 1];
                    correos[i] = correos[i + 1];
                    claves[i] = claves[i + 1];
                    documentos[i] = documentos[i + 1];
                    telefonos[i] = telefonos[i + 1];
                    nombresUsuario[i] = nombresUsuario[i + 1];
                }

                totalUsuarios--;
                System.out.println("Usuario eliminado correctamente.");
            }
        }

        static int buscarUsuario(int id) {

            for (int i = 0; i < totalUsuarios; i++) {
                if (idUsuarios[i] == id) {
                    return i;
                }
            }

            return -1;
        }

        // =========================================
        // CRUD DE PRODUCTOS
        // =========================================

        static void menuProductos() {

            int opcion;

            do {
                System.out.println("\n========== ADMINISTRAR PRODUCTOS ==========");
                System.out.println("1. Registrar producto");
                System.out.println("2. Listar productos");
                System.out.println("3. Modificar producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Regresar");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        registrarProducto();
                        break;

                    case 2:
                        listarProductos();
                        break;

                    case 3:
                        modificarProducto();
                        break;

                    case 4:
                        eliminarProducto();
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 5);
        }

        static void registrarProducto() {

            if (totalProductos >= MAX) {
                System.out.println("No hay espacio para mas productos.");
                return;
            }

            System.out.print("Codigo del producto: ");
            int codigo = leerEntero();

            if (buscarProducto(codigo) != -1) {
                System.out.println("Ese codigo ya existe.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Categoria: ");
            String categoria = sc.nextLine();

            System.out.print("Descripcion: ");
            String descripcion = sc.nextLine();

            System.out.print("Precio: ");
            double precio = leerDouble();

            if (precio < 0) {
                System.out.println("El precio no puede ser negativo.");
                return;
            }

            System.out.print("Cantidad en inventario: ");
            int stock = leerEntero();

            if (stock < 0) {
                System.out.println("El inventario no puede ser negativo.");
                return;
            }

            codProductos[totalProductos] = codigo;
            nomProductos[totalProductos] = nombre;
            catProductos[totalProductos] = categoria;
            descProductos[totalProductos] = descripcion;
            precioProductos[totalProductos] = precio;
            stockProductos[totalProductos] = stock;

            totalProductos++;

            System.out.println("Producto registrado correctamente.");
        }

        static void listarProductos() {

            System.out.println("\n========== INVENTARIO DE PRODUCTOS ==========");

            if (totalProductos == 0) {
                System.out.println("No hay productos registrados.");
            } else {
                for (int i = 0; i < totalProductos; i++) {
                    System.out.println("--------------------------------");
                    System.out.println("Codigo: " + codProductos[i]);
                    System.out.println("Nombre: " + nomProductos[i]);
                    System.out.println("Categoria: " + catProductos[i]);
                    System.out.println("Descripcion: " + descProductos[i]);
                    System.out.println("Precio: $" + precioProductos[i]);
                    System.out.println("Stock: " + stockProductos[i]);
                }
            }
        }

        static void modificarProducto() {

            System.out.print("Codigo del producto que desea modificar: ");
            int codigo = leerEntero();

            int pos = buscarProducto(codigo);

            if (pos == -1) {
                System.out.println("Producto no encontrado.");
            } else {
                System.out.print("Nuevo nombre: ");
                nomProductos[pos] = sc.nextLine();

                System.out.print("Nueva categoria: ");
                catProductos[pos] = sc.nextLine();

                System.out.print("Nueva descripcion: ");
                descProductos[pos] = sc.nextLine();

                System.out.print("Nuevo precio: ");
                double precio = leerDouble();

                if (precio < 0) {
                    System.out.println("Precio invalido. Se conserva el anterior.");
                } else {
                    precioProductos[pos] = precio;
                }

                System.out.print("Nuevo stock: ");
                int stock = leerEntero();

                if (stock < 0) {
                    System.out.println("Stock invalido. Se conserva el anterior.");
                } else {
                    stockProductos[pos] = stock;
                }

                System.out.println("Proceso de modificacion finalizado.");
            }
        }

        static void eliminarProducto() {

            System.out.print("Codigo del producto que desea eliminar: ");
            int codigo = leerEntero();

            int pos = buscarProducto(codigo);

            if (pos == -1) {
                System.out.println("Producto no encontrado.");
            } else {
                for (int i = pos; i < totalProductos - 1; i++) {
                    codProductos[i] = codProductos[i + 1];
                    nomProductos[i] = nomProductos[i + 1];
                    catProductos[i] = catProductos[i + 1];
                    descProductos[i] = descProductos[i + 1];
                    precioProductos[i] = precioProductos[i + 1];
                    stockProductos[i] = stockProductos[i + 1];
                }

                totalProductos--;
                System.out.println("Producto eliminado correctamente.");
            }
        }

        static int buscarProducto(int codigo) {

            for (int i = 0; i < totalProductos; i++) {
                if (codProductos[i] == codigo) {
                    return i;
                }
            }

            return -1;
        }

        // =========================================
        // CRUD DE SERVICIOS
        // =========================================

        static void menuServicios() {

            int opcion;

            do {
                System.out.println("\n========== ADMINISTRAR SERVICIOS ==========");
                System.out.println("1. Registrar servicio");
                System.out.println("2. Listar servicios");
                System.out.println("3. Modificar servicio");
                System.out.println("4. Eliminar servicio");
                System.out.println("5. Regresar");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        registrarServicio();
                        break;

                    case 2:
                        listarServicios();
                        break;

                    case 3:
                        modificarServicio();
                        break;

                    case 4:
                        eliminarServicio();
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 5);
        }

        static void registrarServicio() {

            if (totalServicios >= MAX) {
                System.out.println("No hay espacio para mas servicios.");
                return;
            }

            System.out.print("Codigo del servicio: ");
            int codigo = leerEntero();

            if (buscarServicio(codigo) != -1) {
                System.out.println("Ese codigo ya existe.");
                return;
            }

            System.out.print("Nombre del servicio: ");
            String nombre = sc.nextLine();

            System.out.print("Descripcion: ");
            String descripcion = sc.nextLine();

            System.out.print("Precio del servicio: ");
            double precio = leerDouble();

            if (precio < 0) {
                System.out.println("El precio no puede ser negativo.");
                return;
            }

            codServicios[totalServicios] = codigo;
            nomServicios[totalServicios] = nombre;
            descServicios[totalServicios] = descripcion;
            precioServicios[totalServicios] = precio;

            totalServicios++;

            System.out.println("Servicio registrado correctamente.");
        }

        static void listarServicios() {

            System.out.println("\n========== LISTA DE SERVICIOS ==========");

            if (totalServicios == 0) {
                System.out.println("No hay servicios registrados.");
            } else {
                for (int i = 0; i < totalServicios; i++) {
                    System.out.println("--------------------------------");
                    System.out.println("Codigo: " + codServicios[i]);
                    System.out.println("Nombre: " + nomServicios[i]);
                    System.out.println("Descripcion: " + descServicios[i]);
                    System.out.println("Precio: $" + precioServicios[i]);
                }
            }
        }

        static void modificarServicio() {

            System.out.print("Codigo del servicio que desea modificar: ");
            int codigo = leerEntero();

            int pos = buscarServicio(codigo);

            if (pos == -1) {
                System.out.println("Servicio no encontrado.");
            } else {
                System.out.print("Nuevo nombre: ");
                nomServicios[pos] = sc.nextLine();

                System.out.print("Nueva descripcion: ");
                descServicios[pos] = sc.nextLine();

                System.out.print("Nuevo precio: ");
                double precio = leerDouble();

                if (precio >= 0) {
                    precioServicios[pos] = precio;
                    System.out.println("Servicio modificado correctamente.");
                } else {
                    System.out.println("Precio invalido. No se modifico el precio.");
                }
            }
        }

        static void eliminarServicio() {

            System.out.print("Codigo del servicio que desea eliminar: ");
            int codigo = leerEntero();

            int pos = buscarServicio(codigo);

            if (pos == -1) {
                System.out.println("Servicio no encontrado.");
            } else {
                for (int i = pos; i < totalServicios - 1; i++) {
                    codServicios[i] = codServicios[i + 1];
                    nomServicios[i] = nomServicios[i + 1];
                    descServicios[i] = descServicios[i + 1];
                    precioServicios[i] = precioServicios[i + 1];
                }

                totalServicios--;
                System.out.println("Servicio eliminado correctamente.");
            }
        }

        static int buscarServicio(int codigo) {

            for (int i = 0; i < totalServicios; i++) {
                if (codServicios[i] == codigo) {
                    return i;
                }
            }

            return -1;
        }

        // =========================================
        // ACCESO DE CLIENTES
        // =========================================

        static void menuAccesoCliente() {

            int opcion;

            do {
                System.out.println("\n========== MENU DE CLIENTES ==========");
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesion");
                System.out.println("3. Regresar");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;

                    case 2:
                        iniciarSesionCliente();
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 3);
        }


        static void iniciarSesionCliente() {

         System.out.println("\n========== INICIAR SESION ==========");

         System.out.print("Nombre de usuario: ");
         String usuario = sc.nextLine().trim();

         System.out.print("Contrasena: ");
         String clave = sc.nextLine();

         int pos = buscarNombreUsuario(usuario);

         if (pos == -1) {
            System.out.println("El nombre de usuario no esta registrado.");
         } else if (claves[pos].equals(clave)) {
            System.out.println("Bienvenido/a " + nombres[pos] + ".");
            menuCliente(idUsuarios[pos]);
         } else {
            System.out.println("Contrasena incorrecta.");
        }
    }


    // =========================================
        // MENU DEL CLIENTE
        // =========================================

        static void menuCliente(int idCliente) {

            int opcion;

            do {
                System.out.println("\n========== MENU DEL CLIENTE ==========");
                System.out.println("1. Ver mis datos");
                System.out.println("2. Modificar mis datos");
                System.out.println("3. Ver productos disponibles");
                System.out.println("4. Comprar producto");
                System.out.println("5. Consultar una factura");
                System.out.println("6. Ver mi historial de compras");
                System.out.println("7. Cerrar sesion");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        verDatosCliente(idCliente);
                        break;

                    case 2:
                        modificarDatosCliente(idCliente);
                        break;

                    case 3:
                        listarProductos();
                        break;

                    case 4:
                        comprarProducto(idCliente);
                        break;

                    case 5:
                        consultarFacturaCliente(idCliente);
                        break;

                    case 6:
                        historialComprasCliente(idCliente);
                        break;

                    case 7:
                        System.out.println("Sesion cerrada.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 7);
        }


        static void verDatosCliente(int idCliente) {

           int pos = buscarUsuario(idCliente);

           if (pos != -1) {
            System.out.println("\n========== MI PERFIL ==========");
            System.out.println("ID: " + idUsuarios[pos]);
            System.out.println("Nombres: " + nombres[pos]);
            System.out.println("Apellidos: " + apellidos[pos]);
            System.out.println("Documento: " + documentos[pos]);
            System.out.println("Telefono: " + telefonos[pos]);
            System.out.println("Correo: " + correos[pos]);
            System.out.println("Nombre de usuario: " + nombresUsuario[pos]);
            System.out.println("Contrasena: ********");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }



    static void modificarDatosCliente(int idCliente) {

        int pos = buscarUsuario(idCliente);

        if (pos == -1) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.println("\n========== MODIFICAR PERFIL ==========");
        System.out.println("1. Modificar nombres");
        System.out.println("2. Modificar apellidos");
        System.out.println("3. Modificar telefono");
        System.out.println("4. Modificar correo");
        System.out.println("5. Modificar nombre de usuario");
        System.out.println("6. Cambiar contrasena");
        System.out.println("7. Regresar");
        System.out.print("Seleccione una opcion: ");

        int opcion = leerEntero();

        switch (opcion) {
            case 1:
                System.out.print("Nuevos nombres: ");
                nombres[pos] = sc.nextLine().trim();
                break;

            case 2:
                System.out.print("Nuevos apellidos: ");
                apellidos[pos] = sc.nextLine().trim();
                break;

            case 3:
                System.out.print("Nuevo telefono: ");
                telefonos[pos] = sc.nextLine().trim();
                break;

            case 4:
                System.out.print("Nuevo correo: ");
                correos[pos] = sc.nextLine().trim();
                break;

            case 5:
                System.out.print("Nuevo nombre de usuario: ");
                String nuevoUsuario = sc.nextLine().trim();

                int existente = buscarNombreUsuario(nuevoUsuario);

                if (existente != -1 && existente != pos) {
                    System.out.println("Ese nombre de usuario ya existe.");
                } else if (nuevoUsuario.isEmpty()) {
                    System.out.println("El nombre de usuario no puede estar vacio.");
                } else {
                    nombresUsuario[pos] = nuevoUsuario;
                    System.out.println("Nombre de usuario actualizado.");
                }
                break;

            case 6:
                System.out.print("Nueva contrasena: ");
                String nuevaClave = sc.nextLine();

                if (nuevaClave.isEmpty()) {
                    System.out.println("La contrasena no puede estar vacia.");
                } else {
                    claves[pos] = nuevaClave;
                    System.out.println("Contrasena actualizada.");
                }
                break;

            case 7:
                break;

            default:
                System.out.println("Opcion no valida.");
        }
    }


    // =========================================
        // COMPRAS Y FACTURAS
        // =========================================

        static void comprarProducto(int idCliente) {

            if (totalVentas >= MAX) {
                System.out.println("No se pueden registrar mas ventas.");
                return;
            }

            listarProductos();

            System.out.print("\nIngrese el codigo del producto que desea comprar: ");
            int codigo = leerEntero();

            int pos = buscarProducto(codigo);

            if (pos == -1) {
                System.out.println("Producto no encontrado.");
                return;
            }

            if (stockProductos[pos] <= 0) {
                System.out.println("Este producto no tiene unidades disponibles.");
                return;
            }

            System.out.print("Cantidad que desea comprar: ");
            int cantidad = leerEntero();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
            } else if (cantidad > stockProductos[pos]) {
                System.out.println("No hay suficiente inventario.");
                System.out.println("Unidades disponibles: " + stockProductos[pos]);
            } else {
                double total = precioProductos[pos] * cantidad;

                // Descontar unidades del inventario
                stockProductos[pos] = stockProductos[pos] - cantidad;

                // Guardar la venta y generar factura
                numFacturas[totalVentas] = consecutivoFactura;
                clienteFactura[totalVentas] = idCliente;
                productoFactura[totalVentas] = codigo;
                cantidadFactura[totalVentas] = cantidad;
                totalFactura[totalVentas] = total;

                totalVentas++;

                System.out.println("\nCompra realizada correctamente.");
                mostrarFactura(consecutivoFactura);
                consecutivoFactura++;
            }
        }

        static void mostrarFactura(int numero) {

            int pos = buscarFactura(numero);

            if (pos == -1) {
                System.out.println("Factura no encontrada.");
            } else {
                int posProducto = buscarProducto(productoFactura[pos]);

                System.out.println("\n========== FACTURA HOWLS ACCESORIOS BABY ==========");
                System.out.println("Numero de factura: " + numFacturas[pos]);
                System.out.println("ID del cliente: " + clienteFactura[pos]);

                if (posProducto != -1) {
                    System.out.println("Producto: " + nomProductos[posProducto]);
                    System.out.println("Precio unitario: $" + precioProductos[posProducto]);
                } else {
                    System.out.println("Codigo del producto: " + productoFactura[pos]);
                    System.out.println("El producto ya no esta en el inventario.");
                }

                System.out.println("Cantidad: " + cantidadFactura[pos]);
                System.out.println("TOTAL: $" + totalFactura[pos]);
                System.out.println("===================================================");
            }
        }

        static int buscarFactura(int numero) {

            for (int i = 0; i < totalVentas; i++) {
                if (numFacturas[i] == numero) {
                    return i;
                }
            }

            return -1;
        }

        static void consultarFacturaCliente(int idCliente) {

            System.out.print("Ingrese el numero de factura: ");
            int numero = leerEntero();

            int pos = buscarFactura(numero);

            if (pos == -1) {
                System.out.println("Factura no encontrada.");
            } else if (clienteFactura[pos] != idCliente) {
                System.out.println("No puede consultar facturas de otro cliente.");
            } else {
                mostrarFactura(numero);
            }
        }

        static void historialComprasCliente(int idCliente) {

            boolean encontrada = false;

            System.out.println("\n========== MI HISTORIAL DE COMPRAS ==========");

            for (int i = 0; i < totalVentas; i++) {
                if (clienteFactura[i] == idCliente) {
                    System.out.println("--------------------------------");
                    System.out.println("Factura: " + numFacturas[i]);
                    System.out.println("Codigo del producto: " + productoFactura[i]);
                    System.out.println("Cantidad: " + cantidadFactura[i]);
                    System.out.println("Total: $" + totalFactura[i]);

                    encontrada = true;
                }
            }

            if (!encontrada) {
                System.out.println("Todavia no tienes compras registradas.");
            }
        }

        // =========================================
        // VENTAS PARA EL ADMINISTRADOR
        // =========================================

        static void menuVentasAdministrador() {

            int opcion;

            do {
                System.out.println("\n========== VENTAS Y FACTURAS ==========");
                System.out.println("1. Ver todas las ventas");
                System.out.println("2. Buscar factura");
                System.out.println("3. Regresar");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        listarTodasLasVentas();
                        break;

                    case 2:
                        System.out.print("Numero de factura: ");
                        int numero = leerEntero();
                        mostrarFactura(numero);
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 3);
        }

        static void listarTodasLasVentas() {

            System.out.println("\n========== TODAS LAS VENTAS ==========");

            if (totalVentas == 0) {
                System.out.println("No hay ventas registradas.");
            } else {
                for (int i = 0; i < totalVentas; i++) {
                    System.out.println("--------------------------------");
                    System.out.println("Factura: " + numFacturas[i]);
                    System.out.println("Cliente: " + clienteFactura[i]);
                    System.out.println("Producto: " + productoFactura[i]);
                    System.out.println("Cantidad: " + cantidadFactura[i]);
                    System.out.println("Total: $" + totalFactura[i]);
                }
            }
        }

        // =========================================
        // INFORMES
        // =========================================

        static void menuInformes() {

            int opcion;

            do {
                System.out.println("\n========== INFORMES ==========");
                System.out.println("1. Inventario completo");
                System.out.println("2. Productos con poco inventario");
                System.out.println("3. Total de ventas");
                System.out.println("4. Ingresos acumulados");
                System.out.println("5. Cantidad de usuarios");
                System.out.println("6. Regresar");
                System.out.print("Seleccione una opcion: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        listarProductos();
                        break;

                    case 2:
                        informePocoInventario();
                        break;

                    case 3:
                        System.out.println("Cantidad de ventas realizadas: " + totalVentas);
                        break;

                    case 4:
                        informeIngresos();
                        break;

                    case 5:
                        System.out.println("Usuarios registrados: " + totalUsuarios);
                        break;

                    case 6:
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 6);
        }

        static void informePocoInventario() {

            boolean encontrado = false;

            System.out.println("\n========== PRODUCTOS CON POCO INVENTARIO ==========");

            for (int i = 0; i < totalProductos; i++) {
                if (stockProductos[i] <= 5) {
                    System.out.println("Producto: " + nomProductos[i]);
                    System.out.println("Codigo: " + codProductos[i]);
                    System.out.println("Unidades restantes: " + stockProductos[i]);

                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No hay productos con cinco unidades o menos.");
            }
        }

        static void informeIngresos() {

            double ingresos = 0;

            for (int i = 0; i < totalVentas; i++) {
                ingresos = ingresos + totalFactura[i];
            }

            System.out.println("Ingresos acumulados: $" + ingresos);
        }

        // =========================================
        // FUNCIONES PARA LEER DATOS
        // =========================================

        static int leerEntero() {

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un numero entero valido: ");
                sc.nextLine();
            }

            int numero = sc.nextInt();
            sc.nextLine();

            return numero;
        }

        static double leerDouble() {

            while (!sc.hasNextDouble()) {
                System.out.print("Ingrese un valor numerico valido: ");
                sc.nextLine();
            }

            double numero = sc.nextDouble();
            sc.nextLine();

            return numero;
        }
    }
