package com.pe.nttdata.business.impl;

import com.pe.nttdata.business.CtaPrinicipalService;
import com.pe.nttdata.dao.CtaPrincipalDao;
import com.pe.nttdata.model.entity.CtaPrincipal;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link CtaPrincipalImpl}<br/>
 *<b>Copyright</b>: &Copy; 2024 NTTDATA Per&uacute;. <br/>
 *<b>Company</b>: NTTDATA del Per&uacute;. <br/>
 *
 *@author NTTDATA Per&uacute;. (EVE) <br/>
 *<u>Developed by</u>: <br/>
 *<ul>
 *<li>Hugo Oliveros Monti</li>
 *</ul>
 *<u>Changes</u>:<br/>
 *<ul>
 *<li>feb. 29, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
@Service
@Slf4j
public class CtaPrincipalImpl implements CtaPrinicipalService {

  @Autowired
  private CtaPrincipalDao ctaPrincipalDao;

  private CtaPrincipal ctap = CtaPrincipal.builder().build();

  @Override
  public Flux<CtaPrincipal> findAll() {
    return ctaPrincipalDao.findAll();
  }

  @Override
  public Mono<CtaPrincipal> findById(String id) {
    return ctaPrincipalDao.findById(id);
  }

  @Override
  public Mono<CtaPrincipal> save(CtaPrincipal ctaPrincipal) {
    return Mono.from(findAll())
            .filter(f -> f.getMainAccountNumber().equals(ctaPrincipal.getMainAccountNumber()))
            .flatMap(req -> {
              ctap = CtaPrincipal.builder().build();
              ctap.setDescrip("main account already exists.");
              return Mono.just(ctap);
            })
            .onErrorResume(error -> {
              ctap = CtaPrincipal.builder().build();
              ctap.setDescrip("The user does not have an account created."
                      + error);
              return Mono.just(ctap);
            }).switchIfEmpty(Mono.defer(() -> {
              return ctaPrincipalDao.save(ctaPrincipal);
            }));
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @param ctaPrincipal {@link CtaPrincipal}
   * @return {@link Mono}&lt;{@link CtaPrincipal}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public  Mono<CtaPrincipal> update(final String id, final CtaPrincipal ctaPrincipal) {
    return ctaPrincipalDao.findById(id)
            .map(Optional::of)
            .defaultIfEmpty(Optional.empty())
            .flatMap(optional -> {
              if (optional.isPresent()) {
                ctaPrincipal.setId(new ObjectId(id));
                return ctaPrincipalDao.save(ctaPrincipal);
              }
              return Mono.empty();
            });
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return ctaPrincipalDao.deleteById(id);
  }

}
