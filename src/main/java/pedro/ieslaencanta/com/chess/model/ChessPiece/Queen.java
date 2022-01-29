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
public class Queen extends Piece {

    private int movimientos[][];

    public Queen() {
        super();
        this.letter = 'Q';
    }

    public Queen(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'Q';
        this.setId(id);
    }

   
    @Override
    public Move[] getMoves(Board board) {
        int c = 0, i;
       // if (this.moves == null) {
            this.moves = new Move[28];
            Move tempo[];
            boolean nulo = false;
            //diagonal arriba derecha columnas+1, filas-1
            tempo = this.getDiagonal(board, 1, -1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            //diagonal arriba izquierda columnas+1, filas-1
            tempo = this.getDiagonal(board, -1, -1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            //diagonal abajo derecha columnas+1, filas-1
            tempo = this.getDiagonal(board, 1, 1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            //diagonal abajo izquierda columnas+1, filas-1
            tempo = this.getDiagonal(board, -1, 1);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            //derecha
            tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol() + 1, 8);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            //izquierda
            tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol() - 1, 0);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            //abajo
            tempo = this.getVertical(board, this.p.getCol(), this.p.getRow() + 1, 8);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            //arriba
            tempo = this.getVertical(board, this.p.getCol(), this.p.getRow() + -1, 0);
            for (i = 0; i < tempo.length && !nulo; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }

       // }
        return moves;
    }

}
