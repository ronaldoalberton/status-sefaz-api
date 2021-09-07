package br.com.ronaldoalberton.statussefazapi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ronaldoalberton.statussefazapi.model.Autorizador;
import br.com.ronaldoalberton.statussefazapi.model.StatusServicoHistorico;
import br.com.ronaldoalberton.statussefazapi.repository.StatusServicoHistoricoRepository;
import br.com.ronaldoalberton.statussefazapi.service.AutorizadorService;
import br.com.ronaldoalberton.statussefazapi.service.StatusServicoHistoricoService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StatusServicoHistoricoServiceImpl implements StatusServicoHistoricoService {

    private final @NonNull
    StatusServicoHistoricoRepository statusServicoHistoricoRepository;

    private final @NonNull
    AutorizadorService autorizadorService;

    @Override
    @Transactional
    public void save(StatusServicoHistorico statusServicoHistorico) {

        statusServicoHistoricoRepository.removeStatusAtual(statusServicoHistorico.getAutorizador().getIdAutorizador());

        statusServicoHistoricoRepository.save(statusServicoHistorico);

    }

    @Override
    public List<StatusServicoHistorico> findAll() {

        return statusServicoHistoricoRepository.findAll();

    }

    @Override
    public List<StatusServicoHistorico> findByFlagStatusAtualOrderById(Boolean flagStatusAtual) {

        return statusServicoHistoricoRepository.findByFlagStatusAtualOrderByAutorizadorAsc(flagStatusAtual);

    }

    @Override
    public List<StatusServicoHistorico> findByFilter(Long idAutorizador, Date dataStatus) {

        if ((idAutorizador != null) && (dataStatus != null)) {

            return statusServicoHistoricoRepository.findByAutorizadorAndDataStatusOrderByAutorizadorAsc(autorizadorService.findByIdAutorizador(idAutorizador),
                    dataStatus);

        } else if (idAutorizador != null) {

            return statusServicoHistoricoRepository.findByAutorizador(autorizadorService.findByIdAutorizador(idAutorizador));

        } else if (dataStatus != null) {

            return statusServicoHistoricoRepository.findByDataStatusOrderByAutorizadorAsc(dataStatus);

        } else {

            return statusServicoHistoricoRepository.findByFlagStatusAtualOrderByAutorizadorAsc(Boolean.TRUE);

        }

    }

}
