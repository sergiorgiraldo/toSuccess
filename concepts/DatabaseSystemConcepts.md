#####Storage and File Structure
==================================
* Two factors determine the reliability of storage media: whether a power failure or system crash causes data to be lost, and what the likelihood is of physical failure of the storage device.
* We can reduce the likelihood of physical failure by **retaining multiple copies of data**. For disks, we can use mirroring. Or we can use more sophisticated methods based on redundant arrays of independent disks (RAID). By striping data across disks, these methods offer high throughput rates on large accesses; by introducing redundancy across disks, they improve reliability greatly. Several different RAID organizations are possible, each with different cost, performance, and reliability characteristics. *RAID level 1 (mirroring) and RAID level 5 are the most commonly used*.
* We can organize a file logically as **a sequence of records mapped onto disk blocks**. One approach to mapping the database to files is to use several files, and to *store records of only one fixed length in any given file*. An alternative is to *structure files so that they can accommodate multiple lengths for records*. The **slotted-page** method is widely used to handle varying length records within a disk block.
* Since **data are transferred between disk storage and main memory in units of a block **, it is worthwhile to assign file records to blocks in such a way that a single block contains related records. If we can access several of the records we want with only one block access, we save disk accesses. Since **disk accesses** are usually the bottleneck in the performance of a database system, **careful assignment of records to blocks can pay significant performance dividends**.
* One way to reduce the number of disk accesses is to **keep as many blocks as possible in main memory**. Since it is not possible to keep all blocks in main memory, we need to manage the allocation of the space available in main memory for the storage of blocks. The **buffer** is that part of main memory available for storage of copies of disk blocks. The subsystem responsible for the allocation of buffer space is called the buffer manager.

##### Questions
######Flash storage:
###### a. How is the flash translation table, which is used to map logical page numbers to physical page numbers, created in memory?
It is stored as **an array containing physical page numbers, indexed by logical page numbers**. This representation gives an overhead equal to the size of the page address for each page.

######b. Suppose you have a 64 gigabyte flash storage system, with a 4096 byte page size. How big would the flash translation table be, assuming each page has a 32 bit address, and the table is stored as an array.
It takes 32 bits for every page or every 4096 bytes of storage. Hence, it takes 64 megabytes for the 64 gigabyte of flash storage. 
a byte is 8 bit 
( 64 * 2^30 / 4096* 2^3 = 2^36/2^15=2^21= 2mb
32bit * 2mb=64mb)

######c. Suggest how to reduce the size of the translation table if very often long ranges of consecutive logical page numbers are mapped to consecutive physical page numbers.
If the mapping is such that, every p consecutive logical page numbers are mapped to p consecutive physical pages, we can **store the mapping of the first page for every p pages**. This reduces the in memory structure by a factor of p. Further, if p is an exponent of 2, we can avoid some of the least significant digits of the addresses stored.

######Consider the following bitmap technique for tracking free space in a file. For each block in the file, two bits are maintained in the bitmap. If the block is between 0 and 30 percent full the bits are 00, between 30 and 60 percent the bits are 01, between 60 and 90 percent the bits are 10, and above 90 percent the bits are 11. Such bitmaps can be kept in memory even for quite large files.
######a. Describe how to keep the bitmap up to date on record insertions and deletions.
Everytime a record is inserted/deleted, check if the usage of the block has changed levels. In that case, update the corresponding Storage and File Structure bits. Note that *we don’t need to access the bitmaps at all unless the usage crosses a boundary*, so in most of the cases there is no overhead.
######b. Outline the benefit of the bitmap technique over free lists in searching for free space and in updating free space information.
When free space for a large record or a set of records is sought, then multiple free list entries may have to be scanned before finding a proper sized one, so overheads are much higher. With bitmaps, one page of bitmap can store free info for many pages, so I/O spent for finding free space is minimal. Similarly, when a whole block or a large part of it is deleted, bitmap technique is more convenient for updating free space information.

######It is important to be able to quickly find out if a block is present in the buffer, and if so where in the buffer it resides. Given that database buffer sizes are very large, what (in-memory) data structure would you use for the above task?

**Hash table** is the common option for large database buffers. The hash function helps in locating the appropriate bucket, on which linear search is performed.

######Give an example of a relational-algebra expression and a query-processing strategy in each of the following situations:
a. MRU is preferable to LRU.
 like looping through the same (large than cache) data multiple times, and so you will not go back to recently accessed data
 
b. LRU is preferable to MRU.

#####Indexing and Hashing
