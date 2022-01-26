/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public class Bishop extends Piece {

    public Bishop() {
        super();
        this.letter = 'B';
    }

    public Bishop(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'B';
        this.setId(id);
    }


    @Override
    public Move[] getMoves(Board board) {
        //14 posibles movimiento 13 celdas menos una que ocupaha
        int c = 0, i;
        if (this.moves == null) {
            this.moves = new Move[28];
            Move tempo[];
            boolean nulo = false;
            tempo = this.getDiagonal(board, 1, -1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                moves[c] = tempo[i];
                c++;
            }
            //diagonal arriba izquierda columnas-1, filas-1
            tempo = this.getDiagonal(board, -1, -1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                moves[c] = tempo[i];
                c++;
            }
            //diagonal abajo derecha columnas+1, filas-1
            tempo = this.getDiagonal(board, 1, 1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                moves[c] = tempo[i];
                c++;
            }
            //diagonal abajo izquierda columnas+1, filas-1
            tempo = this.getDiagonal(board, -1, 1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                moves[c] = tempo[i];
                c++;
            }

        }

        return moves;
    }

}
