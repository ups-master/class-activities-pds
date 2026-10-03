package pedidos;

public abstract class Producto {
    private final int id;
    private final String nombre;
    private final double precio;

    protected Producto(int id, String nombre, double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public double obtenerPrecio() { return precio; }

    // Polimorfismo: cada tipo de producto calcula su entrega de forma distinta
    public abstract double calcularCostoEntrega();
}
