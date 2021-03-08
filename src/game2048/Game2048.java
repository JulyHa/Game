/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import java.awt.Color;
import javax.swing.JFrame;
public class Game2048 {

    JFrame game;
    QuanLyManHinh qlMH;
    VeManHinh vMH;
    QuanLyData qlDT;
    
    public Game2048(){
        init();
        setUP();
    }
    private void init(){
        game = new JFrame();
        qlMH = new QuanLyManHinh(vMH,qlDT,game);
    }
    private void setUP(){
        qlMH.setUp(game);
    }
    public void RunGame(){
        game.setVisible(true);
    }
    public static void main(String[] args) {
       Game2048 g = new Game2048();
       g.RunGame();
    }
    public static Color hex2Rgb(String colorStr){
        return new Color(
            Integer.valueOf(colorStr.substring(1,3),16),
            Integer.valueOf(colorStr.substring(3,5),16),
            Integer.valueOf(colorStr.substring(5,7),16));
    }
    
}
