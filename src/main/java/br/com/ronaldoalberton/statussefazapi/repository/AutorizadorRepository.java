package br.com.ronaldoalberton.statussefazapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ronaldoalberton.statussefazapi.model.Autorizador;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
public interface AutorizadorRepository extends JpaRepository<Autorizador, Long> {

    Autorizador findAutorizadorByIdentificacaoSite(String identificacaoSite);

}
