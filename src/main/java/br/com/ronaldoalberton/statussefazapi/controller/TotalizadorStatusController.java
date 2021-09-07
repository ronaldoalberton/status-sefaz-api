package br.com.ronaldoalberton.statussefazapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldoalberton.statussefazapi.model.TotalizadorStatus;
import br.com.ronaldoalberton.statussefazapi.service.TotalizadorStatusService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (07/09/21)
 */
@RestController
@RequestMapping("/totalizadorstatus")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TotalizadorStatusController {

    private final @NonNull
    TotalizadorStatusService totalizadorStatusService;

    @GetMapping
    ResponseEntity<List<TotalizadorStatus>> findAll() {

        List<TotalizadorStatus> result = totalizadorStatusService.findAll();

        return result.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(result);

    }
}
