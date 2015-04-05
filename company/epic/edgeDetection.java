/*

Edge Detection
Two-dimensional array representation of an image can also be represented by a one-dimensional array of W*H size, 
where W represent row and H represent column size and each cell represent pixel value of that image. 
You are also given a threshold X. For edge detection, you have to compute difference of a pixel value with each of it’s adjacent pixel and find maximum of all differences. 
And finally compare if that maximum difference is greater than threshold X. if so, then that pixel is a edge pixel and have to display it.

*/

import java.util.*;

public class edgeDetection{
    // not finished
    public static void detect(int[] image, int W, int X){

    	int H= image.length/W;
    	int maxDiff=0;
    	int xprev, xnext, yup, ydown, cur;
        for(int x=0; x< W; ++x){
        	for(int y=0; y< H; ++y){
        		int cvalue= image[i*W +j];
        		xprev= x-1<0 ? 0: x-1;
        		xnext= x+1== W? x: x+1;
        		yup= y-1<0 ? 0:y-1;
        		ydown= y+1==H? y: y+1;
        	}
        }
        
    }
    
    public static void main(String[] args){
        
        System.out.println();
        
    }
    
}