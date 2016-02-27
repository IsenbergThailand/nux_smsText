/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_nux;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * @author Nakarin
 */
public class coreGenKey {
        public String genKeyMain(String key_serect, int size_sms) throws UnsupportedEncodingException{
    sysNewClass sysSTR = new sysNewClass();
    String Bin1 =sysNewClass.AsciiToBinary(key_serect);   //// convert to binn
    double[] beginIn=new double[Bin1.length()];
    for ( int i=0;i<=(Bin1.length())-1;i++){
    beginIn[i] = Integer.parseInt(Bin1.substring(i,i+1));  /// convert to array
} 
    double sum5 = (sysNewClass.sum(beginIn))/16;     /// initial value
    
  String[] aX = new String[size_sms];   
  String[] aY = new String[size_sms]; 
    aX=sysSTR.genXascii(key_serect,size_sms);   /// gen x [asjdba, idnv45, 687aas, ... idnv45]
    aY=sysSTR.genYascii(key_serect,size_sms);  // gen y
    
      System.out.println("textaX :"+Arrays.toString(aX));
         System.out.println("textaX :"+Arrays.toString(aY));
     String[] cofX = new String[size_sms];  
     String[] cofY = new String[size_sms];  
   for(int i=0;i<size_sms;i++){
          cofX[i]=sysNewClass.convBinToDec3(sysNewClass.AsciiToBinary(aX[i])); // gen cof [-1.0177658008442876, -11.00135594147757...
          cofY[i]=sysNewClass.convBinToDec3(sysNewClass.AsciiToBinary(aY[i])); // gen cof
     }
       double[] finP = new double[size_sms]; 
     String[] KP = new String[finP.length];

     for(int i=0;i<size_sms;i++){
         double C = Double.parseDouble(cofX[i])-sum5;
         double D = Double.parseDouble(cofY[i])-sum5;        
         finP=sysSTR.KeyPlane(C,D,sum5,size_sms);    // gen Key [0.24175649366784313, 0.052027498168342845, -0.727368740026904.... 
         KP[i] = String.valueOf(finP[i]);
     }
         System.out.println("Coe-Dec : "+Arrays.toString(KP));
     
     
        String[] decode_bin =sysSTR.convDec2ToBin(KP);  /// conv Bin  [00011111, 00000111, 01011101...
        
                /// settigng non-array //      
       StringBuilder sbf = new StringBuilder();        
       if(decode_bin.length > 0){  
       sbf.append(decode_bin[0]);
       for(int i=1; i < decode_bin.length; i++){
       sbf.append("").append(decode_bin[i]);  } }         
       String strKey = sbf.toString(); // done 4 key 00011111000001110 ....
         
          return strKey;
}
        
        
        
}
