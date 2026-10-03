package pedidos;

import java.math.BigDecimal;

public class Producto {
    private final int id;
    private final String nombre;
    private BigDecimal precio;

    public Producto(int id, String nombre, BigDecimal precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        this.id = id;
        this.nombre = nombre;
        setPrecio(precio);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public BigDecimal getPrecio() { return precio; }

    public void setPrecio(BigDecimal precio) {
        if (precio == null || precio.signum() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        this.precio = precio;
    }
}
