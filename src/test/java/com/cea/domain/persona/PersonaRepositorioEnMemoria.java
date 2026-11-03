package com.cea.domain.persona;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class PersonaRepositorioEnMemoria implements PersonaRepositorio {

    private final Map<UUID, Persona> personas = new HashMap<>();

    @Override
    public void guardar(Persona persona) {
        personas.put(persona.getIdPersona(), persona);
    }

    @Override
    public Optional<Persona> buscarPorId(UUID idPersona) {
        return Optional.ofNullable(personas.get(idPersona));
    }

    @Override
    public boolean existePorId(UUID idPersona) {
        return personas.containsKey(idPersona);
    }
}

