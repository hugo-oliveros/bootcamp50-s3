package com.pe.nttdata.dao.impl;

import com.pe.nttdata.dao.CtaPrincipalDao;
import com.pe.nttdata.dao.repository.CtaPrincipalRepository;
import com.pe.nttdata.model.entity.CtaPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link CtaPrincipalDaoImpl}<br/>
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
 *<li>Mar. 8, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
@Service
public class CtaPrincipalDaoImpl implements CtaPrincipalDao {

  @Autowired
  private CtaPrincipalRepository ctaPrincipalRepository;

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link CtaPrincipal}&gt;
   * @see String
   * @see Flux
   */
  @Override
  public Flux<CtaPrincipal> findAll() {
    return ctaPrincipalRepository.findAll();
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link CtaPrincipal}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<CtaPrincipal> findById(String id) {
    return ctaPrincipalRepository.findById(id);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param ctaPrincipal {@link String}
   * @return {@link Mono}&lt;{@link CtaPrincipal}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<CtaPrincipal> save(CtaPrincipal ctaPrincipal) {
    return ctaPrincipalRepository.save(ctaPrincipal);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link com.pe.nttdata.model.entity.Persona}&gt;
   * @see String
   * @see Mono
   * @see Void
   */
  @Override
  public Mono<Void> deleteById(String id) {
    return ctaPrincipalRepository.deleteById(id);
  }

}