package com.cea.domain.persona;

import java.util.Optional;
import java.util.UUID;

public interface PersonaRepositorio {

    void guardar(Persona persona);

    Optional<Persona> buscarPorId(UUID idPersona);

    boolean existePorId(UUID idPersona);
}