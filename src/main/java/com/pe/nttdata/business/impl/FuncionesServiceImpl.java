package com.pe.nttdata.business.impl;

import com.pe.nttdata.business.BancoService;
import com.pe.nttdata.business.FuncionesService;
import com.pe.nttdata.dto.ParametroDto;
import com.pe.nttdata.dto.SaldoDto;
import com.pe.nttdata.model.entity.Activo;
import com.pe.nttdata.model.entity.Movimiento;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link FuncionesServiceImpl}<br/>
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
public class FuncionesServiceImpl implements FuncionesService {

  /**
   * .
   * BancoService bancoService
   **/
  @Autowired
  private BancoService bancoService;

  /**
   * <p/>
   * Flux all elements from Flux passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Movimiento}&gt;
   * @see String
   * @see Flux
   */
  @Override
  public Flux<Activo> getAllActivos(ParametroDto param) {
    return bancoService.getActivos()
            .filter(p -> p.getPersona().getDni().equals(param.getDni()));
  }

  /**
   * <p/>
   * Flux all elements from Mono passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Mono}&lt;{@link Activo}&gt;
   * @see String
   * @see Mono
   */
  public Mono<Activo> checkDeuda(ParametroDto param) {
    return Mono.just(new Activo());
  }


  /**
   * <p/>
   * Flux all elements from Mono passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Mono}&lt;{@link Activo}&gt;
   * @see String
   * @see Mono
   */
  public Mono<SaldoDto> consultarSaldo(ParametroDto param) {
    SaldoDto saldoF = SaldoDto.builder().build();

    return Mono.from(bancoService.getActivos()
            .filter(p -> p.getPersona().getDni().equals(param.getDni())
                            || p.getEmpresa().getRuc().equals(param.getRuc()))
            .map(m -> {
              saldoF.setType(m.getType());
              saldoF.setNumberAccount(m.getTarjeta().getNumberAccount());
              return m.getTarjeta().getMontoTotal();
            })
            .reduce(BigDecimal.ZERO, BigDecimal::add))
            .map(m -> {
              saldoF.setSaldoPrincipal(m.doubleValue());
              if (m.doubleValue() == 0.0) {
                saldoF.setDescri("No found.");
              }
              return saldoF;
            });

  }
}