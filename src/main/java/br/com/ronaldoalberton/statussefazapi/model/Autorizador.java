package br.com.ronaldoalberton.statussefazapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (05/09/21)
 */
@Getter
@Setter
@Entity
@Table(name = "autorizador")
public class Autorizador {

    @Id
    @Column(name = "id_autorizador")
    private Long idAutorizador;

    @Column(name = "sigla_autorizador")
    private String siglaAutorizador;

    @Column(name = "descricao_autorizador")
    private String descricaoAutorizador;

    @JsonIgnore
    @Column(name = "identificacao_site")
    private String identificacaoSite;

}
