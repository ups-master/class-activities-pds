package pedidos;

public class ProductoFisico extends Producto {
    static final double TARIFA_POR_KG = 1.0;

    private final double peso;
    private final double costoBaseEnvio;

    public ProductoFisico(int id, String nombre, double precio, double peso, double costoBaseEnvio) {
        super(id, nombre, precio);
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero");
        }
        if (costoBaseEnvio < 0) {
            throw new IllegalArgumentException("El costo base de envío no puede ser negativo");
        }
        this.peso = peso;
        this.costoBaseEnvio = costoBaseEnvio;
    }

    @Override
    public double calcularCostoEntrega() {
        return costoBaseEnvio + peso * TARIFA_POR_KG;
    }
}
