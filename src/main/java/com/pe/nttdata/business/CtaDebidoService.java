package com.pe.nttdata.business;

import com.pe.nttdata.model.entity.CtaDebido;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Interface</b>: {@link CtaDebidoService}<br/>
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
public interface CtaDebidoService {

  public Flux<CtaDebido> findAll();

  public Mono<CtaDebido> findById(String id);

  public Mono<CtaDebido> save(CtaDebido ctadebito);

  public  Mono<CtaDebido> update(final String id, final CtaDebido ctadebito);

  Mono<Void> deleteById(String id);

}
