# Revisión del diagrama `pedidos.puml` contra `prompt.md`

**Archivos revisados:** `pedidos.puml` (propuesta del grupo) y `prompt.md` (criterios y enunciado).
**Fecha de la revisión:** 2026-10-02

**Veredicto general:** el modelo cumple los requisitos obligatorios y es coherente con el enunciado. Los problemas encontrados son de refinamiento, no de fondo.

---

## Índice

1. [Enunciado resumido](#1-enunciado-resumido)
2. [Inventario del modelo](#2-inventario-del-modelo)
3. [Validación contra la rúbrica](#3-validación-contra-la-rúbrica)
4. [Revisión de cada relación](#4-revisión-de-cada-relación)
5. [Revisión crítica](#5-revisión-crítica)
6. [Evidencia del uso de IA](#6-evidencia-del-uso-de-ia)
7. [Preparación para la explicación oral](#7-preparación-para-la-explicación-oral)
8. [Checklist de acciones](#8-checklist-de-acciones)

---

## 1. Enunciado resumido

- Un cliente puede registrar varios pedidos.
- Cada pedido contiene uno o más detalles; cada detalle registra producto, cantidad y precio aplicado.
- Los productos son físicos o digitales y calculan su costo de entrega de forma diferente.
- Un catálogo organiza los productos, que pueden existir independientemente de él.
- Para confirmar un pedido se usa un servicio externo de pagos.
- Los atributos sensibles deben permanecer encapsulados.

## 2. Inventario del modelo

| Clase | Atributos (todos `-`) | Operaciones (todas `+`) |
|---|---|---|
| `Cliente` | `id: int`, `nombre: String`, `correo: String`, `pedidos: List<Pedido>` | `registrarPedido(): Pedido` |
| `Pedido` | `id: int`, `fecha: LocalDate`, `estado: String`, `detalles: List<DetallePedido>` | `agregarDetalle(producto: Producto, cantidad: int): void`, `calcularTotal(): double`, `confirmar(servicio: ServicioPago): boolean` |
| `DetallePedido` | `cantidad: int`, `precioAplicado: double`, `producto: Producto` | `calcularSubtotal(): double` |
| `Producto` (abstracta) | `id: int`, `nombre: String`, `precio: double` | `{abstract} calcularCostoEntrega(): double` |
| `ProductoFisico` | `peso: double`, `costoBaseEnvio: double` | `calcularCostoEntrega(): double` |
| `ProductoDigital` | `urlDescarga: String` | `calcularCostoEntrega(): double` |
| `Catalogo` | `id: int`, `nombre: String`, `productos: List<Producto>` | `agregarProducto(producto: Producto): void`, `buscarProducto(id: int): Producto` |
| `ServicioPago` (interfaz) | — | `procesarPago(monto: double): boolean` |

## 3. Validación contra la rúbrica

| Requisito | Cumple | Evidencia en el modelo | Problema encontrado / mejora |
|---|---|---|---|
| Clases con atributos y métodos | Sí | 7 clases y 1 interfaz, todas con atributos y operaciones | Ninguno de fondo |
| Visibilidad +, -, # | Sí | Atributos `-`, operaciones `+`, sin atributos públicos | No se usa `#`, y no hace falta |
| Tipos de datos | Sí | `int`, `String`, `LocalDate`, `double`, `List<…>` | `estado: String` podría ser un enum; `double` para dinero sería `BigDecimal` en Java real. Ambos opcionales |
| Valores de retorno | Sí | Todas las operaciones declaran retorno | Ninguno |
| Multiplicidades en ambos extremos | Sí | Las 4 asociaciones estructurales las tienen en ambos lados | `0..1` del lado `Catalogo` sin justificar en la cota superior (B1) |
| Navegabilidad | Sí | 4 flechas unidireccionales | Todas justificadas |
| Asociación | Sí | `Cliente → Pedido`, `DetallePedido → Producto` | Correctas |
| Composición | Sí | `Pedido *→ DetallePedido` | Correcta: el detalle no existe sin su pedido |
| Agregación | Sí | `Catalogo o→ Producto` | Correcta: los productos existen independientemente |
| Generalización | Sí | `Producto <|-- ProductoFisico / ProductoDigital` | Correcta, superclase abstracta justificada |
| Dependencia | Sí | `Pedido ..> ServicioPago` | Correcta: parámetro de `confirmar()` |
| Responsabilidades coherentes | Sí | Cada clase tiene una responsabilidad clara | Falta saber quién usa `calcularCostoEntrega()` (B2) |
| Encapsulación | Sí | Atributos privados, sin getters/setters | `DetallePedido` necesita leer `Producto.precio` y no hay operación para ello (B3) |

## 4. Revisión de cada relación

| Clase A | Relación | Clase B | Mult. A | Mult. B | Navegabilidad | Justificación |
|---|---|---|---|---|---|---|
| Cliente | Asociación | Pedido | 1 | 0..* | Cliente → Pedido | "Un cliente puede registrar varios pedidos". Puede no tener pedidos (0). Cada pedido pertenece a un solo cliente (1). Solo `Cliente` necesita conocer sus pedidos. |
| Pedido | Composición | DetallePedido | 1 | 1..* | Pedido → DetallePedido | "Contiene uno o más detalles", mínimo 1. El detalle pertenece a un único pedido y no tiene sentido sin él. El pedido los necesita para calcular el total. |
| DetallePedido | Asociación | Producto | 0..* | 1 | DetallePedido → Producto | "Cada detalle registra un producto". Un producto puede estar en muchos detalles o en ninguno. Solo el detalle necesita conocer el producto. |
| Catalogo | Agregación | Producto | 0..1 | 0..* | Catalogo → Producto | "Organiza los productos... pueden existir independientemente". Un catálogo puede estar vacío. Un producto puede no estar en ningún catálogo. |
| Producto | Generalización | ProductoFisico, ProductoDigital | n/a | n/a | n/a | Relación "es un". Cada subclase redefine `calcularCostoEntrega()` (polimorfismo). |
| Pedido | Dependencia | ServicioPago | n/a | n/a | n/a | Uso temporal como parámetro de `confirmar()`. No es relación permanente. |

## 5. Revisión crítica

### A. Elementos correctos

- **Composición bien elegida.** `Pedido ◆→ DetallePedido`: el detalle depende del ciclo de vida del pedido y no es compartible. La alternativa `DetallePedido → Producto` sería un error, porque el producto es independiente.
- **Rombos en el lado del todo.** Están en `Pedido` y `Catalogo`.
- **Agregación y composición bien distinguidas.** El producto sobrevive al catálogo; el detalle no sobrevive al pedido.
- **`precioAplicado` en `DetallePedido`.** Conserva el precio histórico aunque cambie `Producto.precio`, y responde al enunciado.
- **Herencia real.** Hay un "es un". Los atributos comunes (`id`, `nombre`, `precio`) están en la superclase y los propios (`peso`, `costoBaseEnvio`, `urlDescarga`) en las subclases. `Producto` es abstracta porque no tiene sentido instanciarla.
- **Dependencia bien diferenciada.** Línea discontinua y sin atributo `servicio` en `Pedido`.
- **Encapsulación.** Atributos privados, operaciones de negocio (`agregarDetalle`, `confirmar`) y ningún getter/setter genérico.

### B. Errores o puntos a corregir

1. **Multiplicidad `0..1` del lado `Catalogo`.** El enunciado justifica el `0` (el producto existe sin catálogo), pero no dice que no pueda estar en varios catálogos. Opciones:
   - `0..*`: asume menos y es la más segura según el prompt ("no inventes multiplicidades").
   - `0..1`: válida si el grupo la defiende como "un producto pertenece a un solo catálogo".
2. **`calcularCostoEntrega()` sin usuario claro.** Ninguna operación visible lo invoca. El grupo debe poder decir si lo usa `DetallePedido.calcularSubtotal()` o `Pedido.calcularTotal()`. No requiere nuevas relaciones.
3. **Lectura del precio con atributo privado.** `agregarDetalle(producto, cantidad)` debe copiar `producto.precio` a `precioAplicado`, pero `precio` es privado. Opciones:
   - Un `+obtenerPrecio(): double` explícito en `Producto`.
   - Que `DetallePedido` reciba el precio por constructor.

   En ambos casos conviene mencionarlo oralmente, porque el diagrama no lo muestra.
4. **Atributos duplicados con asociaciones.** `Cliente.pedidos`, `Pedido.detalles`, `DetallePedido.producto` y `Catalogo.productos` aparecen como atributo y como línea de asociación. Es un defecto menor, y la repetición es habitual si se piensa en el código Java. Para ser consistente hay que elegir:
   - Quitar los atributos y dejar solo las líneas (recomendado).
   - Quitar las líneas y dejar solo atributos (no viable: se perderían asociación, composición y agregación).

### C. Mejoras recomendadas

- Eliminar los 4 atributos duplicados (B4). Es el cambio con mayor valor UML.
- Ajustar `0..1` a `0..*` o dejar lista su justificación (B1).
- Opcional: `estado` como enum (`PENDIENTE`, `CONFIRMADO`). Añade un elemento, así que solo si el grupo lo quiere defender.
- Opcional: estereotipo `<<use>>` en la dependencia.

### D. Elementos que NO deberían agregarse

- Dependencia `Pedido ..> Producto`: ya están relacionados mediante `DetallePedido`, solo añadiría ruido.
- Navegabilidad bidireccional (`Pedido → Cliente`, `Producto → DetallePedido`): ninguna clase la necesita.
- Clases `Pago`, `Estado` o `Factura`: el enunciado no las pide.
- Una clase que implemente `ServicioPago`: es un servicio externo.
- Patrones de diseño (Strategy, Factory, etc.) para el costo de entrega: la herencia con polimorfismo ya lo resuelve.
- Setters para `estado`: `confirmar()` ya controla el cambio.

**Nota sobre `ServicioPago` como interfaz:** está justificada. Es un servicio externo cuya implementación no se conoce, así que `Pedido` depende de un contrato. Es una de las pocas interfaces que el prompt permite, porque tiene una necesidad concreta.

## 6. Evidencia del uso de IA

**Recomendación principal de la IA**

- **Problema detectado:** `Cliente.pedidos`, `Pedido.detalles`, `DetallePedido.producto` y `Catalogo.productos` aparecen como atributo y como asociación a la vez.
- **Recomendación:** eliminarlos de los compartimentos de atributos y dejar la información solo en las líneas de relación. Si el grupo prefiere mantenerlos, debe poder explicar que es una decisión orientada al código Java.
- **Fundamento UML:** un extremo de asociación navegable ya representa un atributo de la clase origen. Mostrarlo dos veces es redundante (criterio 12, "no tenga relaciones redundantes").
- **Consecuencia de aplicar el cambio:** el diagrama queda más limpio y consistente. Se pierde la lista visible de atributos relacionales, y quien lea el diagrama debe interpretar las flechas.

*Es una recomendación para que el grupo la acepte, modifique o rechace. La IA no decide por el grupo.*

**Decisión del grupo:** _(pendiente: aceptada / modificada / rechazada, y por qué)_

## 7. Preparación para la explicación oral

### 7.1 Composición vs. agregación
- **Decisión:** `Pedido ◆→ DetallePedido` es composición y `Catalogo ◇→ Producto` es agregación.
- **Alternativa:** agregación en ambos casos, o composición en ambos.
- **Justificación:** el detalle no tiene sentido sin su pedido, se destruye con él y no es compartible. El enunciado dice que los productos "pueden existir independientemente del catálogo", por lo que una composición con `Catalogo` lo contradiría.

### 7.2 Herencia y polimorfismo en `Producto`
- **Decisión:** `Producto` es abstracta, con `ProductoFisico` y `ProductoDigital` redefiniendo `calcularCostoEntrega()`.
- **Alternativa:** un solo `Producto` con atributo `tipo` y un `if` en el cálculo, o una interfaz `CalculoEntrega`.
- **Justificación:** hay un "es un" real y los atributos específicos (`peso`, `urlDescarga`) solo tienen sentido en cada subtipo. La abstracción evita instanciar un producto genérico y el polimorfismo elimina condicionales sobre el tipo.

### 7.3 Dependencia con `ServicioPago`, multiplicidad y navegabilidad
- **Decisión:** `Pedido ..> ServicioPago` es una dependencia (parámetro de `confirmar()`), y las asociaciones son unidireccionales con la multiplicidad mínima justificada por el texto.
- **Alternativa:** asociación permanente con un atributo `servicio` en `Pedido`, o navegabilidad bidireccional `Cliente ↔ Pedido`.
- **Justificación:** el pedido solo usa el servicio durante la confirmación y no lo conserva, así que no es relación estructural. `Cliente` necesita conocer sus pedidos, pero `Pedido` no necesita conocer a su cliente para ninguna operación del enunciado.

## 8. Checklist de acciones

- [ ] Decidir sobre la multiplicidad `0..1` / `0..*` de `Catalogo → Producto` (B1).
- [ ] Definir quién invoca `calcularCostoEntrega()` y prepararlo para la oral (B2).
- [ ] Decidir cómo `DetallePedido` obtiene el precio del producto (B3).
- [ ] Aceptar, modificar o rechazar la recomendación principal sobre atributos duplicados (B4).
- [ ] Decidir si `estado` pasa a enum (opcional).
- [ ] Ensayar las tres decisiones de la sección 7.
