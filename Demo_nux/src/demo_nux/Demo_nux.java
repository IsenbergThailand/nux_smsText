/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_nux;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Nakarin
 */
public class Demo_nux {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) throws UnsupportedEncodingException {
    sysNewClass sysSTR = new sysNewClass();
     String key_serect = "asjdbaidnv45687a"; 

    String Bin1 =sysSTR.AsciiToBinary(key_serect);

    double[] beginIn=new double[Bin1.length()];
    for ( int i=0;i<=(Bin1.length())-1;i++){
    beginIn[i] = Integer.parseInt(Bin1.substring(i,i+1));
}
    double sum5 = (sysSTR.sum(beginIn))/16;   
        System.out.println(sum5);
 /////////////////////
     String[] aX = new String[10];   
     String[] aY = new String[10]; 
    aX=sysSTR.genXascii(key_serect);
    aY=sysSTR.genYascii(key_serect);
     System.out.println(Arrays.toString(aX));
     System.out.println(Arrays.toString(aY));

    String[] cofX = new String[10];  
    String[] cofY = new String[10];  

     for(int i=0;i<10;i++){
          cofX[i]=sysSTR.convBinToDec3(sysSTR.AsciiToBinary(aX[i]));
          cofY[i]=sysSTR.convBinToDec3(sysSTR.AsciiToBinary(aY[i]));
     }
     System.out.println(Arrays.toString(cofX));
     System.out.println(Arrays.toString(cofY));        
     ////////*
     ///// TEST 2nd Func
     
  //   genKeyPlane sysSTR = new genKeyPlane();
     double[] finP = new double[10]; 
     String[] KP = new String[finP.length];

     for(int i=0;i<10;i++){
         double C = Double.parseDouble(cofX[i])-sum5;
         double D = Double.parseDouble(cofX[i])-sum5;        
         finP=sysSTR.KeyPlane(C,D,sum5);
         KP[i] = String.valueOf(finP[i]);
     }
          System.out.println("TEST"+Arrays.toString(KP));
      String[] decode_bin =sysSTR.convDec2ToBin(KP);
                System.out.println("text2 : "+Arrays.toString(decode_bin));
                
   /// END Key Bin
                
       String InputSMS = "ChangMai99";
       StringBuilder sbf = new StringBuilder();        
       if(decode_bin.length > 0){  
       sbf.append(decode_bin[0]);
       for(int i=1; i < decode_bin.length; i++){
       sbf.append("").append(decode_bin[i]);  } }         
       String strKey = sbf.toString();

 String inBin=sysSTR.AsciiToBinary(InputSMS);      
 int[] binInArray=new int[inBin.length()];  
 int[] binKEYArray=new int[strKey.length()];  
 int[] binOutputArray=new int[strKey.length()]; 
  int[] binCipArray=new int[strKey.length()];  
 int[] binPlainArray=new int[strKey.length()]; 
  for (int i=0;i<inBin.length();i++){
    binInArray[i] = Integer.parseInt(inBin.substring(i,i+1));
    binKEYArray[i] = Integer.parseInt(strKey.substring(i,i+1));
    binOutputArray[i]=binInArray[i] ^binKEYArray[i] ;
    
}              
  System.out.println("text3 : "+Arrays.toString(binInArray));              
   System.out.println("text4 : "+Arrays.toString(binKEYArray));               
    System.out.println("text5 : "+Arrays.toString(binOutputArray));  
    
///////
// Display Ouyput
//////

StringBuilder sb = new StringBuilder(binOutputArray.length);
for (int i : binOutputArray) {
  sb.append(i);
}
String s = sb.toString(); 
String hexString = new BigInteger(s, 2).toString(16);
    System.out.println("text5(2) : "+hexString);  
    
         ///// ENDING ////
     String Cipher = hexString;
String BIN = sysSTR.hexToBinary(Cipher);

if(BIN.length()<80){
    BIN="0"+BIN;
}
      System.out.println("text6 : "+BIN.length());  
      System.out.println("text6 : "+BIN);  
      
      for (int i=0;i<inBin.length();i++){
    binCipArray[i] = Integer.parseInt(BIN.substring(i,i+1));        
    binKEYArray[i] = Integer.parseInt(strKey.substring(i,i+1));
    binPlainArray[i]=binCipArray[i] ^binKEYArray[i] ;    
}             
    System.out.println("text6 : "+Arrays.toString(binCipArray));  
      System.out.println("text4 : "+Arrays.toString(binKEYArray)); 
        System.out.println("text7 : "+Arrays.toString(binPlainArray));   
     

StringBuilder tmpPlain = new StringBuilder(binPlainArray.length);
for (int i2 : binPlainArray) {
  tmpPlain.append(i2);
}
String s2 = tmpPlain.toString(); 
String hexPlain = new BigInteger(s2, 2).toString(16);
    
        System.out.println("text8 : "+hexPlain); 
String asciiPlain =sysSTR.convertHexToString(hexPlain);
        System.out.println("text9 : "+asciiPlain); 
     }  
     
     

      
     


  


}
