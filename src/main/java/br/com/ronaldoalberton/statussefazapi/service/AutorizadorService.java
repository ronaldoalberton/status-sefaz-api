package br.com.ronaldoalberton.statussefazapi.service;

import java.util.List;

import br.com.ronaldoalberton.statussefazapi.commons.IService;
import br.com.ronaldoalberton.statussefazapi.model.Autorizador;
/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
public interface AutorizadorService extends IService<Autorizador> {

    void save(Autorizador statusServicoHistorico);

    List<Autorizador> findAll();

    Autorizador findAutorizadorByIdentificacaoSite(String identificacaoSite);

    Autorizador findByIdAutorizador(Long IdAutorizador);

}
