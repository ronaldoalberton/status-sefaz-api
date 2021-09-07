package br.com.ronaldoalberton.statussefazapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ronaldoalberton.statussefazapi.model.StatusServico;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
public interface StatusServicoRepository extends JpaRepository<StatusServico, Long> {

    StatusServico findAutorizadorByIdentificacaoSite(String identificacaoSite);

}
