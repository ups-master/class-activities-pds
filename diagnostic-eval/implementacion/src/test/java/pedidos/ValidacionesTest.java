package pedidos;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ValidacionesTest {
    @Test
    void clienteRequiereNombreYCorreoValido() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente(1, " ", "a@b.com"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente(1, "Ana", "no-es-correo"));
    }

    @Test
    void productoRequierePrecioPositivoYNombre() {
        assertThrows(IllegalArgumentException.class, () -> new Producto(1, "X", new BigDecimal("-1")));
        assertThrows(IllegalArgumentException.class, () -> new Producto(1, " ", BigDecimal.ONE));
    }

    @Test
    void tarjetaRequiere16DigitosYSeEnmascara() {
        assertThrows(IllegalArgumentException.class, () -> new PagoTarjeta(1, BigDecimal.TEN, "123"));
        PagoTarjeta pago = new PagoTarjeta(1, BigDecimal.TEN, "1234567812345678");
        assertEquals("**** **** **** 5678", pago.getTarjetaEnmascarada());
    }

    @Test
    void transferenciaRequiereBancoYNumero() {
        assertThrows(IllegalArgumentException.class, () -> new PagoTransferencia(1, BigDecimal.TEN, "", "T-1"));
        assertThrows(IllegalArgumentException.class, () -> new PagoTransferencia(1, BigDecimal.TEN, "B", null));
    }

    @Test
    void estadosSoloAvanzanPorTransicionesValidas() {
        assertTrue(EstadoPedido.PENDIENTE.puedeTransicionarA(EstadoPedido.PAGADO));
        assertFalse(EstadoPedido.PENDIENTE.puedeTransicionarA(EstadoPedido.ENVIADO));
        assertFalse(EstadoPedido.ENVIADO.puedeTransicionarA(EstadoPedido.CANCELADO));
    }
}
