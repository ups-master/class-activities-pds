package pedidos;

import java.math.BigDecimal;

public abstract class Pago {
    private final int id;
    private final BigDecimal monto;

    protected Pago(int id, BigDecimal monto) {
        if (monto == null || monto.signum() <= 0) {
            throw new IllegalArgumentException("El monto del pago debe ser mayor que cero");
        }
        this.id = id;
        this.monto = monto;
    }

    public int getId() { return id; }
    public BigDecimal getMonto() { return monto; }

    /** Cada medio de pago define cómo se procesa. Devuelve true si el pago fue aceptado. */
    public abstract boolean procesarPago();
}
