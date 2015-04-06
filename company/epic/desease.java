package ll;
/*
有一种传染病，可以通过人和人的接触传播，而且被传染的人又将成为新的传染源。 XX公司举办了个见面会，
邀请了一些人来参加，这个见面会有个很别(you)致(bing)的规则 - 每个回合，你只能选择 a和一个人交流, b谁也不理， 
回合结束后会有统一的信号（比如响个铃什么的），之后开始下一回合。 会有人记录下来每个人每回合都做了什么选择，统计成了一个matrix， 
给定一开始的传染源是参与者Y， 要求输出见面会结束后，都有谁被传染了。 多说一句，原题对于这个matrix的描述真是太绕了。。 
它想表达的是， 这个matrix每一行代表的是每个人， 每一列代表的是每个回合， element的值是你接触的人的号码，若是谁也没接触，就是-1。举个例子， 
假设4个人参与，一共5回合， attendee 2 是初始传染源， matrix如下：.
[
[ 3  4  -1  -1  -1]
[-1  3   3  -1   4]
[ 1  2   2   4   -1]
[-1  1  -1   3    2]
] 

ROUND 1   1 - 3.
ROUND 2   1 - 4， 2 - 3  （传染给3）
ROUND 3   2 - 3
ROUND 4   2 - 4  （传染给4）.
那么结束后， 传染者为（2， 3， 4）
*/
import java.util.*;

public class desease{
    
    public static void helper(int[][] matrix, int source){
        int round= matrix[0].length, num= matrix.length;
       HashSet<Integer> infected= new HashSet<Integer>();
        for(int i=0; i< round; ++i){
        	if(matrix[source-1][i]==-1 || infected.contains(matrix[source-1][i]))
        		continue;
        	infected.add(matrix[source-1][i]);
        }
        
        while(true){ 
        	HashSet<Integer> infectedPrev= new HashSet<Integer>(infected);
        	for(int person: infectedPrev){
        		for(int i=0; i< round; ++i){
        			if(matrix[person-1][i]==-1 || infected.contains(matrix[person-1][i]))
        				continue;
        			infected.add(matrix[person-1][i]);
        		}     		
        	}
        	if(infected.size()== infectedPrev.size())
        		break;
        }
        
        System.out.println(infected);
    }
    
    public static void main(String[] args){
        int[][] matrix= {
        		{3,  4,  -1,  -1,  -1},
        		{-1,  3,   3,  -1,   4},
        		{1,  2,   2,   4,   -1},
        		{-1,  1,  -1,   3,   2}
        };
        helper(matrix, 1);
        System.out.println();
        
    }
    
}