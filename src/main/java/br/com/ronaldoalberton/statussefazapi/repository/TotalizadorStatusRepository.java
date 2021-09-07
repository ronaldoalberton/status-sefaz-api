package br.com.ronaldoalberton.statussefazapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ronaldoalberton.statussefazapi.model.TotalizadorStatus;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (06/09/21)
 */
public interface TotalizadorStatusRepository extends JpaRepository<TotalizadorStatus, Long> {

}
