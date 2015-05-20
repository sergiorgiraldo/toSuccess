###(10.1) 1000 clients need get stock price information(open, close, high, low). How would you design the client-facing service which provides the information to client applications ? 

This is asking data storage techniques. 

We need to consider:
1. client ease of use 
2. easy to implement and maintain
3. scalability and efficiency
4. flexibility for future demands

####Proposal #1
  Use a SQL database and let the clients plug directly into the database. Advantages are:
	* easy to do query 
	* back up, roll back and security provided by database
	* easy to access for clients
  Disadvantages:
	* heavy weight in this situation (1000 client, simple information)
	

####Proposal #2
  Use XML/JSON for distributing information Advantages are:
	* standard data model to share and distribution data, easy to distribute and parse
	* adding data is easy
	* backing up with existing tools (many)
  Disadvantages:
	* send all information even if they perform simple queries ( w/o use of other tools )
	* limited to the data we expect them to, while SQL can provide some advanced functions.


###(10.2) Design data structures for a very large social network like Facebook and LinkedIn ? Describe how you would design an algorithm to show the connection, or path, between two people (e.g.., ME->BOB—>SUSAN—>JASON->YOU )

Is it asking BFS/DFS search on graph ? In this case, BFS is better than DFS because most two people are connected by at most 6 inner nodes. Thus, the question is asking how to efficiently representing the social graph on large scale. We may use many machines to store Person objects and require a server for mastering. 
 ```
	class Person{
		int PersonID;
		ArrayList<Integer> friends;
		
		public addFriends(int PersonID){
			friends.add(PersonID);
		} 

	} 

	class Machine{
		int MachineID;
		HashMap<Integer, Person>PersonLookUp;

		public Person getPerson(int PersonID){
			return PersonLookUp.get(PersonID);
		}

	}

	class Server{
		HashMap<Integer, Integer>PersonID2MachineID;
		HashMap<Integer, Machine>MachineLookUp;
		

		public int getMachineID(int PersonID){
			if Person exists 
				return PersonID2MachineID.get(PersonID);
		} 

		public Machine getMachine(int MachineID){
			return MachineLookUp.get(MachineID);
		}
		
		public Person getPerson(int PersonID){
			// get MachineID
			// get Machine m

			return m.getPerson(int PersonID);

		}

	}
```
Optimization: Reduce Machine Jumps: occurs when a friend is not in current machine. 
	*If five of my friends live on the same machine, I should look up all at once.

Optimization: Smart Division of People:
	*divide people by country, state, city, etc. 

Optimization: BFS circle
	*using a separate HashMap to mark a node as visited.  


### 10.3 Given an input file with four billion non-negative integers, generate an integer which is not contained in the file. Assume you have 1 GB memoery. 

There are total 2^32 distinct integers. We have 1G memory, or 2^30*8=2^33 bits. So:
1 create a 4 million bit vector. 
2 initialize bit vector with all 0s
3 scan all numbers from the file and call BV.set(num, 1);
4 scan again BV from the 0th index
5 Return the first index which has a value of 0

    long numberofInts =(long)Integer.MAX_VALUE+1;
    byte[] bitvector =new byte[numberofInts/8];
    
    Scanner in = new Scanner(new FileReader("file.txt"));
    while(in.hasNextInt){
        int n=in.nextInt();
        bitvector[n/8] |= 1<< (n % 8);
    }
    
    for(int i=0; i<bitvector.length; ++i){
        for( int j=0; j<8; ++j){
            if(bitvector[i] & (1 << j) ==0){
                System.out.println( i*8 +j);
            }
        }    
    }
    
    **Why not use int instead of byte so that the memory cost will be lower ?**
    
#### What if you have 10 MB memory ?
Divide into chunks of fixed size. we scan through the input and count how many values are in the chunk's range. If the number is small than the chunk's size, we know that a missing int must in that range. Once we find the chunk, we seach through that chunk to actullay look for the missing number, this requirs a second pass through the input numbers.

With 10 MB, we can at most hold 2^23*8=2^26 numbers, we must divide data into blocks.
if use int array:
            bitArraysize < 2^26 / 2^5 = 2^21
            chunksize > 2^32 / 2^21 = 2^11

Using above information, the code is:
    
    int arraysize= 2^20;
    int chunksize=2^12;
    byte[] bitvector=new byte[arraysize/8];// each byte covers 8 number
    int[] chunks= new int[chunksize]; // count numbers in each chunk
    
    /*--------first pass--------------*/
    int starting=-1;
    Scanner in = new Scanner(new FileReader("file.txt"));
    while(in.hasNextInt){ // count
        int n=in.nextInt();
        chunk[n/arraysize]++; // we do not store in bitvector coz not enough memeory
    }
    
    for(int i=0; i<chunks.length; ++i){
        if(chunks[i] < arraysize){
            starting=i*arraysize;  // get that chunk's first value
            break;
        }
    }
    /*------------second pass-----------*/
    Scanner in = new Scanner(new FileReader("file.txt"));
    while(in. hasNextInt){
        int n=in.nextInt();
        if (n>=starting && n<< starting + arraysize){
            bitvector[(n-starting)/8] |= 1<< ((n-starting)%8); // now store that chunk with missing num
        }
    }
    
    for(int i=0; i<bitvecotr.length; ++i){
        for(int j=0; j<8; ++j){
            if(bitvector[i] & (1<<j) ==0)
                System.out.println(starting+ i*8+j);
        }
    }

###### Key: If asked for even less memory, we would do similar steps: check to see how many intergers are found within each level1chunk, then in second pass, we check how many integers are found in each level2chunk....etc. Finally, we check the bit vector to get the missing num. 

### 10.4 You have an array with all the numbers from 1 to N, where N is at most 32,000. With only 4KB memeory available, how would yo print all duplicates in that array ?
4KB is 4*2^10*8=2^15, we can hold up to 32768 numbers, which covers the input array, one pass scan is enough. 

```
    Publi class Bitset{
        int[] bitset;
        
        public Bitset(int size){
            bitset=new int[size>>5]; //divide by 32, each int covers 32 numbers 
        }
        public void set(int pos){
            int numpos=pos/32; // alternative is (pos >> 5)
            int bitpos=pos%32; // alternative is (pos & 0x1f)
            bitset[numpos] |= 1<<bitpos; // set that bit
        }
        public boolean check(int pos){
            int numpos=pos >> 5;
            int bitpos= (pos & 0x1f);
            if(bitset[numpos] &(1<< bitpos)!=0)// check bit
                return true;
            return false;
        }
    
    }
    
    public static void checkDuplicates(int[] arr){
        Bitset bitset=new Bitset(32000);
        for(int i=0; i<arr.length; ++i){
            if(bitset.check(i))
                System.out.println(i);
            else
                bitset.set(i);
        }
    
    }
```


### 10.5 If you were designing a web crawler, how would avoid getting into infinite loop?
This is about circles in Graph when BFSing
##### Option1: use hashmap
set hash[v] to true after we visit page v;
###### what is duplicate defination ? based on content or URL ?
There is no perfect way to define a "different" page. There is "near-duplicate"

##### Option2: similarity check
If a page is deemed to be sufficiently similar to other pages, we deprioritize crawling its children. For each page, we come up with some sort of signature based on snippets of the content and the page's URL. We do the following:

1. Open up the page and create a signature of the page based on specific subsections of the page and its URL
2. Query database to see whether anything with this signature has been crawled recently
3. If something with this signature has been recently crawled, insert the page back into the database at a low priority
4. If not, crawl the page and insert its links into the database.

Under the above implemetation, we never complete the crawling. to Finish, we can set a minimum priority that a page must have to be crawled.

### 10.6 You have 10 billion URLs. How would you detect duplicates (identical urls) ?
1 byte =1 ASCII character, 2 byte= 1 UTF-16 character
suppose each URL is 100 characters long and each character is 4 byte. 10 billion * 100*4 ~ 2^42= 4 TB

**Option1: divide into chunks and store in disks **
Divide by hash(url)%4000 into 4000chuncks of 1 GB each. Load each chunck into memory and use a hashmap to look for duplicates
This is because any two duplicates will end up in the same buket, the duplicates can then be found by scanning every bucket T[i] which contains two or more members. 

**Option2: divide into chunks and maintained by multiple machines **
Same procedure as above, but use multiple machines so that we can parallelize the comparison operations.
PRO: fast for really large scale data
CON: handle failure, and other complexity


### 10.7 Image a system has 100 machines to respond to search queries, which may call out using ProcessSearch( String query) to another cluster of mchines to actually get the result, which is very expensive. The machine which responds to a given query is chosen at random, so you can not guarantee that the same machine will always repond to the same request. Design a caching mechanism to cache the results of the most recent queries. Explain how you would uodate the cache when data changes. 

system requirements:
* efficient lookup for queries (reduce ProcessSearch call)
* expiration of old data so that it can be replaced by new data
* update/clean caches once the results for a query changes ( this is for common queries that result cached before hand)

lookup--> hashmap, expiration/update---> Doublelinkedlist. we merge them by having the list's node stored in hashmap, in particular, hashmap<query, node>.

**Cache for a single system as below:**

```
    public class cache{
        HashMap<String, ListNode> lookup;
        ListNode head, tail;
        static int capacity;
        int size;
        
        public cache(){
            lookup=new HashMap<String, ListNode>();
            size=0;
            head=new ListNode(0);
            tail=new ListNode(0);
            head.next=tail;
            tail.next=head;
        }
        public void movetoFront(ListNode n){...}   
        public void removefromList(ListNode n){...}
        
        public void insertResult(String query, String[] results){
            if(lookup.contains(query)){// update value
                ListNode node=lookup.get(query);
                node.results=results;
                movetoFront(node);
                return;
            }
            ListNode newnode=new ListNode(0);
            newnode.results=results;
            movetoFront(newNode);
            size++;
            
            if(size>capacity){
                lookup.remove(tail.query);
                removefromList<tail>;
            }
            
        }
        public String[] getResult(String query){
            if(lookup.contains(query)){// update value
                ListNode node=lookup.get(query);
                movetoFront(node);
                return node.results;
            }
            return null;
        }
    
    }
```
**expend to many machines:**
Option1: each machine maintains an independent cache
    * PROS: quick, since no machine-to-machine calls are used
    * CONS: many repeated queries would be treated as fresh ones
Option2: each machine maintains a copy of the cache
    * PROS: simple
    * CONS: update is horrible
            each machine has less cache left of its own use
Option3: each machine stores a segment of the cache
    Assign queries based on formula hash(query) % N, then machine i only needs to apply this formula to know that machine j should store the results for the query. Machine j would then return the value from its cache or call processSearch to get the results, and sent the results back to i
    
**updating results when contents change **
some queries are so popular that they would be permently cached. We use "automatic time-out" on the cache, regardless of how popular it is, can sit in the cache for more than x minutes.  We could implement time outs based on topic or based on URLs because we may want to update some data much more frequently than other data. 
















