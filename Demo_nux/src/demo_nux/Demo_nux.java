/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_nux;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nakarin
 */
public class Demo_nux {

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     */
    
  public static void main(String[] args) throws UnsupportedEncodingException {
    sysNewClass sysSTR = new sysNewClass();
    coreGenKey sysKey = new coreGenKey();

  String key_serect = "asjdbaidnv45687a"; 
  String InputSMS = "ChangMai995555555";

  int size_sms= InputSMS.length();

  String strKey = sysKey.genKeyMain(key_serect, size_sms);
  
 String inBin=sysNewClass.AsciiToBinary(InputSMS);    // conv Bin   
 int[] binInArray=new int[strKey.length()];  
 int[] binKEYArray=new int[strKey.length()];  
 int[] binOutputArray=new int[strKey.length()]; 
 
 //// XOR bin vs bin  ////
  for (int i=0;i<inBin.length();i++){
    binInArray[i] = Integer.parseInt(inBin.substring(i,i+1));
    binKEYArray[i] = Integer.parseInt(strKey.substring(i,i+1));
    binOutputArray[i]=binInArray[i] ^binKEYArray[i] ;
}        
 
StringBuilder sb = new StringBuilder(binOutputArray.length);
for (int i : binOutputArray) {
  sb.append(i);
}
String s = sb.toString(); 
String hexString = new BigInteger(s, 2).toString(16);

    System.out.println("SMS-sending : "+hexString);  
    
         ///// ENDING ////
        
/////////////////////////////////////////////////////////////////
///////////////// Display Ouyput/////////////////////////////////
////////////////////////////////////////////////////////////////

    String decryptedKey = "asjdbaidnv45687a"; 
    String Cipher = hexString;
    int size_Cip = Cipher.length()/2;
    int size_binCip =Cipher.length()*4;
   String DstrKey = sysKey.genKeyMain(decryptedKey, size_Cip);
        
 //  String inBin=sysNewClass.AsciiToBinary(InputSMS);    // conv Bin   
   String cipBIN = sysNewClass.hexToBinary(Cipher,size_binCip);
  // String dKey_BIN =sysNewClass.AsciiToBinary(key_serect);   //// convert to binn
 //System.out.println("text7 :"+dKey_BIN);
     int[] binCipArray=new int[DstrKey.length()];  
     int[] binPlainArray=new int[DstrKey.length()];
     int[] binKEYArrayD=new int[DstrKey.length()]; 

    double[] DbeginIn=new double[DstrKey.length()];
    for ( int i=0;i<=(DstrKey.length())-1;i++){
    DbeginIn[i] = Integer.parseInt(DstrKey.substring(i,i+1));  /// convert to array
}


     System.out.println("text6 : "+cipBIN.length());  
     System.out.println("text6 : "+cipBIN);  
      
   
      for (int i=0;i<cipBIN.length();i++){
    binCipArray[i] = Integer.parseInt(cipBIN.substring(i,i+1));        
    binKEYArrayD[i] = Integer.parseInt(DstrKey.substring(i,i+1));
    binPlainArray[i]=binCipArray[i] ^binKEYArrayD[i] ;    
}      
     
    System.out.println("text6 : "+Arrays.toString(binCipArray));  
      System.out.println("text4 : "+Arrays.toString(binKEYArrayD)); 
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
