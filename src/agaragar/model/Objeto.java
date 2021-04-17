package agaragar.model;

import java.awt.Color;

/**
 *
 * @author haperlin
 */
public class Objeto {
    private int x,y;
    private int xD,yD;
    private int raio;
    private int massa;
    private Color cor;
    
        /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the raio
     */
    public int getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(int raio) {
        this.raio = raio;
    }

    /**
     * @return the massa
     */
    public int getMassa() {
        return massa;
    }

    /**
     * @param massa the massa to set
     */
    public void setMassa(int massa) {
        this.massa = massa;
    }
    
    public Color getCor(){
        return this.cor;
    }
    
    public void setCor(Color cor){
        this.cor = cor;
    }
    
    
    public String toString(){
        return this.x +","+this.y;
    }

    /**
     * @return the xD
     */
    public int getxD() {
        return xD;
    }

    /**
     * @param xD the xD to set
     */
    public void setxD(int xD) {
        this.xD = xD;
    }

    /**
     * @return the yD
     */
    public int getyD() {
        return yD;
    }

    /**
     * @param yD the yD to set
     */
    public void setyD(int yD) {
        this.yD = yD;
    }
}
