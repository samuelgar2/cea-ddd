package com.cea.domain.persona;

import com.cea.domain.municipio.Municipio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonaRepositorioTest {

    private PersonaRepositorioEnMemoria repositorio;
    private Persona persona;

    @BeforeEach
    void configurar() {
        repositorio = new PersonaRepositorioEnMemoria();

        Municipio municipio = new Municipio(
                1, 1, "001", "Cartagena"
        );

        persona = new Persona(
                "Stivenson",
                "Garcia",
                FechaNacimiento.crear(LocalDate.of(2000, 5, 15)),
                municipio
        );
    }

    @Test
    void debeGuardarPersonaCorrectamente() {
        repositorio.guardar(persona);

        assertTrue(repositorio.existePorId(persona.getIdPersona()));
    }

    @Test
    void debeBuscarPersonaPorIdentificador() {
        repositorio.guardar(persona);

        assertTrue(repositorio.buscarPorId(persona.getIdPersona()).isPresent());
    }

    @Test
    void noDebeEncontrarPersonaInexistente() {
        UUID idInexistente = UUID.randomUUID();

        assertFalse(repositorio.buscarPorId(idInexistente).isPresent());
    }

    @Test
    void debeIndicarSiUnaPersonaExiste() {
        repositorio.guardar(persona);

        assertTrue(repositorio.existePorId(persona.getIdPersona()));
    }
}
