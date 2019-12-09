package br.com.swap.rover.controller;

import br.com.swap.rover.domain.Plateau;

/**
 * @author Bruno Andrade
 * Dia: 10/11/2019
 **/
public interface PlateauController {

    /**
     * Cria o planato com os parametros
     * @param x - coordenada X do planalto
     * @param y - coordenada Y do planato
     * @return Plateau
     * @throws Exception
     */
    Plateau create(int x, int y) throws Exception;
}
