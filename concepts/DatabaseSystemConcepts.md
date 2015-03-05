####Storage and File Structure
==================================
* Two factors determine the reliability of storage media: whether a power failure or system crash causes data to be lost, and what the likelihood is of physical failure of the storage device.

* We can reduce the likelihood of physical failure by **retaining multiple copies of data**. For disks, we can use mirroring. Or we can use more sophisticated methods based on redundant arrays of independent disks (RAID). By striping data across disks, these methods offer high throughput rates on large accesses; by introducing redundancy across disks, they improve reliability greatly. Several different RAID organizations are possible, each with different cost,
performance, and reliability characteristics. *RAID level 1 (mirroring) and RAID level 5 are the most commonly used*.

* We can organize a file logically as **a sequence of records mapped onto disk blocks**. One approach to mapping the database to files is to use several files, and to *store records of only one fixed length in any given file*. An alternative is to *structure files so that they can accommodate multiple lengths for records*. The **slotted-page** method is widely used to handle varying length records within a disk block.

* Since **data are transferred between disk storage and main memory in units of a block **, it is worthwhile to assign file records to blocks in such a way that a single block contains related records. If we can access several of the records we want with only one block access, we save disk accesses. Since **disk accesses** are usually the bottleneck in the performance of a database system, **careful assignment of records to blocks can pay significant performance dividends**.

* One way to reduce the number of disk accesses is to **keep as many blocks as possible in main memory**. Since it is not possible to keep all blocks in main memory, we need to manage the allocation of the space available in main memory for the storage of blocks. The **buffer** is that part of main memory available for storage of copies of disk blocks. The subsystem responsible for the allocation of buffer space is called the buffer manager.

##### Questions
######Flash storage:
a. How is the flash translation table, which is used to map logical page numbers to physical page numbers, created in memory?
>It is stored as **an array containing physical page numbers, indexed by logical page numbers**. This representation gives an overhead equal to the size of the page address for each page.

b. Suppose you have a 64 gigabyte flash storage system, with a 4096 byte page size. How big would the flash translation table be, assuming each page has a 32 bit address, and the table is stored as an array.
>It takes 32 bits for every page or every 4096 bytes of storage. Hence, it takes 64 megabytes for the 64 gigabyte of flash storage. 
>a byte is 8 bit 
>( 64 * 2^30 / 4096* 2^3 = 2^36/2^15=2^21= 2mb 32bit * 2mb=64mb)

c. Suggest how to reduce the size of the translation table if very often long ranges of consecutive logical page numbers are mapped to consecutive physical page numbers.
>If the mapping is such that, every p consecutive logical page numbers are mapped to p consecutive physical pages, we can **store the mapping of the first page for every p pages**. This reduces the in memory structure by a factor of p. Further, if p is an exponent of 2, we can avoid some of the least significant digits of the addresses stored.

######Consider the following bitmap technique for tracking free space in a file. For each block in the file, two bits are maintained in the bitmap. If the block is between 0 and 30 percent full the bits are 00, between 30 and 60 percent the bits are 01, between 60 and 90 percent the bits are 10, and above 90 percent the bits are 11. Such bitmaps can be kept in memory even for quite large files.
a. Describe how to keep the bitmap up to date on record insertions and deletions.
>Everytime a record is inserted/deleted, check if the usage of the block has changed levels. In that case, update the corresponding Storage and File Structure bits. Note that *we don’t need to access the bitmaps at all unless the usage crosses a boundary*, so in most of the cases there is no overhead.

b. Outline the benefit of the bitmap technique over free lists in searching for free space and in updating free space information.
>When free space for a large record or a set of records is sought, then multiple free list entries may have to be scanned before finding a proper sized one, so overheads are much higher. With bitmaps, one page of bitmap can store free info for many pages, so I/O spent for finding free space is minimal. Similarly, when a whole block or a large part of it is deleted, bitmap technique is more convenient for updating free space information.

######It is important to be able to quickly find out if a block is present in the buffer, and if so where in the buffer it resides. Given that database buffer sizes are very large, what (in-memory) data structure would you use for the above task?

>**Hash table** is the common option for large database buffers. The hash function helps in locating the appropriate bucket, on which linear search is performed.

######Give an example of a relational-algebra expression and a query-processing strategy in each of the following situations:
a. MRU is preferable to LRU.
>like looping through the same (large than cache) data multiple times, and so you will not go back to recently accessed data
 
b. LRU is preferable to MRU.

===========================
####Indexing and Hashing
============================
* Many queries reference only a small proportion of the records in a file. To reduce the overhead in searching for these records, we can construct indices for the files that store the database.

***Index-sequential files** are one of the oldest index schemes used in database systems. To permit fast **retrieval of records in search-key order**, records are stored sequentially, and out-of-order records are chained together. **To allow fast random access, we use an index** structure. There are two types of indices that we can use: dense indices and sparse indices. Dense indices contain entries for every search-key value, whereas sparse indices contain entries only for some search-key values.

* The primary disadvantage of the index-sequential file organization is that **performance degrades as the file grows**. To overcome this deficiency, we can use a B+-tree index.

* A B+-tree index takes the form of a balanced tree, in which **every path from the root of the tree to a leaf of the tree is of the same length**. The height of a B+-tree is proportional to the logarithm to the base N of the number of records in the relation, where each nonleaf node stores N pointers; the value of N is often around 50 or 100. B+-trees are much shorter than other balanced binary-tree structures such as AVL trees, and therefore require fewer disk accesses to locate records.

* Lookup on B+-trees is straightforward and efficient. Insertion and deletion, however, are somewhat more complicated, but still efficient. The number of operations required for lookup, insertion, and deletion on B+-trees is **proportional to the logarithm to the base N** of the number of records in the relation, where each nonleaf node stores N pointers.

* B-tree indices are similar to B+-tree indices.The primary advantage of a B-tree is that the B-tree *eliminates the redundant storage of search-key values*. The major disadvantages are overall complexity and *reduced fanout* for a given node size. System designers almost universally prefer B+-tree indices over B-tree indices in practice.

* Sequential file organizations require an index structure to locate data. File organizations based on hashing, by contrast, allow us to find the address of a data item directly by computing a function on the search-key value of the desired record. Since we do not know at design time precisely which search- key values will be stored in the file, a good hash function to choose is one that assigns search-key values to buckets such that the distribution is both uniform and random.

* Static hashing uses hash functions in which **the set of bucket addresses is fixed**. Such hash functions cannot easily accommodate databases that **grow significantly larger over time**. There are several dynamic hashing techniques that allow the hash function to be modified. One example is extendable hashing, which copes with changes in database size by splitting and coalescing buckets as the database grows and shrinks.

* Ordered indices such as B+-trees and hash indices can be used for selections based on equality conditions involving single attributes. When multiple attributes are involved in a selection condition, we can *intersect record identifiers retrieved from multiple indices*.

* **Bitmap indices** provide a very compact representation for indexing attributes with very few distinct values. Intersection operations are extremely fast on bitmaps, making them ideal for supporting queries on multiple attributes.

#####Questions
######Indices speed query processing, but it is usually a bad idea to create indices on every attribute, and every combinations of attributes, that is a potential search keys. Explain why.
>
* Every index requires additional CPU time and disk I/O overhead during inserts and deletions.
* Indices on non-primary keys might have to be changed on updates, although an index on the primary key might not (this is because updates typically do not modify the primary key attributes).
* Each extra index requires additional storage space.
* For queries which involve conditions on several search keys, efficiency might not be bad even if only some of the keys have indices on them. Therefore database performance is improved less by adding indices when many indices already exist.

=======================
####Query Processing
======================
* The first action that the system must perform on a query is to translate the query into its internal form, which (for relational database systems) is usually based on the relational algebra. In the process of generating the internal form of the query, the parser checks the syntax of the user’s query, verifies that the relation names appearing in the query are names of relations in the database, and so on. If the query was expressed in terms of a view, the parser replaces all references to the view name with the relational-algebra expression to compute the view.

* We can process simple selection operations by performing a linear scan, or by making use of indices. We can handle complex selections by computing unions and intersections of the results of simple selections.

* We can sort relations larger than memory by the **external sort–merge** algorithm.

* Queries involving a natural join may be processed in several ways,depending on the availability of indices and the form of physical storage for the relations.
..* If the join result is almost as large as the Cartesian product of the two relations, a block nested-loop join strategy may be advantageous.
..* If indices are available, the indexed nested-loop join can be used.
..* If the relations are sorted, a merge join may be desirable. It may be advantageous to sort a relation prior to join computation (so as to allow use of the merge-join strategy).
..* The hash-join algorithm partitions the relations into several pieces, such that each piece of one of the relations fits in memory. The partitioning is carried out with a hash function on the join attributes, so that corresponding pairs of partitions can be joined independently.

* *Duplicate elimination, projection, set operations (union, intersection, and difference), and aggregation* can be done by sorting or by hashing. **Hashing and sorting are dual**, in the sense that any operation such as du- plicate elimination, projection, aggregation, join, and outer join that can be implemented by hashing can also be implemented by sorting, and vice versa; that is, any operation that can be implemented by sorting can also be imple- mented by hashing.

#####Questions
######Suppose you need to sort a relation of 40 gigabytes, with 4 kilobyte blocks, using a memory size of 40 megabytes. Suppose the cost of a seek is 5 milliseconds, while the disk transfer rate is 40 megabytes per second.
a. Find the cost of sorting the relation, in seconds, with bb = 1 and with bb = 100.
>

b. In each case, how many merge passes are required?
>

c. Suppose a flash storage device is used instead of a disk, and it has a seek time of 1 microsecond, and a transfer rate of 40 megabytes per second. Recompute the cost of sorting the relation, in seconds, with bb = 1 and with bb = 100, in this setting.

####Interview Concepts

