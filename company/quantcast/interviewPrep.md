######Find and remove all the duplicates (unsorted)
1 for Array:
    * sort. can do it in-place. CONS: original order not maintained
    * hashset 
    
2 for List:
    * O(n^2) check one by one
    * sort. Best method for sorting a list is Merge Sort
    * use an auxiliary hashmap to record the ocurrance of node. O(n) time, O(n) space
Notice, java has LinkedHashSet

3 very large file:
    * Bit vector if can load into memory
    * Bit vector + Hash trick if can not load into memory
    
    

###### Find K smallest elements in N lines of data

Min heap
```
    Scanner in= new Scanner(new FileReader("file.txt"));
    int count=0;
    Comparator cmp= new Comparator(String){
        @Override
        public int compare( String s1, String s2){
            int n1= Integer.parseInt(s1);
            int n2= Integer.parseInt(s2);
            return n1-n2;
        }
    }
    PriorityQueue<String> pq= new PriorityQueue<String>(n, cmp);
    while( in.hasNextInt() ){
        //
        pq.add(in.NextInt());
    }
```
Java standard library appears to be a min Priority Queue, use  ```PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(20,Collections.reverseOrder());``` to change to max

###### Min Stack
```
class MinStack {
    // can not use priority queue, retrieving min is O(lgn)
    // use two stacks ?
    // 正确性在于，如果后来得到的值是大于当前最小栈顶的值的，那么接下来pop都会先出去，而最小栈顶的值会一直在，而当pop到最小栈顶的值时，一起出去后接下来第二小的就在pop之后最小栈的顶端了。
    Stack<Integer> s=new Stack<Integer>();
    Stack<Integer> minS = new Stack<Integer>();
    
    public void push(int x) {
        s.push(x);
        if (minS.isEmpty() || x <= minS.peek())
            minS.push(x);
    }

    public void pop() {
        int e=s.pop();
        if(e==minS.peek())
            minS.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
```
###### generate a random integer in the range [1, 7] if I only had a function that returned random integers from [1, 5]. 

```
    int rand7(){
        int[][] trans={
        [1, 2, 3, 4, 5],
        [6, 7, 1, 2, 3],
        [4, 5, 6, 7, 1],
        [2, 3, 4, 5, 6],
        [7, 0, 0, 0, 0]        
        };
        
        int res=0;
        while( res==0){
            int x=rand5();
            int y=rand5();
            res=trans[x-1][y-1];
        }
        return res;
    }

```
or

```
    int rand7(){
        //int tmp= 5*rand5(); /* wrong, only get 5, 10, 15 ... */
        int tmp= 5*(rand5() -1) +rand5(); 
        
        while(tmp>21){
            tmp=5*(rand5() -1) +rand5(); 
        }
        
        //return tmp/3;  /* wrong, not uniformly distributed */
        return tmp % 7 +1;
    }
```

###### How does the internet work?
###### Big data platform knowledge
###### What do you know about quantcast?
provides free measurement of audience demographics and delivers real-time advertising
aps your ideal customers and matches their patterns against our view across the entire web, seeking out millions more online customers who look just like them. 
######parse Perl and C
######Bayes' Law, expectation, variance.
relates current probability to prior probability:
P(A|B)=P(B|A)P(A)/P(B), where:
    -P(A), the prior, is the initial degree of belief in A.
    -P(A|B), the posterior, is the degree of belief having accounted for B.
    -the quotient P(B|A)/P(B) represents the support B provides for A.

###### factorial(n)
recursive:
```
int factorial(n){
    if(n==0)
        return 1;
    return n*factorial(n-1);
}
```
iteration:
```
int fatorial(n){
    int res=1;
    for(int i=1; i<=n; ++i)
        res*=i;
    return res;
}
```
######LCA in any tree
1 in BST
```
void LCA(TreeNode root, TreeNode n1, TreeNode n2){
    if(root==null)
        return null;
    if(n1.val<root.val && n2.val<root.val)
        LCA(root.left, n1, n2);
    if(n1.val >root && n2.val>root)
        LCA(root.right, n1, n2);
        
    return root;
}
```
2 in binary tree


######How would you build a predictive model for guessing the value of 10,000 different stocks?

0. predictable?

1. stocks independent of each other ? 

2  as totally or individually ?

3  short term or long term ?

4 use data from other stock prices, sectoral data, text, economic data, experts' predictions, etc

###### How to find a duplicate element in an array of shuffled consecutive integers?

Solution1:
```
Input: 1,2,3,2,4 => 12
Expected: 1,2,3,4 => 10

Input - Expected => 2
```

Solution2:
```
for (int i = 1; i < 1001; i++)
{
   array[i] = array[i] ^ array[i-1] ^ i;
}

printf("Answer : %d\n", array[1000]);
```