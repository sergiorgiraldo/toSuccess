#(10.1) 1000 clients need get stock price information(open, close, high, low). How would you design the client-facing service which provides the information to client applications ? 

This is asking data storage techniques. 

We need to consider:
1. client ease of use 
2. easy to implement and maintain
3. scalability and efficiency
4. flexibility for future demands

##Proposal #1
  Use a SQL database and let the clients plug directly into the database. Advantages are:
	* easy to do query 
	* back up, roll back and security provided by database
	* easy to access for clients
  Disadvantages:
	* heavy weight in this situation (1000 client, simple information)
	

##Proposal #2
  Use XML/JSON for distributing information Advantages are:
	* standard data model to share and distribution data, easy to distribute and parse
	* adding data is easy
	* backing up with existing tools (many)
  Disadvantages:
	* send all information even if they perform simple queries ( w/o use of other tools )
	* limited to the data we expect them to, while SQL can provide some advanced functions.


#(10.2) Design data structures for a very large social network like Facebook and LinkedIn ? Describe how you would design an algorithm to show the connection, or path, between two people (e.g.., ME->BOB—>SUSAN—>JASON->YOU )

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
	If five of my friends live on the same machine, I should look up all at once.

Optimization: Smart Division of People:
	divide people by country, state, city, etc. 

Optimization: BFS circle
	using a separate HashMap to mark a node as visited.  


# Given an input file with four billion non-negative integers, generate an integer which is not contained in the file. Assume you have 1 GB memoery. 

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
    
## What if you have 10 MB memory ?

with 10 MB, we can at most hold 2^23*8=2^26 bits, we must divide data into blocks.
if use int array:
            bitsize < 2^26 / 2^5 = 2^21
            blocksize > 2^32 / 2^21 = 2^11

Using above information, the code is:
    
    int bitsize= 2^20;
    int blocksize=2^12;
    int[] bitvector=new int[bitsize];
    int[] block= new int[blocksize];
    
    int starting=-1;
    Scanner in = new Scanner(new FileReader("file.txt"));
    while(in.hasNextInt){
        int n=in.nextInt();
        block[n/bitsize]++;
    }












