# Patrón Builder

## Propósito

Separa la construcción de un objeto complejo de su representación, de modo que un mismo proceso de construcción produzca diferentes representaciones.

## Problema / motivación

Una empresa construye objetos `Renta` para departamentos, casas y terrenos. Una renta puede incluir canon, alícuota, agua, electricidad, internet, parqueadero y otros cargos; algunos componentes son obligatorios y otros opcionales según el tipo de propiedad. Un constructor con tantos parámetros hace difícil saber qué se configura y permite combinaciones poco claras. Se necesita construir el objeto paso a paso, con un proceso común y configuraciones distintas.

## Participantes (variante clásica)

| Rol | Responsabilidad | Ejemplo en el repo |
|---|---|---|
| Builder | Define las operaciones para construir las partes del producto. | `ConstructorRenta` (interfaz) |
| ConcreteBuilder | Implementa las operaciones, mantiene la representación en construcción y entrega el producto. | `ConstructorRentaDepartamento`, `ConstructorRentaCasa`, `ConstructorRentaTerreno` |
| Director | Coordina la construcción usando la interfaz `Builder`. | `DirectorRenta` |
| Product | Objeto complejo resultante. | `Renta` |

## Colaboraciones

1. El cliente selecciona un `ConcreteBuilder`.
2. El `Director` ejecuta la secuencia de construcción.
3. El `ConcreteBuilder` construye el producto progresivamente.
4. Al terminar, el cliente obtiene el producto.

## Variante moderna (sin Director)

El cliente configura el objeto con métodos encadenados y termina con `build()` (aquí, `construir()`). Resulta útil con muchos parámetros, atributos opcionales, para evitar constructores sobrecargados y para una construcción más legible.

| Variante | Cuándo elegirla | En el repo |
|---|---|---|
| Clásica (con Director) | Hay un proceso de pasos que debe repetirse con distintas configuraciones. | `ConstructorRenta*`, `ConstructorMenu*`, `ReservaBuilder` |
| Fluida | Muchos parámetros opcionales y se busca legibilidad. | `ConstructorRenta` (fluido), `ConstructorPersonaje`, `ConstructorReporte` |

## Aplicabilidad

Conviene cuando:

- la construcción debe ser independiente de las partes y de cómo se ensamblan;
- un mismo proceso debe producir diferentes representaciones;
- la construcción requiere varios pasos que conviene controlar;
- se quiere separar la lógica de construcción del objeto resultante.

Es útil cuando el problema principal no es **qué** objeto crear, sino **cómo** construirlo progresivamente.

## Contenido

| Carpeta | Qué contiene |
|---|---|
| [`class-activity/`](class-activity) | Actividad de clase: cuatro casos (reserva de vuelo, personaje, reporte financiero y menú), con su diagrama UML. |
| [`guided-review/`](guided-review) | Resolución guiada: rentas sin patrón, con Builder clásico y con Builder fluido, e implementación en Java. |
