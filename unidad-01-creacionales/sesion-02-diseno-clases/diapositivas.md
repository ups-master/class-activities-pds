# Unidad_01_02_PDS

> Conversión a Markdown del PDF original. Total de diapositivas: 35.

## Diapositiva 1

### Patrones de Diseño de Software

Maestría en

Software

Autor(es):

Mauricio Ortiz Ochoa

mortizo@ups.edu.ec

---

## Diapositiva 2

### Unidad 01. Patrones de diseño creacionales

---

## Diapositiva 3

### Diseño de clases

- Diseño de clases
- Código limpio
---

## Diapositiva 4

**Sección:** Diseño de Clases

### La necesidad de diseñar software

- La complejidad aumenta con el número de reglas, componentes, dependencias y cambios.
- Los requisitos establecen qué debe lograr el sistema; el diseño define cómo se organizará la solución.
- Los modelos permiten analizar responsabilidades, relaciones y alternativas antes de comprometerse con el código.
- Un diseño compartido facilita la comunicación y coordinación entre los integrantes del equipo.
- El diseño no es un plano inmutable: se revisa y mejora conforme aprendemos sobre el problema y la solución.
Requisitos: qué → Diseño: cómo → Código: implementación

---

## Diapositiva 5

**Sección:** Diseño de Clases

### No existe la bala de plata

Brooks, F. P. (1987). No Silver Bullet: Essence and Accidents of Software Engineering.

- Complejidad: múltiples componentes, estados, reglas y dependencias interactúan entre sí.
- Conformidad: el software debe ajustarse a procesos, regulaciones, interfaces y sistemas existentes.
- Cambio continuo: los requisitos y el contexto evolucionan; el software exitoso recibe nuevas modificaciones.
- Invisibilidad: su estructura conceptual no puede observarse directamente; cada modelo representa solamente una perspectiva.
¿La IA generativa es la nueva bala de plata?

- Puede acelerar el modelado, la generación de código, las pruebas y la documentación.
- Sin embargo, no determina por sí sola el contexto, las restricciones ni las consecuencias de una decisión de diseño.
La IA reduce trabajo accidental, pero no elimina la complejidad esencial ni reemplaza el criterio profesional.

---

## Diapositiva 6

**Sección:** Diseño de Clases

### UML

UML = Unified Modeling Language.
- Lenguaje visual estandarizado por el Object Management Group (OMG) para representar diferentes perspectivas de un sistema.
- Surgió de la unificación de los métodos de Grady Booch, Ivar Jacobson y James Rumbaugh.
- Proporciona una notación compartida, pero no determina una metodología ni un proceso de desarrollo.
- Un modelo selecciona los elementos necesarios para comunicar y analizar decisiones de diseño; no pretende reproducir todo el código. Diagrama de Clases
- Representa la estructura estática del sistema.
- Muestra clases, interfaces, atributos, operaciones y relaciones.
- Permite analizar responsabilidades y colaboraciones antes y durante la implementación.
- Debe evolucionar junto con el diseño y el código.

---

## Diapositiva 7

**Sección:** Diseño de Clases

> **Contenido visual:** esta diapositiva contiene una imagen, diagrama o esquema relevante en el PDF original.

---

## Diapositiva 8

**Sección:** Diseño de Clases

### Constructores

- Un constructor establece el estado inicial de una nueva instancia.
- En Java, tiene el mismo nombre de la clase y no declara tipo de retorno.
- Se ejecuta al crear una instancia mediante new.
- Su declaración es opcional: si no se declara ninguno, Java proporciona un constructor sin parámetros.
- Cuando se declara al menos un constructor, Java deja de generar automáticamente el constructor por defecto.
- Un constructor debe asegurar que el objeto comience en un estado válido.
---

## Diapositiva 9

**Sección:** Diseño de Clases

### Sobrecarga: misma intención, distintas entradas

- Consiste en declarar varios métodos o constructores con el mismo nombre y diferentes listas de parámetros.
- La diferencia puede estar en el número, tipo u orden de los parámetros.
- El tipo de retorno, por sí solo, no permite sobrecargar un método en Java.
- Es apropiada cuando todas las variantes representan la misma responsabilidad.
- Las implementaciones deberían delegar en una versión principal para evitar duplicación.
- Demasiadas variantes pueden volver ambigua la creación del objeto.
---

## Diapositiva 10

**Sección:** Diseño de Clases

### Clases Abstractas: contrato y comportamiento común

- Representan conceptos generales que no deben instanciarse directamente.
- Pueden declarar atributos, constructores y métodos concretos.
- También pueden declarar métodos abstractos: especifican una operación, pero no proporcionan su implementación.
- Toda subclase concreta debe implementar los métodos abstractos heredados.
- Una subclase abstracta puede posponer esa implementación.
- Son apropiadas cuando las subclases comparten identidad, estado y comportamiento dentro de una relación “es un”.
- La herencia debe expresar una relación conceptual válida, no utilizarse únicamente para reutilizar código.
---

## Diapositiva 11

**Sección:** Diseño de Clases

### Clases Abstractas

> **Contenido visual:** esta diapositiva contiene una imagen, diagrama o esquema relevante en el PDF original.

---

## Diapositiva 12

**Sección:** Diseño de Clases

### Sobrescritura de métodos (override)

- Una subclase puede proporcionar una implementación específica de un método heredado.
- El método sobrescrito mantiene la misma firma y un tipo de retorno compatible.
- La anotación @Override permite verificar que realmente se está sobrescribiendo un método.
- No se puede reducir la visibilidad definida por la clase base.
- this representa la instancia actual.
- super.metodo() permite reutilizar explícitamente la implementación de la clase base.
- Cuando se invoca el método mediante una referencia base, Java ejecuta la implementación correspondiente al tipo real del objeto.
---

## Diapositiva 13

**Sección:** Diseño de clases

### Composición: propiedad y ciclo de vida

- Es una relación fuerte entre un todo y sus partes.
- El todo controla la pertenencia y el ciclo de vida de las partes dentro del modelo.
- Una parte pertenece como máximo a un único compuesto al mismo tiempo.
- Si el todo desaparece, sus partes dejan de existir como elementos independientes del modelo.
- Se representa mediante un rombo negro en el extremo del todo.
- Debe utilizarse únicamente cuando exista una dependencia real de ciclo de vida.
---

## Diapositiva 14

**Sección:** Diseño de clases

### Agregación: relación todo–parte

- Es una relación entre un todo y sus partes, pero más débil que la composición.
- El todo agrupa o utiliza las partes, pero no controla necesariamente su ciclo de vida.
- Una parte puede existir independientemente del todo.
- Si el todo desaparece, sus partes pueden continuar existiendo dentro del modelo.
- Se representa mediante un rombo blanco en el extremo del todo.
- Debe utilizarse cuando exista una relación conceptual “tiene un”, pero sin dependencia estricta de ciclo de vida.
---

## Diapositiva 15

**Sección:** Diseño de Clases

### Interfaces

- Define un contrato de comportamiento que una clase puede implementar.
- Declara las operaciones que el objeto debe ofrecer, sin imponer cómo resolverlas.
- Una clase puede implementar una o varias interfaces.
- Permite programar contra abstracciones y reducir el acoplamiento.
- En Java puede contener métodos abstractos, default, static y private.
- Los campos declarados en una interfaz son implícitamente public static final.
- Una clase concreta debe implementar los métodos abstractos que correspondan.
---

## Diapositiva 16

**Sección:** Actividad en clase: diagrama completo

### Caso: sistema de pedidos en línea

Una tienda necesita modelar su proceso de compra:

- Un cliente puede registrar varios pedidos.
- Cada pedido contiene uno o más detalles; cada detalle registra un producto, la cantidad y el precio aplicado.
- Los productos pueden ser físicos o digitales y calculan su costo de entrega de manera diferente.
- Un catálogo organiza los productos disponibles, aunque estos pueden existir independientemente del catálogo.
- Para confirmar un pedido, el sistema utiliza un servicio externo de pagos.
- Los atributos sensibles deben permanecer encapsulados.
Reto del grupo

- Construir un diagrama UML que represente correctamente las clases, responsabilidades y relaciones del caso.
---

## Diapositiva 17

**Sección:** Actividad en clase: diagrama completo

### Caso: sistema de pedidos en línea

El diagrama debe incluir:
- Clases con atributos y métodos relevantes.
- Visibilidad UML: +, − o #.
- Tipos de datos y valores de retorno.
- Multiplicidades en ambos extremos.
- Navegabilidad cuando sea necesaria.
- Al menos una asociación, una composición, una agregación, una generalización y una dependencia.
- Responsabilidades distribuidas coherentemente entre las clases. Uso permitido de IA:
- Pueden utilizar IA como revisora, pero el grupo debe decidir y justificar el diseño final.
- Registrar el prompt utilizado y una recomendación de la IA que hayan aceptado, modificado o rechazado. Entrega:
- Diagrama UML exportado en PDF o PNG y explicación oral de tres decisiones de diseño

---

## Diapositiva 18

### Código limpio

- Diseño de clases
- Código limpio
---

## Diapositiva 19

**Sección:** Código limpio

### ¿Por qué escribir un código limpio?

- Que el código funcione es indispensable, pero no garantiza que sea comprensible ni fácil de modificar.
- Sin disciplina de diseño, el crecimiento del sistema incrementa el costo y el riesgo de cada cambio.
- El código se lee y modifica muchas más veces de las que se escribe.
- La duplicación, la complejidad y las responsabilidades confusas acumulan deuda técnica.
- Refactorizar mejora la estructura interna sin cambiar el comportamiento observable.
Regla del Boy Scout

- Deja el código un poco más limpio de lo que lo encontraste.
---

## Diapositiva 20

**Sección:** Código limpio

### Deuda Técnica

Imprudente Prudente

- No hay tiempo para diseñar.
- Copiar y pegar sin evaluar consecuencias.
- Omitir pruebas o refactorización sin un plan.
  - Se acepta temporalmente por una restricción concreta.
  - Se registran sus impactos y riesgos.
  - Se define cuándo y cómo reducirla.
Deliberada

- Desconocimiento de principios de diseño.
- Responsabilidades y dependencias mal distribuidas.
- La complejidad aparece durante el mantenimiento.
  - La implementación genera nuevo aprendizaje.
  - Después descubrimos una solución mejor.
  - Nuevos requisitos revelan limitaciones del diseño.
Inadvertida

---

## Diapositiva 21

**Sección:** Código limpio

### Dimensiones del código limpio

- Nombres significativos.
- Funciones pequeñas y cohesionadas.
- Comentarios necesarios y precisos.
- Formato consistente.
- Objetos y estructuras de datos.
- Manejo de errores.
- Límites e integraciones externas.
- Pruebas automatizadas.
- Clases con responsabilidades claras.
---

## Diapositiva 22

**Sección:** Código limpio

### Nombres significativos

- Deben revelar la intención y utilizar el vocabulario del dominio.
- Deben ser pronunciables, buscables y suficientemente específicos.
- Utilizar el mismo término para el mismo concepto.
- Evitar abreviaturas ambiguas, nombres genéricos y codificaciones de tipo.
- Las clases se nombran con sustantivos; los métodos, con verbos.
- Los booleanos deben formularse como preguntas: isActive, hasPermission, canRetry.
- Utilizar un solo idioma de manera consistente según las convenciones del proyecto.
---

## Diapositiva 23

**Sección:** Código limpio

### Funciones

- Pequeñas, enfocadas y con un solo propósito.
- Mantienen un nivel de abstracción coherente.
- Su nombre expresa claramente la acción realizada.
- Prefieren pocos parámetros; más de tres sugieren revisar el diseño.
- Evitan parámetros booleanos y efectos secundarios ocultos.
- Utilizan cláusulas de guarda para reducir el anidamiento.
- Extraen y reutilizan la lógica duplicada.
- Separan consultas de operaciones que modifican el estado.
---

## Diapositiva 24

**Sección:** Código limpio

### Principio DRY

- Don’t repeat Yourself.
- Una regla o conocimiento del sistema debe tener una única representación autorizada.
- Evita duplicar reglas de negocio, validaciones, cálculos y transformaciones.
- Centraliza la lógica verdaderamente común en una función, clase o módulo.
- Reduce el riesgo de corregir una copia y olvidar las demás.
- Facilita que los cambios se realicen y prueben en un solo lugar.
- Refactoriza cuando las repeticiones representan el mismo concepto y tienen la misma razón para cambiar.
---

## Diapositiva 25

**Sección:** Código limpio

### Comentarios

- No se debe documentar mediante comentarios aquello que el propio código puede expresar.
- Los nombres, funciones, clases y constantes deben revelar claramente la intención.
- Antes de añadir un comentario, se debe intentar mejorar o refactorizar el código.
- Los comentarios desactualizados generan desinformación y deuda técnica.
- Comentar únicamente cuando sea necesario explicar un porqué no evidente: una restricción externa, una decisión de negocio, un riesgo o una consecuencia.
---

## Diapositiva 26

**Sección:** Código limpio

### Formato

- El formato debe facilitar la lectura y hacer visible la estructura del código.
- Todo el proyecto debe aplicar las mismas reglas de sangría, espacios, llaves, saltos de línea e importaciones.
- Utilizar un formateador y un analizador estático configurados para todo el equipo.
- Integrar estas verificaciones en el IDE y en el proceso de integración continua.
- Agrupar instrucciones relacionadas y separar conceptos diferentes mediante espacios en blanco.
- Organizar los archivos desde el contrato público y los elementos generales hacia los detalles de implementación.
- Evitar alineaciones manuales que se rompen cuando cambia el código.
- Las convenciones del proyecto prevalecen sobre las preferencias personales.
---

## Diapositiva 27

**Sección:** Código limpio

### Objetos y estructuras de datos

- Una estructura de datos representa valores y ofrece poco comportamiento.
- Elegir conscientemente según el tipo de cambio esperado.
- Evitar híbridos que exponen datos y, al mismo tiempo, concentran comportamiento.
- No devolver colecciones internas modificables ni generar getters y setters indiscriminadamente.
- Aplicar la Ley de Demeter: colaborar únicamente con objetos conocidos directamente.
---

## Diapositiva 28

**Sección:** Código limpio

### Procesar Errores

- Utilizar excepciones para condiciones excepcionales, no como flujo normal de control.
- Preferir excepciones específicas del dominio.
- Capturar una excepción únicamente cuando pueda recuperarse, tratarse o enriquecerse.
- Conservar la causa original y añadir contexto útil.
- Evitar bloques catch vacíos y capturas genéricas.
- Representar explícitamente la ausencia mediante Optional, resultados tipados o colecciones vacías cuando corresponda.
- No incluir contraseñas, tokens ni datos sensibles en mensajes o registros.
---

## Diapositiva 29

**Sección:** Código limpio

### Límites

- Separar el dominio del código desarrollado por otros equipos o proveedores.
- Definir interfaces propias y estables para las necesidades del sistema.
- Encapsular bibliotecas externas mediante adaptadores.
- Evitar que tipos, excepciones y configuraciones de terceros se propaguen por toda la aplicación.
- Crear pruebas de aprendizaje o de contrato para verificar el comportamiento externo.
- Mantener versiones controladas y evaluar los cambios antes de actualizar dependencias.
- Documentar los supuestos y restricciones existentes en el límite.
---

## Diapositiva 30

**Sección:** Código limpio

### Clases

- Una clase debe representar un concepto claro y tener una responsabilidad principal.
- Debe existir una razón coherente para que cambie.
- La cohesión es alta cuando sus métodos colaboran sobre un estado y propósito relacionados.
- Mantener una interfaz pública pequeña y ocultar los detalles de implementación.
- Distribuir persistencia, pagos, notificaciones y reglas de negocio en responsabilidades diferentes.
- Organizar sus elementos siguiendo una convención compartida por el equipo.
- Evaluar el tamaño por responsabilidades, no por un número arbitrario de líneas.
---

## Diapositiva 31

**Sección:** Código limpio

### Pruebas

Ciclo TDD
- Rojo: escribir una prueba que describa el comportamiento esperado y comprobar que falla.
- Verde: implementar el código mínimo necesario para aprobarla.
- Refactorizar: mejorar el diseño manteniendo todas las pruebas aprobadas.
- Repetir el ciclo mediante incrementos pequeños. Las pruebas deben ser FIRST
- Fast: rápidas.
- Independent: independientes.
- Repeatable: repetibles.
- Self-validating: con resultado inequívoco.
- Timely: escritas oportunamente.

---

## Diapositiva 32

**Sección:** Unidad 01.02

### Retroalimentación y cierre

Qué vimos hoy
- El diseño de clases transforma los requisitos en responsabilidades, relaciones y decisiones implementables.
- UML permite representar clases, atributos, operaciones, multiplicidades, navegabilidad y dependencias.
- Los constructores deben garantizar que los objetos comiencen en un estado válido.
- Las clases abstractas y las interfaces permiten trabajar con abstracciones y reducir el acoplamiento.
- La composición controla el ciclo de vida de sus partes; la agregación permite que estas existan independientemente.
- La actividad grupal integró las relaciones UML y utilizó IA para revisar, no sustituir, las decisiones del equipo.
- El código limpio facilita comprender, modificar y probar el sistema.
- Los nombres, funciones, clases, límites, errores y pruebas influyen directamente en la mantenibilidad. Antes de finalizar: ¿Qué decisión del diagrama o del código modificarían ahora y por qué? Idea final: Un sistema mantenible no surge únicamente de código que funciona, sino de responsabilidades claras, dependencias controladas y decisiones que pueden comprenderse y justificarse.

---

## Diapositiva 33

**Sección:** Anexos

### Bibliografía

Gamma, E., Helm, R., Johnson, R. y Vlissides, J.; Design Patterns: Elements of Reusable Object-Oriented Software; 1.ª edición, 1994.

Sarcar, V.; Java Design Patterns: A Hands-On Experience with Real-World Examples; 3.ª edición, 2022.

Musch, O.; Design Patterns with Java: An Introduction; 1.ª edición, 2023.

Fowler, M.; UML Distilled: A Brief Guide to the Standard Object Modeling Language; 3.ª edición, 2004.

Shvets, A.; Sumérgete en los patrones de diseño; 1.ª edición, 2019.

IEEE Computer Society; Guide to the Software Engineering Body of Knowledge — SWEBOK Guide V4.0a; versión 4.0a, 2025.

Asaad, J. y Avksentieva, E.; Assessing the Impact of GoF Design Patterns on Software Engineering Practices; 2025.

---

## Diapositiva 34

**Sección:** Anexos

### Links de Referencia

- https://www.campusmvp.es/recursos/post/los-conceptos-fundamentales-sobre-programacion-orientada- objetos-explicados-de-manera-simple.aspx
- https://codideep.com/blogpost/stupid-vs-solid
- https://refactoring.guru/design-patterns
- https://reactiveprogramming.io/books/design-patterns/es
---

## Diapositiva 35

Gracias por su atención

> **Contenido visual:** esta diapositiva contiene una imagen, diagrama o esquema relevante en el PDF original.

---
