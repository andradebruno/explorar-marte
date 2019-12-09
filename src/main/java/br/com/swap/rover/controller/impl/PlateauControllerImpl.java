package br.com.swap.rover.controller.impl;

import br.com.swap.rover.controller.PlateauController;
import br.com.swap.rover.domain.Plateau;

/**
 * @author Bruno Andrade
 * Dia: 10/11/2019
 **/
public class PlateauControllerImpl implements PlateauController {

    @Override
    public Plateau create(int x, int y) throws Exception {
        if (x < 0 || y < 0) {
            throw new Exception("As coordenadas do planalto nao podem ser negativas.");
        }
        return new Plateau(x, y);
    }
}
