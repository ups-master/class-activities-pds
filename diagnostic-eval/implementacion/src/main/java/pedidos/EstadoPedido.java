package pedidos;

public enum EstadoPedido {
    PENDIENTE, PAGADO, ENVIADO, CANCELADO;

    public boolean puedeTransicionarA(EstadoPedido destino) {
        return switch (this) {
            case PENDIENTE -> destino == PAGADO || destino == CANCELADO;
            case PAGADO -> destino == ENVIADO || destino == CANCELADO;
            case ENVIADO, CANCELADO -> false;
        };
    }
}
