package pedidos;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Ana Pérez", "ana@correo.com");
        Producto teclado = new ProductoFisico(1, "Teclado", 45.50, 0.8, 3.00);
        Producto curso = new ProductoDigital(2, "Curso de Java", 20.00, "https://tienda.ejemplo/curso");

        Catalogo catalogo = new Catalogo(1, "Tecnología");
        catalogo.agregarProducto(teclado);
        catalogo.agregarProducto(curso);
        System.out.println("Catálogo '" + catalogo.getNombre() + "': " + catalogo.getProductos().size() + " productos");
        System.out.println("Entrega teclado: " + teclado.calcularCostoEntrega()
            + " | Entrega curso: " + curso.calcularCostoEntrega());

        System.out.println("\n=== Flujo correcto ===");
        Pedido p = cliente.registrarPedido();
        p.agregarDetalle(catalogo.buscarProducto(1), 2);
        p.agregarDetalle(catalogo.buscarProducto(2), 1);
        System.out.println("Total: " + p.calcularTotal());
        ServicioPago aprobado = monto -> true;
        System.out.println("Pago aprobado: " + p.confirmar(aprobado) + " -> estado " + p.getEstado());

        System.out.println("\n=== Pago rechazado ===");
        Pedido q = cliente.registrarPedido();
        q.agregarDetalle(curso, 1);
        ServicioPago rechazado = monto -> false;
        System.out.println("Pago aprobado: " + q.confirmar(rechazado) + " -> estado " + q.getEstado());

        System.out.println("\n=== Casos inválidos ===");
        Pedido r = cliente.registrarPedido();
        probar("confirmar sin detalles", () -> r.confirmar(aprobado));
        probar("cantidad 0", () -> r.agregarDetalle(teclado, 0));
        probar("servicio nulo", () -> q.confirmar(null));
        probar("agregar tras confirmar", () -> p.agregarDetalle(curso, 1));
        probar("confirmar dos veces", () -> p.confirmar(aprobado));
        probar("producto repetido en el catálogo", () -> catalogo.agregarProducto(teclado));
        probar("precio negativo", () -> new ProductoDigital(3, "X", -1, "http://x"));
        probar("correo inválido", () -> new Cliente(2, "Luis", "no-es-correo"));
    }

    private static void probar(String caso, Runnable accion) {
        try {
            accion.run();
            System.out.println("[FALLO] '" + caso + "' no lanzó excepción");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("[OK] " + caso + " -> " + e.getMessage());
        }
    }
}
