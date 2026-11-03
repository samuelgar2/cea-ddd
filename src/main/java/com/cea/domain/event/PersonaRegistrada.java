package com.cea.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public final class PersonaRegistrada {

    private final UUID idPersona;
    private final LocalDateTime fechaRegistro;

    public PersonaRegistrada(UUID idPersona) {
        if (idPersona == null) {
            throw new IllegalArgumentException(
                    "El identificador de la persona es obligatorio."
            );
        }

        this.idPersona = idPersona;
        this.fechaRegistro = LocalDateTime.now();
    }

    public UUID getIdPersona() {
        return idPersona;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
}
