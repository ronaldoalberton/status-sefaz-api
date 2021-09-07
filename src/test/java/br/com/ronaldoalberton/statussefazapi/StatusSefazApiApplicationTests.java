package br.com.ronaldoalberton.statussefazapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.com.ronaldoalberton.statussefazapi.model.Autorizador;
import br.com.ronaldoalberton.statussefazapi.model.StatusServico;
import br.com.ronaldoalberton.statussefazapi.run.StatusSefazApiApplication;
import br.com.ronaldoalberton.statussefazapi.service.AutorizadorService;
import br.com.ronaldoalberton.statussefazapi.service.StatusServicoService;

@SpringBootTest(classes = StatusSefazApiApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class StatusSefazApiApplicationTests {

    @Autowired
    AutorizadorService autorizadorService;

    @Autowired
    StatusServicoService statusServicoService;

    @Test
    void autorizadorTest() {

        Autorizador autorizador = autorizadorService.findAutorizadorByIdentificacaoSite("AM");

        assertEquals(autorizador.getIdAutorizador(), 1L);
        assertEquals(autorizador.getDescricaoAutorizador(),  "Amazonas");

    }

    @Test
    void statusServicoOnlineTest() {

        StatusServico statusServico = statusServicoService.findAutorizadorByIdentificacaoSite("<img src=\"imagens/bola_verde_P.png\">");
        assertEquals(statusServico.getStatusServico(), "Online");

    }

    @Test
    void statusServicoAlertTest() {

        StatusServico statusServico = statusServicoService.findAutorizadorByIdentificacaoSite("<img src=\"imagens/bola_amarela_P.png\">");
        assertEquals(statusServico.getStatusServico(), "Alert");

    }

    @Test
    void statusServicoOfflineTest() {

        StatusServico statusServico = statusServicoService.findAutorizadorByIdentificacaoSite("<img src=\"imagens/bola_vermelho_P.png\">");
        assertEquals(statusServico.getStatusServico(), "Offline");

    }

}
