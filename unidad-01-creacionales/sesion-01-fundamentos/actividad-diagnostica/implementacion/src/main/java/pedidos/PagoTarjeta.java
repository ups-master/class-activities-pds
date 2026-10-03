package pedidos;

import java.math.BigDecimal;

public class PagoTarjeta extends Pago {
    private final String ultimosCuatro; // no se conserva el número completo

    public PagoTarjeta(int id, BigDecimal monto, String numeroTarjeta) {
        super(id, monto);
        if (numeroTarjeta == null || !numeroTarjeta.matches("\\d{16}")) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos");
        }
        this.ultimosCuatro = numeroTarjeta.substring(12);
    }

    public String getTarjetaEnmascarada() {
        return "**** **** **** " + ultimosCuatro;
    }

    @Override
    public boolean procesarPago() {
        // Simulación: aquí iría la comunicación con la pasarela de pago
        return true;
    }
}
