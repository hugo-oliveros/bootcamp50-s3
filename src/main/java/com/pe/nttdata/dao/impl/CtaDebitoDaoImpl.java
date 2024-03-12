package com.pe.nttdata.dao.impl;

import com.pe.nttdata.dao.CtaDebitoDao;
import com.pe.nttdata.dao.repository.CtaDebitoRepository;
import com.pe.nttdata.model.entity.CtaDebido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link CtaDebitoDaoImpl}<br/>
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
public class CtaDebitoDaoImpl implements CtaDebitoDao {

  @Autowired
  private CtaDebitoRepository ctaDebitoRepository;

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link CtaDebido}&gt;
   * @see String
   * @see Flux
   */
  @Override
  public Flux<CtaDebido> findAll() {
    return ctaDebitoRepository.findAll();
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link CtaDebido}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<CtaDebido> findById(String id) {
    return ctaDebitoRepository.findById(id);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param ctadebito {@link String}
   * @return {@link Mono}&lt;{@link CtaDebido}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<CtaDebido> save(CtaDebido ctadebito) {
    return ctaDebitoRepository.save(ctadebito);
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
    return ctaDebitoRepository.deleteById(id);
  }

}