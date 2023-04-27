/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pedro.ieslaencanta.com.chess.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;
import pedro.ieslaencanta.com.chess.model.Move;

/**
 *
 * @author Simon Roca
 */
public class GameIT {
    
    public GameIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int startrow = 0;
        int startcol = 0;
        int endrow = 0;
        int endcol = 0;
        Game instance = new Game();
        Move expResult = null;
        Move result = instance.move(startrow, startcol, endrow, endcol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Jaque method, of class Game.
     */
    @Test
    public void testJaque() {
        System.out.println("Jaque");
        Game instance = new Game();
        Move[] expResult = null;
        Move[] result = instance.Jaque();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of JaqueMate method, of class Game.
     */
    @Test
    public void testJaqueMate() {
        System.out.println("JaqueMate");
        PieceType type = null;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.JaqueMate(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canMove method, of class Game.
     */
    @Test
    public void testCanMove() {
        System.out.println("canMove");
        int startrow = 0;
        int startcol = 6;
        int endrow = 0;
        int endcol = 5;
        Game instance = new Game();
        boolean expResult = true;
        boolean result = instance.canMove(startrow, startcol, endrow, endcol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.      
    }
    
    @Test
    public void TestCuadroVacio() {
        System.out.println("canMove");
        int startrow = 1;
        int startcol = 4;
        int endrow = 1;
        int endcol = 6;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.canMove(startrow, startcol, endrow, endcol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.      
    }
    
    @Test
    public void TestNegras() {
        System.out.println("canMove");
        int startrow = 4;
        int startcol = 1;
        int endrow = 4;
        int endcol = 2;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.canMove(startrow, startcol, endrow, endcol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.      
    }
}
