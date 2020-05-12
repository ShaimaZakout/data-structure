/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabDataStructure.recursion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Sunshine
 */
public class RecursionDrawCircle extends JFrame {

    Point2D.Float center = new Point2D.Float(10, 10);
    Point2D.Float dimentions = new Point2D.Float(10, 10);

    public RecursionDrawCircle() {
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setVisible(true);
    } 
    void DrawCircle(int x, int y, int radius, Graphics G) {
        G.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        if (radius >= 3) {
            radius = radius / 2;
            DrawCircle(x, y, radius, G);
         }
     }  
      @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        DrawCircle(250 , 280, 150, grphcs);
 
    }
     

}
