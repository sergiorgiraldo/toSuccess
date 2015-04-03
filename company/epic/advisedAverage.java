/*
Advisered Average Number
Write a program to display the advisered average for the list of numbers my omitting the three largest number in the series.
E.g:3,6,12,55,289,600,534,900,172. avg=(3+6+12+55+289+172) /6 and eliminating 534,900,600
*/

import java.util.*;

public class advisedAverage{
    
    public static double calculate(int[] A){
        if(A.length<= 3)
            return 0;
        int first= 0, second=0, third=0;
        for(int i=0; i<A.length; ++i){
            if(A[i] >= A[first]){
                int t1= first;
                first= i;
                int t2= second;
                second= t1;
                third= t2;
            }else if(A[i] >= A[second] && A[i] <= A[first]){
                int tmp= second;
                second= i;
                third= tmp;
            }else if(A[i] >= A[third] && A[i] <= A[second]){
                third= i;
            }
        }
        
        //System.out.println(A[first] +" "+ A[second] +" "+ A[third]);
        
        int sum=0;
        for(int i=0; i< A.length; ++i){
            if(i==first || i==second || i==third)
                continue;
            sum+=A[i];
        }
        return 1.0*sum/(A.length-3);
    }
    
    public static void main(String[] args){
        int [] arr= {3,6,12,55,289,600,534,900,172};
        System.out.println(calculate(arr));
        
    }
    
}
