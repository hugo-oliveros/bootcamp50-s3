package com.pe.nttdata.business.impl;

import com.pe.nttdata.business.CtaDebidoService;
import com.pe.nttdata.dao.CtaDebitoDao;
import com.pe.nttdata.model.entity.CtaDebido;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link CtaDebitoImpl}<br/>
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
public class CtaDebitoImpl implements CtaDebidoService {


  @Autowired
  private CtaDebitoDao ctaDebitoDao;

  @Override
  public Flux<CtaDebido> findAll() {
    return ctaDebitoDao.findAll();
  }

  @Override
  public Mono<CtaDebido> findById(String id) {
    return ctaDebitoDao.findById(id);
  }

  @Override
  public Mono<CtaDebido> save(CtaDebido ctadebito) {
    return ctaDebitoDao.save(ctadebito);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @param ctadebito {@link CtaDebido}
   * @return {@link Mono}&lt;{@link CtaDebido}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public  Mono<CtaDebido> update(final String id, final CtaDebido ctadebito) {
    return ctaDebitoDao.findById(id)
            .map(Optional::of)
            .defaultIfEmpty(Optional.empty())
            .flatMap(optional -> {
              if (optional.isPresent()) {
                ctadebito.setId(new ObjectId(id));
                return ctaDebitoDao.save(ctadebito);
              }
              return Mono.empty();
            });
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return ctaDebitoDao.deleteById(id);
  }

}
