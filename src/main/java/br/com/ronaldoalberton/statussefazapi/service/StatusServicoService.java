package br.com.ronaldoalberton.statussefazapi.service;

import java.util.List;

import br.com.ronaldoalberton.statussefazapi.commons.IService;
import br.com.ronaldoalberton.statussefazapi.model.StatusServico;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
public interface StatusServicoService extends IService<StatusServico> {

    void save(StatusServico servicoSefaz);

    List<StatusServico> findAll();

    StatusServico findAutorizadorByIdentificacaoSite(String identificacaoSite);

}
