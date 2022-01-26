/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.controller;

import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.ChessPiece.King;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;
import pedro.ieslaencanta.com.chess.model.Move;

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
     * indica si en el siguiente movimiento se produce un jaque por la pieza situada
     * en esa celda
     * @param row
     * @param col
     * @return movimiento que hace que el rey este en mate
     */
    public Move Jaque(int row, int col){
        
        Piece p = this.board.getCell(row, col).getPiece();
        Move mvs[];
        Move vuelta=null;
        if (p != null ) {
            mvs = p.getMoves();
            for(int i=0;mvs!=null && i<mvs.length && vuelta==null;i++){
                if(mvs[i].getReplaced()!=null && (mvs[i].getReplaced() instanceof King) && mvs[i].getReplaced().getType()!=p.getType()){
                    vuelta=mvs[i];
                }
            }
                
        }
        return vuelta;
        
    }
    /**
     * Se comprueba jaquemate si antes es jaque !!IMPORTANTE!!
     * @return si el rey se puede move
     */
    public boolean JaqueMate(PieceType type){
        boolean vuelta=false;
        Move moves[];
        if(type==PieceType.Black)
            moves=this.board.getKingWhite().getMoves();
        else
            moves=this.board.getKingBlack().getMoves();
         if(moves==null || moves.length==0)
             vuelta=true;
        
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
    public void reset(){
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
