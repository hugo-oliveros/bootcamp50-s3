package com.pe.nttdata.business;

import com.pe.nttdata.dto.ParametroDto;
import com.pe.nttdata.dto.SaldoDto;
import com.pe.nttdata.model.entity.Activo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Interface</b>: {@link FuncionesService}<br/>
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
public interface FuncionesService {

  public Flux<Activo> getAllActivos(ParametroDto param);

  public Mono<Activo> checkDeuda(ParametroDto param);

  public Mono<SaldoDto> consultarSaldo(ParametroDto param);

}
