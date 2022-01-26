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
        ;
        int contador = 0;
        int fila, columna;
        if (this.moves == null) {
            this.moves = new Move[8];
            for (int i = 0; i < movimientos.length; i++) {
                fila = this.getPosition().getRow() + movimientos[i][0];
                columna = this.getPosition().getCol() + movimientos[i][1];
                //se encuentra en los margenes del tablero
                if (fila >= 0 && fila < board.getHeight() && columna >= 0 && columna < board.getWidht()) {
                    //se anyade si el destino es nulo o en caso de no ser nulo es una celda con ficha de diferente color
                    if (board.getCell(fila, columna).getPiece() == null
                            || (board.getCell(fila, columna).getPiece() != null && board.getCell(fila, columna).getPiece().getType() != this.getType())) {
                        moves[contador] = new Move(this, board.getCell(fila, columna).getPiece(), this.p.clone(), new Position(fila, columna));
                        contador++;
                    }
                }
            }
        }
        return moves;

    }

}
