package com.pe.nttdata.dao.repository;

import com.pe.nttdata.model.entity.CtaDebido;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtaDebitoRepository extends ReactiveMongoRepository<CtaDebido, String> {


}
