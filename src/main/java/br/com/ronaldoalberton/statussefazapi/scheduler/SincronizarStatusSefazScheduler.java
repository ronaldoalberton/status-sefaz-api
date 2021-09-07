package br.com.ronaldoalberton.statussefazapi.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.ronaldoalberton.statussefazapi.service.SincronizarStatusSefazService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (05/09/21)
 */
@Slf4j
@Component
public class SincronizarStatusSefazScheduler {

    private final @NonNull
    SincronizarStatusSefazService sincronizarStatusSefazService;

    @NonNull
    @Autowired
    public SincronizarStatusSefazScheduler(SincronizarStatusSefazService sincronizarStatusSefazService) {

        this.sincronizarStatusSefazService = sincronizarStatusSefazService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onSchedule() {
        sincronizarStatusSefaz();
    }

    @Scheduled(cron = "0  0/1  *  *  *  *")
    public void sincronizarStatusSefaz() {

        log.info("Sincronizando satatus da Sefaz");
        sincronizarStatusSefazService.sincronizarStatusSefaz();

    }

}
