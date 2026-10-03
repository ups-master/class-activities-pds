package pedidos;

// Servicio externo de pagos: el sistema solo conoce este contrato.
public interface ServicioPago {
    boolean procesarPago(double monto);
}
