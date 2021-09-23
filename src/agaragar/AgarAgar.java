/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agaragar;

import agaragar.controler.Jogo;

public class AgarAgar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Jogo j = new Jogo();
        
        Thread t = new Thread(j);
        t.start();
    }
    
}
