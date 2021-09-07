package br.com.ronaldoalberton.statussefazapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ronaldoalberton.statussefazapi.model.ServicoSefaz;
import br.com.ronaldoalberton.statussefazapi.repository.ServicoSefazRepository;
import br.com.ronaldoalberton.statussefazapi.service.ServicoSefazService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServicoSefazServiceImpl implements ServicoSefazService {

    private final @NonNull
    ServicoSefazRepository servicoSefazRepository;

    @Override
    public void save(ServicoSefaz servicoSefaz) {

        servicoSefazRepository.save(servicoSefaz);

    }

    @Override
    public List<ServicoSefaz> findAll() {

        return servicoSefazRepository.findAll();
    }

}
