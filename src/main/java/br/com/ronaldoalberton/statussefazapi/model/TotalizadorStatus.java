package br.com.ronaldoalberton.statussefazapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (06/09/21)
 */
@Getter
@Setter
@Entity(name = "vw_totalizador_status")
public class TotalizadorStatus {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_autorizador", referencedColumnName = "id_autorizador")
    private Autorizador autorizador;

    @Column(name = "nr_total_offline")
    private Long nrTotalOffline;


}
