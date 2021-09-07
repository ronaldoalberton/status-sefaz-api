package br.com.ronaldoalberton.statussefazapi.commons;

import java.util.List;

import br.com.ronaldoalberton.statussefazapi.model.StatusServicoHistorico;

/**
 * @author Ronaldo Alberton
 * @since 1.0 (04/09/21)
 */
public interface IService<T> {

    void save(T model);

    List<T> findAll();

}
