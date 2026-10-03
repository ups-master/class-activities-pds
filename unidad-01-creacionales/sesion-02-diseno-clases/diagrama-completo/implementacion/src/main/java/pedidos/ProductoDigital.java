package pedidos;

public class ProductoDigital extends Producto {
    private final String urlDescarga;

    public ProductoDigital(int id, String nombre, double precio, String urlDescarga) {
        super(id, nombre, precio);
        if (urlDescarga == null || urlDescarga.isBlank()) {
            throw new IllegalArgumentException("La URL de descarga es obligatoria");
        }
        this.urlDescarga = urlDescarga;
    }

    // No hay envío físico: la entrega es una descarga sin costo
    @Override
    public double calcularCostoEntrega() {
        return 0;
    }
}
