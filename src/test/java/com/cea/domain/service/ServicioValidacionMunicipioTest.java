package com.cea.domain.service;

import com.cea.domain.exception.ExcepcionDominio;
import com.cea.domain.municipio.Municipio;
import com.cea.domain.municipio.MunicipioRepositorio;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ServicioValidacionMunicipioTest {

    @Test
    void debeValidarMunicipioExistente() {

        Municipio municipio = new Municipio(
                1, 10, "001", "Cartagena"
        );

        MunicipioRepositorio repositorio = new MunicipioRepositorio() {
            @Override
            public Optional<Municipio> buscarPorId(Integer idMunicipio) {
                return Optional.of(municipio);
            }

            @Override
            public boolean existePorId(Integer idMunicipio) {
                return true;
            }
        };

        ServicioValidacionMunicipio servicio =
                new ServicioValidacionMunicipio(repositorio);

        Municipio resultado = servicio.validarExistencia(1);

        assertNotNull(resultado);
        assertEquals("Cartagena", resultado.getNombre());
    }

    @Test
    void noDebeAceptarMunicipioInexistente() {

        MunicipioRepositorio repositorio = new MunicipioRepositorio() {
            @Override
            public Optional<Municipio> buscarPorId(Integer idMunicipio) {
                return Optional.empty();
            }

            @Override
            public boolean existePorId(Integer idMunicipio) {
                return false;
            }
        };

        ServicioValidacionMunicipio servicio =
                new ServicioValidacionMunicipio(repositorio);

        assertThrows(
                ExcepcionDominio.class,
                () -> servicio.validarExistencia(99)
        );
    }

    @Test
    void noDebeAceptarIdentificadorInvalido() {

        MunicipioRepositorio repositorio = new MunicipioRepositorio() {
            @Override
            public Optional<Municipio> buscarPorId(Integer idMunicipio) {
                return Optional.empty();
            }

            @Override
            public boolean existePorId(Integer idMunicipio) {
                return false;
            }
        };

        ServicioValidacionMunicipio servicio =
                new ServicioValidacionMunicipio(repositorio);

        assertThrows(
                ExcepcionDominio.class,
                () -> servicio.validarExistencia(0)
        );
    }
}

