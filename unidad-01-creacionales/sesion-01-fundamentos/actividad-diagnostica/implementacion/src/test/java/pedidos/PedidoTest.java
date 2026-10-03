package pedidos;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidoTest {
    private Cliente cliente;
    private Producto teclado;
    private Pedido pedido;

    @BeforeEach
    void preparar() {
        cliente = new Cliente(1, "Ana Pérez", "ana@correo.com");
        teclado = new Producto(1, "Teclado", new BigDecimal("45.50"));
        pedido = cliente.realizarPedido();
    }

    @Test
    void pedidoPerteneceAUnClienteYNaceEnPendiente() {
        assertSame(cliente, pedido.getCliente());
        assertTrue(cliente.getPedidos().contains(pedido));
        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstado());
    }

    @Test
    void calculaTotalAgrupandoProductosRepetidos() {
        pedido.agregarProducto(teclado, 2);
        pedido.agregarProducto(teclado, 1);
        assertEquals(1, pedido.getDetalles().size());
        assertEquals(new BigDecimal("136.50"), pedido.calcularTotal());
    }

    @Test
    void conservaElPrecioDelMomentoDeLaCompra() {
        pedido.agregarProducto(teclado, 1);
        teclado.setPrecio(new BigDecimal("99.00"));
        assertEquals(new BigDecimal("45.50"), pedido.calcularTotal());
    }

    @Test
    void rechazaCantidadNoPositiva() {
        assertThrows(IllegalArgumentException.class, () -> pedido.agregarProducto(teclado, 0));
    }

    @Test
    void noPermiteModificarLosDetallesDesdeFuera() {
        pedido.agregarProducto(teclado, 1);
        assertThrows(UnsupportedOperationException.class, () -> pedido.getDetalles().clear());
    }

    @Test
    void noPagaPedidoVacio() {
        Pago pago = new PagoTransferencia(1, BigDecimal.TEN, "Banco X", "T-1");
        assertThrows(IllegalStateException.class, () -> pedido.registrarPago(pago));
    }

    @Test
    void rechazaPagoConMontoDistinto() {
        pedido.agregarProducto(teclado, 1);
        Pago pago = new PagoTransferencia(1, new BigDecimal("1.00"), "Banco X", "T-1");
        assertThrows(IllegalArgumentException.class, () -> pedido.registrarPago(pago));
        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstado());
        assertNull(pedido.getPago());
    }

    @Test
    void noPermiteAgregarNiPagarDosVecesTrasPagar() {
        pedido.agregarProducto(teclado, 1);
        pedido.registrarPago(new PagoTarjeta(1, pedido.calcularTotal(), "1234567812345678"));
        assertThrows(IllegalStateException.class, () -> pedido.agregarProducto(teclado, 1));
        assertThrows(IllegalStateException.class, () -> pedido.registrarPago(
            new PagoTarjeta(2, pedido.calcularTotal(), "1234567812345678")));
    }

    @Test
    void flujoCompletoTerminaEnviado() {
        pedido.agregarProducto(teclado, 1);
        pedido.registrarPago(new PagoTarjeta(1, pedido.calcularTotal(), "1234567812345678"));
        pedido.enviar();
        assertEquals(EstadoPedido.ENVIADO, pedido.getEstado());
        assertThrows(IllegalStateException.class, pedido::cancelar);
    }

    @Test
    void noEnviaPedidoSinPagar() {
        pedido.agregarProducto(teclado, 1);
        assertThrows(IllegalStateException.class, pedido::enviar);
    }

    @Test
    void cancelarPedidoPendiente() {
        pedido.cancelar();
        assertEquals(EstadoPedido.CANCELADO, pedido.getEstado());
        assertThrows(IllegalStateException.class, () -> pedido.agregarProducto(teclado, 1));
    }
}
