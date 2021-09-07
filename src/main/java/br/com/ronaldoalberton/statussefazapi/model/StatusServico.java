package br.com.ronaldoalberton.statussefazapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
@Getter
@Setter
@Entity
@Table(name = "status_servico")
public class StatusServico {

    @Id
    @Column(name = "id_status_servico")
    private Long idStatusServico;

    @Column(name = "descricao_status_servico")
    private String statusServico;

    @JsonIgnore
    @Column(name = "identificacao_site")
    private String identificacaoSite;

}
