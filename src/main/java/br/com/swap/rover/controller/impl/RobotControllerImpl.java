package br.com.swap.rover.controller.impl;

import br.com.swap.rover.domain.Plateau;
import br.com.swap.rover.controller.RobotController;
import br.com.swap.rover.domain.RoverRobot;

/**
 * @author Bruno Andrade
 * Dia: 10/11/2019
 **/
public class RobotControllerImpl implements RobotController {

    @Override
    public RoverRobot create(int x, int y, char orientation) throws Exception {
        if (x < 0 || y < 0) {
            throw new Exception("Coordenadas nao podem ser negativas.");
        } else if (orientation != 'N' && orientation != 'E' && orientation != 'S' && orientation != 'W') {
            throw new Exception("A orientacao do robo precisa ser 'N', 'E', 'S' ou 'W'");
        }
        return new RoverRobot(x, y, orientation);
    }

    @Override
    public boolean canMove(RoverRobot roverRobot, Plateau plateau) {
        if (roverRobot.getOrientation() == 'N' && roverRobot.getY() + 1 > plateau.getY()) return false;
        else if (roverRobot.getOrientation() == 'E' && roverRobot.getX() + 1 > plateau.getX()) return false;
        else if (roverRobot.getOrientation() == 'S' && roverRobot.getY() - 1 < 0) return false;
        else if (roverRobot.getOrientation() == 'W' && roverRobot.getX() + 1 < 0) return false;
        return true;
    }

    @Override
    public RoverRobot move(RoverRobot roverRobot) {
        switch (roverRobot.getOrientation()) {
            case 'N':
                roverRobot.setY(roverRobot.getY() + 1);
                break;
            case 'E':
                roverRobot.setX(roverRobot.getX() + 1);
                break;
            case 'S':
                roverRobot.setY(roverRobot.getY() - 1);
                break;
            case 'W':
                roverRobot.setX(roverRobot.getX() - 1);
                break;
        }
        return roverRobot;
    }

    @Override
    public RoverRobot rotate(RoverRobot roverRobot, char rotation) throws Exception {
        if (rotation == 'L') {
            roverRobot.setOrientation(moveToLeft(roverRobot.getOrientation()));
        } else if (rotation == 'R') {
            roverRobot.setOrientation(moveToRight(roverRobot.getOrientation()));
        } else {
            throw new Exception("Rotacao precisa ser 'R' ou 'L'");
        }
        return roverRobot;
    }

    /**
     * Move o rover para esquerda
     * @param orientation
     * @return
     */
    private static char moveToLeft(char orientation) {
        if (orientation == 'N') return 'W';
        if (orientation == 'W') return 'S';
        if (orientation == 'S') return 'E';
        return 'N';
    }

    /**
     * Move o rover para direita
     * @param orientation
     * @return
     */
    private static char moveToRight(char orientation) {
        if (orientation == 'N') return 'E';
        if (orientation == 'E') return 'S';
        if (orientation == 'S') return 'W';
        return 'N';
    }
}
