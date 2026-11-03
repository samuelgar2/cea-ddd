
package com.cea.domain.municipio;

import com.cea.domain.exception.ExcepcionDominio;
import java.util.Objects;

public class Municipio {

    private final Integer idMunicipio;
    private final Integer idProvincia;
    private final String codigoMunicipio;
    private final String nombre;

    public Municipio(
            Integer idMunicipio,
            Integer idProvincia,
            String codigoMunicipio,
            String nombre
    ) {
        if (idMunicipio == null || idMunicipio <= 0) {
            throw new ExcepcionDominio(
                    "El identificador del municipio no es válido."
            );
        }

        if (idProvincia == null || idProvincia <= 0) {
            throw new ExcepcionDominio(
                    "El identificador de la provincia no es válido."
            );
        }

        if (codigoMunicipio == null || codigoMunicipio.isBlank()) {
            throw new ExcepcionDominio(
                    "El código del municipio es obligatorio."
            );
        }

        if (nombre == null || nombre.isBlank()) {
            throw new ExcepcionDominio(
                    "El nombre del municipio es obligatorio."
            );
        }

        this.idMunicipio = idMunicipio;
        this.idProvincia = idProvincia;
        this.codigoMunicipio = codigoMunicipio.trim();
        this.nombre = nombre.trim();
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Municipio)) return false;

        Municipio municipio = (Municipio) objeto;
        return idMunicipio.equals(municipio.idMunicipio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMunicipio);
    }
}

