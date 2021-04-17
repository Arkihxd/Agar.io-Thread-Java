/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agaragar.view;

import javax.swing.*;

/**
 *
 * @author haperlin
 */
public class JanelaPrincipal extends JFrame{
    
    public JanelaPrincipal(int largura, int altura, PainelJogo painel){
        this.setSize(largura, altura);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(painel);
        this.setVisible(true);
    }
    
    
    
    
}
