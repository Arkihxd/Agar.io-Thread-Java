/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agaragar.view;

import agaragar.model.Objeto;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author haperlin
 */
public class PainelJogo extends JPanel{
    
    private ArrayList<Objeto> objetos;
    
    public PainelJogo(){
        super(true);
    }
    
    public void setObjetos(ArrayList<Objeto> objetos){
        this.objetos = objetos;
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON); 

        // Set anti-alias for text
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        
        for(Objeto o:objetos){
            graphics2D.setColor(o.getCor());
            graphics2D.fillOval(o.getX(),o.getY(), o.getRaio(), o.getRaio());
        }
    }
    
}
