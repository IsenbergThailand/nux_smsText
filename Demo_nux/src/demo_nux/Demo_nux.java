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
    genPass2 asciiIN = new genPass2();
    genPass3 asciiIN2 = new genPass3();
 //   String key_serect = "!w][k@d5Tz9*9-g5"; 
     String key_serect = "asjdbaidnv45687b"; 
 //       String key_serect = "!w][k@d5Tz9*9-g5"; 
        
    String Bin1 =AsciiToBinary(key_serect);

    double[] beginIn=new double[Bin1.length()];
    for ( int i=0;i<=(Bin1.length())-1;i++){
    beginIn[i] = Integer.parseInt(Bin1.substring(i,i+1));
}
    double sum5 = (sum(beginIn))/16;   
        System.out.println(sum5);
 /////////////////////
     String[] aX = new String[10];   
     String[] aY = new String[10]; 
    aX=asciiIN.genXascii(key_serect);
    aY=asciiIN.genYascii(key_serect);
     System.out.println(Arrays.toString(aX));
     System.out.println(Arrays.toString(aY));

    String[] cofX = new String[10];  
    String[] cofY = new String[10];  

     for(int i=0;i<10;i++){
          cofX[i]=convBinToDec3(AsciiToBinary(aX[i]));
          cofY[i]=convBinToDec3(AsciiToBinary(aY[i]));
     }
     System.out.println(Arrays.toString(cofX));
     System.out.println(Arrays.toString(cofY));        
     ////////*
     ///// TEST 2nd Func
     
     genKeyPlane str5 = new genKeyPlane();
     double[] finP = new double[10]; 
     String[] KP = new String[finP.length];

     for(int i=0;i<10;i++){
         double C = Double.parseDouble(cofX[i])-sum5;
         double D = Double.parseDouble(cofX[i])-sum5;        
         finP=str5.KeyPlane(C,D,sum5);
         KP[i] = String.valueOf(finP[i]);
     }
          System.out.println("TEST"+Arrays.toString(KP));
      String[] decode_bin =asciiIN2.convDec2ToBin(KP);
                System.out.println("text2 : "+Arrays.toString(decode_bin));
                
   /// END Key Bin
                
       String InputSMS = "ChangMai99";
       StringBuilder sbf = new StringBuilder();        
       if(decode_bin.length > 0){  
       sbf.append(decode_bin[0]);
       for(int i=1; i < decode_bin.length; i++){
       sbf.append("").append(decode_bin[i]);  } }         
       String strKey = sbf.toString();

 String inBin=AsciiToBinary(InputSMS);      
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
String BIN = hexToBinary(Cipher);

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
String asciiPlain =convertHexToString(hexPlain);
        System.out.println("text9 : "+asciiPlain); 
     }  
     
     
      public static String convBinToDec3( String s ){
String str  =new StringBuilder(s).reverse().toString();   // reverse  
String mySub1 = str; 
int[] newIntInput=new int[s.length()];
int indexOfbit=s.length();
double[] valueOfBit=new double[s.length()];
double[] decInt=new double[s.length()];
double sum = 0;

for ( indexOfbit=0;indexOfbit<=47;indexOfbit++){
    newIntInput[indexOfbit] = Integer.parseInt(str.substring(indexOfbit,indexOfbit+1));
}
for ( indexOfbit=1;indexOfbit<=5;indexOfbit++){
    valueOfBit[indexOfbit] = Math.pow(2,5-indexOfbit);
    decInt[indexOfbit]=newIntInput[indexOfbit]*valueOfBit[indexOfbit];
}

for ( indexOfbit=6;indexOfbit<=47;indexOfbit++){
    valueOfBit[indexOfbit] = Math.pow(2,-indexOfbit);
    decInt[indexOfbit]=newIntInput[indexOfbit]*valueOfBit[indexOfbit];
}
double sum4 = sum(decInt); 

if(newIntInput[0]==0){    sum4=sum4*1;
}else{ sum4=sum4*(-1); }
String total2 = String.valueOf(sum4);

return total2;
           }
      
     

 public static double sum(double...values) {
   double result = 0;
   for (double value:values)
     result += value;
   return result;
 }
 
    public static String AsciiToBinary(String asciiString){  

          byte[] bytes = asciiString.getBytes();  
          StringBuilder binary = new StringBuilder();  
          for (byte b : bytes)  
          {  
             int val = b;  
             for (int i = 0; i < 8; i++)  
             {  
                binary.append((val & 128) == 0 ? 0 : 1);  
                val <<= 1;  
             }  
            // binary.append(' ');  
          }  
          return binary.toString();  
    }  
public static String hexToBinary(String hex) {
         String tmp1 = new BigInteger(hex, 16).toString(2);
while (tmp1 .length() < 8) {
    tmp1  = "0" + tmp1 ;
}
    return tmp1;
}


public static String hexToBinary2(String hexString) {
    int i = Integer.parseInt(hexString, 16);
    String binaryString = Integer.toBinaryString(i);
    String padded = String.format("%8s", binaryString.replace(' ', '0'));
    return padded;
}


public static String convertHexToString(String hex){

          StringBuilder sb = new StringBuilder();
          StringBuilder temp = new StringBuilder();
          
          //49204c6f7665204a617661 split into two characters 49, 20, 4c...
          for( int i=0; i<hex.length()-1; i+=2 ){
                  
              //grab the hex in pairs
              String output = hex.substring(i, (i + 2));
              //convert hex to decimal
              int decimal = Integer.parseInt(output, 16);
              //convert the decimal to character
              sb.append((char)decimal);
                  
              temp.append(decimal);
          }
         // System.out.println("Decimal : " + temp.toString());
          
          return sb.toString();
}

}
