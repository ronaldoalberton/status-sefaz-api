package br.com.ronaldoalberton.statussefazapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldoalberton.statussefazapi.model.StatusServicoHistorico;
import br.com.ronaldoalberton.statussefazapi.service.StatusServicoHistoricoService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (05/09/21)
 */
@RestController
@RequestMapping("/statusServicoHistorico")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StatusServicoHistoricoController {

    private final @NonNull
    StatusServicoHistoricoService statusServicoHistoricoService;

    @GetMapping
    ResponseEntity<List<StatusServicoHistorico>> statusAtual() {

        List<StatusServicoHistorico> result = statusServicoHistoricoService.findByFlagStatusAtualOrderById(Boolean.TRUE);

        return result.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(result);

    }

    @GetMapping("/filter")
    ResponseEntity<List<StatusServicoHistorico>> statusAtualByAutorizador(@RequestParam(value="idAutorizador", required = false)  Long idAutorizador,
            @RequestParam(value="dataStatus", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataStatus) {

        List<StatusServicoHistorico> result = statusServicoHistoricoService.findByFilter(idAutorizador, dataStatus);

        return result == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(result);

    }


}
