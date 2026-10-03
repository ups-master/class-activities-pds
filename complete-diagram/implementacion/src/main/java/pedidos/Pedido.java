package pedidos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
    private static final AtomicInteger SECUENCIA = new AtomicInteger(1);

    private final int id;
    private final LocalDateTime fecha;
    private final Cliente cliente;
    private EstadoPedido estado;
    private final List<DetallePedido> detalles = new ArrayList<>(); // composición
    private Pago pago; // 0..1

    Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El pedido requiere un cliente");
        }
        this.id = SECUENCIA.getAndIncrement();
        this.fecha = LocalDateTime.now();
        this.cliente = cliente;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public EstadoPedido getEstado() { return estado; }
    public Pago getPago() { return pago; }
    public List<DetallePedido> getDetalles() { return Collections.unmodifiableList(detalles); }

    public void agregarProducto(Producto producto, int cantidad) {
        if (estado != EstadoPedido.PENDIENTE) {
            throw new IllegalStateException("Solo se pueden agregar productos a un pedido PENDIENTE (estado: " + estado + ")");
        }
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        DetallePedido existente = buscarDetalle(producto);
        if (existente != null) {
            existente.sumarCantidad(cantidad);
        } else {
            detalles.add(new DetallePedido(producto, cantidad));
        }
    }

    public BigDecimal calcularTotal() {
        return detalles.stream()
            .map(DetallePedido::calcularSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void registrarPago(Pago nuevoPago) {
        verificarTransicion(EstadoPedido.PAGADO);
        if (detalles.isEmpty()) {
            throw new IllegalStateException("No se puede pagar un pedido sin productos");
        }
        if (nuevoPago == null) {
            throw new IllegalArgumentException("El pago es obligatorio");
        }
        if (nuevoPago.getMonto().compareTo(calcularTotal()) != 0) {
            throw new IllegalArgumentException("El monto del pago (" + nuevoPago.getMonto()
                + ") no coincide con el total del pedido (" + calcularTotal() + ")");
        }
        if (!nuevoPago.procesarPago()) {
            throw new IllegalStateException("El pago fue rechazado");
        }
        pago = nuevoPago;
        estado = EstadoPedido.PAGADO;
    }

    public void enviar() {
        verificarTransicion(EstadoPedido.ENVIADO);
        estado = EstadoPedido.ENVIADO;
    }

    public void cancelar() {
        verificarTransicion(EstadoPedido.CANCELADO);
        estado = EstadoPedido.CANCELADO;
    }

    private void verificarTransicion(EstadoPedido destino) {
        if (!estado.puedeTransicionarA(destino)) {
            throw new IllegalStateException("Transición no permitida: " + estado + " -> " + destino);
        }
    }

    private DetallePedido buscarDetalle(Producto producto) {
        for (DetallePedido d : detalles) {
            if (d.getProducto() == producto) {
                return d;
            }
        }
        return null;
    }
}
