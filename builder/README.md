# Patrón Builder

Separa la **construcción** de un objeto complejo de su representación, de modo que un mismo proceso pueda crear configuraciones distintas.

## Cuándo usarlo

Cuando un objeto tiene muchos componentes, varios son opcionales y un constructor con muchos parámetros posicionales resulta ilegible o propenso a errores.

## Variantes que aparecen en el repo

| Variante | Participantes | Idea |
|---|---|---|
| **Clásico** (GoF) | Producto, interfaz Builder, Builders concretos, Director | El Director define el orden de los pasos y cada Builder concreto decide qué construye. |
| **Fluido** | Producto, Builder encadenable | Cada método devuelve el propio builder y el orden no importa. |

## Contenido

| Carpeta | Qué contiene |
|---|---|
| [`class-activity/`](class-activity) | Actividad de clase: Builder clásico para una reserva de vuelo (solo diagrama). |
| [`guided-review/`](guided-review) | Revisión guiada: rentas de departamentos, casas y terrenos, sin patrón, con Builder clásico y con Builder fluido (diagramas e implementación en Java). |
