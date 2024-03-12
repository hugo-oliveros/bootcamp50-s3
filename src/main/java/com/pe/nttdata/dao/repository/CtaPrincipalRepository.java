package com.pe.nttdata.dao.repository;

import com.pe.nttdata.model.entity.CtaPrincipal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtaPrincipalRepository extends ReactiveMongoRepository<CtaPrincipal, String> {


}
