package br.com.swap.rover.service.impl;

import br.com.swap.rover.controller.impl.RobotControllerImpl;
import br.com.swap.rover.domain.Plateau;
import br.com.swap.rover.domain.RoverRobot;
import br.com.swap.rover.controller.PlateauController;
import br.com.swap.rover.controller.RobotController;
import br.com.swap.rover.controller.impl.PlateauControllerImpl;
import br.com.swap.rover.service.MarsRoverService;

/**
 * @author Bruno Andrade
 * Dia: 10/11/2019
 **/
public class MarsRoverServiceImpl implements MarsRoverService {


    private RobotController robotController;
    private PlateauController plateauController;

    public MarsRoverServiceImpl() {
        this.robotController = new RobotControllerImpl();
        this.plateauController = new PlateauControllerImpl();
    }

    @Override
    public RoverRobot solve(int x, int y, int roverX, int roverY, char roverOrientation, String instructions) throws Exception {
        Plateau plateau = this.plateauController.create(x, y);
        RoverRobot roverRobot = this.robotController.create(roverX, roverY, roverOrientation);

        roverRobot = followInstructions(plateau, roverRobot, instructions);

        return roverRobot;
    }

    /**
     * Segue as instrucoes mandadas pela "base"
     * @param plateau
     * @param roverRobot
     * @param instructions
     * @return
     * @throws Exception
     */
    private RoverRobot followInstructions(Plateau plateau, RoverRobot roverRobot, String instructions) throws Exception {
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'M') {
                if (this.robotController.canMove(roverRobot, plateau)) {
                    roverRobot = this.robotController.move(roverRobot);
                }
            } else {
                roverRobot = this.robotController.rotate(roverRobot, instructions.charAt(i));
            }
        }
        return roverRobot;
    }
}
