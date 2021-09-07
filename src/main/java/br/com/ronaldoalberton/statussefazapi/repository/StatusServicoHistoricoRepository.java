package br.com.ronaldoalberton.statussefazapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.ronaldoalberton.statussefazapi.model.Autorizador;
import br.com.ronaldoalberton.statussefazapi.model.StatusServicoHistorico;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
public interface StatusServicoHistoricoRepository extends JpaRepository<StatusServicoHistorico, Long> {

    @Modifying
    @Query(value = "UPDATE status_servico_historico ssh SET ssh.flag_status_atual = 0 WHERE ssh.flag_status_atual =  1 and id_autorizador = :idAutorizador",
            nativeQuery = true)
    void removeStatusAtual(Long idAutorizador);

   List<StatusServicoHistorico> findByFlagStatusAtualOrderByAutorizadorAsc(Boolean flagStatusAtual);

    List<StatusServicoHistorico> findByAutorizador(Autorizador autorizador);

    List<StatusServicoHistorico> findByAutorizadorAndDataStatusOrderByAutorizadorAsc(Autorizador autorizador, Date dataStatus);

    List<StatusServicoHistorico> findByDataStatusOrderByAutorizadorAsc(Date dataStatus);

}
