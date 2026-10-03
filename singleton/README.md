# Patrón Singleton

Garantiza que una clase tenga **una sola instancia** y ofrece un punto de acceso global a ella.

## Cuándo usarlo

Cuando varias partes del sistema deben compartir el mismo recurso o estado y tener dos instancias causaría inconsistencias: configuración, gestor de impresión, sesiones de usuario, pool de conexiones.

## Cómo funciona

1. Constructor `private`: nadie crea la clase con `new`.
2. Atributo estático `instancia` que guarda la única instancia.
3. Método estático `obtenerInstancia()` que la crea la primera vez y devuelve la misma después.

## Contenido

| Carpeta | Qué contiene |
|---|---|
| [`class-activity/`](class-activity) | Actividad de clase: cuatro casos modelados en UML (configuración, impresión, sesiones y pool de conexiones). |
| [`guided-review/`](guided-review) | Revisión guiada: diagrama e implementación en Java de una configuración global compartida por tres módulos. |
