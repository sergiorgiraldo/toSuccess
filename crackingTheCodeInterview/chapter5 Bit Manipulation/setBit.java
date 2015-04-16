/*
You are given two 32-bit numbers, N and M, and two bit positions, i and j Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)
SOLUTION
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6 Output: N = 10001010100
*/

import java.util.*;

public class setBit{
    
    public static void set(int n, int m, int i, int j){
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m));

        int left= ~0 - ((1 <<j)-1);
        int right= (1<<i)-1;
        int mask= left | right; // ...111000...000111...
        
        n= (n& mask) | (m<<i);

        System.out.println(Integer.toBinaryString(n));
    }
    
    public static void main(String[] args){
        
        set(100000000, 1000, 0, 3);
        
    }
    
}