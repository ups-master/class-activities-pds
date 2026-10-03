package pedidos;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Ana Pérez", "ana@correo.com");
        Producto teclado = new Producto(1, "Teclado", new BigDecimal("45.50"));
        Producto mouse = new Producto(2, "Mouse", new BigDecimal("20.00"));

        System.out.println("=== Flujo correcto ===");
        Pedido p = cliente.realizarPedido();
        p.agregarProducto(teclado, 2);
        p.agregarProducto(mouse, 1);
        p.agregarProducto(teclado, 1); // se agrupa: teclado x3
        System.out.println("Total: " + p.calcularTotal());
        p.registrarPago(new PagoTarjeta(1, p.calcularTotal(), "1234567812345678"));
        p.enviar();
        System.out.println("Estado final: " + p.getEstado());
        System.out.println("Pedidos del cliente: " + cliente.getPedidos().size());

        System.out.println("\n=== Casos inválidos ===");
        Pedido q = cliente.realizarPedido();
        probar("cantidad 0", () -> q.agregarProducto(mouse, 0));
        probar("pagar pedido sin productos", () -> q.registrarPago(
            new PagoTransferencia(2, BigDecimal.TEN, "Banco X", "T-001")));
        probar("enviar sin pagar", q::enviar);
        q.agregarProducto(mouse, 2);
        probar("monto distinto al total", () -> q.registrarPago(
            new PagoTransferencia(3, new BigDecimal("1.00"), "Banco X", "T-002")));
        probar("tarjeta inválida", () -> new PagoTarjeta(4, new BigDecimal("40.00"), "123"));
        probar("correo inválido", () -> new Cliente(2, "Luis", "no-es-correo"));
        probar("precio negativo", () -> new Producto(3, "X", new BigDecimal("-1")));
        q.registrarPago(new PagoTransferencia(5, q.calcularTotal(), "Banco X", "T-003"));
        probar("agregar tras pagar", () -> q.agregarProducto(mouse, 1));
        probar("pagar dos veces", () -> q.registrarPago(
            new PagoTransferencia(6, q.calcularTotal(), "Banco X", "T-004")));
        probar("cancelar un pedido enviado", p::cancelar);
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
