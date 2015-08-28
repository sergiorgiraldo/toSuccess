1.  给一个tree（不一定是binary tree） 还有一个数字n，改变tree的结构，使得除了一个node外的每个node都只有0或n个child，剩下的那个node有0-n个child

2. find kth smallest number in an array

3. find top K most occurring words in streaming data

4. 循序渐进的增加题目难度
for example，merge two sorted array => merge multiple sorted array => merge a 2D sorted array => merge sorted 2D array with different length.

5. encode BST and decode BST(value is int)

6. 一个打印目录树结构的题（DFS）

7. serialize和deserializeString，即从一个ArrayList中变成一个String，再把这个String恢复成原来的ArrayList.1point3acres缃�
String serialize(ArrayList<String> input)， ArrayList<String> deserialize(String s)  正确的做法是在ArrayList中元素头部加上一个length再加上一个delimiter

8. 设计一个Hash Table，常用操作的时间复杂度和空间复杂度

9. 2sum如果枚举就是n^2，排序了再找是n lgn，允许用额外空间hash就是n。

10. implement fibonacci sequence.

11. You have a robot in a grid, it can move in forward direction and can change its facing towards north, south, east n west and you are given a command sequence. So what will be the final position of the robot 

Example 
Grid(100*500) 
Robot Position – (5,3) 
Sequence — {N,S,M,M,E,W,E,S,M,S,M} North, East, West, South, Move forward

```java
	public void move(String cmds){
    	char prev='#';
    	int n=5, m=5;
    	int i=0, j=0;// start pos
    	for(int k=0; k< cmds.length(); ++k){
    		char c= cmds.charAt(k);
    		if(c=='M'){// only meet 'M', then move
    			if(prev=='#') j++; 
    			else if(prev=='E' && j< m-1 ) j++; 
    			else if(prev=='W' && j> 0 ) j--; 
    			else if(prev=='S' && i< n-1 ) i++;
    			else if(prev=='N' && i> 0 ) i--;
    			else System.out.println("ERROR");
    		}else{
    			prev= c;
    		}
    		System.out.println(i+" "+ j);
    	}
    	
    }
```

12 word break in DP

13 给一个整数值的金额(n cents)，返回最少总硬币数，用(quarter, dime, 5 cents,
penny)
解：直接用贪心策略。先算用多少quarter，再dime，再5 cents，再penny

14 还是一个金额(n cents)，但是硬币用自己定义的额度，比如[10, 7, 1]
解：这个问题存在无解情况。比如给个额度3，但是硬币面值只有2的，这种情况fail，
返回-1 剩下的，用背包问题解。DP

15 search in 2d array(row and column sorted respectively)
prove correctness
因为top, right array以右上角为mid， 构成一个sorted array

16 String encoding-decoding question. Given a digit sequence, return no. of ways it can be decoded. 
Mapping : A->1, B->2, Z->26 
For ex : Given a string "123", based on the mapping it can be decoded to following ways :- 
(1) 1,2,3 -> A,B,C (2) 12,3 -> L,C (3) 1,23 -> A,W

[Decode Ways](https://leetcode.com/problems/decode-ways/)
[Enocode & Decode Strings](http://www.fgdsb.com/2015/01/06/encode-decode-strings/)

17 atoi 

18 You have a requirement where a user searches for a search term, which could be say, the title of a movie 
and you need to find the title and then show a description of the movie. How would you implement it. Describe the data structures used. If you were going to host this service on a single machine with 250 MB of RAM while you need to handle, say 10 GB of data, how would you do this?