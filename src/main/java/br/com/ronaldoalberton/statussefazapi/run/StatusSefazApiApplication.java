package br.com.ronaldoalberton.statussefazapi.run;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan("br.com.ronaldoalberton.statussefazapi.model")
@EnableJpaRepositories("br.com.ronaldoalberton.statussefazapi.repository")
@SpringBootApplication(scanBasePackages = "br.com.ronaldoalberton.*")
public class StatusSefazApiApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(StatusSefazApiApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
