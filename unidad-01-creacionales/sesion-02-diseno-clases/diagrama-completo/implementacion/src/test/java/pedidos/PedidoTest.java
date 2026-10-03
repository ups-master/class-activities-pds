package pedidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidoTest {
    private Cliente cliente;
    private Producto teclado; // físico: precio 45.50, entrega 3.00 + 0.8 * 1.0 = 3.80
    private Producto curso;   // digital: precio 20.00, entrega 0
    private Pedido pedido;

    @BeforeEach
    void preparar() {
        cliente = new Cliente(1, "Ana Pérez", "ana@correo.com");
        teclado = new ProductoFisico(1, "Teclado", 45.50, 0.8, 3.00);
        curso = new ProductoDigital(2, "Curso", 20.00, "https://tienda.ejemplo/curso");
        pedido = cliente.registrarPedido();
    }

    @Test
    void elClienteRegistraSusPedidosYNacenPendientes() {
        assertTrue(cliente.getPedidos().contains(pedido));
        assertEquals("PENDIENTE", pedido.getEstado());
    }

    @Test
    void totalIncluyeElCostoDeEntregaDeCadaTipo() {
        pedido.agregarDetalle(teclado, 2);
        pedido.agregarDetalle(curso, 1);
        assertEquals(2 * (45.50 + 3.80) + 20.00, pedido.calcularTotal(), 1e-9);
    }

    @Test
    void agrupaDetallesDelMismoProducto() {
        pedido.agregarDetalle(curso, 1);
        pedido.agregarDetalle(curso, 2);
        assertEquals(1, pedido.getDetalles().size());
        assertEquals(3, pedido.getDetalles().get(0).getCantidad());
    }

    @Test
    void conservaElPrecioAplicado() {
        pedido.agregarDetalle(curso, 1);
        assertEquals(20.00, pedido.getDetalles().get(0).getPrecioAplicado());
    }

    @Test
    void rechazaCantidadNoPositivaYProductoNulo() {
        assertThrows(IllegalArgumentException.class, () -> pedido.agregarDetalle(teclado, 0));
        assertThrows(IllegalArgumentException.class, () -> pedido.agregarDetalle(null, 1));
    }

    @Test
    void noPermiteModificarLosDetallesDesdeFuera() {
        pedido.agregarDetalle(curso, 1);
        assertThrows(UnsupportedOperationException.class, () -> pedido.getDetalles().clear());
    }

    @Test
    void confirmarConPagoAprobadoCambiaElEstadoYRecibeElTotal() {
        pedido.agregarDetalle(curso, 2);
        double[] montoRecibido = new double[1];
        boolean resultado = pedido.confirmar(monto -> {
            montoRecibido[0] = monto;
            return true;
        });
        assertTrue(resultado);
        assertEquals("CONFIRMADO", pedido.getEstado());
        assertEquals(40.00, montoRecibido[0], 1e-9);
    }

    @Test
    void confirmarConPagoRechazadoDejaElPedidoPendiente() {
        pedido.agregarDetalle(curso, 1);
        assertFalse(pedido.confirmar(monto -> false));
        assertEquals("PENDIENTE", pedido.getEstado());
    }

    @Test
    void noConfirmaPedidoVacioNiConServicioNulo() {
        assertThrows(IllegalStateException.class, () -> pedido.confirmar(monto -> true));
        pedido.agregarDetalle(curso, 1);
        assertThrows(IllegalArgumentException.class, () -> pedido.confirmar(null));
    }

    @Test
    void trasConfirmarNoSeAgregaNiSeConfirmaDeNuevo() {
        pedido.agregarDetalle(curso, 1);
        pedido.confirmar(monto -> true);
        assertThrows(IllegalStateException.class, () -> pedido.agregarDetalle(curso, 1));
        assertThrows(IllegalStateException.class, () -> pedido.confirmar(monto -> true));
    }
}
