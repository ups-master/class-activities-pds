package pedidos;

import java.math.BigDecimal;

public class PagoTransferencia extends Pago {
    private final String banco;
    private final String numeroTransferencia;

    public PagoTransferencia(int id, BigDecimal monto, String banco, String numeroTransferencia) {
        super(id, monto);
        if (banco == null || banco.isBlank()) {
            throw new IllegalArgumentException("El banco es obligatorio");
        }
        if (numeroTransferencia == null || numeroTransferencia.isBlank()) {
            throw new IllegalArgumentException("El número de transferencia es obligatorio");
        }
        this.banco = banco;
        this.numeroTransferencia = numeroTransferencia;
    }

    public String getBanco() { return banco; }
    public String getNumeroTransferencia() { return numeroTransferencia; }

    @Override
    public boolean procesarPago() {
        // Simulación: aquí iría la verificación de la transferencia
        return true;
    }
}
