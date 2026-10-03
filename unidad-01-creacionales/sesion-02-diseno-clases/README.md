# Sesión 02 - Diseño de clases y código limpio

Material: [`diapositivas.md`](diapositivas.md) (35 diapositivas). Actividad: [`diagrama-completo/`](diagrama-completo).

## Diseño de clases

- Los requisitos dicen **qué** debe lograr el sistema, el diseño **cómo** se organiza y el código lo implementa.
- UML ofrece una notación compartida; el diagrama de clases muestra la estructura estática (clases, interfaces, atributos, operaciones y relaciones) y debe evolucionar con el código.
- Brooks (*No Silver Bullet*): la complejidad esencial no desaparece. La IA reduce el trabajo accidental, pero no reemplaza el criterio profesional.

| Concepto | Idea clave |
|---|---|
| Constructor | Fija el estado inicial y debe dejar el objeto en un estado válido. Si se declara alguno, Java ya no genera el constructor por defecto. |
| Sobrecarga | Mismo nombre, distintos parámetros; las variantes deben delegar en una versión principal. |
| Clase abstracta | Concepto general no instanciable, con estado y métodos concretos, y métodos abstractos que las subclases concretas implementan. La herencia debe expresar "es un", no solo reutilizar código. |
| Sobrescritura | Misma firma y retorno compatible, con `@Override`; no reduce la visibilidad. Se ejecuta la implementación del tipo real. |
| Interfaz | Contrato de comportamiento; permite programar contra abstracciones y reducir el acoplamiento. |
| Composición | Relación fuerte todo-parte: el todo controla el ciclo de vida y la parte pertenece a un solo compuesto. Rombo negro. |
| Agregación | Relación "tiene un" más débil: la parte existe sin el todo. Rombo blanco. |

## Actividad en clase: diagrama completo

Sistema de pedidos en línea con clientes, pedidos con detalles, productos físicos y digitales, un catálogo y un servicio externo de pagos. El diagrama debe incluir visibilidad, tipos, multiplicidades en ambos extremos, navegabilidad, y al menos una asociación, composición, agregación, generalización y dependencia. Se permite IA como revisora; se entrega el diagrama y la explicación oral de tres decisiones.

Resolución en el repo: [`diagrama-completo/`](diagrama-completo) (propuesta, revisión con IA, propuesta corregida e implementación en Java).

## Código limpio

El código se lee y modifica muchas más veces de las que se escribe. Refactorizar mejora la estructura sin cambiar el comportamiento (regla del Boy Scout: deja el código más limpio de lo que lo encontraste).

| Dimensión | Criterios principales |
|---|---|
| Nombres | Revelan la intención, usan el vocabulario del dominio y son pronunciables y buscables. Clases con sustantivos, métodos con verbos, booleanos como preguntas. |
| Funciones | Pequeñas, un solo propósito, un nivel de abstracción, pocos parámetros, sin booleanos de control ni efectos ocultos, con cláusulas de guarda. |
| DRY | Cada regla tiene una única representación autorizada. |
| Comentarios | Solo para explicar un porqué no evidente; si el código puede expresarlo, se refactoriza. |
| Formato | Mismas reglas en todo el proyecto, con formateador y analizador estático. |
| Objetos y datos | No devolver colecciones internas modificables ni generar getters/setters indiscriminados; Ley de Demeter. |
| Errores | Excepciones para condiciones excepcionales, específicas del dominio y sin datos sensibles. |
| Límites | Encapsular terceros mediante adaptadores y definir interfaces propias. |
| Clases | Un concepto claro, una responsabilidad principal y alta cohesión. |
| Pruebas | TDD (rojo, verde, refactorizar) y pruebas FIRST: rápidas, independientes, repetibles, autovalidables y oportunas. |

**Deuda técnica:** puede ser *prudente* (se acepta temporalmente, con plan para reducirla) o *imprudente* (sin tiempo para diseñar, copiar y pegar, omitir pruebas), y *deliberada* o *inadvertida* (aparece al aprender más del problema).

## Idea de cierre

Un sistema mantenible no surge únicamente de código que funciona, sino de responsabilidades claras, dependencias controladas y decisiones que pueden comprenderse y justificarse.
