package com.ejemplo.configuracion;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionGlobalTest {

    @Test
    void siempreDevuelveLaMismaInstancia() {
        assertSame(ConfiguracionGlobal.obtenerInstancia(), ConfiguracionGlobal.obtenerInstancia());
    }

    @Test
    void unValorEstablecidoSeLeeDesdeOtraReferencia() {
        ConfiguracionGlobal a = ConfiguracionGlobal.obtenerInstancia();
        ConfiguracionGlobal b = ConfiguracionGlobal.obtenerInstancia();

        a.establecerParametro("clave.prueba", "valor");

        assertEquals("valor", b.obtenerParametro("clave.prueba"));
    }

    @Test
    void elConstructorEsPrivado() throws NoSuchMethodException {
        Constructor<ConfiguracionGlobal> constructor = ConfiguracionGlobal.class.getDeclaredConstructor();

        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    void traeValoresPorDefecto() {
        ConfiguracionGlobal config = ConfiguracionGlobal.obtenerInstancia();

        assertEquals("USD", config.obtenerParametro("moneda"));
        assertEquals("0.15", config.obtenerParametro("iva"));
    }

    @Test
    void unaClaveInexistenteDevuelveNull() {
        assertNull(ConfiguracionGlobal.obtenerInstancia().obtenerParametro("no.existe"));
    }

    @Test
    void conVariosHilosHayUnaSolaInstancia() throws InterruptedException {
        int hilos = 50;
        Set<ConfiguracionGlobal> instancias = ConcurrentHashMap.newKeySet();
        CountDownLatch inicio = new CountDownLatch(1);
        CountDownLatch fin = new CountDownLatch(hilos);
        ExecutorService pool = Executors.newFixedThreadPool(hilos);

        for (int i = 0; i < hilos; i++) {
            pool.execute(() -> {
                try {
                    inicio.await();
                    instancias.add(ConfiguracionGlobal.obtenerInstancia());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    fin.countDown();
                }
            });
        }
        inicio.countDown();
        fin.await();
        pool.shutdown();

        assertEquals(1, instancias.size());
    }
}
