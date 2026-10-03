package pedidos;

public class DetallePedido {
    private final Producto producto;
    private int cantidad;
    private final double precioAplicado; // precio capturado al momento de la compra

    // Solo Pedido lo crea: el detalle es parte de su composición
    DetallePedido(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioAplicado = producto.obtenerPrecio();
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioAplicado() { return precioAplicado; }

    void sumarCantidad(int adicional) {
        if (adicional <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        cantidad += adicional;
    }

    // Supuesto: el costo de entrega se cobra por unidad
    public double calcularSubtotal() {
        return cantidad * (precioAplicado + producto.calcularCostoEntrega());
    }
}
