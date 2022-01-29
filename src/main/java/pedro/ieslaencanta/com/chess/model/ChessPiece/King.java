/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import java.util.logging.Level;
import java.util.logging.Logger;
import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public class King extends Piece {

    private int movimientos[][] = {
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {1, -1},
        {1, 0},
        {1, -1},
        {0, -1},
        {0, 1}
    };

    public King() {
        super();
        this.letter = 'K';
    }

    public King(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'K';
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {

        int contador = 0;
        int fila, columna;
        //8 posibles movimiento  celdas menos una que ocupaha
        // if (this.moves == null) {
        this.moves = new Move[8];
        int c = 0, i;
        Move tempo[];
        boolean nulo = false;

        //derecha
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol() + 1, this.p.getCol() + 2);
        for (i = 0; i < tempo.length && !nulo; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        //izquierda
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol() - 1, this.p.getCol() - 2);
        for (i = 0; i < tempo.length && !nulo; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        //abajo
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow() + 1, this.p.getRow() + 2);
        for (i = 0; i < tempo.length && !nulo; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        //arriba
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow()-1 , this.p.getRow()-2);
        for (i = 0; i < tempo.length && !nulo; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        //diagonal derecha arriba columnas+1, filas-1
        tempo = this.getDiagonal(board, 1, -1, 1);
        for (i = 0; i < tempo.length && !nulo; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        //diagonal izquierda arriba columnas-1, filas-1
        tempo = this.getDiagonal(board, -1, -1, 1);
        for (i = 0; i < tempo.length && !nulo; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        //diagonal derecha abaja columnas+1, filas+1
        tempo = this.getDiagonal(board, 1, 1, 1);
        for (i = 0; i < tempo.length && !nulo; i++) {
             if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        //diagonal abajo izquierda columnas-1, filas+1
        tempo = this.getDiagonal(board, -1, 1, 1);
        for (i = 0; i < tempo.length && !nulo; i++) {
          if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }

        //if (this.moves == null) {
        //   this.moves = new Move[8];
        /* for (int i = 0; i < movimientos.length; i++) {
                fila = this.getPosition().getRow() + movimientos[i][0];
                columna = this.getPosition().getCol() + movimientos[i][1];
                //se encuentra en los margenes del tablero
                if (fila >= 0 && fila < board.getHeight() && columna >= 0 && columna < board.getWidht()) {
                    //se anyade si el destino es nulo o en caso de no ser nulo es una celda con ficha de diferente color
                    if (board.getCell(fila, columna).getPiece() == null
                            || (board.getCell(fila, columna).getPiece() != null && board.getCell(fila, columna).getPiece().getType() != this.getType())) {
                        try {
                            moves[contador] = new Move(this, board.getCell(fila, columna).getPiece(), this.p.clone(), new Position(fila, columna));
                            contador++;
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(King.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        //}*/
        return moves;

    }

}
