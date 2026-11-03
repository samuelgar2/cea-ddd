package com.cea.domain.service;

import com.cea.domain.exception.ExcepcionDominio;
import com.cea.domain.municipio.Municipio;
import com.cea.domain.municipio.MunicipioRepositorio;

public class ServicioValidacionMunicipio {

    private final MunicipioRepositorio municipioRepositorio;

    public ServicioValidacionMunicipio(
            MunicipioRepositorio municipioRepositorio
    ) {
        if (municipioRepositorio == null) {
            throw new ExcepcionDominio(
                    "El repositorio de municipios es obligatorio."
            );
        }

        this.municipioRepositorio = municipioRepositorio;
    }

    public Municipio validarExistencia(Integer idMunicipio) {

        if (idMunicipio == null || idMunicipio <= 0) {
            throw new ExcepcionDominio(
                    "El identificador del municipio no es válido."
            );
        }

        return municipioRepositorio.buscarPorId(idMunicipio)
                .orElseThrow(() -> new ExcepcionDominio(
                        "El municipio solicitado no existe."
                ));
    }
}

