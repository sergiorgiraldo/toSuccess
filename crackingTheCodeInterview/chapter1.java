import java.util.Arrays;

public class chapter1{
    //------Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
    public static boolean question1_1(String s){
	// solution1 auxiliary array to record if ASCII(256) char repeats
        /*boolean[] aux=new boolean[256];
         for(int i=0; i<s.length();++i){
            int cur=s.charAt(i);
            if(aux[cur]==true)
                return false;
            aux[cur]=true;
         }
         return true;*/
    
    //solution2 bitset, suppose there are only [A-Za-z]
        long bitset=0;
        for(int i=0; i<s.length();++i){
            long cur=s.charAt(i);
            if((bitset&(1<<cur))!=0)// check if cur's bit has been set or not
                return false;
            bitset|=(1<<cur);
    
        }
        return true;
    
}
    // -----Implement a function to reverses a null-terminated string.
    // Note that in java, we can not change function arguments(java is always pass-by-value, So you can't change the reference that gets passed in).
    public static String question1_2(String s){
        StringBuilder res=new StringBuilder();
        for(int i=s.length()-1;i>=0;--i){
            res.append(s.charAt(i));
        }
        return res.toString();
    
    }
    //----Given two strings, write a method to decide if one is a permutaion of the other.
    //an anagram of a word must have a meaning. A permutation is not necessarily having a meaning in the original language.

    public static boolean question1_3(String a, String b){
     // solution1 sort and compare
        /*char[] achars=a.toCharArray(), bchars=b.toCharArray();
        Arrays.sort(achars);
        Arrays.sort(bchars);
        a=new String(achars);
        b=new String(bchars);
        if(a.equals(b))
            return true;
        return false;*/
        
        // solution2 similar to count sort, count the occurance of every char
        if(a.length()!=b.length())
            return false;
        int[] aux=new int[256];
        for(int i=0; i<a.length();++i){
            int cur=a.charAt(i);
            aux[cur]++;
        }
        for(int j=0; j<b.length();++j){
            int cur=b.charAt(j);
            if(aux[cur]<0)
                return false;
            aux[cur]--;
        }
        return true;
        
    }
    //------- Write a method to replace all spaces in a string with '%20', suppose string has sufficient space at the end to hold additioanl characters, and given the 'true' length of string
    public static String question1_4(String s, int len) {
    // do it in-place
    // first pass to count num of spaces, second pass to edit from end to front
      /*  int count=0;
        for(int i=0; i<len;++i){
            if(s.charAt(i)==' ')
                count++;
        }
        char[] schars=s.toCharArray();
        for(int i=count*2+len-1, j=len-1; i>=0 && j>=0; --i, --j){
            if(s.charAt(j)==' '){
                schars[i]='%';
                schars[i-1]='2';
                schars[i-2]='0';
                i=i-2;
            }else
                schars[i]=s.charAt(j);
        }
        
        //return schars.toString(); // this is not correct! will return schars.
        return new String(schars);*/
        
        // solution2 use StringBuilder
        StringBuilder res=new StringBuilder();
        for(int i=0; i<len; ++i){
            if(s.charAt(i)==' ')
                res.append("%20");
            else
                res.append(s.charAt(i));
        }
        return res.toString();
    }
    
    //------implement a method to perform basic string compression using the counts of repeated characters. for example: "aaaabbbcc"===>"a4b3c2"
    public static String question1_5(String s){
        if(s.length()==0||s==null)
            return null;
        StringBuilder res=new StringBuilder();
        int count=1;
        res.append(s.charAt(0));
        for(int i=1; i<s.length(); ++i){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                res.append(count);
                count=1;
                res.append(s.charAt(i));
            }
        }
        res.append(count);
        return res.toString();
    }
    
    // ----------given an image by N*N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degress, and in place
    public static void question1_6(int[][] matrix){
        // it asks to rotate the matrix, here we rotate as time order
        int n=matrix.length;

        for(int i=0; i<n/2; ++i){
            for(int j=i; j<n-i-1;++j){
                int tmp=matrix[i][j];
                // top=left
                matrix[i][j]=matrix[n-j-1][i];
                //left=bottom
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                //bottom=right
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                //right=top
                matrix[j][n-i-1]=tmp;
            
            }
        
        }
        
    }
    
    // ----------write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0
    public static void question1_7(int[][] matrix){
        boolean []row=new boolean[matrix.length];
        boolean []col=new boolean[matrix[0].length];
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                if(row[i]||col[j]){
                    matrix[i][j]=0;
                }
            }
        }
    
        

    }
    // write code to check if s2 is a rotation of s1 using only one call to isSubstring();
    public static boolean question1_8(String s1, String s2){
        // naive: find the rotation point and check left and right
        // since s2 is always the substring of s1s1, is it enough
        if(s1.length()!=s2.length())
            return false;
        String tmp=s1+s2;
        return isSubstring(s2,tmp);
            
    }
    public static boolean isSubstring(String s1, String s2) {
        // java's str.contains() only checks if all characters in the origin ones, not necessarily
		if(s1.length() < s2.length())
			return false;
		boolean isSub = false;
		int j = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(j))
				j++;
			else
				j = 0;
			if(j == s2.length()) {
				isSub = true;
				break;
			}
		}
		return isSub;
	}
    
    public static void main(String[] args){
        String test1="adddb";
        String test2="dbabd";
        int[][] matrix={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}};
        
        //question1_7(matrix);
        //boolean res=question1_1(test);
        //String res=question1_2(test);
        //boolean res=question1_3(test1,test2);
        //String res=question1_4(test1, 6);
        //String res=question1_5(test1);
        //boolean res=question1_8(test1,test2);
        question1_6(matrix);
        for(int i=0; i<matrix.length; ++i){
         for(int j=0; j<matrix[0].length; ++j){
         System.out.print(matrix[i][j]+" ");
         
         }
         }
        System.out.println(matrix);
    }

}