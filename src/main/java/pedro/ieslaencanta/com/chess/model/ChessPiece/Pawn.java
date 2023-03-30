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
public class Pawn extends Piece {

    private boolean can_move_two;

    public Pawn() {
        super();
        this.can_move_two = true;
        this.letter = 'P';
    }

    public Pawn(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.can_move_two = true;
        this.type = type;
        this.alive = alive;
        this.letter = 'P';
        this.setId(id);
    }
    
    @Override
    public Move move(Board board, int row, int col) {
        this.can_move_two = false;
        
        return super.move(board, row, col);
        
    }

    @Override
    public Move[] getMoves(Board board) {
        // 4 posibles movimiento avanza 1, 2(primera vez), diagonal izquierda, diagonal drecha
        int c = 0;

        this.moves = new Move[4];
        if (this.type == PieceType.White) {
            //si puede avanzar 1 casilla hacia abajo
            if (this.getPosition().getRow() + 1 >= 0
                    && board.getCell(this.getPosition().getRow() - 1, this.getPosition().getCol()).getPiece() == null) {
                moves[0] = new Move(this, null, this.getPosition(), new Position(this.getPosition().getRow() - 1, this.getPosition().getCol()));
            }
            //si puede avanzar 2 casilla hacia arriba
            if (this.getPosition().getRow() - 2 >= 0
                    && this.can_move_two
                    && board.getCell(this.getPosition().getRow() - 2, this.getPosition().getCol()).getPiece() == null) {
                moves[1] = new Move(this, null, this.getPosition(), new Position(this.getPosition().getRow() - 2, this.getPosition().getCol()));

            }
            //si puede avanzar hacia la DIAGONAL derecha si no es un extremo
            //existe una pieza y no es blanca x-1, y+1
            if (this.getPosition().getRow() - 1 >= 0
                    && this.getPosition().getCol() + 1 < board.getWidht()
                    && board.getCell(this.getPosition().getRow() - 1, this.getPosition().getCol() + 1).getPiece() != null
                    && board.getCell(this.getPosition().getRow() - 1, this.getPosition().getCol() + 1).getPiece().getType() != this.getType()) {
                moves[2] = new Move(this, board.getCell(this.getPosition().getRow() - 1, this.getPosition().getCol() + 1).getPiece(), this.getPosition(), new Position(this.getPosition().getRow() - 1, this.getPosition().getCol() + 1));
            }
            //si puede avanzar hacia la DIAGONAL izquierda si no es un extremo
            //existe una pieza y no es blanca x-1, y-1
            if (this.getPosition().getRow() - 1 > 0
                    && this.getPosition().getCol() - 1 >= 0
                    && board.getCell(this.getPosition().getRow() - 1, this.getPosition().getCol() - 1).getPiece() != null
                    && board.getCell(this.getPosition().getRow() - 1, this.getPosition().getCol() - 1).getPiece().getType() != this.getType()) {
                moves[3] = new Move(this, board.getCell(this.getPosition().getRow() - 1, this.getPosition().getCol() - 1).getPiece(), this.getPosition(), new Position(this.getPosition().getRow() - 1, this.getPosition().getCol() - 1));
            }
        } //fichas negras
        else {
            //si puede avanzar 1 casilla hacia abajo
            if (this.getPosition().getRow() + 1 < board.getHeight()
                    && board.getCell(this.getPosition().getRow() + 1, this.getPosition().getCol()).getPiece() == null) {
                moves[0] = new Move(this, null, this.getPosition(), new Position(this.getPosition().getRow() + 1, this.getPosition().getCol()));
            }
            //si puede avanzar 2 casilla hacia abajo
            if (this.getPosition().getRow() + 2 < board.getHeight()
                    && this.can_move_two
                    && board.getCell(this.getPosition().getRow() + 2, this.getPosition().getCol()).getPiece() == null) {
                moves[1] = new Move(this, null, this.getPosition(), new Position(this.getPosition().getRow() + 2, this.getPosition().getCol()));
            }
            //si puede avanzar hacia la DIAGONAL derecha si no es un extremo
            //existe una pieza y no es negra x+1, y+1
            if (this.getPosition().getRow() + 1 >= 0
                    && this.getPosition().getCol() + 1 < board.getWidht()

                    && board.getCell(this.getPosition().getRow() + 1, this.getPosition().getCol() + 1).getPiece() != null
                    && board.getCell(this.getPosition().getRow() + 1, this.getPosition().getCol() + 1).getPiece().getType() != this.getType()) {
                try {
                    moves[2] = new Move(this, board.getCell(this.getPosition().getRow() + 1, this.getPosition().getCol() + 1).getPiece(), this.getPosition().clone(), new Position(this.getPosition().getRow() + 1, this.getPosition().getCol() + 1));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Pawn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //si puede avanzar hacia la DIAGONAL izquierda si no es un extremo
            //existe una pieza y no es blanca x-1, y+1
            if (this.getPosition().getRow() + 1 >= 0
                    && this.getPosition().getCol() - 1 >= 0

                    && board.getCell(this.getPosition().getRow() + 1, this.getPosition().getCol() - 1).getPiece() != null
                    && board.getCell(this.getPosition().getRow() + 1, this.getPosition().getCol() - 1).getPiece().getType() != this.getType()) {
                try {
                    moves[3] = new Move(this, board.getCell(this.getPosition().getRow() + 1, this.getPosition().getCol() - 1).getPiece(), this.getPosition().clone(), new Position(this.getPosition().getRow() + 1, this.getPosition().getCol() - 1));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Pawn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return moves;
    }
}
