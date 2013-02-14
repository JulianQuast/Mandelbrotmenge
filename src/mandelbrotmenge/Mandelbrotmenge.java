/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrotmenge;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Julian
 */
public class Mandelbrotmenge {

    public static Graphics g;
    public static double xmin = -2;
    public static double xmax = 2;
    public static double ymin = -2;
    public static double ymax = 2;
    public static double border = 2;
    public static int limit = 1000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
        g = gui.getGraphics();
        draw();
    }

    public static int calc(double realpart, double imagpart, double border) {
        double r = 0;
        double i = 0;
        double r2;
        double i2;
        int counter = 0;
        while (r * r + i * i < border && counter < limit) {
            r2 = r * r - i * i + realpart;
            i2 = 2 * r * i + imagpart;
            r = r2;
            i = i2;
            counter++;
        }
        return counter;
    }

    public static void draw() {
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                double im = ymin + (ymax - ymin) * i / 400;
                double re = xmin + (xmax - xmin) * j / 400;
                int erg = calc(re, im, border);
                if (erg >= limit) {
                    g.setColor(Color.black);
                    g.fillRect(j, i, 1, 1);
                } else if (erg >= 625) {
                    g.setColor(Color.blue);
                    g.fillRect(j, i, 1, 1);
                } else if (erg >= 625) {
                    g.setColor(Color.pink);
                    g.fillRect(j, i, 1, 1);
                } else if (erg >= 125) {
                    g.setColor(Color.red);
                    g.fillRect(j, i, 1, 1);
                } else if (erg >= 25) {
                    g.setColor(Color.orange);
                    g.fillRect(j, i, 1, 1);
                } else if (erg >= 5) {
                    g.setColor(Color.green);
                    g.fillRect(j, i, 1, 1);
                } else {
                    g.setColor(Color.white);
                    g.fillRect(j, i, 1, 1);
                }
            }
        }
    }
}
