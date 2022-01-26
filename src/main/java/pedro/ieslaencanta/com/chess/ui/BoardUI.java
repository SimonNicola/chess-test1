/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.ui;

import javafx.geometry.Point2D;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.*;

/**
 *
 * @author Pedro
 */
public class BoardUI {

    private Element element;
    public static String COLOR_NEGRAS="#aaaaaa";
    public static  String COLOR_BLANCAS="#FFFFFF";
    public static  String COLOR_SELECCIONADO="#00FF00";
    public static  String COLOR_POSIBLES="#222222";
    public static  String COLOR_MATAR="#770000";
    public BoardUI(Document doc, int board_width, int board_height) {
        Element rect = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "g");
        Element cell, texto;
        rect.setAttributeNS(null, "x", "0");
        //rect.setAttributeNS(null, "y", "0");
        //rect.setAttributeNS(null, "width", String.valueOf(board_width));
        //rect.setAttributeNS(null, "height", String.valueOf(board_height));
        //rect.setAttributeNS(null, "fill", "#ff0000");
        this.element = rect;
        float width = board_width / 8;
        float height = board_height / 8;
        int contador = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cell = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "rect");
                cell.setAttributeNS(null, "x", String.valueOf(width * j));
                cell.setAttributeNS(null, "y", String.valueOf(height * i));
                cell.setAttributeNS(null, "width", String.valueOf(width));
                cell.setAttributeNS(null, "height", String.valueOf(height));

                cell.setAttributeNS(null, "id", ("r" + i + "c" + j));
              if (i % 2 != 0) {
                    if (j % 2 != 0) {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_BLANCAS);
                    } else {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_NEGRAS);
                    }
                } else {
                    if (j % 2 != 0) {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_NEGRAS);
                    } else {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_BLANCAS);
                    }
                }

                this.element.appendChild(cell);
            }
        }

        /* Element group=doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "g");
        Element tablero = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "path");
       
        float width = board_width / 8;
        float height = board_height / 8;
        int px = 0, py = 0;
        StringBuffer path = new StringBuffer();
        path.append("M 0 0");
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                path.append("M " + width * 0 + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");
                path.append("M " + width * 2 + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");
                path.append("M " + (width * 4) + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");
                path.append("M " + (width * 6) + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");
            } else {
                path.append("M " + width * 1 + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");
                path.append("M " + width * 3 + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");
                path.append("M " + (width * 5) + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");
                path.append("M " + (width * 7) + " " + height * i + " h " + width + "v" + height + " h" + (-width) + " v" + (-height) + "\n");

            }
        }

        path.append("z");
        tablero.setAttributeNS(null, "x", "0");
        tablero.setAttributeNS(null, "y", "0");
        tablero.setAttributeNS(null, "fill", "#aaaaaa");
        tablero.setAttributeNS(null, "id", "tablero");
        tablero.setAttributeNS(null, "d", path.toString());//M22.5 9c-2.21 0-4 1.79-4 4 0 .89.29 1.71.78 2.38C17.33 16.5 16 18.59 16 21c0 2.03.94 3.84 2.41 5.03-3 1.06-7.41 5.55-7.41 13.47h23c0-7.92-4.41-12.41-7.41-13.47 1.47-1.19 2.41-3 2.41-5.03 0-2.41-1.33-4.5-3.28-5.62.49-.67.78-1.49.78-2.38 0-2.21-1.79-4-4-4z");
        this.element=group;
        this.element.appendChild(rect);
        this.element.appendChild(tablero);*/
    }

    /**
     * @return the element
     */
    public Element getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Element element) {
        this.element = element;
    }
}
