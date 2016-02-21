package demo_nux;

import java.io.UnsupportedEncodingException;

public class genPass2{

String[] genXascii( String s ) throws UnsupportedEncodingException{
String key_serect = s;
// System.out.println("key 16 Chars: " + key_serect);    
      String[] tmp1 = new String[10];
      String[] tmp2 = new String[10];
      String[] New1 = new String[10];
      int size,new_size = 0;
int index,IndexEnd = 0;
int index2 = 0;
int length = 6;
for(index=0;index<10;index++){
IndexEnd=index2+length;
if(IndexEnd>16){IndexEnd=16;}
tmp1[index]=key_serect.substring(index2,IndexEnd); 
size=tmp1[index].length();
if(size<6){
    new_size = 6-size;
    tmp2[index]=key_serect.substring(0,new_size);
     New1[index]=tmp1[index]+tmp2[index];
    index2=new_size;
}else{
    New1[index]=tmp1[index];
    index2=IndexEnd;
}
}
    return New1;
}
String[] genYascii( String s ) throws UnsupportedEncodingException{
String key_serect = s;
 key_serect =new StringBuilder(key_serect).reverse().toString();   // reverse 
// System.out.println("key 16 Chars: " + key_serect);    
      String[] tmp1 = new String[10];
      String[] tmp2 = new String[10];
      String[] New1 = new String[10];
      int size,new_size = 0;
int index,IndexEnd = 0;
int index2 = 0;
int length = 6;
for(index=0;index<10;index++){
IndexEnd=index2+length;
if(IndexEnd>16){IndexEnd=16;}
tmp1[index]=key_serect.substring(index2,IndexEnd); 
size=tmp1[index].length();
if(size<6){
    new_size = 6-size;
    tmp2[index]=key_serect.substring(0,new_size);
     New1[index]=tmp1[index]+tmp2[index];
    index2=new_size;
}else{
    New1[index]=tmp1[index];
    index2=IndexEnd;
}
}
    return New1;
}

}
