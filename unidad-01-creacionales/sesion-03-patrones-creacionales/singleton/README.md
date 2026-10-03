# Patrón Singleton

## Propósito

Garantiza que una clase tenga una única instancia y proporciona un punto de acceso controlado a ella.

## Problema / motivación

Un sistema comparte un recurso cuya existencia debe controlarse durante la ejecución, por ejemplo un componente de configuración global usado por varios módulos. Si cada módulo crea su propia instancia, pueden existir configuraciones inconsistentes o duplicadas. Se necesita controlar la creación, garantizar una sola instancia dentro del alcance definido y ofrecer un acceso conocido.

## Participantes

| Rol | Responsabilidad | Ejemplo en el repo |
|---|---|---|
| Singleton | Guarda su única instancia, controla su creación, ofrece una operación pública de acceso y impide que los clientes la creen con un constructor no público. | `ConfiguracionGlobal` (`- {static} instancia`, constructor privado, `+ {static} obtenerInstancia()`) |
| Cliente | Pide la instancia con `obtenerInstancia()` sin controlar su creación. | `ModuloFacturacion`, `ModuloInventario`, `ModuloReportes` |

## Colaboraciones

- Los clientes solicitan la instancia mediante una operación como `getInstance()` (aquí `obtenerInstancia()`).
- La clase la crea cuando corresponde y devuelve siempre la misma referencia.
- Los clientes la usan sin conocer ni controlar su creación.

## Aplicabilidad

Conviene cuando:

- debe existir una única instancia controlada dentro de un alcance determinado;
- esa instancia es un recurso o servicio compartido por varios componentes;
- hay que controlar explícitamente cómo se crea y cómo se accede;
- varias instancias podrían provocar inconsistencias o conflictos.

**Evitarlo** cuando:

- solo se busca una variable global;
- la clase tiene demasiadas responsabilidades;
- dificulta las pruebas unitarias o introduce dependencias ocultas;
- el problema se resuelve mejor con inyección de dependencias.

## Contenido

| Carpeta | Qué contiene |
|---|---|
| [`class-activity/`](class-activity) | Actividad de clase: cuatro casos (configuración, impresión, sesiones y base de datos) con su diagrama UML y la justificación de cada uno. |
| [`guided-review/`](guided-review) | Resolución guiada: diagrama e implementación en Java de una configuración global compartida por tres módulos. |
