/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_nux;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author Nakarin
 */
public class genKeyPlane {

double[] KeyPlane( double C ,double D,double yIn) throws UnsupportedEncodingException{
    double[] toReturn = new double[12];
    double[] yyy = new double[14];
    
    Double C_cof = C; Double D_cof = D;
    
//    System.out.println("Cof1 : " + C + " Cof2 "+D);
yyy[0]=yIn;
yyy[1]=yIn;

int k,j;
 for( k= 2; k < 12+2; k++){
      double lo=C_cof*yyy[k-2];
      double li=D_cof*yyy[k-1];
      double lp = li+lo;   
      double r = ((lp+1) % 2);
    if(r<0){r +=2;} 
    yyy[k]  = r-1;
    toReturn[k-2]=yyy[k]; 
  }
  return toReturn;
}

}

