####1. Design a data structure which should have following operation. Insert, Delete, Random access

    Cache

Related:  Design a data structure in which we can do all CRUD operations in O(1) ?  CRUD- Create, Retrieve, Update, Delete



####2. Design a data structure that supports kind of full text search but in numbers. 
```
We are given file with lot of 10-digits numbers, for example: 

1234 567 890 
4124 123 123 
3123 123 322 

On a given number X we should return all numbers that contain X. 

For example, if the number 123 was given, we should return all numbers (from the list above) because 123 is in all of them. 

If the number 41 was given we should return only the middle number - because the number 41 is only in it.
```

Assume 
k = # of digits per number

n = # of numbers in file

Suffix Tree for the numbers. Assume O(k^2) suffix tree construction for each number. Then, we would perform this n time for a suffix tree construction of O(nk^2). Now, we can simply look up the number in the suffix tree in O(k) time.

####3. A client wants to build a software phone book that contains everyone in the world (7 billion people). Every person has only the first name and the name is unique. What data structure would you use to store the data?

For 7 billion people representing phone number as 12 bytes 10bytes + international code , you will need 70 billion bytes minimum 1 million = 1 mb , 70 billion=70000 million , 70 gb *12 = 840 gb... Average ram size is 8gb so you cannot store all this information in memory ..
You will need a distributed data structure, may be something like a distributed hash table.

####4. Given huge database of songs design search data structure and algorithm to search all songs with words starting with the letters entered and words matching the sequence of words entered. 
```
Suppose the songs are: 
1. Every night in my dreams 
2. Listen to my heart 
3. Show me the meaning 
4. Night in London 
5. Night changes 

Entering "m" should list 1,2 and 3. "my" should list 1 and 2. "Night" should list 1,4 and 5. "Night in" should list 1 and 4.
```

1. Given a song name , split the words from song name.
2. Insert word in Trie if it doesn't exist, Trie as a data structure should have at each node , a list of songs.
3. So when you insert Every and Everything
Each node till y in Every should point to list of two songs and after y should point to one song only.

####5. Blocking Queue

####6. In java, how will you implement hashset in which the insertion order of elements is preserved?

http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/LinkedHashMap.java

add an additional double linked list to maintain the order of input entry

http://blog.csdn.net/luanlouis/article/details/43017071

####7. Implement Priority Queue

####8. Implement Least Recently Used Cache for IPAddress lookup. Assume max cache size is 1000 but it should scale well with larger number. Key of the cache is server name and value is IPAddress.

Use a trie to store ip addresses. This is more efficient than a hash. Lookup would be constant time since number of bits in an IP addresss is fixed. For LRU evictions use a linked list apart from the trie such that there is a pointer from an entry in the trie to the list node. If key-value pairs are to be stored, replace the trie with a hash table.

####9. Advantages and disadvantages of Circular queue according to its implementation in array and linkedlist ?

linkedlist - this gives us the ease of needing to know only current node, no need to know the length of the queue nor the current node's position from the start.

array - this is good for storage complexity but will be more running complexity as implementation requires you to know the length of the array and current position from the start or the end of the array.

####10. You are given two objects, Student and Course, and there exist a many to many relation between them. One student can be enrolled for more than one course and there can be many students enrolled for a single course. Design an effective data structure to store such data keeping in mind that the time complexity for search should be optimum. A search can be for the list of students enrolled for a single course, or for the list of courses a single student is enrolled.

I would just explain another approach that came in my mind, I haven't yet thought about the details of implementation. 
1. But there can be the matrix representation to solve this problem. Where there will be one row corresponding to one entity (1 column for every name or every student) and one column for every ticketId or course. 

2. Then set the corresponding bit to 1 if student have taken course (or ticket logged by name.)

3. Accessing the matrix row wise will give all tickets logged by name (or all courses taken by student)

4. Accessing the matrix column wise will give all all names who have logged by a ticket (or all students who have taken a course).

Time Complexity would be O(mn) when there are m distinct (students/names) and n distinct. (courses/tickets)

####11. Find the depth of Binary search tree without using recursion?

Related: implement maxHeight of binary tree without recursion

http://articles.leetcode.com/2010/04/maximum-height-of-binary-tree.html

####12. New data structure where tree is reversed. Leaves are at the top and root at the bottom. Given two nodes in such DS find the least common ancestor in such tree.

The problem actually whats to find out the first common node in two single lists. 
For both nodes, traverse down to the root to get their lengths, let's say the length of node 1 is len1, the length of node 2 is len2, and len1 < len2. 
Let p and q point to node 1 and node 2 respectively, q moves forward len2-len1 steps first, then p and q both move step by step until they reach the same node, which is their lease common ancestor.

####13. Return the number of pairs of nodes which violate the binary search tree property given a root node. I was lead to the discussion of finding it by handling for different cases like ancestors, siblings, but came to know interviewer was looking for simpler solution. Not sure if it is fair to get this as make/break questions with out any other question for experienced candidate.

http://www.careercup.com/question?id=5655359962218496

####14. Suppose you have a huge data of students.
```
This data is in RAM (around 48 GB). Student has following attributes: 
1) RollNo 
2) Name 
3) Address 

Now I need to implement three method: 

getStudentByRollNo(int rollno) 
getStudentsByName(String name) 
getStudentsByAddress(String address) 

In what data structure I can keep these students so that these methods can return the results really fast.
```
