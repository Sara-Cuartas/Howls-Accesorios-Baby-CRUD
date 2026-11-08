package menus;
import java.util.Scanner;

public class Main {

        static Scanner sc = new Scanner(System.in);

        // Capacidad máxima de los arreglos
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
        static double[] precioProductos = new double[MAX];
        static String[] descProductos = new String[MAX];
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
                System.out.println("\n********************************");
                System.out.println(" HOWL'S ACCESORIOS BABY");
                System.out.println(" Sistema de Administración de Tienda");
                System.out.println("**********************************");
                System.out.println("1. Ingresar como administrador");
                System.out.println("2. Ingresar como cliente");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

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
                        System.out.println("Opción no valida.");
                }

            } while (opcion != 3);

            sc.close();
        }

        // DATOS INICIALES //

        static void cargarDatosIniciales() {

            // Productos de ejemplo
            agregarProductoInicial(101, "Conjunto overol + blusa niña", "Dulce Comienzo",
                    "Sets y conjuntos para crear looks dulces y cómodos.", 65.000,38);

            agregarProductoInicial(102, "Conjunto buzo + pantalón bebé unisex", "Dulce Comienzo",
                    "Sets y conjuntos para crear looks dulces y cómodos.", 58.000,55);

            agregarProductoInicial(103, "Conjunto body + vestido algodón bebé niña", "Dulce Comienzo",
                    "Sets y conjuntos para crear looks dulces y cómodos.", 69.900,32);

            agregarProductoInicial(104, "Conjunto camiseta + bermuda Bluey niño", "Dulce Comienzo",
                    "Sets y conjuntos para crear looks dulces y cómodos.", 80.000,18);

            agregarProductoInicial(105, "Conjunto + peluche de apego bebé unisex", "Dulce Comienzo",
                    "Sets y conjuntos para crear looks dulces y cómodos.", 86.900,49);

            agregarProductoInicial(106, "Pijama algodón cierre doble sentido estampada bebé niña", "Estrellitas Baby",
                    "Prendas para acompañar los momentos de descanso.", 52.000,30);

            agregarProductoInicial(107, "Pijama algodón cierre doble sentido estampada bebé niño", "Estrellitas Baby",
                    "Prendas para acompañar los momentos de descanso.", 52.000,30);

            agregarProductoInicial(108, "Pijama algodón botones a presión x2unds surtida bebé unisex", "Estrellitas Baby",
                    "Prendas para acompañar los momentos de descanso.", 78.990,56);

            agregarProductoInicial(109, "Pijama buzo + pantalón algodón niña", "Estrellitas Baby",
                    "Prendas para acompañar los momentos de descanso.", 64.000,33);

            agregarProductoInicial(110, "Pijama buzo + pantalón algodón niño", "Estrellitas Baby",
                    "Prendas para acompañar los momentos de descanso.", 64.000,33);

            agregarProductoInicial(111, "Overol largo aplique bordado algodón café bebé niño", "Pequeños Exploradores",
                    "Ropa para jugar y descubrir el mundo.", 70.800,41);

            agregarProductoInicial(112, "Overol jardinera algodón índigo bebé niña", "Pequeños Exploradores",
                    "Ropa para jugar y descubrir el mundo.", 63.800,42);

            agregarProductoInicial(113, "Camiseta regular algodón x2unds surtida bebé niña", "Pequeños Exploradores",
                    "Ropa para jugar y descubrir el mundo.", 69.990,35);

            agregarProductoInicial(114, "Camiseta regular x2unds surtida bebé niño", "Pequeños Exploradores",
                    "Ropa para jugar y descubrir el mundo.", 69.990,35);

            agregarProductoInicial(115, "Polo oversize beige niño", "Pequeños Exploradores",
                    "Ropa para jugar y descubrir el mundo.", 54.990,30);

            agregarProductoInicial(116, "Vestido midi índigo claro niña", "Pequeños Exploradores",
                    "Ropa para jugar y descubrir el mundo.", 66.990,32);

            agregarProductoInicial(117, "Camibuso regular protección UV estampado niño", "Dulce Verano",
                    "Ideas para renovar el armario de los pequeños en los días más calurosos.", 48.6000,38);

            agregarProductoInicial(118, "Vestido de baño manga larga protección UV estampado niña", "Dulce Verano",
                    "Ideas para renovar el armario de los pequeños en los días más calurosos.", 70.990,39);

            agregarProductoInicial(119, "Vestido de baño 3 piezas protección UV estampado niña", "Dulce Verano",
                    "Ideas para renovar el armario de los pequeños en los días más calurosos.", 85.990,42);

            agregarProductoInicial(120, "Vestido de baño manga larga protección UV estampado bebé niña", "Dulce Verano",
                    "Ideas para renovar el armario de los pequeños en los días más calurosos.", 92.990,44);

            agregarProductoInicial(121, "Traje de baño protección UV 2 piezas estampado bebé niño", "Dulce Verano",
                    "Ideas para renovar el armario de los pequeños en los días más calurosos.", 94.990,45);

            agregarProductoInicial(122, "Gorro bebé unisex algodón x2unds surtido", "Pequeños Tesoros",
                    "Pequeños complementos para darle un toque especial a cada look.", 39.990,53);

            agregarProductoInicial(123, "Tenis casuales blanco niño", "Pequeños Tesoros",
                    "Pequeños complementos para darle un toque especial a cada look.", 70.000,30);

            agregarProductoInicial(124, "Medias con balaca bebé niña", "Pequeños Tesoros",
                    "Pequeños complementos para darle un toque especial a cada look.", 28.000,30);

            agregarProductoInicial(125, "Gorro bebé unisex lana x2unds surtido", "Pequeños Tesoros",
                    "Pequeños complementos para darle un toque especial a cada look.", 27.990,54);

            agregarProductoInicial(126, "Tenis New Balance niña y niño", "Pequeños Tesoros",
                    "Pequeños complementos para darle un toque especial a cada look.", 65.000,48);

            agregarProductoInicial(127, "Set de gafas y moños niña", "Pequeños Tesoros",
                    "Pequeños complementos para darle un toque especial a cada look.", 16.000,30);

            agregarProductoInicial(128, "Set recién nacido algodón bebé niña personalizado", "Regalos con Amor",
                    "Ideas para sorprender a los bebés y sus familias.", 170.990,60);

            agregarProductoInicial(129, "Set recién nacido algodón bebé niño personalizado", "Regalos con Amor",
                    "Ideas para sorprender a los bebés y sus familias.", 170.990,60);

            agregarProductoInicial(130, "Chaqueta textura peluche blanco bebé unisex", "Regalos con Amor",
                    "Ideas para sorprender a los bebés y sus familias.", 79.000,112);

            agregarProductoInicial(131, "Peluche de apego conejo", "Regalos con Amor",
                    "Ideas para sorprender a los bebés y sus familias.", 49.000,96);

            agregarProductoInicial(132, "Cobija para bebé + peluche de oso", "Regalos con Amor",
                    "Ideas para sorprender a los bebés y sus familias.", 82.000,79);

            // Servicio de ejemplo
            codServicios[0] = 201;
            nomServicios[0] = "Empaque de regalo";
            descServicios[0] = "Empaque especial personalizado para regalo";
            precioServicios[0] = 25000;
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


        // INICIO DE SESIÓN ADMINISTRADOR //

        static void iniciarSesionAdministrador() {

            System.out.print("Usuario administrador: ");
            String usuario = sc.nextLine();

            System.out.print("Contraseña: ");
            String clave = sc.nextLine();

            if (usuario.equals("admin") && clave.equals("admin123")) {
                System.out.println("Inicio de sesión exitoso.");
                menuAdministrador();
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
            }
        }

        // MENÚ ADMINISTRADOR //

        static void menuAdministrador() {

            int opcion;

            do {
                System.out.println("\n---------- MENÚ ADMINISTRADOR ----------");
                System.out.println("1. Administrar usuarios");
                System.out.println("2. Administrar productos");
                System.out.println("3. Administrar servicios");
                System.out.println("4. Consultar ventas y facturas");
                System.out.println("5. Informes");
                System.out.println("6. Cerrar sesión");
                System.out.print("Seleccione una opción: ");

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
                        System.out.println("Sesión de administrador cerrada.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } while (opcion != 6);
        }


        // CRUD DE USUARIOS //

        static void menuUsuarios() {

            int opcion;

            do {
                System.out.println("\n---------- ADMINISTRAR USUARIOS ----------");
                System.out.println("1. Registrar usuario");
                System.out.println("2. Listar usuarios");
                System.out.println("3. Modificar usuario");
                System.out.println("4. Eliminar usuario");
                System.out.println("5. Regresar");
                System.out.print("Seleccione una opción: ");

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
                        System.out.println("Opción no válida.");
                }

            } while (opcion != 5);
        }


    static void registrarUsuario() {

        if (totalUsuarios >= MAX) {
            System.out.println("No hay espacio para más usuarios.");
            return;
        }

        System.out.println("\n---------- REGISTRO DE USUARIO ----------");

        System.out.print("Nombres: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Apellidos: ");
        String apellido = sc.nextLine().trim();

        System.out.print("Número de documento: ");
        String documento = sc.nextLine().trim();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine().trim();

        System.out.print("Correo electrónico: ");
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

        System.out.print("Crea una contraseña: ");
        String clave = sc.nextLine();

        if (nombre.isEmpty() || apellido.isEmpty()
                || documento.isEmpty() || telefono.isEmpty()
                || correo.isEmpty() || usuario.isEmpty()
                || clave.isEmpty()) {

            System.out.println("Todos los campos son obligatorios.");
            return;
        }

        // Guardar la información
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

            System.out.println("\n---------- LISTA DE USUARIOS ----------");

             if (totalUsuarios == 0) {
             System.out.println("No hay usuarios registrados.");
             } else {
             for (int i = 0; i < totalUsuarios; i++) {
                System.out.println("------------------------------");
                System.out.println("ID: " + idUsuarios[i]);
                System.out.println("Nombres: " + nombres[i]);
                System.out.println("Apellidos: " + apellidos[i]);
                System.out.println("Documento: " + documentos[i]);
                System.out.println("Teléfono: " + telefonos[i]);
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
                System.out.print("Ingrese el nuevo nombre: ");
                nombres[pos] = sc.nextLine();

                System.out.print("Ingrese los nuevos apellidos: ");
                apellidos[pos] = sc.nextLine();

                System.out.print("Ingrese el nuevo correo: ");
                correos[pos] = sc.nextLine();

                System.out.print("Ingrese la nueva contraseña: ");
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

        // CRUD DE PRODUCTOS //

    // CRUD DE PRODUCTOS //

    static void menuProductos() {

        int opcion;

        do {
            System.out.println("\n---------- ADMINISTRAR PRODUCTOS ----------");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Ver productos por categoría");
            System.out.println("6. Regresar");
            System.out.print("Seleccione una opción: ");

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
                    menuCategorias();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Opción no valida.");
            }

        } while (opcion != 6);
    }

    static void menuCategorias() {

        int opcion;

        do {
            System.out.println("\n---------- CATEGORÍAS ----------");
            System.out.println("1. Dulce comienzo");
            System.out.println("2. Estrellitas Baby");
            System.out.println("3. Pequeños exploradores");
            System.out.println("4. Dulce verano");
            System.out.println("5. Pequeños tesoros");
            System.out.println("6. Regalos con amor");
            System.out.println("7. Regresar");
            System.out.print("Seleccione una categoría: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    categoriaDulceComienzo();
                    break;

                case 2:
                    categoriaEstrellitasBaby();
                    break;

                case 3:
                    categoriaPequeñosExploradores();
                    break;

                case 4:
                    categoriaDulceVerano();
                    break;

                case 5:
                    categoriaPequeñosTesoros();
                    break;

                case 6:
                    categoriaRegalosConAmor();
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Opción no valida.");
            }

        } while (opcion != 7);
    }

    static void categoriaDulceComienzo() {

        System.out.println("\n---------- DULCE COMIENZO ----------");

        System.out.println("\nProducto: Conjunto overol + blusa niña");
        System.out.println("Precio: $65.000");
        System.out.println("Tallas: 6/9 9/12 12/18 18/24 24/36 36/48 meses");

        System.out.println("\nProducto: Conjunto buzo + pantalón bebé unisex");
        System.out.println("Precio: $58.000");
        System.out.println("Tallas: 0/3 3/6 6/9 meses");

        System.out.println("\nProducto: Conjunto body + vestido algodón bebé niña");
        System.out.println("Precio: $69.900");
        System.out.println("Tallas: 0/3 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Conjunto camiseta + bermuda Bluey niño");
        System.out.println("Precio: $80.000");
        System.out.println("Tallas: 12/18M 18/24M 2T 4T 5T 6T");

        System.out.println("\nProducto: Conjunto + peluche de apego bebé unisex");
        System.out.println("Precio: $86.900");
        System.out.println("Tallas: 0/3 3/6 6/9 meses");
    }

    static void categoriaEstrellitasBaby() {

        System.out.println("\n---------- ESTRELLITAS BABY ----------");

        System.out.println("\nProducto: Pijama algodón cierre doble sentido estampada bebé niña");
        System.out.println("Precio: $52.000");
        System.out.println("Tallas: 0/0 0/3 3/6 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Pijama algodón cierre doble sentido estampada bebé niño");
        System.out.println("Precio: $52.000");
        System.out.println("Tallas: 0/0 0/3 3/6 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Pijama algodón botones a presión x2unds surtida bebé unisex");
        System.out.println("Precio: $78.990");
        System.out.println("Tallas: 0/3 3/6 6/9 9/12 12/18 meses");

        System.out.println("\nProducto: Pijama buzo + pantalón algodón niña");
        System.out.println("Precio: $64.000");
        System.out.println("Tallas: 12/18M 18/24M 2T 3T 4T 5T 6T");

        System.out.println("\nProducto: Pijama buzo + pantalón algodón niño");
        System.out.println("Precio: $64.000");
        System.out.println("Tallas: 18/24M 2T 3T 4T 5T 6T");
    }

    static void categoriaPequeñosExploradores() {

        System.out.println("\n---------- PEQUEÑOS EXPLORADORES ----------");

        System.out.println("\nProducto: Overol largo aplique bordado algodón cafe bebé niño");
        System.out.println("Precio: $70.800");
        System.out.println("Tallas: 0/3 3/6 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Overol jardinera algodón índigo bebé niña");
        System.out.println("Precio: $63.800");
        System.out.println("Tallas: 0/3 3/6 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Camiseta regular algodón x2unds surtida bebé niña");
        System.out.println("Precio: $69.990");
        System.out.println("Tallas: 0/3 3/6 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Camiseta regular x2unds surtida bebé niño");
        System.out.println("Precio: $69.990");
        System.out.println("Tallas: 0/3 3/6 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Polo oversize beige niño");
        System.out.println("Precio: $54.990");
        System.out.println("Tallas: 18/24M 2T 3T 4T 5T 6T");

        System.out.println("\nProducto: Vestido midi indigo claro niña");
        System.out.println("Precio: $66.990");
        System.out.println("Tallas: 18/24M 2T 3T 4T 5T 6T");
    }

    static void categoriaDulceVerano() {

        System.out.println("\n---------- DULCE VERANO ----------");

        System.out.println("\nProducto: Camibuso regular protección UV estampado niño");
        System.out.println("Precio: $48.600");
        System.out.println("Tallas: 18/24M 2T 3T 4T 5T 6T");

        System.out.println("\nProducto: Vestido de baño manga larga protección UV estampado niña");
        System.out.println("Precio: $70.990");
        System.out.println("Tallas: 12/18M 18/24M 2T 3T 4T 5T 6T");

        System.out.println("\nProducto: Vestido de baño 3 piezas protección UV estampado niña");
        System.out.println("Precio: $85.990");
        System.out.println("Tallas: 12/18M 18/24M 2T 3T 4T 5T 6T");

        System.out.println("\nProducto: Vestido de baño manga larga protección UV estampado bebé niña");
        System.out.println("Precio: $92.990");
        System.out.println("Tallas: 6/9 9/12 12/18 18/24 meses");

        System.out.println("\nProducto: Traje de baño protección UV 2 piezas estampado bebé niño");
        System.out.println("Precio: $94.990");
        System.out.println("Tallas: 6/9 9/12 12/18 18/24 meses");
    }

    static void categoriaPequeñosTesoros() {

        System.out.println("\n---------- PEQUEÑOS TESOROS ----------");

        System.out.println("\nProducto: Gorro bebé unisex algodón x2unds surtido");
        System.out.println("Precio: $39.990");
        System.out.println("Tallas: 0/0 0/3 3/6 6/9 meses");

        System.out.println("\nProducto: Tenis casuales blanco niño");
        System.out.println("Precio: $70.000");
        System.out.println("Tallas: 19/20/21/22/23/24/25/26");

        System.out.println("\nProducto: Medias con balaca bebé niña");
        System.out.println("Precio: $28.000");
        System.out.println("Tallas: 0/12 meses");

        System.out.println("\nProducto: Gorro bebé unisex lana x2unds surtido");
        System.out.println("Precio: $27.990");
        System.out.println("Tallas: 0/0 0/3 3/6 6/9 meses");

        System.out.println("\nProducto: Tenis New Balance niña y niño");
        System.out.println("Precio: $65.000");
        System.out.println("Tallas: 23/24/25/26");

        System.out.println("\nProducto: Set de gafas y moños niña");
        System.out.println("Precio: $16.000");
        System.out.println("Tallas: 0/12 meses");
    }

    static void categoriaRegalosConAmor() {

        System.out.println("\n---------- REGALOS CON AMOR ----------");

        System.out.println("\nProducto: Set recién nacido algodón bebe niña personalizado");
        System.out.println("Precio: $170.990");
        System.out.println("Tallas: 0/0 0/3 meses");

        System.out.println("\nProducto: Set recién nacido algodón bebe niño personalizado");
        System.out.println("Precio: $170.990");
        System.out.println("Tallas: 0/0 0/3 meses");

        System.out.println("\nProducto: Chaqueta textura peluche blanco bebé unisex");
        System.out.println("Precio: $79.000");
        System.out.println("Tallas: 0/0 0/3 3/6 6/9 9/12 meses");

        System.out.println("\nProducto: Peluche de apego conejo");
        System.out.println("Precio: $49.000");

        System.out.println("\nProducto: Cobija para bebé + peluche de oso");
        System.out.println("Precio: $82.000");
        System.out.println("Talla: Única");
    }

        static void registrarProducto() {

            if (totalProductos >= MAX) {
                System.out.println("No hay espacio para más productos.");
                return;
            }

            System.out.print("Código del producto: ");
            int codigo = leerEntero();

            if (buscarProducto(codigo) != -1) {
                System.out.println("Ese código ya existe.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Categoría: ");
            String categoria = sc.nextLine();

            System.out.print("Descripción: ");
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

            System.out.println("\n---------- INVENTARIO DE PRODUCTOS ----------");

            if (totalProductos == 0) {
                System.out.println("No hay productos registrados.");
            } else {
                for (int i = 0; i < totalProductos; i++) {
                    System.out.println("--------------------------------");
                    System.out.println("Código: " + codProductos[i]);
                    System.out.println("Nombre: " + nomProductos[i]);
                    System.out.println("Categoría: " + catProductos[i]);
                    System.out.println("Descripción: " + descProductos[i]);
                    System.out.println("Precio: $" + precioProductos[i]);
                    System.out.println("Stock: " + stockProductos[i]);
                }
            }
        }

        static void modificarProducto() {

            System.out.print("Código del producto que desea modificar: ");
            int codigo = leerEntero();

            int pos = buscarProducto(codigo);

            if (pos == -1) {
                System.out.println("Producto no encontrado.");
            } else {
                System.out.print("Nuevo nombre: ");
                nomProductos[pos] = sc.nextLine();

                System.out.print("Nueva categoría: ");
                catProductos[pos] = sc.nextLine();

                System.out.print("Nueva descripción: ");
                descProductos[pos] = sc.nextLine();

                System.out.print("Nuevo precio: ");
                double precio = leerDouble();

                if (precio < 0) {
                    System.out.println("Precio inválido. Se conserva el anterior.");
                } else {
                    precioProductos[pos] = precio;
                }

                System.out.print("Nuevo stock: ");
                int stock = leerEntero();

                if (stock < 0) {
                    System.out.println("Stock inválido. Se conserva el anterior.");
                } else {
                    stockProductos[pos] = stock;
                }

                System.out.println("Proceso de modificación finalizado.");
            }
        }

        static void eliminarProducto() {

            System.out.print("Código del producto que desea eliminar: ");
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

        // CRUD DE SERVICIOS //

        static void menuServicios() {

            int opcion;

            do {
                System.out.println("\n----------ADMINISTRAR SERVICIOS ----------");
                System.out.println("1. Registrar servicio");
                System.out.println("2. Listar servicios");
                System.out.println("3. Modificar servicio");
                System.out.println("4. Eliminar servicio");
                System.out.println("5. Regresar");
                System.out.print("Seleccione una opción: ");

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
                        System.out.println("Opción no válida.");
                }

            } while (opcion != 5);
        }

        static void registrarServicio() {

            if (totalServicios >= MAX) {
                System.out.println("No hay espacio para más servicios.");
                return;
            }

            System.out.print("Código del servicio: ");
            int codigo = leerEntero();

            if (buscarServicio(codigo) != -1) {
                System.out.println("Ese código ya existe.");
                return;
            }

            System.out.print("Nombre del servicio: ");
            String nombre = sc.nextLine();

            System.out.print("Descripción: ");
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

            System.out.println("\n---------- LISTA DE SERVICIOS ----------");

            if (totalServicios == 0) {
                System.out.println("No hay servicios registrados.");
            } else {
                for (int i = 0; i < totalServicios; i++) {
                    System.out.println("--------------------------------");
                    System.out.println("Código: " + codServicios[i]);
                    System.out.println("Nombre: " + nomServicios[i]);
                    System.out.println("Descripción: " + descServicios[i]);
                    System.out.println("Precio: $" + precioServicios[i]);
                }
            }
        }

        static void modificarServicio() {

            System.out.print("Código del servicio que desea modificar: ");
            int codigo = leerEntero();

            int pos = buscarServicio(codigo);

            if (pos == -1) {
                System.out.println("Servicio no encontrado.");
            } else {
                System.out.print("Nuevo nombre: ");
                nomServicios[pos] = sc.nextLine();

                System.out.print("Nueva descripción: ");
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

            System.out.print("Código del servicio que desea eliminar: ");
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

        // ACCESO DE CLIENTES //

        static void menuAccesoCliente() {

            int opcion;

            do {
                System.out.println("\n---------- MENÚ DE CLIENTES ----------");
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Regresar");
                System.out.print("Seleccione una opción: ");

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
                        System.out.println("Opción no válida.");
                }

            } while (opcion != 3);
        }


        static void iniciarSesionCliente() {

         System.out.println("\n-------- INICIAR SESIÓN --------");

         System.out.print("Nombre de usuario: ");
         String usuario = sc.nextLine().trim();

         System.out.print("Contraseña: ");
         String clave = sc.nextLine();

         int pos = buscarNombreUsuario(usuario);

         if (pos == -1) {
            System.out.println("El nombre de usuario no esta registrado.");
         } else if (claves[pos].equals(clave)) {
            System.out.println("Bienvenido/a " + nombres[pos] + ".");
            menuCliente(idUsuarios[pos]);
         } else {
            System.out.println("Contraseña incorrecta.");
        }
    }


        // MENÚ DEL CLIENTE //

        static void menuCliente(int idCliente) {

            int opcion;

            do {
                System.out.println("\n-------- MENÚ DEL CLIENTE --------");
                System.out.println("1. Ver mis datos");
                System.out.println("2. Modificar mis datos");
                System.out.println("3. Ver productos disponibles");
                System.out.println("4. Comprar producto");
                System.out.println("5. Consultar una factura");
                System.out.println("6. Ver mi historial de compras");
                System.out.println("7. Cerrar sesión");
                System.out.print("Seleccione una opción: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        verDatosCliente(idCliente);
                        break;

                    case 2:
                        modificarDatosCliente(idCliente);
                        break;

                    case 3:
                        menuCategorias();
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
                        System.out.println("Sesión cerrada.");
                        break;

                    default:
                        System.out.println("Opción no valida.");
                }

            } while (opcion != 7);
        }


        static void verDatosCliente(int idCliente) {

           int pos = buscarUsuario(idCliente);

           if (pos != -1) {
            System.out.println("\n-------- MI PERFIL --------");
            System.out.println("ID: " + idUsuarios[pos]);
            System.out.println("Nombres: " + nombres[pos]);
            System.out.println("Apellidos: " + apellidos[pos]);
            System.out.println("Documento: " + documentos[pos]);
            System.out.println("Teléfono: " + telefonos[pos]);
            System.out.println("Correo: " + correos[pos]);
            System.out.println("Nombre de usuario: " + nombresUsuario[pos]);
            System.out.println("Contraseña: ********");
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

        System.out.println("\n--------- MODIFICAR PERFIL ---------");
        System.out.println("""
                                1. Modificar nombres
                                2. Modificar apellidos
                                3. Modificar teléfono
                                4. Modificar correo
                                5. Modificar nombre de usuario
                                6. Cambiar contraseña
                                7. Regresar
        """);
        System.out.print("Seleccione una opción: ");

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
                System.out.print("Nuevo teléfono: ");
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
                    System.out.println("El nombre de usuario no puede estar vacío.");
                } else {
                    nombresUsuario[pos] = nuevoUsuario;
                    System.out.println("Nombre de usuario actualizado.");
                }
                break;

            case 6:
                System.out.print("Nueva contraseña: ");
                String nuevaClave = sc.nextLine();

                if (nuevaClave.isEmpty()) {
                    System.out.println("La contraseña no puede estar vacía.");
                } else {
                    claves[pos] = nuevaClave;
                    System.out.println("Contraseña actualizada.");
                }
                break;

            case 7:
                break;

            default:
                System.out.println("Opción no valida.");
        }
    }


        // COMPRAS Y FACTURAS //

        static void comprarProducto(int idCliente) {

            if (totalVentas >= MAX) {
                System.out.println("No se pueden registrar más ventas.");
                return;
            }

            listarProductos();

            System.out.print("\nIngrese el código del producto que desea comprar: ");
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

                System.out.println("\n---------- FACTURA HOWLS ACCESORIOS BABY ----------");
                System.out.println("Número de factura: " + numFacturas[pos]);
                System.out.println("ID del cliente: " + clienteFactura[pos]);

                if (posProducto != -1) {
                    System.out.println("Producto: " + nomProductos[posProducto]);
                    System.out.println("Precio unitario: $" + precioProductos[posProducto]);
                } else {
                    System.out.println("Código del producto: " + productoFactura[pos]);
                    System.out.println("El producto ya no esta en el inventario.");
                }

                System.out.println("Cantidad: " + cantidadFactura[pos]);
                System.out.println("TOTAL: $" + totalFactura[pos]);
                System.out.println("----------------------------------------");
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

            System.out.print("Ingrese el número de factura: ");
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

            System.out.println("\n---------- MI HISTORIAL DE COMPRAS ----------");

            for (int i = 0; i < totalVentas; i++) {
                if (clienteFactura[i] == idCliente) {
                    System.out.println("--------------------------------");
                    System.out.println("Factura: " + numFacturas[i]);
                    System.out.println("Código del producto: " + productoFactura[i]);
                    System.out.println("Cantidad: " + cantidadFactura[i]);
                    System.out.println("Total: $" + totalFactura[i]);

                    encontrada = true;
                }
            }

            if (!encontrada) {
                System.out.println("Todavía no tienes compras registradas.");
            }
        }

        // VENTAS PARA EL ADMINISTRADOR //

        static void menuVentasAdministrador() {

            int opcion;

            do {
                System.out.println("\n--------- VENTAS Y FACTURAS ---------");
                System.out.println("""
                1. Ver todas las ventas");
                2. Buscar factura");
                3. Regresar
                """);
                System.out.print("Seleccione una opción: ");

                opcion = leerEntero();

                switch (opcion) {
                    case 1:
                        listarTodasLasVentas();
                        break;

                    case 2:
                        System.out.print("Número de factura: ");
                        int numero = leerEntero();
                        mostrarFactura(numero);
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } while (opcion != 3);
        }

        static void listarTodasLasVentas() {

            System.out.println("\n-------- RESUMEN DE VENTAS --------");

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

        // INFORMES //

        static void menuInformes() {

            int opcion;

            do {
                System.out.println("\n--------- INFORMES ---------");
                System.out.println("""
                1. Inventario completo
                2. Productos con poco inventario
                3. Total de ventas
                4. Ingresos acumulados
                5. Cantidad de usuarios
                6. Regresar
                """);
                System.out.print("Seleccione una opción: ");

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
                        System.out.println("Opción no válida.");
                }

            } while (opcion != 6);
        }

        static void informePocoInventario() {

            boolean encontrado = false;

            System.out.println("\n--------- PRODUCTOS CON POCO INVENTARIO ----------");

            for (int i = 0; i < totalProductos; i++) {
                if (stockProductos[i] <= 5) {
                    System.out.println("Producto: " + nomProductos[i]);
                    System.out.println("Código: " + codProductos[i]);
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

        // FUNCIONES PARA LEER DATOS //

        static int leerEntero() {

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número entero válido: ");
                sc.nextLine();
            }

            int numero = sc.nextInt();
            sc.nextLine();

            return numero;
        }

        static double leerDouble() {

            while (!sc.hasNextDouble()) {
                System.out.print("Ingrese un valor numérico válido: ");
                sc.nextLine();
            }

            double numero = sc.nextDouble();
            sc.nextLine();

            return numero;
        }
    }
