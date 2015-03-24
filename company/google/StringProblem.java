/*
 Two strings A, B, A is longer than B, check if A contains all the chars that B has. 
 e.g. A="ABCDEFG", B="AB", return True
 */

class StringProblem{
    // use two int32 to cover 26bits, corresponding A-Z, set that bit if exists
    public boolean sameChars(String A, String B){
        int m1=0, m2=0;
        for(int i=0; i< A.length(); ++i){
            m1 |= 1<< (A.charAt(i)- 'A');
        }
        for(int i=0; i< B.length(); ++i){
            m2 |= 1<< (B.charAt(i)- 'A');
        }
        
        return (m1 & m2) == m2;// intersection
        
    }
    
    public static void main(String[] args){
        StringProblem s=new StringProblem();
        boolean res= s.sameChars("ABCDEFGHIJKLMNOPQRS", "DCGRQAZ");
        //System.out.println(res);
        
    
        System.out.println(Integer.toBinaryString(14));
    
    }


}