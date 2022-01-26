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
public class Rook extends Piece {

    public Rook() {
        super();
        this.letter = 'R';
    }

    public Rook(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'R';
        this.setId(id);
    }

    /* @Override
    public boolean canmove(Board board, int row, int col) {
        boolean vuelta = true;
        if (row != this.p.getRow() && col != this.p.getCol()) {
            vuelta = false;
        }
        //tiene que coincidir la fila y la columna
        if (vuelta && row == this.p.getRow()) {
            //se comprueba que no existe ninguna ficha en el camino
            for (int i = col; i != this.p.getCol() && vuelta; i = i + (col < this.p.getCol() ? 1 : -1)) {
                //se encuentra por el caminino una figura y no es posible
                if (board.getCell(row, i).getPiece() != null && i != col) {
                    vuelta = false;
                }
            }
        } else {
            //se mira en la columna
            if (vuelta && col == this.p.getCol()) {
                for (int i = row; i != this.p.getRow() && vuelta; i = i + (row < this.p.getRow() ? 1 : -1)) {
                    //se encuentra por el caminino una figura y no es posible
                    if (board.getCell(i, col).getPiece() != null && i != row) {
                        vuelta = false;
                    }
                }
            }
        }
        //si se ha llegado hasta aquí se comprueba que el final no sea de su mismo color
        if (vuelta && board.getCell(row, col).getPiece() != null && board.getCell(row, col).getPiece().getType() == this.type) {
            vuelta = false;
        }
        if (vuelta && this.getPosition().equals(new Position(row, col))) {
            vuelta = false;
        }
        return vuelta;
    }
     */
    @Override
    public Move[] getMoves(Board board) {
        //14 posibles movimiento 8 celdas menos una que ocupaha
        this.moves = new Move[20];
        Move tempo[];
        boolean nulo = false;
        int c = 0;

        Piece tope = null;
        int i;
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

        return this.moves;
    }

}
