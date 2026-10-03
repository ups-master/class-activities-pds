package pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private final int id;
    private String nombre;
    private String correo;
    private final List<Pedido> pedidos = new ArrayList<>(); // 0..*

    public Cliente(int id, String nombre, String correo) {
        this.id = id;
        setNombre(nombre);
        setCorreo(correo);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public List<Pedido> getPedidos() { return Collections.unmodifiableList(pedidos); }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("Correo inválido: " + correo);
        }
        this.correo = correo;
    }

    public Pedido realizarPedido() {
        Pedido pedido = new Pedido(this);
        pedidos.add(pedido);
        return pedido;
    }
}
