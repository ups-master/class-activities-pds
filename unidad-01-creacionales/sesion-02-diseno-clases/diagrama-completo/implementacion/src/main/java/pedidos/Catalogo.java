package pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalogo {
    private final int id;
    private final String nombre;
    // Agregación: los productos se crean fuera y pueden existir sin el catálogo
    private final List<Producto> productos = new ArrayList<>();

    public Catalogo(int id, String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del catálogo es obligatorio");
        }
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Producto> getProductos() { return Collections.unmodifiableList(productos); }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (buscarProducto(producto.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un producto con id " + producto.getId());
        }
        productos.add(producto);
    }

    public Producto buscarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
