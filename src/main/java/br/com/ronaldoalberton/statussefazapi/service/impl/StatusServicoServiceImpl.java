package br.com.ronaldoalberton.statussefazapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ronaldoalberton.statussefazapi.model.StatusServico;
import br.com.ronaldoalberton.statussefazapi.repository.StatusServicoRepository;
import br.com.ronaldoalberton.statussefazapi.service.StatusServicoService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StatusServicoServiceImpl implements StatusServicoService {

    private final @NonNull
    StatusServicoRepository statusServicoRepository;

    @Override
    public void save(StatusServico statusServico) {

        statusServicoRepository.save(statusServico);

    }

    @Override
    public List<StatusServico> findAll() {

        return statusServicoRepository.findAll();
    }

    @Override
    public StatusServico findAutorizadorByIdentificacaoSite(String identificacaoSite) {

        return statusServicoRepository.findAutorizadorByIdentificacaoSite(identificacaoSite);
    }

}
