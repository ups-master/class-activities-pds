# Builder clásico - Reserva de vuelo

Diagrama de clases UML del patrón Builder clásico aplicado a la reserva de un vuelo (sin código).

```
class-activity/
├── README.md
├── diagram-clasic.puml
└── diagramas/            # SVG generados
```

## Diagrama

[`diagram-clasic.puml`](diagram-clasic.puml)

![Builder clásico - Reserva de vuelo](diagramas/diagram-clasic.svg)

## Participantes

| Rol en el patrón | Clase | Responsabilidad |
|---|---|---|
| Producto | `ReservaVuelo` | Objeto complejo: origen, destino, fecha, pasajeros, tarifa y extras (asiento, equipaje, alimentación, servicios especiales). |
| Builder | `ReservaBuilder` (interfaz) | Declara un paso `agregarX(...)` por cada componente y `obtenerReserva()`. |
| Builders concretos | `ReservaBasicaBuilder`, `ReservaEjecutivaBuilder`, `ReservaEspecialBuilder` | Implementan los pasos y arman cada variante de reserva. |
| Director | `DirectorReservaVuelo` | `construirReserva(builder)` ejecuta los pasos en el orden correcto con el builder que recibe. |

## Relaciones

| Relación | Tipo | Significado |
|---|---|---|
| `ReservaBuilder <\|.. Reserva*Builder` | Realización | Cada builder concreto implementa la interfaz. |
| `DirectorReservaVuelo "1" --> "1" ReservaBuilder` | Asociación | El director usa un builder, sin saber cuál es el concreto. |
| `Reserva*Builder ..> ReservaVuelo <<create>>` | Dependencia | Cada builder crea la reserva que entrega. |

El director conoce solo la interfaz, por lo que el mismo proceso sirve para las tres variantes: para añadir un tipo de reserva basta con un nuevo builder concreto.
