# Prompt
Actúa como revisor experto en Programación Orientada a Objetos, UML y principios de diseño de software.
Te proporcionaré el enunciado del problema y nuestra propuesta inicial de diagrama de clases. No rediseñes la solución desde cero. Tu objetivo es revisar críticamente nuestra propuesta e identificar errores, inconsistencias y oportunidades de mejora.
Revisa específicamente:
1. Clases
   - Verifica si cada clase representa una responsabilidad clara del dominio.
   - Identifica clases innecesarias o responsabilidades que deberían separarse.
2. Atributos y operaciones
   - Comprueba que los atributos pertenezcan a la clase correcta.
   - Revisa los tipos de datos.
   - Verifica que las operaciones correspondan a las responsabilidades de la clase.
3. Encapsulación y visibilidad
   - Revisa el uso de private, protected y public.
   - Evita exponer atributos directamente.
   - Indica dónde deberían existir métodos que controlen cambios de estado.
4. Validaciones
   - Identifica qué reglas del negocio deberían validarse dentro de las clases.
   - Señala operaciones que puedan dejar los objetos en estados inválidos.
5. Asociaciones UML
   - Revisa las relaciones entre clases.
   - Comprueba las multiplicidades (1, 0..1, 1..*, 0..*).
   - Revisa si la navegabilidad propuesta tiene sentido.
   - Indica si alguna relación debería ser asociación, agregación o composición.
6. Herencia
   - Comprueba si las relaciones de herencia realmente representan una relación “es un”.
   - Si se está utilizando herencia solo para reutilizar código, indícalo.
   - Propón composición cuando sea más apropiada.
7. Principios de diseño
   - Revisa especialmente responsabilidad única, bajo acoplamiento, alta cohesión y encapsulación.
   - No propongas complejidad innecesaria.
8. Patrones de diseño
   - Determina si existe un problema concreto que justifique utilizar un patrón de diseño.
   - Considera patrones como Strategy, Factory Method, State, Observer o Template Method, pero no recomiendes ninguno solamente por incluir un patrón.
   - Para cada patrón recomendado explica:
     - qué problema resuelve;
     - qué clases participarían;
     - por qué mejora nuestra propuesta;
     - qué desventaja o complejidad introduce.
9. Operación con validación
   - Selecciona una operación importante del modelo.
   - Explica qué validaciones debería realizar.
   - Muestra un ejemplo breve en Java o pseudocódigo.
Finalmente entrega el análisis con esta estructura:
A. Aspectos correctos de nuestra propuesta
B. Errores o inconsistencias encontradas
C. Mejoras recomendadas
D. Patrón de diseño que podría aplicar y justificación
E. Recomendaciones que NO son necesarias o que podrían sobrecomplicar el diseño
F. Ejemplo de una operación con validación
Prioriza una solución sencilla, coherente con el problema y justificable académicamente. No agregues clases, patrones o relaciones que no tengan una necesidad concreta en el dominio.