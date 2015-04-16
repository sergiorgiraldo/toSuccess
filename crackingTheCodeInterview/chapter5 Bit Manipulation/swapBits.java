/*
Write a program to swap odd and even bits in an integer with as few instructions as possible (e g , bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)
*/

import java.util.*;

public class swapBits{
    
     public static void swap(int n){
         System.out.println(Integer.toBinaryString(n));
         // even mask: Oxaaaaaaaa : 101010
         // odd mask: 0x55555555:   01010101
         n= ((n & 0xaaaaaaaa)>>1) | ((n & 0x55555555)<<1);
         System.out.println(Integer.toBinaryString(n));
    }
    
    public static void main(String[] args){
        
        swap(8);
 
    }
    
}