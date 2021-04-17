/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agaragar.controler;

import agaragar.model.Bacteria;
import agaragar.model.Jogador;
import agaragar.model.Objeto;
import agaragar.view.JanelaPrincipal;
import agaragar.view.PainelJogo;
import java.awt.Color;
import static java.awt.Color.red;
import static java.awt.Color.yellow;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author haperlin
 */
public class Jogo implements KeyListener, Runnable{
    
    private ArrayList<Objeto> objetos;
    
    private Jogador jogador;
    private JanelaPrincipal janela;
    private PainelJogo painel;
    private int largura,altura;
    
    private Random rand;
     
    public Jogo() {
        
        Dimension dimMonitor = Toolkit.getDefaultToolkit().getScreenSize();
        
        //altura = dimMonitor.height;
        //largura = dimMonitor.width;
        altura=1000;
        largura=1000;
        rand = new Random(System.currentTimeMillis());
        
        objetos = new ArrayList<Objeto>();
        for(int i=0;i<50;i++){
            Bacteria obj = new Bacteria(largura, altura, 100,rand);
            obj.setX(rand.nextInt(largura));
            obj.setY(rand.nextInt(altura));
            obj.setxD(rand.nextInt(largura));
            obj.setyD(rand.nextInt(altura));
            
            obj.setRaio(rand.nextInt(20));
            
            if(rand.nextBoolean()==true){
            obj.setCor(Color.yellow);
            }
            else{
               obj.setCor(Color.red);
            }
            
            objetos.add(obj);
            
            new Thread(obj).start();
        }
        
      
        
        jogador = new Jogador();
        jogador.setX(180);
        jogador.setY(180);
        jogador.setRaio(20);
        jogador.setCor(Color.ORANGE);
        
        objetos.add(jogador);
        
        painel = new PainelJogo();
        painel.setObjetos(objetos);
        painel.setBackground(Color.white);
        
        janela = new JanelaPrincipal(largura,altura,painel);
        
        janela.addKeyListener(this);
    }
   

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            jogador.setY(jogador.getY()-10);
            if(jogador.getY() < -1*jogador.getRaio()){
                jogador.setY(altura);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            jogador.setY(jogador.getY()+10);
            if(jogador.getY() > altura){
                jogador.setY(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            jogador.setX(jogador.getX()+10);
            if(jogador.getX() > largura){
                jogador.setX(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            jogador.setX(jogador.getX()-10);
            if(jogador.getX() < -1*jogador.getRaio()){
                jogador.setX(largura);
            }
        }
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    private double distancia(int x1,int y1,int x2,int y2){
        double difX = (x1-x2);
        double difY = (y1-y2);
        
        difX = difX*difX;
        difY = difY*difY;
        
        return Math.sqrt(difX+difY);
    }
    
    private void verificaColisao(){
        for (Iterator<Objeto> iterator = objetos.iterator(); iterator.hasNext(); ) {
            Objeto o = iterator.next();
            if(!(o instanceof Jogador)){
                if (distancia(jogador.getX(),jogador.getY(),o.getX(),o.getY()) < jogador.getRaio()/2){
                    Color g = ((Bacteria)o).getCor();
                    if(g == yellow){
                      jogador.setRaio(jogador.getRaio()-o.getRaio());
                        ((Bacteria)o).morreu();
                         iterator.remove();
                    }
                    else{
                    jogador.setRaio(jogador.getRaio()+o.getRaio());
                        ((Bacteria)o).morreu();
                        iterator.remove();
                    }
                }
               
            }
        }
        
    }

    @Override
    public void run() {
        while(true){
            verificaColisao();
            this.janela.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    
}
