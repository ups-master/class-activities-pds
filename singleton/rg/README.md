# Singleton - Configuración Global

Implementación en Java del diagrama `configuracion-singleton.puml`. Varios módulos (facturación, inventario y reportes) comparten los mismos parámetros de configuración a través de una única instancia de `ConfiguracionGlobal`.

## Problema que resuelve

Si cada módulo crea su propia configuración con `new`, pueden quedar valores distintos o duplicados. El Singleton resuelve tres cosas:

1. **Controla la creación**: el constructor es `private`, así que ningún módulo puede instanciarla.
2. **Garantiza una sola instancia**: un atributo estático `instancia` la guarda.
3. **Da un acceso conocido**: `ConfiguracionGlobal.obtenerInstancia()` la crea la primera vez (inicialización perezosa) y devuelve la misma después. Es `synchronized`, por lo que es segura entre hilos.

## Estructura

```
rg/
├── README.md
├── configuracion-singleton.puml
└── configuracion-singleton/               # proyecto Maven
    ├── pom.xml
    ├── src/main/java/com/ejemplo/configuracion/
    │   ├── ConfiguracionGlobal.java       # el Singleton
    │   ├── ModuloFacturacion.java         # clientes
    │   ├── ModuloInventario.java
    │   ├── ModuloReportes.java
    │   └── Main.java                      # demo
    └── src/test/java/com/ejemplo/configuracion/
        ├── ConfiguracionGlobalTest.java
        └── ModulosTest.java
```

## Requisitos

- Java 25
- Maven 3.8+

Todos los comandos se ejecutan desde `configuracion-singleton/`.

## Cómo usarlo

No se usa `new`: se pide la instancia con `obtenerInstancia()`.

```java
ConfiguracionGlobal config = ConfiguracionGlobal.obtenerInstancia();

String moneda = config.obtenerParametro("moneda");   // "USD"
config.establecerParametro("moneda", "EUR");         // lo ven todos los módulos
```

`new ConfiguracionGlobal()` no compila fuera de la clase porque el constructor es privado.

Parámetros por defecto: `moneda=USD`, `iva=0.15`, `empresa=Mi Empresa`. Una clave que no existe devuelve `null`.

Para que un módulo nuevo use la configuración, basta con llamar a `obtenerInstancia()` dentro de su método, como hacen `ModuloFacturacion`, `ModuloInventario` y `ModuloReportes`.

## Ejecutar la demo

```bash
mvn compile exec:java -Dexec.mainClass=com.ejemplo.configuracion.Main
```

Salida esperada:

```
== Configuración inicial ==
Facturación: moneda=USD, iva=0.15
Inventario: empresa=Mi Empresa
Reportes: empresa=Mi Empresa, moneda=USD

== Se cambia la moneda a EUR en un solo punto ==
Facturación: moneda=EUR, iva=0.15
Inventario: empresa=Mi Empresa
Reportes: empresa=Mi Empresa, moneda=EUR
```

El cambio de moneda se hace una sola vez y los módulos de facturación y reportes lo ven.

## Pruebas

```bash
mvn test
```

| Prueba | Qué valida |
|---|---|
| `siempreDevuelveLaMismaInstancia` | Dos llamadas a `obtenerInstancia()` devuelven el mismo objeto. |
| `unValorEstablecidoSeLeeDesdeOtraReferencia` | Un valor escrito con una referencia se lee con otra. |
| `elConstructorEsPrivado` | El constructor es privado (por reflexión). |
| `traeValoresPorDefecto` | `moneda` e `iva` tienen su valor inicial. |
| `unaClaveInexistenteDevuelveNull` | Una clave desconocida devuelve `null`. |
| `conVariosHilosHayUnaSolaInstancia` | 50 hilos simultáneos obtienen la misma instancia. |
| `facturacionYReportesVenElCambioDeMoneda` | Los módulos reflejan un cambio hecho en la configuración. |
| `inventarioMuestraLaEmpresa` | `ModuloInventario` lee la empresa de la configuración. |

La instancia vive toda la JVM. Por eso las pruebas que cambian `moneda` la restauran a `USD` al terminar.
