
package com.cea.domain.persona;

import com.cea.domain.exception.ExcepcionDominio;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FechaNacimientoTest {

    @Test
    void debeCrearFechaNacimientoValida() {
        LocalDate fecha = LocalDate.of(2000, 5, 15);

        FechaNacimiento resultado = FechaNacimiento.crear(fecha);

        assertNotNull(resultado);
        assertEquals(fecha, resultado.getValor());
    }

    @Test
    void noDebeAceptarFechaNula() {
        assertThrows(
                ExcepcionDominio.class,
                () -> FechaNacimiento.crear(null)
        );
    }

    @Test
    void noDebeAceptarFechaFutura() {
        LocalDate fechaFutura = LocalDate.now().plusDays(1);

        assertThrows(
                ExcepcionDominio.class,
                () -> FechaNacimiento.crear(fechaFutura)
        );
    }
}

