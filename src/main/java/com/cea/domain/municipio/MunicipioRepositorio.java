package com.cea.domain.municipio;

import java.util.Optional;

public interface MunicipioRepositorio {

    Optional<Municipio> buscarPorId(Integer idMunicipio);

    boolean existePorId(Integer idMunicipio);
}

