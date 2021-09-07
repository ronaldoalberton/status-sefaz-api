package br.com.ronaldoalberton.statussefazapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronaldoalberton.statussefazapi.model.Autorizador;
import br.com.ronaldoalberton.statussefazapi.service.AutorizadorService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (05/09/21)
 */
@RestController
@RequestMapping("/autorizador")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutorizadorController {

    private final @NonNull
    AutorizadorService autorizadorService;

    @GetMapping
    ResponseEntity<List<Autorizador>> findAll() {

        List<Autorizador> result = autorizadorService.findAll();

        return result.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(result);

    }

}
