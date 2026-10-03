# Prompt
Actúa como revisor experto en UML, Programación Orientada a Objetos y diseño de software.
Voy a proporcionarte:
1. El enunciado de un problema.
2. Nuestra propuesta de diagrama de clases UML.
Tu función es revisar y validar nuestra propuesta, no rediseñarla completamente desde cero. Debes identificar errores, inconsistencias, elementos faltantes y posibles mejoras, manteniendo el diseño lo más simple y justificable posible.
Criterios obligatorios de validación
Revisa uno por uno los siguientes aspectos:
1. Clases y responsabilidades
- Verifica que las clases identificadas tengan sentido dentro del dominio.
- Comprueba que cada clase tenga una responsabilidad clara.
- Detecta responsabilidades mal ubicadas, duplicadas o excesivamente concentradas.
- Identifica clases innecesarias o clases que estén asumiendo demasiadas responsabilidades.
2. Atributos
Para cada atributo verifica:
- que pertenezca a la clase correcta;
- que tenga un tipo de dato apropiado;
- que tenga una visibilidad UML explícita;
- que los datos sensibles o internos permanezcan encapsulados.
Utiliza:
- + público;
- - privado;
- # protegido.
No recomiendes atributos públicos salvo que exista una razón explícita y justificable.
3. Métodos y operaciones
Verifica que:
- cada método represente una responsabilidad coherente de su clase;
- los parámetros tengan tipos;
- el tipo de retorno esté definido;
- la visibilidad esté indicada;
- no existan métodos ubicados en una clase que no debería ser responsable de esa operación.
Ejemplo esperado:
+calcularTotal(): double
o
+agregarElemento(elemento: Elemento, cantidad: int): void
4. Encapsulación
Comprueba que:
- el estado interno no pueda modificarse arbitrariamente;
- los atributos relevantes sean privados o protegidos;
- las modificaciones importantes se controlen mediante operaciones;
- no se utilicen getters/setters indiscriminadamente cuando existan operaciones de negocio más apropiadas.
5. Asociaciones
Revisa todas las asociaciones entre clases.
Para cada relación indica:
- qué clases participan;
- por qué existe la relación;
- si la dirección propuesta tiene sentido.
El modelo debe contener al menos una asociación UML válida.
6. Multiplicidades
Todas las asociaciones estructurales deben especificar multiplicidad en ambos extremos cuando corresponda.
Verifica el uso correcto de:
- 1
- 0..1
- 0..*
- 1..*
- otros rangos si fueran necesarios.
Para cada multiplicidad explica brevemente su significado respecto al enunciado.
No inventes multiplicidades que no puedan justificarse con el problema.
7. Navegabilidad
Revisa si las asociaciones necesitan navegación:
- unidireccional;
- bidireccional;
- o si no es necesario indicarla.
No agregues navegabilidad automáticamente a todas las relaciones.
Para cada flecha propuesta explica qué clase necesita conocer o acceder a la otra.
8. Composición
El diagrama debe contener al menos una composición.
Comprueba que la relación seleccionada realmente cumpla esta idea:
El objeto contenido depende fuertemente del objeto propietario y normalmente no tiene sentido o ciclo de vida independiente fuera de él.

Revisa:
- ubicación correcta del rombo negro;
- multiplicidades;
- justificación del ciclo de vida.
Si la composición elegida no es correcta, explica por qué y sugiere cuál relación del modelo sería más apropiada.
No fuerces una composición solo para cumplir el requisito sin justificación conceptual.
9. Agregación
El diagrama debe contener al menos una agregación.
Comprueba que represente correctamente una relación todo-parte débil donde:
- una clase agrupa o contiene elementos;
- los elementos pueden existir independientemente del agregado.
Revisa:
- ubicación correcta del rombo blanco;
- multiplicidades;
- independencia del ciclo de vida.
Distingue claramente la agregación de la composición.
10. Generalización / Herencia
El modelo debe contener al menos una generalización.
Comprueba que:
- exista una relación real de tipo “es un”;
- las subclases sean especializaciones válidas de la superclase;
- los atributos y métodos comunes estén ubicados en la superclase;
- la herencia no se utilice únicamente para reutilizar código.
Revisa también:
- si la superclase debería ser abstracta;
- qué operaciones podrían ser redefinidas mediante polimorfismo.
11. Dependencia
El diagrama debe contener al menos una dependencia.
Comprueba que una clase realmente use temporalmente a otra mediante, por ejemplo:
- parámetros;
- variables locales;
- servicios externos;
- llamadas a operaciones;
- creación temporal de objetos.
Distingue la dependencia de una asociación permanente.
La dependencia debe representarse mediante una línea discontinua con flecha.
12. Coherencia global
Revisa que el diseño:
- represente correctamente el enunciado;
- mantenga responsabilidades distribuidas;
- tenga alta cohesión;
- evite acoplamiento innecesario;
- no tenga relaciones redundantes;
- no introduzca elementos que el problema no necesita.
No agregues patrones de diseño, interfaces, clases abstractas o capas adicionales salvo que tengan una necesidad concreta.
Validación obligatoria contra la rúbrica
Al final genera una tabla como esta:
Requisito	Cumple	Evidencia en el modelo	Problema encontrado / mejora
Clases con atributos y métodos	Sí/No	...	...
Visibilidad +, -, #	Sí/No	...	...
Tipos de datos	Sí/No	...	...
Valores de retorno	Sí/No	...	...
Multiplicidades en ambos extremos	Sí/No	...	...
Navegabilidad	Sí/No	...	...
Asociación	Sí/No	...	...
Composición	Sí/No	...	...
Agregación	Sí/No	...	...
Generalización	Sí/No	...	...
Dependencia	Sí/No	...	...
Responsabilidades coherentes	Sí/No	...	...
Encapsulación	Sí/No	...	...


Revisión de cada relación
Después construye una segunda tabla:
Clase A	Relación	Clase B	Multiplicidad A	Multiplicidad B	Navegabilidad	Justificación


Incluye todas las relaciones del modelo.
Revisión crítica
Clasifica tus observaciones en:
A. Elementos correctos del diseño
Explica qué está bien y por qué.
B. Errores que deberían corregirse
Indica errores UML o incoherencias respecto al dominio.
C. Mejoras recomendadas
Propón únicamente cambios que aporten valor real.
D. Elementos que NO deberían agregarse
Señala recomendaciones que podrían sobrecomplicar innecesariamente el modelo.
Evidencia del uso de IA
Como esta IA funciona únicamente como revisora, selecciona al final:
Recomendación principal de la IA
Describe una recomendación concreta que el grupo pueda:
- aceptar;
- modificar;
- o rechazar.
Indica:
- problema detectado;
- recomendación;
- fundamento UML;
- consecuencia de aplicar el cambio.
No decidas por el grupo.
Preparación para la explicación oral
Propón tres decisiones de diseño relevantes que el grupo debería estar preparado para explicar oralmente.
Para cada una utiliza:
Decisión:
Qué se decidió.
Alternativa:
Qué otra opción podía utilizarse.
Justificación:
Por qué la solución seleccionada puede defenderse según el enunciado y UML.
Prioriza decisiones relacionadas con:
- composición vs. agregación;
- herencia/generalización;
- multiplicidad o navegabilidad;
- dependencia;
- encapsulación y responsabilidades.
Restricciones de la revisión
- No rediseñes todo automáticamente.
- No agregues requisitos que no aparecen en el problema.
- No confundas asociación, agregación, composición y dependencia.
- No fuerces herencia si no existe una relación “es un”.
- No fuerces composición cuando los objetos puedan vivir independientemente.
- No aceptes una relación solamente porque permite cumplir formalmente con la rúbrica.
- Señala explícitamente cualquier elemento que parezca agregado únicamente para cumplir el requisito académico.
- Cuando exista más de una solución UML válida, presenta las alternativas y sus implicaciones sin asumir que una es obligatoriamente la única correcta.
ENUNCIADO DEL PROBLEMA
Una tienda necesita modelar su proceso de compra:
• Un cliente puede registrar varios pedidos.
• Cada pedido contiene uno o más detalles; cada detalle registra un producto, la cantidad y el precio aplicado.
• Los productos pueden ser físicos o digitales y calculan su costo de entrega de manera diferente.
• Un catálogo organiza los productos disponibles, aunque estos pueden existir independientemente del 
catálogo.
• Para confirmar un pedido, el sistema utiliza un servicio externo de pagos.
• Los atributos sensibles deben permanecer encapsulados.
Reto del grupo
• Construir un diagrama UML que represente correctamente las clases, responsabilidades y relaciones del 
caso