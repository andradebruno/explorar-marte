package br.com.swap.rover.service;

import br.com.swap.rover.domain.RoverRobot;

/**
 * @author Bruno Andrade
 * Dia: 10/11/2019
 **/
public interface MarsRoverService {
    /**
     * Resolve o problema de um unico rover utilizando os parametros a seguir
     * @param x coordenada X do Plateau
     * @param y coordenada Y do Plateau
     * @param roverX coordenada X do inicio do rover
     * @param roverY coordenada y do inicio do rover
     * @param roverOrientation orientacao inicial do rover
     * @param instructions lista de instrucoes que o rover deve seguir
     * @return
     * @throws Exception
     */
    RoverRobot solve(int x, int y, int roverX, int roverY, char roverOrientation, String instructions) throws Exception;
}
