
package com.cea.domain.municipio;

import com.cea.domain.exception.ExcepcionDominio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioTest {

    @Test
    void debeCrearMunicipioValido() {
        Municipio municipio = new Municipio(
                1,
                10,
                "001",
                "Cartagena"
        );

        assertEquals(1, municipio.getIdMunicipio());
        assertEquals(10, municipio.getIdProvincia());
        assertEquals("001", municipio.getCodigoMunicipio());
        assertEquals("Cartagena", municipio.getNombre());
    }

    @Test
    void noDebeAceptarIdentificadorInvalido() {
        assertThrows(
                ExcepcionDominio.class,
                () -> new Municipio(0, 10, "001", "Cartagena")
        );
    }

    @Test
    void noDebeAceptarNombreVacio() {
        assertThrows(
                ExcepcionDominio.class,
                () -> new Municipio(1, 10, "001", "")
        );
    }

    @Test
    void noDebeAceptarCodigoVacio() {
        assertThrows(
                ExcepcionDominio.class,
                () -> new Municipio(1, 10, " ", "Cartagena")
        );
    }
}

