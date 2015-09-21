####1. Write a library that given a url, finds all email addresses on that url.
ex input: "http://www.ehtp.org/contact-us", output: ["info@ehtp.org"]

####2. 括号匹配

有千种括号需要匹配，怎么优化，算是设计模式？ 然后分析了时间复杂度是否会因为符号增多而增加
solution : 把判断符号的方法独立出来，减少依赖
不会

####3. 3SUM

####4. median of two sorted array 

####5. BIN file validation.

Assume a BIN file to contain partial credit card numbers (from the front/prefixes) and an associated value true or false indicating whether the matching cards are debit cards or credit cards. The type of the card is determined by the longest matching prefix.

e.g. If the binfile contains an entry ("4321", true) then a card beginning with "4321" is a debit card.
e.g. If there is another entry ("432143", false) then a card beginning with "432143" is not a debit card because it matches a longer pattern.

这题就是给一个长为L的数字串n和一个含有多个数字串的词典dict，找出dict中是n前缀的最长字串.
最简单的思路应该就是hash表。先将BIN file的内容建立成映射：
{{“4321”： true}, {"432143"： false} ... } 
然后在map中依次寻找n.substring(0, L), n.substring(0, L-1), ... n.substring(0, i), ... n.substring(0, 0)。当第一次找到n.substring(0, i)存在于hash表中，返回该字串对应的bool值即可。

但是这个算法的时间复杂度是O(L^2)的，因为平均情况下需要试O(L)个字符串，而在hash表中寻找每个字符串所需时间也是O(L)。对于字符串，hashCode一般是将每个字符都处理一遍才能得到，所以字符串key的查询时间应当是O(L)。
如果dict中共有K个entry，那么建hash表需要O(KL)时间。hash表所占的空间也为O(KL)。

另一个思路是用prefix tree，将BIN file中的每一个entry加入到prefix tree中的时间为O(L)，因此建立此树也需要O(KL)时间。但是查找仅需O(L)时间。prefix tree在entry重复率不高的情况下也是占用O(KL)内存，但是如果entry重复率很高的话，能节省不少内存空间。

####6. linux的fork是什么，IPC有哪些，syscall是用来干什么的

####7. palindrome / palindrome with anagram

####8. reverse string / reverse text。

####9. 给一串text，让你实现RGB (0,0,0) -> (255, 0, 0) -> (0, 255, 0) -> (0,0,255)的渐变效果

####10. Given an array of integers, a, return the maximum difference of any pair of numbers such that the larger integer in the pair occurs at a higher index (in the array) than the smaller integer
[smaller difference](http://www.lintcode.com/en/problem/the-smallest-difference/)

container with most water 的变形题

####11. 