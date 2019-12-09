package br.com.swap.rover.service;

import br.com.swap.rover.domain.RoverRobot;
import br.com.swap.rover.service.impl.MarsRoverServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Bruno Andrade
 * Dia: 11/11/2019
 **/
@RunWith(JUnit4.class)
public class MarsRoverServiceTest {

    private static final int x = 5;
    private static final int y = 5;

    private MarsRoverService marsRoverService;

    @Before
    public void before() {
        this.marsRoverService = new MarsRoverServiceImpl();
    }

    @Test
    public void solveWithNoInstructions() throws Exception {
        final int roverX = 0;
        final int roverY = 0;
        final char roverOrientation = 'N';
        final String instructions = "";

        RoverRobot solution = this.marsRoverService.solve(x, y, roverX, roverY, roverOrientation, instructions);

        assertEquals(solution.getX(), roverX);
        assertEquals(solution.getY(), roverY);
        assertEquals(solution.getOrientation(), roverOrientation);
    }

    @Test
    public void solveWithNorthOrientation() throws Exception {
        final int roverX = 1;
        final int roverY = 2;
        final char roverOrientation = 'N';
        final String instructions = "LMLMLMLMM";

        final int expectedX = 1;
        final int expectedY = 3;
        final char expectedOrientation = 'N';

        RoverRobot solution = this.marsRoverService.solve(x, y, roverX, roverY, roverOrientation, instructions);

        assertEquals(solution.getX(), expectedX);
        assertEquals(solution.getY(), expectedY);
        assertEquals(solution.getOrientation(), expectedOrientation);
    }


    @Test(expected = Exception.class)
    public void solveWithWrongRobotParameters() throws Exception {
        final int roverX = -1;
        final int roverY = -9;
        final char roverOrientation = 'A';
        final String instructions = "LLRMMMLRMMR";

        this.marsRoverService.solve(x, y, roverX, roverY, roverOrientation, instructions);
    }

    @Test(expected = Exception.class)
    public void solveWithWrongInstructions() throws Exception {
        final int roverX = 3;
        final int roverY = 3;
        final char roverOrientation = 'E';
        final String instructions = "FSDDSFSDFSD";

        this.marsRoverService.solve(x, y, roverX, roverY, roverOrientation, instructions);
    }
}
