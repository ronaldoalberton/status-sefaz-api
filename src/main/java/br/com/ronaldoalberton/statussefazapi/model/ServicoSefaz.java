package br.com.ronaldoalberton.statussefazapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (05/09/21)
 */
@Getter
@Setter
@Entity
@Table(name = "servico_sefaz")
public class ServicoSefaz {

    @Id
    @Column(name = "id_servico_sefaz")
    private Long idServicoSefaz;

    @Column(name = "descricao_servico")
    private String descricaoServico;

}
