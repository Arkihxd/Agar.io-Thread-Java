/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agaragar.model;

import java.util.Random;

public class Bacteria extends Objeto implements Runnable{
    
    private boolean vivo;
    private int largura,altura;
    private Random rnd;
    private int maxSono;
    
    public Bacteria(int largura, int altura, int maxSono, Random rnd){
        vivo = true;
        this.largura = largura;
        this.altura = altura;
        this.maxSono = maxSono;
        this.rnd = rnd;
    }
    
    public void morreu(){
        vivo = false;
    }
    
    public void run(){
        while(vivo){
            if(rnd.nextDouble()<=0.05){
                    int x = rnd.nextInt(largura);
                    int y = rnd.nextInt(altura);
                    this.setxD(x);
                    this.setyD(y);
                }
                
                double dX = ((this.getxD()-this.getX())/Math.abs(this.getxD()-this.getX()+0.01))*3;
                double dY = ((this.getyD()-this.getY())/Math.abs(this.getyD()-this.getY()+0.01))*3;
                
                this.setX((int)(this.getX()+dX));
                
                if(this.getX() > largura){
                    this.setX(0);
                }
                if(this.getX() < 0){
                    this.setX(largura);
                }
                
                this.setY((int)(this.getY()+dY));

                if(this.getY() > altura){
                    this.setY(0);
                }
                if(this.getY() < 0){
                    this.setY(altura);
                }
            
            try{
                Thread.sleep(rnd.nextInt(maxSono));
            }catch(InterruptedException e){}
        }
    }
    
    
}
