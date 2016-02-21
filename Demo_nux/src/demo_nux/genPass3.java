package demo_nux;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;


public class genPass3{
 
public String convertStringToHex(String str){
          
          char[] chars = str.toCharArray();
          
          StringBuilder hex = new StringBuilder();
          for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
          }
          
          return hex.toString();
}
  
public String convertHexToString(String hex){

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

public static byte[] xor(byte[] a, byte[] b) {
  byte[] result = new byte[Math.min(a.length, b.length)];

  for (int i = 0; i < result.length; i++) {
    result[i] = (byte) (((int) a[i]) ^ ((int) b[i]));
  }

  return result;
}
public static String bytesToHex(byte[] in) {
    final StringBuilder builder = new StringBuilder();
    for(byte b : in) {
        builder.append(String.format("%02x", b));
    }
    return builder.toString();
}

/*#################################################
##### convert binary to Dec -1<x<1  
##### example 10100001 -> 1.0100001 -> -0.256
################################################ */     
        double convBinToDec3( String s ){
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
/*System.out.println(Arrays.toString(newIntInput)); 
System.out.println(Arrays.toString(valueOfBit)); 
System.out.println(Arrays.toString(decInt));
System.out.println(sum4);*/

for ( indexOfbit=6;indexOfbit<=47;indexOfbit++){
    valueOfBit[indexOfbit] = Math.pow(2,-indexOfbit);
    decInt[indexOfbit]=newIntInput[indexOfbit]*valueOfBit[indexOfbit];
}
double sum4 = sum(decInt); 
System.out.println(Arrays.toString(decInt));

if(newIntInput[0]==0){    sum4=sum4*1;
}else{ sum4=sum4*(-1); }
    
  return sum4;
        }
 
     String toBinary( byte[] bytes ){ 
{
StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
  sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
return sb.toString();
}
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
     
String Newcore( String s ) throws UnsupportedEncodingException{
    genPass str = new genPass();
String key_serect = s;
String toReturn ;

          String tmp4Y =new StringBuilder(key_serect).reverse().toString();   // reverse 
 
           byte[] bytes_1 = key_serect.getBytes("TIS-620");          
//           String b_x1 = str.toBinary(bytes_1); 
           String b_x1 = AsciiToBinary(key_serect);  
           
            String dec_X1 =str.convBinToDec3("001000010111011101011101010110110110101101000000");
            System.out.println(b_x1);
            toReturn=dec_X1 ;
  
            return toReturn;
}

/*############# Encryption Chaotic ##############
##################################################*/
     String[] choticE( String[] s,String v,String j )
{
    int len = s.length;
String[] toReturn = new String[len];
double I;
double c1=Double.parseDouble(v);double c2=Double.parseDouble(j);
double[] yyy = new double[len];double[] inum = new double[len];
  for(int kk = 2; kk <len; kk++){
      inum[kk]=Double.parseDouble(s[kk]);
      double lo=c2*yyy[kk-2];double li=c1*yyy[kk-1];
      double lp = li+lo;       I =inum[kk]+lp;
      double r = ((I+1) % 2);
    if(r<0){r +=2;} 
    yyy[kk]  = r-1;
    toReturn[kk] = ""+yyy[kk];
        int con =toReturn[kk].length();
    if(con>10){
     toReturn[kk] = toReturn[kk].substring(0,10);
    }
    for (int in=toReturn[kk].length();in<10;in++){            //check for 10digi
        toReturn[kk] =toReturn[kk]+"0";}       
    toReturn[0]="0";toReturn[1]="0";
  }
    return toReturn;
}    

 /*################################################
 ##### convert Dec to Bin  -1<x<1  
 ##### example 10100001 <- 1.0100001 <- -0.256
 ################################################*/    
  String[] convDec2ToBin( String[] s )
{
    int len = s.length;
String[] toReturn = new String[len];
StringBuilder sb = new StringBuilder();
String[] yyy = new String[len];
double[] inum = new double[len];
int[] temper = new int[9];
double[] temp = new double[9];
double superman;
String s4;
  for(int kk = 0; kk <len; kk++){ 
      inum[kk]=Double.parseDouble(s[kk]);    
      if(inum[kk]<0){temper[0]=1;superman=inum[kk]*-1;}else{temper[0]=0;superman=inum[kk];}
      sb.append(temper[0]);     
          for(int hh=1;hh<9;hh++){    
    temp[0]=superman;
    temp[hh]=temp[hh-1]*2;    
    if(temp[hh]<1)    {temper[hh]=0;}    else {temper[hh]=1;temp[hh]=temp[hh]-1;}
    sb.append(temper[hh]);
    }
 String con = sb.toString().substring(0,8);
 String con2 = sb.toString().substring(8,9);
          int number0 = Integer.parseInt(con, 2)+Integer.parseInt(con2, 2);         
String s3 = String.format("%8s",Integer.toBinaryString(number0));
s4 = s3.replace(" ","0");
          
                   
    yyy[kk]  =s4 ;
    sb.delete(0, sb.length());     
    toReturn[kk] = ""+yyy[kk];
  }
  
    return toReturn;
} 

    Double convBinToDec3(String[] aX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double sum(double[] decInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
