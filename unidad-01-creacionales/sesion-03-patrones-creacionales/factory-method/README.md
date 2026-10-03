# Patrón Factory Method

## Propósito

Define un método para crear objetos, permitiendo que las subclases decidan qué clase concreta instanciar. Desacopla al código cliente de la creación directa de productos concretos.

## Problema / motivación

Una empresa gestiona contratos Fijo, Temporal y por Factura. Todos comparten `calcularSueldo()`, pero cada tipo lo implementa distinto. El sistema debe crear contratos sin acoplar al cliente a `ContratoFijo`, `ContratoTemporal` o `ContratoFactura`: la creación se delega a una jerarquía de creadores.

## Participantes

| Rol | Responsabilidad | Ejemplo en el repo |
|---|---|---|
| Product | Contrato común de los objetos que crea el factory method (interfaz o clase abstracta). | `Contrato` |
| ConcreteProduct | Implementa el contrato. | `ContratoFijo`, `ContratoTemporal`, `ContratoFactura` |
| Creator | Declara el factory method, que devuelve un `Product`. | `CreadorContrato` |
| ConcreteCreator | Redefine el factory method y devuelve un `ConcreteProduct`. | `CreadorFijo`, `CreadorTemporal`, `CreadorFactura` |

## Colaboraciones

- El `Creator` trabaja con la abstracción `Product`.
- Cada `ConcreteCreator` decide qué `ConcreteProduct` crea.
- El cliente usa el producto a través de su abstracción, sin depender de la clase concreta.

## Aplicabilidad

Conviene cuando:

- una clase no puede anticipar qué clase concreta debe crear;
- se quiere que las subclases decidan qué producto instanciar;
- se quiere desacoplar al cliente de las clases concretas;
- los tipos nuevos deben añadirse con nuevas subclases de `Creator`, sin modificar al cliente.

Es útil cuando la decisión de creación varía por herencia y polimorfismo, **no** mediante un `switch` centralizado (por eso el diagrama de Simple Factory de `guided-review` se muestra como contraste).

## Contenido

| Carpeta | Qué contiene |
|---|---|
| [`class-activity/`](class-activity) | Actividad de clase: cuatro casos para decidir si aplica Factory Method (logística, documentos, enemigos de videojuego y reportes), con su diagrama UML. |
| [`guided-review/`](guided-review) | Resolución guiada: contratos sin patrón, con Simple Factory y con Factory Method, e implementación en Java. |
