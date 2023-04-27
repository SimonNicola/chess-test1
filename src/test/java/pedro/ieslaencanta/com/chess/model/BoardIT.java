/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pedro.ieslaencanta.com.chess.model.ChessPiece.King;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Knight;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Pawn;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Queen;

/**
 *
 * @author Simon Roca
 */
public class BoardIT {

    public BoardIT() {
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
     * Test of reset method, of class Board.
     */
    /**
     * Test of getCell method, of class Board.
     */
    /* Clases Equivalencia */
    @Test
    public void TestPocicionDebajo0_ROW() {
        int row = -1;
        int col = 0;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertTrue(celda instanceof Cell);
    }

    @Test
    public void TestPocicionArribaDe7_ROW() {
        System.out.println("getCell");
        int row = 9;
        int col = 0;
        Board instance = new Board();        
        Cell celda = instance.getCell(row, col);
        assertNull(celda);
    }

    @Test
    public void TestPocicion0Entre7_ROW() {
        System.out.println("getCell");
        int row = 5;
        int col = 0;
        Board instance = new Board();       
        Cell celda = instance.getCell(row, col);
        assertTrue(celda instanceof Cell);
    }

    @Test
    public void TestPocicionDebajo0_COL() {
        System.out.println("getCell");
        int row = 0;
        int col = -4;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertNull(celda);
    }

    @Test
    public void TestPocicionArriba7_COL() {
        System.out.println("getCell");
        int row = 0;
        int col = 9;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertNull(celda);
    }

    @Test
    public void TestPocicion0Entre7_COL() {
        System.out.println("getCell");
        int row = 0;
        int col = 5;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertTrue(celda instanceof Cell);
    }

    /* Clases Limite */
    @Test
    public void Test_COL_0() {
        System.out.println("getCell");
        int row = 0;
        int col = 0;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertTrue(celda instanceof Cell);
    }

    @Test
    public void Test_COL_Menos1() {
        System.out.println("getCell");
        int row = 0;
        int col = -1;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertNull(celda);
    }

    @Test
    public void Test_COL_7() {
        System.out.println("getCell");
        int row = 0;
        int col = 7;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertTrue(celda instanceof Cell);
    }

    @Test
    public void Test_COL_8() {
        System.out.println("getCell");
        int row = 0;
        int col = 8;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertNull(celda);
    }
    
    @Test
    public void Test_ROW_0() {
        System.out.println("getCell");
        int row = 0;
        int col = 0;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertTrue(celda instanceof Cell);
    }

    @Test
    public void Test_ROW_Menos1() {
        System.out.println("getCell");
        int row = 0;
        int col = -1;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertNull(celda);
    }

    @Test
    public void Test_ROW_7() {
        System.out.println("getCell");
        int row = 0;
        int col = 7;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertTrue(celda instanceof Cell);
    }

    @Test
    public void Test_ROW_8() {
        System.out.println("getCell");
        int row = 0;
        int col = 8;
        Board instance = new Board();
        Cell celda = instance.getCell(row, col);
        assertNull(celda);
    }
    
    /* test move Clases de equivalencia, Posición inicial (start_row / start_col)*/
    
    @Test
    public void testMoveInicialNegativo() {
        Board instance = new Board();
        int star_row = -2;
        int star_col = 5;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }
    
    @Test
    public void testMoveEntre0y7() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = 1;
        int end_col = 2;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertTrue(result instanceof Move);
    }
    
    @Test
    public void testMoveInicialMayor() {
        Board instance = new Board();
        int star_row = 8;
        int star_col = 1;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }
    
    @Test
    public void testMoveFinalNegativo() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = -2;
        int end_col = 5;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }
    
    /* test move Clases de equivalencia, Posición final (start_row / start_col)*/
    @Test
    public void testMoveFinalMayor() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 2;
        int end_row = 1;
        int end_col = 8;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }    
    
    @Test
    public void testMoveCeldaVacia() {
        Board instance = new Board();
        int star_row = 2;
        int star_col = 3;
        int end_row = 2;
        int end_col = 4;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }       
    
    @Test
    public void testMovePocicionNoInicial() {
        Board instance = new Board();
        instance.getCell(5, 0).setPiece(new Queen(5, 0, PieceType.White, true,"1"));
        int star_row = 5;
        int star_col = 0;
        int end_row = 4;
        int end_col = 0;      
        instance.getCell(end_row, end_col);      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertTrue(result instanceof Move);
    }    
    
    /* valores limites */
   
    @Test
    public void testMoveNegativoRowIni() {
        Board instance = new Board();
        int star_row = -1;
        int star_col = 0;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
    @Test
    public void testMoveNegativoColIni() {
        Board instance = new Board();
        int star_row = 0;
        int star_col = -1;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
        
    @Test
    public void testMoveLimite0() {
        Board instance = new Board();
        int star_row = 0;
        int star_col = 0;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertTrue(result instanceof Move);
    }   
    
    @Test
    public void testMoveLimite7() {
        Board instance = new Board();
        int star_row = 7;
        int star_col = 7;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertTrue(result instanceof Move);
    }   
    
    @Test
    public void testMoveRowMayorIni() {
        Board instance = new Board();
        int star_row = 8;
        int star_col = 7;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
    @Test
    public void testMoveColMayorIni() {
        Board instance = new Board();
        int star_row = 7;
        int star_col = 8;
        int end_row = 1;
        int end_col = 1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
    @Test
    public void testMoveRowNegFin() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = -1;
        int end_col = 0;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
    @Test
    public void testMoveRowColFin() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = 0;
        int end_col = -1;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
    @Test
    public void testMoveLimite0Fin() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = 0;
        int end_col = 0;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertTrue(result instanceof Move);
    }   
    
    @Test
    public void testMoveLimite7Fin() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = 7;
        int end_col = 7;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertTrue(result instanceof Move);
    }   
    
    @Test
    public void testMoveRowLim8() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = 8;
        int end_col = 7;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
    @Test
    public void testMoveColLim8() {
        Board instance = new Board();
        int star_row = 1;
        int star_col = 1;
        int end_row = 7;
        int end_col = 8;      
        Move result = instance.move(star_row, star_col, end_row, end_col);
        assertNull(result);
    }   
    
}
