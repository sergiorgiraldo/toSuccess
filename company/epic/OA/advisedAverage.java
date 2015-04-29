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
 
        int sum=0;
        for(int i=0; i< A.length; ++i){
            if(i==first || i==second || i==third)
                continue;
            sum+=A[i];
        }
        return 1.0*sum/(A.length-3);
    }
    // round2
    public static double calculate2(int[] arr){
        if(arr.length <=3)
            return 0;
        int max1= arr[0], max2= arr[0], max3= arr[0];
        for(int i=0; i< arr.length; ++i){
            if(arr[i] > max1){
                int t1= max1;
                max1= arr[i];
                int t2= max2;
                max2= t1;
                max3= t2;
            }else if(arr[i] < max1 && arr[i] >= max2 ){
                int t= max2;
                max2= arr[i];
                max3= t;
            }else if( arr[i] < max2 && arr[i] >=max3){
                max3= arr[i];
            }
        }
        int res=0;
        for(int num: arr)
            res+=num;
        return (res- max1- max2-max3)*1.0/ (arr.length-3);
    }
    
    public static void main(String[] args){
        int [] arr= {3,6,12,55,289,600,534,900,172};
        System.out.println(calculate(arr));
        
    }
    
}
