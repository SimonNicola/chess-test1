/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.ChessPiece.King;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Queen;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public class Game {

    private Board board;
    //cierto blancas, falso neras
    private boolean currentTurn;
    private Move[] leans;
    private PieceType turn;

    public Game() {
        this.board = new Board();
        this.currentTurn = true;
        this.turn = PieceType.White;
    }

    /**
     * Mover una pieza si existe en la posición y es del turno
     *
     * @param startrow
     * @param startcol
     * @param endrow
     * @param endcol
     * @return
     */
    public Move move(int startrow, int startcol, int endrow, int endcol) {
        Move m = this.board.move(startrow, startcol, endrow, endcol);
        Piece p = this.board.getCell(endrow, endcol).getPiece();
        if (p != null) {
            p.getPosition().setRow(endrow);
            p.getPosition().setCol(endcol);
            this.turn = (this.turn == PieceType.Black ? PieceType.White : PieceType.Black);

        }
        return m;
    }

    /**
     * indica si alguna de las piezas se encuentra en posicion de dar jaque
     *
     *
     * @return movimiento que hace que el rey este en mate
     */
    public Move[] Jaque() {
        Piece p;
        int c = 0;
        Move mvs[];
        //como máximo 32 -2 30 movimimentos
        Move[] vuelta = new Move[30];
        for (int i = 0; i < this.board.getHeight(); i++) {
            for (int j = 0; j < this.board.getWidht(); j++) {
                p = this.board.getCell(i, j).getPiece();

                if (p != null) {
                    mvs = p.getMoves(board);
                    for (int k = 0; mvs != null && k < mvs.length; k++) {
                        
                        //si en el movimiento se cuentra un rey del signo contrario
                        if (mvs[k] != null && mvs[k].getReplaced() != null && (mvs[k].getReplaced() instanceof King) && mvs[k].getReplaced().getType() != p.getType()) {
                            vuelta[c] = mvs[k];
                            c++;
                        }
                    }
                   // System.out.println("Evaluando:" + i + " " + j + " con pieza:" + p.getClass().getName() + " contador:" + c);

                }
            }
        }
        //no se utilizan estructuras dinámicas ya que no se han visto en clase
        if (c == 0) {
            return null;
        } else {
            return vuelta;
        }

    }

    private boolean IsJaque(King rey) {
        boolean vuelta = false;
        //vemos los jaques con ese nuevo tablero
        Move[] kingmoves = this.Jaque();
        //si existe una ficha en ese movimiento entoces es jaque
        for (int j = 0; kingmoves != null && j < kingmoves.length && !vuelta; j++) {
            if (kingmoves[j] != null && kingmoves[j].getReplaced() != null && kingmoves[j].getReplaced() == rey) {
                vuelta = true;
            }
            //Se vuelve a la posicion inicial

        }
        return vuelta;
    }

    /**
     * Se comprueba jaquemate si antes es jaque se le pasa el color de la última
     * jugada y comprueba para el rey contrario
     *
     * @return si el rey se puede move
     */
    public boolean JaqueMate(PieceType type) {
        //es jaque mientras no pueda hacer algun movimiento
        //vuelta true si libre, 0 si no libre
        boolean vuelta = true;
        Position origin=null;
        King tempo=null;
        Move moves[]=null;

        if (type == PieceType.White) {
            try {
                tempo = this.board.getKingWhite();
                origin = tempo.getPosition().clone();
                moves = this.board.getKingWhite().getMoves(this.board);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                tempo = this.board.getKingBlack();
                origin = tempo.getPosition().clone();
                moves = this.board.getKingBlack().getMoves(this.board);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //será jaque mate sii todos los movimientos posibles son jaque
        //en el momento que uno no sea jaque, no es jaquemate
        for (int i = 0; moves != null && i < moves.length && vuelta; i++) {
            if (moves[i] != null) {
                //se mueve a la posicion
                this.move(origin.getRow(), origin.getCol(), moves[i].getEnd().getRow(), moves[i].getEnd().getCol());
                //se evalua si con ese movimiento se tiene jaque
                //mientras el movimiento sea jaque en el momento que un movimiento no
                //sea jaque, no es jque mate
                vuelta = this.IsJaque(tempo);
                this.move(moves[i].getEnd().getRow(), moves[i].getEnd().getCol(), origin.getRow(), origin.getCol());
                

            }
        }

        return vuelta;
    }

    /**
     * Si una ficha se puede mover o no a partir de las coordenadas
     *
     * @param startrow
     * @param startcol
     * @param endrow
     * @param endcol
     * @return
     */
    public boolean canMove(int startrow, int startcol, int endrow, int endcol) {
        boolean vuelta = false;
        Piece p = this.board.getCell(startrow, startcol).getPiece();

        if (p != null && p.getType() == this.turn) {
            vuelta = p.canmove(this.board, endrow, endcol);
        }
        return vuelta;
    }

    /**
     * Para una celda devuelve los movimientos calculados de esa celda de estar
     * una pieza en ella
     *
     * @param row
     * @param col
     * @return movimientos posibles
     * @see pedro.ieslaencanta.com.chess.model.Move
     */
    public Move[] getCalculatesMoves(int row, int col) {
        Move m[] = null;
        Piece p = this.board.getCell(row, col).getPiece();
        //
        if (p != null && p.getType() == this.turn) {
            m = p.getCalculatedMoves();

        }
        return m;
    }

    /**
     * Calcula y devuelve los movimeintos posibles para esa figura si en la
     * celda se encuentra una figura, los movimientos se quedan almacenados en
     * la figura
     *
     * @param row
     * @param col
     * @return Movimientos posibles
     * @see pedro.ieslaencanta.com.chess.model.Move
     */
    public Move[] getMoves(int row, int col) {
        Move m[] = null;
        Piece p = this.board.getCell(row, col).getPiece();
        if (p != null && p.getType() == this.turn) {
            m = p.getMoves(this.board);

        }
        return m;
    }

    public void reset() {
        this.board.reset();
    }

    public PieceType getPieceType(int row, int col) {
        PieceType pt = null;
        Piece p = this.board.getCell(row, col).getPiece();
        if (p != null && p.getType() == this.turn) {
            pt = p.getType();
        }
        return pt;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    public PieceType getTurn() {
        return this.turn;
    }
}
