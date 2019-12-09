package br.com.swap.rover.controller;

import br.com.swap.rover.domain.Plateau;
import br.com.swap.rover.domain.RoverRobot;

/**
 * @author Bruno Andrade
 * Dia: 10/11/2019
 **/
public interface RobotController {
    /**
     * Cria rover com os seguintes parametros
     * @param x
     * @param y
     * @param orientation
     * @return
     * @throws Exception
     */
    RoverRobot create(int x, int y, char orientation) throws Exception;

    /**
     * Verifica se o robo pode mover de acordo com as dimensoes do Plateau
     * @param roverRobot
     * @param plateau
     * @return true, pode se mover, false nao pode
     */
    boolean canMove(RoverRobot roverRobot, Plateau plateau);

    /**
     * Move o robo para a proxima possicao
     * @param roverRobot
     * @return
     */
    RoverRobot move(RoverRobot roverRobot);

    /**
     * Rotaciona o robo para o sentido indicado
     * @param roverRobot
     * @param rotation
     * @return
     * @throws Exception
     */
    RoverRobot rotate(RoverRobot roverRobot, char rotation) throws Exception;
}
