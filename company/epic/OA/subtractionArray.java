package ll;
/*Subtraction of two Arrays
 Suppose you want to do the subtraction of two numbers. 
 Each digit of the numbers is divided and put in an array.
 Like A=[1,2, 3, 4, 5], B=[4, 5, 3, 5]. 
 You should output an array C=[7, 8, 1, 0].
 Remember that your machine can’t hand numbers larger than 20.
 */
import java.util.*;

public class subtractionArray{
    
    public static void subtract(int[] A, int[] B){
    	// any negative numbers ? 
    	// here suppose A is always bigger than B, no sign
    	int size= Math.max(A.length, B.length);
        if( size >20)
        	return;
        int carry=0;
        int[] res= new int[size];
        for(int i= A.length-1, j= B.length-1; i>=0 && j>=0; --i, --j){
        	int sub= A[i]- B[j]- carry;
        	if(sub <0){
        		carry=1;
        		sub+=10;
        	}
        	res[i]= sub;
        }
        System.out.println(Arrays.toString(res));
        
    }
    
    public static void main(String[] args){
        int a[]={1, 2, 3, 4, 5};
        int b[]= {4, 5, 3, 5};
        subtract(a, b);
        System.out.println();
        
    }
    
}