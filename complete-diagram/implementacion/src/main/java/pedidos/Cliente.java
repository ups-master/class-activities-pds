package pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private final int id;
    private final String nombre;
    private final String correo;
    private final List<Pedido> pedidos = new ArrayList<>(); // 0..*

    public Cliente(int id, String nombre, String correo) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        if (correo == null || !correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("Correo inválido: " + correo);
        }
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public List<Pedido> getPedidos() { return Collections.unmodifiableList(pedidos); }

    public Pedido registrarPedido() {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return pedido;
    }
}
