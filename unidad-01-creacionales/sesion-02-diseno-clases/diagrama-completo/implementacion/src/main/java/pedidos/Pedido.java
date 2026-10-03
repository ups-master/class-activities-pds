package pedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
    private static final AtomicInteger SECUENCIA = new AtomicInteger(1);
    static final String PENDIENTE = "PENDIENTE";
    static final String CONFIRMADO = "CONFIRMADO";

    private final int id;
    private final LocalDate fecha;
    private String estado;
    private final List<DetallePedido> detalles = new ArrayList<>(); // composición

    Pedido() {
        this.id = SECUENCIA.getAndIncrement();
        this.fecha = LocalDate.now();
        this.estado = PENDIENTE;
    }

    public int getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public List<DetallePedido> getDetalles() { return Collections.unmodifiableList(detalles); }

    public void agregarDetalle(Producto producto, int cantidad) {
        if (!PENDIENTE.equals(estado)) {
            throw new IllegalStateException("Solo se pueden agregar detalles a un pedido PENDIENTE (estado: " + estado + ")");
        }
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        for (DetallePedido d : detalles) {
            if (d.getProducto() == producto) {
                d.sumarCantidad(cantidad);
                return;
            }
        }
        detalles.add(new DetallePedido(producto, cantidad));
    }

    public double calcularTotal() {
        double total = 0;
        for (DetallePedido d : detalles) {
            total += d.calcularSubtotal();
        }
        return total;
    }

    // Dependencia: el servicio solo se usa durante la confirmación, no se guarda
    public boolean confirmar(ServicioPago servicio) {
        if (!PENDIENTE.equals(estado)) {
            throw new IllegalStateException("Solo se puede confirmar un pedido PENDIENTE (estado: " + estado + ")");
        }
        if (detalles.isEmpty()) {
            throw new IllegalStateException("No se puede confirmar un pedido sin detalles");
        }
        if (servicio == null) {
            throw new IllegalArgumentException("El servicio de pago es obligatorio");
        }
        boolean aprobado = servicio.procesarPago(calcularTotal());
        if (aprobado) {
            estado = CONFIRMADO;
        }
        return aprobado;
    }
}
