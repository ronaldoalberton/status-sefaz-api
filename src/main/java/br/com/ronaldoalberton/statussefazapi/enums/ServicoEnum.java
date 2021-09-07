package br.com.ronaldoalberton.statussefazapi.enums;

import lombok.Getter;

/**
 * Descrever o motivo da classe ter sido criada.
 *
 * @author Ronaldo Alberton
 * @since 1.0 (03/09/21)
 */
@Getter
public enum ServicoEnum {

    AUTORIZACAO(1, "Autorização4"),
    RETORNO_AUTORIZACAO(2, "Retorno Autorização4"),
    INUTILIZACAO(3, "Inutilização4"),
    CONSULTA_PROTOCOLO(4, "Consulta Protocolo4"),
    STATUS_SERVICO(5, "Status Serviço4"),
    CONSULTA_CADASTRO(7, "Consulta Cadastro4"),
    RECEPCAO_EVENTO(8, "Recepção Evento4");

    private int tableIndex;
    private String descricao;

    ServicoEnum(int tableIndex, String descricao) {
        this.tableIndex = tableIndex;
        this.descricao = descricao;
    }

}
