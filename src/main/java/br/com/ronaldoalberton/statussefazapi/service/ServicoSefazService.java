package br.com.ronaldoalberton.statussefazapi.service;

import java.util.List;

import br.com.ronaldoalberton.statussefazapi.commons.IService;
import br.com.ronaldoalberton.statussefazapi.model.ServicoSefaz;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
public interface ServicoSefazService extends IService<ServicoSefaz> {

    void save(ServicoSefaz servicoSefaz);

    List<ServicoSefaz> findAll();

}
