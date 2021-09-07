package br.com.ronaldoalberton.statussefazapi.service;

import java.util.List;

import br.com.ronaldoalberton.statussefazapi.commons.IService;
import br.com.ronaldoalberton.statussefazapi.model.StatusServico;
import br.com.ronaldoalberton.statussefazapi.model.TotalizadorStatus;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (06/09/21)
 */
public interface TotalizadorStatusService  extends IService<TotalizadorStatus> {

    List<TotalizadorStatus> findAll();

}
