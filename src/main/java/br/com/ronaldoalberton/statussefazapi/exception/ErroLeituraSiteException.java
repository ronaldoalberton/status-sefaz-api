package br.com.ronaldoalberton.statussefazapi.exception;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (05/09/21)
 */
public class ErroLeituraSiteException extends RuntimeException {

    public ErroLeituraSiteException(String message) {

        super(String.format("Erro ao ler HTML do site: %s",message));

    }

}
