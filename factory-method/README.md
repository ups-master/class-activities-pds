# Patrón Factory Method

Define una interfaz (método) para crear un objeto, pero deja que las **subclases decidan qué clase concreta instanciar**. El cliente depende solo de la abstracción.

## Cuándo usarlo

Cuando el código cliente no debe conocer la clase concreta que crea, o cuando se quieren añadir nuevos tipos sin modificar el código existente (principio abierto/cerrado).

## Participantes

| Rol | Ejemplo en el repo |
|---|---|
| Producto | `Contrato` (abstracta) |
| Productos concretos | `ContratoFijo`, `ContratoTemporal`, `ContratoFactura` |
| Creador | `CreadorContrato` (abstracta, con `crearContrato()`) |
| Creadores concretos | `CreadorFijo`, `CreadorTemporal`, `CreadorFactura` |

## Contenido

| Carpeta | Qué contiene |
|---|---|
| [`guided-review/`](guided-review) | Tres diagramas (sin patrón, Simple Factory y Factory Method) y la implementación en Java del Factory Method. |
