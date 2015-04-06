package ll;
/*Given a array 
{{ 4,7,3,6,7}} 

construct a triangle like 
{{81}} 
{{40,41}} 
{{21,19,22}} 
{{11,10,9,13}} 
{{ 4,7,3,6,7}}
*/
import java.util.*;

public class constructTriangle{
    
    public static void construct(int[] arr){
        ArrayList<ArrayList<Integer>> triangle= new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> bottom= new ArrayList<Integer>();
        for(int i=0; i<arr.length; ++i)
        	bottom.add(arr[i]);
        triangle.add(bottom);
        
        int i= bottom.size();
        while(i>1){
        	ArrayList<Integer> tmp= new ArrayList<Integer>();
        	for(int j=0; j< triangle.get(arr.length - i).size()-1; ++j){
        		int cur= triangle.get(arr.length - i).get(j);
        		int next=triangle.get(arr.length - i).get(j+1);
        		tmp.add(cur + next);
        	}
        	triangle.add(tmp);
        	i--;
        }
        //for(ArrayList<Integer> tmp : triangle)
        System.out.println(triangle.toString());
    }
    
    public static void main(String[] args){
        int[] arr= {4,7,3,6,7};
        construct(arr);
        System.out.println();
        
    }
    
}