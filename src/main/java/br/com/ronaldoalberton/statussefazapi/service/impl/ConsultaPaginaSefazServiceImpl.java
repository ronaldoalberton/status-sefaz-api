package br.com.ronaldoalberton.statussefazapi.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ronaldoalberton.statussefazapi.exception.ErroLeituraSiteException;
import br.com.ronaldoalberton.statussefazapi.enums.ServicoEnum;
import br.com.ronaldoalberton.statussefazapi.model.Autorizador;
import br.com.ronaldoalberton.statussefazapi.model.StatusServico;
import br.com.ronaldoalberton.statussefazapi.model.StatusServicoHistorico;
import br.com.ronaldoalberton.statussefazapi.service.AutorizadorService;
import br.com.ronaldoalberton.statussefazapi.service.SincronizarStatusSefazService;
import br.com.ronaldoalberton.statussefazapi.service.StatusServicoHistoricoService;
import br.com.ronaldoalberton.statussefazapi.service.StatusServicoService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConsultaPaginaSefazServiceImpl implements SincronizarStatusSefazService {

    private static final String URL_SITE = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";

    private static final String TABLE_QUERY_NAME = "#ctl00_ContentPlaceHolder1_gdvDisponibilidade2";

    private final @NonNull
    StatusServicoHistoricoService statusServicoHistoricoService;

    private final @NonNull
    AutorizadorService autorizadorService;

    private final @NonNull
    StatusServicoService statusServicoService;

    public void sincronizarStatusSefaz() {

        LocalDateTime dataHoraStatus = LocalDateTime.now();
        Date dataStatus = Date.valueOf(dataHoraStatus.toLocalDate());
        Time horaStatus = Time.valueOf(dataHoraStatus.toLocalTime());

        Elements tableStatus = this.findHtmlTableStatus();

        for (Element tableLine : tableStatus.select("tr")) {

            Elements html = tableLine.select("td");

            if (html.isEmpty()) {
                continue;
            }

            StatusServicoHistorico statusServicoHistorico = new StatusServicoHistorico();
            statusServicoHistorico.setAutorizador(this.findAutorizador(html));
            statusServicoHistorico.setAutorizacao(this.findStatuServico(html, ServicoEnum.AUTORIZACAO));
            statusServicoHistorico.setRetornoAutorizacao(this.findStatuServico(html, ServicoEnum.RETORNO_AUTORIZACAO));
            statusServicoHistorico.setInutilizacao(this.findStatuServico(html, ServicoEnum.INUTILIZACAO));
            statusServicoHistorico.setConsultaProtocolo(this.findStatuServico(html, ServicoEnum.CONSULTA_PROTOCOLO));
            statusServicoHistorico.setStatusServico(this.findStatuServico(html, ServicoEnum.STATUS_SERVICO));
            statusServicoHistorico.setConsultaCadastro(this.findStatuServico(html, ServicoEnum.CONSULTA_CADASTRO));
            statusServicoHistorico.setRecepecaoEvento(this.findStatuServico(html, ServicoEnum.RECEPCAO_EVENTO));
            statusServicoHistorico.setDataStatus(dataStatus);
            statusServicoHistorico.setHoraStatus(horaStatus);
            statusServicoHistorico.setFlagStatusAtual(Boolean.TRUE);

            statusServicoHistoricoService.save(statusServicoHistorico);

        }

    }

    private Elements findHtmlTableStatus() {

        try {

            Document doc = Jsoup.connect(URL_SITE).get();

            return doc.select(TABLE_QUERY_NAME);

        } catch (IOException e) {

            throw new ErroLeituraSiteException(e.getMessage());
        }

    }

    private StatusServico findStatuServico(Elements html, ServicoEnum servicoEnum) {

        return statusServicoService.findAutorizadorByIdentificacaoSite(html.get(servicoEnum.getTableIndex()).html());

    }

    private Autorizador findAutorizador(Elements html) {

        return autorizadorService.findAutorizadorByIdentificacaoSite(html.get(0).text());

    }

}
