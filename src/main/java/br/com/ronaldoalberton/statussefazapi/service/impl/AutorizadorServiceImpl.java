package br.com.ronaldoalberton.statussefazapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ronaldoalberton.statussefazapi.model.Autorizador;
import br.com.ronaldoalberton.statussefazapi.repository.AutorizadorRepository;
import br.com.ronaldoalberton.statussefazapi.service.AutorizadorService;

import lombok.NonNull;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
@Service
public class AutorizadorServiceImpl implements AutorizadorService {

    private final @NonNull
    AutorizadorRepository autorizadorRepository;

    @NonNull
    @Autowired
    public AutorizadorServiceImpl(AutorizadorRepository autorizadorRepository) {

        this.autorizadorRepository = autorizadorRepository;
    }

    @Override
    public void save(Autorizador autorizador) {

        autorizadorRepository.save(autorizador);

    }

    @Override
    public List<Autorizador> findAll() {

        return autorizadorRepository.findAll();
    }

    @Override
    public Autorizador findAutorizadorByIdentificacaoSite(String identificacaoSite) {

        return autorizadorRepository.findAutorizadorByIdentificacaoSite(identificacaoSite);
    }

    @Override
    public Autorizador findByIdAutorizador(Long IdAutorizador) {

        return autorizadorRepository.findById(IdAutorizador).orElseThrow();

    }

}
