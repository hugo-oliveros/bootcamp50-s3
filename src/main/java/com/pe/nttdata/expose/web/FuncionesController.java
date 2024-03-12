package com.pe.nttdata.expose.web;

import com.pe.nttdata.business.FuncionesService;
import com.pe.nttdata.dto.ParametroDto;
import com.pe.nttdata.dto.SaldoDto;
import com.pe.nttdata.model.entity.Activo;
import com.pe.nttdata.model.entity.Movimiento;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *<b>Class</b>: {@link FuncionesController}<br/>
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
@RestController
@RequestMapping("funciones/api/v1")
@CrossOrigin("*")
@Slf4j
public class FuncionesController {

  /**
   * .
   * VipPymeService vipPymeService
   **/
  @Autowired
  private FuncionesService funcionesService;


  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Movimiento}&gt;
   * @see Movimiento
   * @see Flux
   */
  @PostMapping(value = "/consolidadoCliente")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Activo> getAllMovBack(@RequestBody @NotNull final ParametroDto param) {
    return funcionesService.getAllActivos(param);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Movimiento}&gt;
   * @see Movimiento
   * @see Flux
   */
  @PostMapping(value = "/verificarDeuda")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Activo> verificarDeuda(@RequestBody @NotNull final ParametroDto param) {
    return funcionesService.checkDeuda(param);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Movimiento}&gt;
   * @see Movimiento
   * @see Flux
   */
  @PostMapping(value = "/consultarSaldoPrincipal")
  @ResponseStatus(HttpStatus.OK)
  public Mono<SaldoDto> consultarSaldoPrincipal(@RequestBody @NotNull final ParametroDto param) {
    return funcionesService.consultarSaldo(param);
  }


  public String idReturn(Movimiento mov) {
    return mov.getId().toString();
  }

}
