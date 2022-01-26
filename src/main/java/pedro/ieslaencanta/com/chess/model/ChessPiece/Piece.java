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
public abstract class Piece {

    protected Position p;
    protected PieceType type;
    protected boolean alive;
    protected Move moves[];
    protected char letter;
    private String id;

    public Piece() {

    }

    public Piece(int row, int col) {
        this.p = new Position(row, col);
    }

    @Override
    public String toString() {
        return this.getId();
    }

    /**
     * Mueve una pieza a una posición del tablero, la comprobación se realiza en
     * canmove, no aqui
     *
     * @param board
     * @param row
     * @param col
     * @return devuelve un movimiento
     */
    public Move move(Board board, int row, int col) {
        //se crea el movimiento
        Position origin = this.getPosition().clone();
        Position end = new Position(row, col);
        Piece p = board.getCell(row, col).getPiece();
        //en caso de que el destino tenga pieza, se elimina
        if (p != null) {
            p.setAlive(false);
        }
        Move move = new Move(this, p, origin, end);
        //se actualiza la posición
        this.getPosition().setRow(row);
        this.getPosition().setCol(col);
        //al mover la pieza ya no se tiene esos movimientos
        this.moves = null;
        return move;
    }

    protected Move[] getHorizontalMoves(Board b, int row, int start, int end) {

        Move moves[] = new Move[(start > end) ? start - end + 1 : end - start + 1];
        int c = 0;

        Piece p = null;
        //para la condicion del for que se evalue el ultimo
        if (end < start) {
            end = end - 1;
        }
        for (int i = start; i != end && p == null && i >= 0 && i < b.getWidht(); i = i + ((start > end) ? -1 : 1)) {

            if (i < b.getWidht()
                    && i >= 0
                    && (b.getCell(row, i).getPiece() == null
                    || (b.getCell(row, i).getPiece() != null && b.getCell(row, i).getPiece().getType() != this.getType()))) {

                moves[c] = new Move(this,
                        b.getCell(row, i).getPiece(),
                        this.getPosition().clone(), new Position(row, i));
                c++;
            }
            if (b.getCell(row, i).getPiece() != null) {
                p = b.getCell(row, i).getPiece();
            }
        }
        return moves;
    }

    protected Move[] getVertical(Board b, int col, int start, int end) {

        Move moves[] = new Move[(start > end) ? start - end + 1 : end - start + 1];
        int c = 0;
        Piece p = null;
        //para la condicion del for que se evalue
        if (end < start) {
            end = end - 1;
        }

        for (int i = start; i != end && p == null && i >= 0 && i < b.getHeight(); i = i + ((start > end) ? -1 : 1)) {
            if (i < b.getWidht()
                    && i >= 0
                    && (b.getCell(i, col).getPiece() == null
                    || (b.getCell(i, col).getPiece() != null && b.getCell(i, col).getPiece().getType() != this.getType()))) {
                moves[c] = new Move(this, b.getCell(i, col).getPiece(), this.getPosition().clone(), new Position(i, col));
                c++;
            }
            if (b.getCell(i, col).getPiece() != null) {
                p = b.getCell(i, col).getPiece();
            }
        }
        return moves;
    }

    /**
     *
     * @param b tablero
     * @param dirx si va hacia la izquierda o derecha
     * @param diry si va hacia arriba o hacia abajo
     * @return movimientos posibles en esa diagonal
     */
    protected Move[] getDiagonal(Board b, int dirx, int diry) {

        return this.getDiagonal(b, dirx, diry, b.getHeight());
    }

    /**
     *
     * @param b tablero
     * @param dirx direccion de la diagonal enel eje x -1 izquierda, 1 derecha
     * @param diry direccionde la diagonal en el eje y -1 arriba, 1 abajo
     * @param lenght longitud máxima
     * @return
     */
    protected Move[] getDiagonal(Board b, int dirx, int diry, int lenght) {

        Move moves[] = new Move[7];
        int c = 0;
        int i = this.p.getRow() + diry;
        int j = this.p.getCol() + dirx;
        Piece p = null;
        for (; i != ((diry == -1) ? -1 : b.getHeight()) && j != ((dirx == -1) ? -1 : b.getWidht()) && p == null && c < lenght;
                i = i + diry, j = j + dirx) {
            if ((b.getCell(i, j).getPiece() == null
                    || (b.getCell(i, j).getPiece() != null && b.getCell(i, j).getPiece().getType() != this.getType()))) {
                moves[c] = new Move(this, b.getCell(i, j).getPiece(), this.getPosition().clone(), new Position(i, j));
                c++;
            }
            if (b.getCell(i, j).getPiece() != null) {
                p = b.getCell(i, j).getPiece();
            }
        }
        return moves;
    }

    public boolean canmove(Board board, int row, int col) {
        boolean vuelta = false;
        
        if (this.moves == null) {
            this.getMoves(board);
        }
       
        if (this.moves != null) {
            for (int i = 0; i < this.moves.length && !vuelta ; i++) {
                if (this.moves[i]!=null && this.moves[i].getEnd()!=null && this.moves[i].getEnd().getRow() == row && this.moves[i].getEnd().getCol() == col) {
                    vuelta = true;
                }
                 /*if (this.moves[i]!=null && this.moves[i].getEnd()!=null){
                     System.out.println(this.moves[i].getEnd().getRow()+" "+row+" ->"+ this.moves[i].getEnd().getCol()+" "+ col);
                 }*/
            }
        }
       
        return vuelta;
    }
    public Move[] getCalculatedMoves(){
        return this.moves;
    }
    public abstract Move[] getMoves(Board board);

    /**
     * @return the letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     * @param letter the letter to set
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * @return the p
     */
    public Position getPosition() {
        return p;
    }

    /**
     * @return the type
     */
    public PieceType getType() {
        return type;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param p the p to set
     */
    public void setPosition(Position p) {
        this.p = p;
    }

    /**
     * @param type the type to set
     */
    public void setType(PieceType type) {
        this.type = type;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = this.letter + ((this.getType() == PieceType.White) ? "W" : "B") + id;
    }

    /**
     * @return the moves
     */
    public Move[] getMoves() {
        return moves;
    }
}
