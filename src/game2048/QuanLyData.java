/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import java.util.Random;

public class QuanLyData {
    Random r= new Random();
    int ok = 0;
    public QuanLyData(){
        taoSo();
    }
    
    public void taoSo(){
        int oConTrong=0;
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]==0)
                    oConTrong++;
            }
        }
        if(oConTrong >=2){
            oConTrong=1;
        }
        int x = r.nextInt(4);
        int y = r.nextInt(4);
        while(Data.getData().arr[x][y] !=0){
            x = r.nextInt(4);
            y = r.nextInt(4);
        }
        if(r.nextInt(10)>6){
            Data.getData().arr[x][y]=4;
        }
        else Data.getData().arr[x][y]=2;
        oConTrong--;
        
    }
    
    public void moveLeft(){
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                    donO(i, j, 0, -1);
            }
        }
        
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                     gopO(i, j, 0, 1);
            }
        }
        
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                        donO(i, j, 0, -1);
            }
        }
        if(ok == 1) taoSo();
        ok = 0;
    }
    
    public void moveRight(){
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                    donO(i, j, 0, 1);  
            }
        }
        
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                  gopO(i, j, 0, 1);
            }
        }
        
        for(int i=0;i <4; i++){
            for(int j=3; j>=0; j--){
                if(Data.getData().arr[i][j]!=0)
                    donO(i, j, 0, 1);
            }
        }
       if(ok == 1) taoSo();
       ok = 0;
    }
    
    public void moveTop(){
       for(int i=3;i>=0; i--){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                    donO(i, j, -1, 0);
            }
        }
        
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                    gopO(i, j, 1, 0);
            }
        }
        
        for(int i=3;i>=0; i--){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                    donO(i, j, -1, 0);
            }
        }
        if(ok == 1) taoSo();
        ok = 0;
    }
    
    public void moveBt(){
         for(int i=3;i>=0; i--){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                    donO(i, j, 1, 0); 
            }
        }
        
        for(int i=0;i <4; i++){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                   gopO(i, j, 1,0);
            }
        }
        
        for(int i=3;i>=0; i--){
            for(int j=0; j<4; j++){
                if(Data.getData().arr[i][j]!=0)
                    donO(i, j, 1, 0);
            }
        }
        if(ok == 1) taoSo();
        ok = 0;
    }
  
    private void donO(int i, int j, int it, int jt){
        if(i==0 && it==-1) return;
        if(i==3 && it==1) return;
        if(j==0 && jt==-1) return;
        if(j==3 && jt==1) return;
        
        int x=i+it;
        int y = j+jt;
        if(Data.getData().arr[x][y]!=0){
            return;
        }
        int k = Data.getData().arr[i][j];
        Data.getData().arr[x][y] = k;
        Data.getData().arr[i][j] = 0;
        ok = 1;
        donO(x,y,it,jt);
        
    }
    
    private void gopO(int i, int j, int it, int jt){
        if(i==0 && it==-1) return;
        if(i==3 && it==1) return;
        if(j==0 && jt==-1) return;
        if(j==3 && jt==1) return;
        
        int x = i+it;
        int y = j+jt;
        if(Data.getData().arr[x][y]!= Data.getData().arr[i][j] ){
            return;
        }
        int k = Data.getData().arr[i][j]*2;
        Data.getData().arr[x][y] = 0;
        Data.getData().arr[i][j] = k;
        ok=1;
    }
}
