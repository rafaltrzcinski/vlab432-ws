package api.service;

import api.domain.Generator;

import java.util.List;

public interface GeneratorService {

    List<Generator> findAllGenerators();

    Generator findGeneratorById(Long id);

    Generator findGeneratorByAddress(String address);

    List<Generator> findGeneratorByType(String type);
}
