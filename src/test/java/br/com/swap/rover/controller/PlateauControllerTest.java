package br.com.swap.rover.controller;

import br.com.swap.rover.domain.Plateau;
import br.com.swap.rover.controller.impl.PlateauControllerImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Bruno Andrade
 * Dia: 11/11/2019
 **/
@RunWith(JUnit4.class)
public class PlateauControllerTest {
    private static final int x = 8;
    private static final int y = 2;
    private static final int negativeX = -8;
    private static final int negativeY = -2;

    private PlateauController plateauController;
    private Plateau plateau;

    @Before
    public void before() {
        this.plateauController = new PlateauControllerImpl();
    }

    @Test
    public void createCorrectlyAPlateau() throws Exception {
        this.plateau = this.plateauController.create(x, y);

        assertEquals(plateau.getX(), x);
        assertEquals(plateau.getY(), y);
        assertTrue(plateau.getX() != y);
        assertTrue(plateau.getY() != x);
    }

    @Test(expected = Exception.class)
    public void createIncorrectlyAPlateau() throws Exception {
        this.plateau = this.plateauController.create(negativeX, negativeY);
    }
}
