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
public class Knight extends Piece {

    private int movimientos[][] = {
        {-2, -1},
        {-2, 1},
        {-1, -2},
        {-1, 2},
        {2, -1},
        {2, 1},
        {1, -2},
        {1, 2}
    };

    public Knight() {
        super();
        this.letter = 'N';
    }

    public Knight(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'N';
        this.setId(id);
    }

   /* @Override
    public boolean canmove(Board board, int row, int col) {
     */
    @Override
    public Move[] getMoves(Board board) {
        //8 posibles movimiento  celdas menos una que ocupaha
        if (this.moves == null) {
            this.moves = new Move[12];
            //movilientos posibes

            int contador = 0;
            int fila, columna;
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
