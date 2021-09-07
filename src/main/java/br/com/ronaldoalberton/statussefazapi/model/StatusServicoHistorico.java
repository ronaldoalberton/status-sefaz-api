package br.com.ronaldoalberton.statussefazapi.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "status_servico_historico")
public class StatusServicoHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_autorizador", referencedColumnName = "id_autorizador")
    private Autorizador autorizador;

    @OneToOne
    @JoinColumn(name = "id_status_autorizacao",
            referencedColumnName = "id_status_servico")
    private StatusServico autorizacao;

    @ManyToOne
    @JoinColumn(name = "id_status_retorno_autorizacao",
            referencedColumnName = "id_status_servico")
    private StatusServico retornoAutorizacao;

    @ManyToOne
    @JoinColumn(name = "id_status_inutilizacao",
            referencedColumnName = "id_status_servico")
    private StatusServico inutilizacao;

    @ManyToOne
    @JoinColumn(name = "id_status_consulta_protocolo",
            referencedColumnName = "id_status_servico")
    private StatusServico consultaProtocolo;

    @ManyToOne
    @JoinColumn(name = "id_status_status_servico",
            referencedColumnName = "id_status_servico")
    private StatusServico statusServico;

    @ManyToOne
    @JoinColumn(name = "id_status_consulta_cadastro",
            referencedColumnName = "id_status_servico")
    private StatusServico consultaCadastro;

    @ManyToOne
    @JoinColumn(name = "id_status_recepecao_evento",
            referencedColumnName = "id_status_servico")
    private StatusServico recepecaoEvento;

    @Column(name = "data_status")
    private Date dataStatus;

    @Column(name = "hora_status")
    private Time horaStatus;

    @JsonIgnore
    @Column(name = "flag_status_atual")
    private Boolean flagStatusAtual;

}
