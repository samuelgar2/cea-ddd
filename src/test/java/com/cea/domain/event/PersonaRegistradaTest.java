package com.cea.domain.event;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonaRegistradaTest {

    @Test
    void debeCrearEventoConIdentificadorValido() {
        UUID id = UUID.randomUUID();

        PersonaRegistrada evento = new PersonaRegistrada(id);

        assertEquals(id, evento.getIdPersona());
        assertNotNull(evento.getFechaRegistro());
    }

    @Test
    void noDebeCrearEventoSinIdentificador() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PersonaRegistrada(null)
        );
    }
}
