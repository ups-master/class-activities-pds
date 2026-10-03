# Sesión 03 - Patrones creacionales

Material: [`diapositivas.md`](diapositivas.md) (32 diapositivas).

## Introducción

Los patrones creacionales abstraen y controlan la creación de objetos: deciden qué objeto crear, cómo configurarlo y cómo construirlo sin acoplar al cliente con clases concretas. No eliminan `new`; encapsulan o delegan la decisión donde conviene. Actúan principalmente por **herencia** (una subclase decide qué clase instanciar) o por **delegación** (otro objeto recibe la responsabilidad de crear). Si no hay un problema real, solo añaden complejidad.

## Catálogo

| Patrón | Qué resuelve | En el repo |
|---|---|---|
| **Factory Method** | Define un método para crear objetos y deja que las subclases decidan qué clase concreta instanciar. | [`factory-method/`](factory-method) |
| **Builder** | Separa la construcción de un objeto complejo de su representación, con un mismo proceso para distintas representaciones. | [`builder/`](builder) |
| **Singleton** | Garantiza una única instancia y un punto de acceso controlado. | [`singleton/`](singleton) |
| Abstract Factory | Crea familias de objetos relacionados sin especificar sus clases concretas. | Semana 2 |
| Prototype | Crea objetos copiando una instancia existente. | Semana 2 |

Cada patrón asume una responsabilidad de creación distinta: Factory Method decide **qué** crear, Builder **cómo** construirlo y Singleton **cuántas** instancias existen.

## Cómo entender un patrón

Cinco preguntas: qué problema recurrente resuelve, en qué contexto aplica, qué participantes intervienen y cómo colaboran, qué estructura propone y qué consecuencias genera. Comprenderlo no es memorizar el diagrama, sino saber cuándo conviene usarlo.

## Cómo usar un patrón (flujo de la clase)

1. Identificar el problema recurrente.
2. Analizar el contexto: dominio, restricciones y objetivos.
3. Evaluar si un patrón aporta valor y si sus consecuencias son aceptables.
4. Seleccionar el patrón que mejor equilibre las fuerzas.
5. Modelar la solución en UML: participantes, responsabilidades y colaboraciones.
6. Aclarar el diseño con IA: entregar el modelo y pedir preguntas sobre supuestos y decisiones pendientes.
7. Implementar con IA: generar código y pruebas a partir del UML y de las decisiones del diseñador.
8. Validar y ajustar: contrastar UML, código y pruebas y corregir desviaciones.

## Estructura de la carpeta

Cada patrón tiene la actividad de clase (casos de las diapositivas, solo diagramas) y la resolución guiada (diagramas e implementación en Java).

```
sesion-03-patrones-creacionales/
├── diapositivas.md
├── factory-method/   class-activity/ (4 casos), guided-review/ (contratos)
├── builder/          class-activity/ (4 casos), guided-review/ (rentas)
└── singleton/        class-activity/ (4 casos), guided-review/ (configuración global)
```

## Soluciones de referencia del docente

- Factory Method: <https://github.com/mortizo/pds-unidad01-ooms/tree/master/src/main/java/p69/factoryMethod>
- Builder: <https://github.com/mortizo/pds-unidad01-ooms/tree/master/src/main/java/p69/builder>
- Builder moderno (sin Director): <https://github.com/mortizo/pds-unidad01-ooms/tree/master/src/main/java/p69/mBuilder>
- Singleton: <https://github.com/mortizo/pds-unidad01-ooms/tree/master/src/main/java/p69/singleton>

## Idea de cierre

Los patrones creacionales no eliminan la creación de objetos; asignan mejor la responsabilidad de decidir cómo, qué y cuántos objetos crear.
