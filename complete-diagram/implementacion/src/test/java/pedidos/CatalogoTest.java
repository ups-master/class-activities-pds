package pedidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatalogoTest {
    private final Producto curso = new ProductoDigital(1, "Curso", 20.00, "https://x.ejemplo");

    @Test
    void buscaProductosPorIdYDevuelveNullSiNoExiste() {
        Catalogo catalogo = new Catalogo(1, "Cursos");
        catalogo.agregarProducto(curso);
        assertSame(curso, catalogo.buscarProducto(1));
        assertNull(catalogo.buscarProducto(99));
    }

    @Test
    void unProductoPuedeEstarEnVariosCatalogosYSobrevive() {
        Catalogo a = new Catalogo(1, "A");
        Catalogo b = new Catalogo(2, "B");
        a.agregarProducto(curso);
        b.agregarProducto(curso);
        a = null;
        assertSame(curso, b.buscarProducto(1));
    }

    @Test
    void rechazaNulosYIdsRepetidos() {
        Catalogo catalogo = new Catalogo(1, "A");
        catalogo.agregarProducto(curso);
        assertThrows(IllegalArgumentException.class, () -> catalogo.agregarProducto(null));
        assertThrows(IllegalArgumentException.class, () -> catalogo.agregarProducto(curso));
    }

    @Test
    void noPermiteModificarLaListaDesdeFuera() {
        Catalogo catalogo = new Catalogo(1, "A");
        assertThrows(UnsupportedOperationException.class, () -> catalogo.getProductos().add(curso));
    }
}
