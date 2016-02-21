package demo_nux;

import java.io.UnsupportedEncodingException;

public class genPass{
 
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
        String convBinToDec3( String s ){
String str = s;
String mySub1 = str; 
int[] ss=new int[48];
double[] mm=new double[48];
double[] result=new double[48];
double sum = 0;
for (int joker=1;joker<48;joker++){
ss[joker] = Integer.parseInt(mySub1.substring(joker,joker+1));
if (joker == 2||joker ==3 ||joker == 4 ){
     mm[joker] = Math.pow(2,4-joker);
} else {
     mm[joker] = Math.pow(2,-joker);
}    
    result[joker] = ss[joker]*mm[joker] ;
    sum = sum + result[joker];
    }
    double summer2;
 if(ss[0]==1)  
    {
        summer2=sum*-1;
    }else summer2=sum*1;
    String temp_string=""+summer2;
    
  return temp_string;
        }
 
     String toBinary( byte[] bytes ){ 
{
StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
  sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
return sb.toString();
}
    }
String[] Newcore( String s ) throws UnsupportedEncodingException{
    genPass str = new genPass();
String key_serect = s;
String[] toReturn = new String[16];
 System.out.println("key 16 Chars: " + key_serect);
          
          String X1 ,X2,X3,X4,X5,X6,X7,X8;  
          String tmp4Y =new StringBuilder(key_serect).reverse().toString();   // reverse 
          String Y1 ,Y2 ,Y3,Y4,Y5,Y6,Y7,Y8;  
           X1 = key_serect.substring(0, 6);
           X2 = key_serect.substring(6, 12);
           X3 = key_serect.substring(12, 16)+key_serect.substring(0, 2);
           X4 = key_serect.substring(2, 8);
           X5 = key_serect.substring(8, 14);
           X6 = key_serect.substring(14, 16)+key_serect.substring(0, 4);
           X7 = key_serect.substring(4, 10);
           X8 = key_serect.substring(10, 16);
                               
           Y1 = tmp4Y.substring(0, 6);
           Y2 = tmp4Y.substring(6, 12);
           Y3 = tmp4Y.substring(12, 16)+key_serect.substring(0, 2);
           Y4 = tmp4Y.substring(2, 8);
           Y5 = tmp4Y.substring(8, 14);
           Y6 = tmp4Y.substring(14, 16)+key_serect.substring(0, 4);
           Y7 = tmp4Y.substring(4, 10);
           Y8 = tmp4Y.substring(10, 16);

           byte[] bytes_1 = X1.getBytes("TIS-620");
           byte[] bytes_2 = X2.getBytes("TIS-620");
           byte[] bytes_3 = X3.getBytes("TIS-620");
           byte[] bytes_4 = X4.getBytes("TIS-620");
           byte[] bytes_5 = X5.getBytes("TIS-620");
           byte[] bytes_6 = X6.getBytes("TIS-620");           
           byte[] bytes_7 = X7.getBytes("TIS-620");
           byte[] bytes_8 = X8.getBytes("TIS-620");           
           byte[] bytes_d1 = Y1.getBytes("TIS-620");
           byte[] bytes_d2 = Y2.getBytes("TIS-620");
           byte[] bytes_d3 = Y3.getBytes("TIS-620");
           byte[] bytes_d4 = Y4.getBytes("TIS-620");
           byte[] bytes_d5 = Y5.getBytes("TIS-620");
           byte[] bytes_d6 = Y6.getBytes("TIS-620");           
           byte[] bytes_d7 = Y7.getBytes("TIS-620");
           byte[] bytes_d8 = Y8.getBytes("TIS-620");            
           String b_x1 = str.toBinary(bytes_1); 
           String b_x2 = str.toBinary(bytes_2);  
           String b_x3 = str.toBinary(bytes_3); 
           String b_x4 = str.toBinary(bytes_4);  
           String b_x5 = str.toBinary(bytes_5); 
           String b_x6 = str.toBinary(bytes_6);  
           String b_x7 = str.toBinary(bytes_7); 
           String b_x8 = str.toBinary(bytes_8);  
           String b_y1 = str.toBinary(bytes_d1); 
           String b_y2 = str.toBinary(bytes_d2);  
           String b_y3 = str.toBinary(bytes_d3); 
           String b_y4 = str.toBinary(bytes_d4);  
           String b_y5 = str.toBinary(bytes_d5); 
           String b_y6 = str.toBinary(bytes_d6);  
           String b_y7 = str.toBinary(bytes_d7); 
           String b_y8 = str.toBinary(bytes_d8);                    

 String dec_X1 =str.convBinToDec3(b_x1);
 String dec_X2 =str.convBinToDec3(b_x2);
 String dec_X3 =str.convBinToDec3(b_x3);
 String dec_X4 =str.convBinToDec3(b_x4);
 String dec_X5 =str.convBinToDec3(b_x5);
 String dec_X6 =str.convBinToDec3(b_x6);
 String dec_X7 =str.convBinToDec3(b_x7);
 String dec_X8 =str.convBinToDec3(b_x8);
 
  String dec_Y1 =str.convBinToDec3(b_y1);
 String dec_Y2 =str.convBinToDec3(b_y2);
 String dec_Y3 =str.convBinToDec3(b_y3);
 String dec_Y4 =str.convBinToDec3(b_y4);
 String dec_Y5 =str.convBinToDec3(b_y5);
 String dec_Y6 =str.convBinToDec3(b_y6);
 String dec_Y7 =str.convBinToDec3(b_y7);
 String dec_Y8 =str.convBinToDec3(b_y8);

          toReturn[0]=dec_X1 ;
          toReturn[1]=dec_X2 ;
          toReturn[2]=dec_X3 ;
          toReturn[3]=dec_X4 ;
          toReturn[4]=dec_X5 ;
          toReturn[5]=dec_X6 ;
          toReturn[6]=dec_X7 ;
          toReturn[7]=dec_X8 ;
          toReturn[8]=dec_Y1 ;
          toReturn[9]=dec_Y2 ;
          toReturn[10]=dec_Y3 ;
          toReturn[11]=dec_Y4 ;
          toReturn[12]=dec_Y5 ;
          toReturn[13]=dec_Y6 ;
          toReturn[14]=dec_Y7 ;
          toReturn[15]=dec_Y8 ; 
  
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


}
