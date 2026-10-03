package pedidos;

import java.math.BigDecimal;

public class DetallePedido {
    private final Producto producto;
    private int cantidad;
    private final BigDecimal precioUnitario; // precio capturado al momento de la compra

    DetallePedido(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }

    // Solo accesible desde Pedido (mismo paquete): el detalle es parte de su composición
    void sumarCantidad(int adicional) {
        if (adicional <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        cantidad += adicional;
    }

    public BigDecimal calcularSubtotal() {
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }
}
