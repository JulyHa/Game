/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class VeManHinh {

    public JLabel arrlb[][]  = new JLabel[4][4];
   
    public void veCacNut(JFrame frame, int W, int H, int M){
        int w = (W-3*M)/4;
        int h = (H-3*M)/4;
        int x=0, y=0;
        for(int i=0; i<4; i++){
            y = i*w+(1+i)*M;
            for(int j=0; j<4; j++){
                x = j*h+(1+j)*M;
                arrlb[i][j] = new JLabel("2");
                arrlb[i][j].setBounds(x, y, w, h);
                setBG(arrlb[i][j],i, j);
                arrlb[i][j].setOpaque(true);
                frame.add(arrlb[i][j]);
            }
        }
        frame.add(new JLabel());
    }
    private void setBG(JLabel l,int i, int j){
        int d = Data.getData().arr[i][j];
        String color="";
        switch(d) {
       case 2:
            color = "#e6fb01";
            break;
        case 4:
            color = "#9cfa07";
            break;
        case 8:
            color = "#23fa07";
            break;
        case 16:
            color = "#07faec";
            break;
        case 32:
            color = "#07befa";
            break;
        case 64:
            color = "#0790bd";
            break;
        case 128:
            color = "#e50fed";
            break;
        case 256:
            color = "#f014ba";
            break;
        case 512:
            color = "#fa9d3a";
            break;
        case 1024:
            color = "#f01467";
            break;
        case 2048:
            color = "#f90b21";
            break;
        default: 
            color = "#373737";
        }
        if(d==0) l.setText("");
        else{
            l.setText(""+d);
        }
        l.setFont(new Font("Sefif", Font.BOLD,26));
        l.setForeground(Color.WHITE);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);
        l.setBackground(Game2048.hex2Rgb(color));
    }
    
    public void upDate(){
         for(int i=0; i<4; i++){
         for(int j=0; j<4; j++){
             setBG(arrlb[i][j],i, j);
         }
        }
    }
}
