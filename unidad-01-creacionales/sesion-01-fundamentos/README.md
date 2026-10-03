# Sesión 01 - Fundamentos de patrones y bases de POO

Material: [`diapositivas.md`](diapositivas.md) (44 diapositivas). Actividad: [`actividad-diagnostica/`](actividad-diagnostica).

## Temas

1. Propósito y organización de la asignatura
2. Fundamentos de patrones
3. Bases de POO para comprender patrones
4. Actividad diagnóstica

## Fundamentos de patrones

Un patrón es una descripción reutilizable de una solución general para un problema recurrente en un contexto determinado. Su origen está en la arquitectura (Christopher Alexander, *A Pattern Language*, 1977); en software, Kent Beck y Ward Cunningham lo proponen en 1987 y el *Gang of Four* (Gamma, Helm, Johnson y Vlissides) cataloga 23 patrones en 1994.

| Un patrón describe | Un patrón NO es |
|---|---|
| El contexto en el que aparece el problema | Una solución universal |
| El problema recurrente | Una receta rígida |
| Las fuerzas o restricciones a equilibrar | Código listo para copiar |
| La estructura esencial de la solución | |
| Las consecuencias y compromisos | |

Según GoF, un patrón se documenta con cuatro partes: **nombre**, **problema**, **solución** y **consecuencias**.

Un patrón aporta vocabulario común y experiencia de diseño, pero aplicarlo sin un problema real añade complejidad y sobrediseño.

## Bases de POO

| Concepto | Idea clave |
|---|---|
| Objeto | Entidad con estado, comportamiento e identidad. |
| Abstracción | Elegir las características relevantes para un contexto e ignorar las demás. |
| Clase | Plantilla con nombre, atributos y métodos para crear objetos similares. |
| Asociación | Relación estructural entre clases; puede llevar nombre, multiplicidad, navegabilidad y roles. |
| Multiplicidad | Cuántas instancias se relacionan (`1`, `0..1`, `0..*`, `1..*`, `m..n`). Expresa una regla del dominio. |
| Navegabilidad | Qué clase conoce a cuál; la flecha apunta hacia la clase conocida. |
| Dependencia | Uso temporal (parámetro, variable local, retorno u objeto creado en una operación). |
| Visibilidad | `+` público, `-` privado, `#` protegido. Los atributos se mantienen privados. |
| Encapsulación | Protege el estado interno: atributos privados, métodos de acceso y validaciones que evitan estados inválidos. |
| Herencia | Relación "es un": la subclase puede usarse donde se espera la superclase. |

## Actividad diagnóstica

Grupal, 40 minutos, no calificable, IA permitida. Se pide diseñar un sistema de pedidos (cliente, pedido, producto y pago por tarjeta o transferencia) y entregar:

- Diagrama con clases, atributos y operaciones, visibilidad, encapsulación y validaciones.
- Asociaciones con multiplicidad y navegabilidad, y una herencia donde sea pertinente.
- Código Java o pseudocódigo de una operación con validación.
- Evidencia del uso crítico de IA: prompt principal, una recomendación aceptada y una rechazada o modificada, con justificación.

Resolución en el repo: [`actividad-diagnostica/`](actividad-diagnostica) (diagrama original y mejorado, revisión con IA e implementación en Java).

## Idea de cierre

Un patrón no es una receta ni un fragmento de código: es una decisión de diseño reutilizable que solo tiene sentido dentro de un contexto.
