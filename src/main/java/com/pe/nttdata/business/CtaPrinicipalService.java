package com.pe.nttdata.business;

import com.pe.nttdata.model.entity.CtaPrincipal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Interface</b>: {@link CtaPrinicipalService}<br/>
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
public interface CtaPrinicipalService {

  public Flux<CtaPrincipal> findAll();

  public Mono<CtaPrincipal> findById(String id);

  public Mono<CtaPrincipal> save(CtaPrincipal ctaPrincipal);

  public  Mono<CtaPrincipal> update(final String id, final CtaPrincipal ctaPrincipal);

  Mono<Void> deleteById(String id);

}
