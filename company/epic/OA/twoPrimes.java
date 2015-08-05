/*
Two Primes
Goldbach's conjecture : Every even integer greater than 2 can be expressed as the sum of two primes. Write a function which takes a number as input, verify if is an even number greater than 2 and also print at least one pair of prime numbers.
 
 Goldbach's conjecture:
 1. Let n=2.
 2. Increase n by 2
 3. Check to see if n can be written as a sum of two primes (we can do this just by checking all of the (finitely many) primes less than n.
 4. If we could write n as a sum of two primes, go back to step 2. Otherwise, stop.
 
*/

import java.util.*;

public class twoPrimes{
    
    public static void getPrimes(int n){
        if(n%2 !=0) System.out.println("Invalid Input");
        for(int i=1; i< n; i+=2){
            if(isPrime(i) && isPrime(n-i))
                System.out.println("two primes : " + i + ", "+ (n-i));
        }
    }
    public static boolean isPrime(int n){
        if(n==2 || n==1) return true;
        if(n%2==0) return false;
        int i=3;
        while(i<n){
            if(n%i ==0)
                return false;
            i++;
        }
        return true;
    }
    
    public static void main(String[] args){
        
        getPrimes(16);
        
    }
    
}