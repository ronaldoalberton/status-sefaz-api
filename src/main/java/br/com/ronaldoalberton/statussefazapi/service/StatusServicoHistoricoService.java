package br.com.ronaldoalberton.statussefazapi.service;

import java.util.Date;
import java.util.List;

import br.com.ronaldoalberton.statussefazapi.commons.IService;
import br.com.ronaldoalberton.statussefazapi.model.StatusServicoHistorico;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
public interface StatusServicoHistoricoService extends IService<StatusServicoHistorico> {

    void save(StatusServicoHistorico statusServicoHistorico);

    List<StatusServicoHistorico> findAll();

    List<StatusServicoHistorico> findByFlagStatusAtualOrderById(Boolean flagStatusAtual);

    List<StatusServicoHistorico> findByFilter(Long idAutorizador, Date dataStatus);

}
