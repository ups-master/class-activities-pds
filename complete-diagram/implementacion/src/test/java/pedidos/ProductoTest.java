package pedidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductoTest {
    @Test
    void costoDeEntregaDependeDelTipoDeProducto() {
        Producto fisico = new ProductoFisico(1, "Teclado", 45.50, 2.0, 3.00);
        Producto digital = new ProductoDigital(2, "Curso", 20.00, "https://x.ejemplo");
        assertEquals(5.00, fisico.calcularCostoEntrega(), 1e-9);
        assertEquals(0.0, digital.calcularCostoEntrega());
    }

    @Test
    void obtenerPrecioDevuelveElPrecio() {
        assertEquals(45.50, new ProductoFisico(1, "Teclado", 45.50, 1, 0).obtenerPrecio());
    }

    @Test
    void validaDatosComunes() {
        assertThrows(IllegalArgumentException.class, () -> new ProductoDigital(1, " ", 10, "http://x"));
        assertThrows(IllegalArgumentException.class, () -> new ProductoDigital(1, "X", 0, "http://x"));
    }

    @Test
    void validaDatosPropiosDeCadaSubtipo() {
        assertThrows(IllegalArgumentException.class, () -> new ProductoFisico(1, "X", 10, 0, 1));
        assertThrows(IllegalArgumentException.class, () -> new ProductoFisico(1, "X", 10, 1, -1));
        assertThrows(IllegalArgumentException.class, () -> new ProductoDigital(1, "X", 10, ""));
    }
}
