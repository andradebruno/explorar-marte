package br.com.swap.rover;

import br.com.swap.rover.domain.RoverRobot;
import br.com.swap.rover.service.MarsRoverService;
import br.com.swap.rover.service.impl.MarsRoverServiceImpl;

import java.util.Scanner;

/**
 * @author Bruno Andrade
 * Dia: 10/11/2019
 **/
public class Main {
    /**
     * Metodo main do problema
     *
     * @param args arguments
     */
    public static void main(String[] args) throws Exception {
        MarsRoverService marsRoverService = new MarsRoverServiceImpl();

        System.out.println("Defina o tamanho do planalto (ex: 5 5):");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        RoverRobot roverRobot;
        while (true) {
            System.out.println("Defina as coordenadas do rover e a direcao que esta apontado (ex: 1 2 N): ");
            int roverX = scanner.nextInt();
            int roverY = scanner.nextInt();
            char roverOrientation = scanner.next().toUpperCase().charAt(0);

            System.out.println("Defina o conjunto de instrucoes para a locomocao do rover, utilizando 'L', 'M' and 'R', (ex: 'LMLMLMLMM') :");
            String instructions = scanner.next().toUpperCase();

            roverRobot = marsRoverService.solve(x, y, roverX, roverY, roverOrientation, instructions);

            System.out.print("Resposta: ");
            System.out.print(roverRobot.getX());
            System.out.print(' ');
            System.out.print(roverRobot.getY());
            System.out.print(' ');
            System.out.println(roverRobot.getOrientation());
        }
    }
}
