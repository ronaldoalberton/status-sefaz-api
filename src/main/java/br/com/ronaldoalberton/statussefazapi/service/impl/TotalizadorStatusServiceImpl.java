package br.com.ronaldoalberton.statussefazapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ronaldoalberton.statussefazapi.model.TotalizadorStatus;
import br.com.ronaldoalberton.statussefazapi.repository.TotalizadorStatusRepository;
import br.com.ronaldoalberton.statussefazapi.service.TotalizadorStatusService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (06/09/21)
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TotalizadorStatusServiceImpl implements TotalizadorStatusService {

    private final @NonNull
    TotalizadorStatusRepository totalizadorStatusRepository;

    @Override
    public void save(TotalizadorStatus model) {
        throw new RuntimeException("Método nao permitido");
    }

    @Override
    public List<TotalizadorStatus> findAll() {

        return totalizadorStatusRepository.findAll();

    }

}
