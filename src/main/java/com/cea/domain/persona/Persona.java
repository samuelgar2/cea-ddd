
package com.cea.domain.persona;

import com.cea.domain.exception.ExcepcionDominio;
import com.cea.domain.municipio.Municipio;
import com.cea.domain.event.PersonaRegistrada;
import java.util.Objects;
import java.util.UUID;

public class Persona {
    private final PersonaRegistrada eventoRegistro;
    private final UUID idPersona;
    private String nombres;
    private String apellidos;
    private final FechaNacimiento fechaNacimiento;
    private final Municipio municipioNacimiento;

    public Persona(String nombres, String apellidos,
                   FechaNacimiento fechaNacimiento, Municipio municipioNacimiento) {

        if (nombres == null || nombres.isBlank())
            throw new ExcepcionDominio("Los nombres de la persona son obligatorios.");

        if (apellidos == null || apellidos.isBlank())
            throw new ExcepcionDominio("Los apellidos de la persona son obligatorios.");

        if (fechaNacimiento == null)
            throw new ExcepcionDominio("La fecha de nacimiento es obligatoria.");

        if (municipioNacimiento == null)
            throw new ExcepcionDominio("El municipio de nacimiento es obligatorio.");

        // Primero inicializamos los atributos
        this.idPersona = UUID.randomUUID();
        this.nombres = nombres.trim();
        this.apellidos = apellidos.trim();
        this.fechaNacimiento = fechaNacimiento;
        this.municipioNacimiento = municipioNacimiento;

        // Después creamos el evento
        this.eventoRegistro = new PersonaRegistrada(this.idPersona);
    }

    public UUID getIdPersona() {
        return idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Municipio getMunicipioNacimiento() {
        return municipioNacimiento;
    }

    public PersonaRegistrada getEventoRegistro() {
        return eventoRegistro;
    }

    public void actualizarNombres(String nombres) {
        if (nombres == null || nombres.isBlank()) {
            throw new ExcepcionDominio(
                    "Los nombres no pueden estar vacíos."
            );
        }

        this.nombres = nombres.trim();
    }

    public void actualizarApellidos(String apellidos) {
        if (apellidos == null || apellidos.isBlank()) {
            throw new ExcepcionDominio(
                    "Los apellidos no pueden estar vacíos."
            );
        }

        this.apellidos = apellidos.trim();
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Persona)) return false;

        Persona persona = (Persona) objeto;
        return idPersona.equals(persona.idPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona);
    }
}


