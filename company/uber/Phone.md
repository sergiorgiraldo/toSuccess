#####简历，最近的project，challenge part, 20min preparation

#####用户打开app后如何显示周围available的车，还有如何快速实时更新车的位置和availibility？

1. 每次打开app的时候会有一个雷达闪烁的画面，应该是在向server发送用户的geo data并request周围可用的uber，假设需要知道离用户5mile之内的所有uber的话，每辆uber车的geo信息应该如何存储才能快速的找到这5mile之内的车呢？

我的想法是把城市划分成多个block做成hashtable，每个block对应一个pool来存储目前在这个block中的所有车辆，每辆车记住上一个时间点的blockID，当车子移动需要update的时候计算当前的blockID如果与之前的不同，就把这辆车的carID从上一个block的pool中删除，并加入到新的block的pool中。这样用户login的时候，根据用户的geo信息计算其所对应的block，然后读取该block的pool。这样用户找到available车子的时间复杂度就是O(1)，每辆车子update的复杂度也是O(1)。. 
在二维坐标上有很多点(driver的位置)，然后给一个乘客的位置，要求返回附近的driver。我觉得楼主的solution很有道理，不过我想补充的一点就是block之间要有overlap，因为如果乘客在block的边缘的话搜出的附近的driver就不准了。

2. 当一辆车从变换availability的时候，会从地图上实时出现/消失，位置也会实时更新，这个应该是服务器push到用户终端的，要实现实时性，server和用户之间应该是通过websockets链接的，http的request/response无法满足要求。

3. 在uber的app上任意移动pin，即使从东海岸移动到西海岸，uber的app也能在很短时间内找到available的车子，地点换了，应该是要重新request server的吧，这个为啥能这么快？

#####给一个String array，找出每个元素的Anagram，按照相同的anagram分为一组，最后输出每一组元素。
[Anagrams](http://www.lintcode.com/en/problem/anagrams/)

follow up就是怎么不用sort，于是我就说可以把每一个string统计一下a,b,c。。。的频率，然后输出一个pattern a1b3c4。
把这个pattern作为map的key

Check anagrams: 1 sort and compare 2 count every characters

#####用browser打开www.uber.com的时候，发生了什么
1. browser checks cache; if requested object is in cache and is fresh, skip to #9 browser asks OS for server’s IP address
2. OS makes a DNS lookup and replies the IP address to the browser
3. browser opens a TCP connection to server (this step is much more complex with HTTPS)
4. browser sends the HTTP request through TCP connection
5. browser receives HTTP response and may close the TCP connection, or reuse it for another request
6. browser checks if the response is a redirect (3xx result status codes), authorization request (401), error (4xx and 5xx), etc.; these are handled differently from normal responses (2xx)
7. if cacheable, response is stored in cache
8. browser decodes response (e.g. if it’s gzipped)
9. browser determines what to do with response (e.g. is it a HTML page, is it an image, is it a sound clip?)
browser renders response, or offers a download dialog for unrecognized types
10. browser renders response, or offers a download dialog for unrecognized types

#####Reverse Words in a String II
Follow up是加入符号但是reverse的时候需要保留位置. 我大概讲了一下想到的两种思路, 不是最优, 并且由于时间不够, 也没有写完. 面试官最后提了一下最优思路(用Double Stack)
#####问了什么是RPC, 怎么实现的. Linux的file system的结构, 最后让我自己设计一个结构可以存很大的file.
#####有一个很长的list<pair<int, int> > 第一个int 的这个node的序号，第二个int 是这个node 的weight。 写一个函数返回node的序号， 比如：
(2, 3)->(3, 5)->(1, 7). 那么返回2的概率是（3／15）， 3的概率是：（5／15）
我的感觉是先遍历一下list，然后记录总的weights， 然后产生一个random number， 代表weight_th， 最后从头遍历找到weight_th落在哪个node，然后就返回那个node。
#####1. regex match
2. 实现trie. 
3. youtube architecture设计。. 
4. 聊天。
5. min stack

#####计算表达式  1+2*3+4 = 11可以去搜parse mathematical expression
#####题目是这样，给一个file，把file里的内容format成json.
File:
== Abc*# ==. 

= I am a string\\
=== abc ===. 

Expected Json:
{'abc': 
       {'title': 'abc*#',
        'body': 'i am a string\\'
        }
'abc-1':. visit 1point3acres.com for more.
       {'title': 'abc',
        'body': ''}
}
有三点注意：
一个是title虽然和key可能一样，但是key没有non-alpha和non-space的character,title可以有。这里我用了regex。
另一个title被equal quotes起来了，但一定是前后都有才可以，那个第三行的‘= I am a string\\’就不是title。
另外一个是如果有相同key,需要加上dash和第几次重复。这里我用的是dict装count，当时只想到这个，不知道大家会怎么想的。.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
body应该还好，就是有可能为空，没有特别需要处理的
#####一道题：longest distance in binary tree，可以是任意两个节点。就是把Binary Tree Maximum Path Sum的每个节点value改为1，最后减去1即可。

#####乱七八糟
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=116449&highlight=uber
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=115277&highlight=uber
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=110268&highlight=uber
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=105851&highlight=uber

#####  palindrome
1. 给定一个string，判断能否用这个string来组成一个palindrome。e.g. 'uber' --> False, 'aab' --> True, 'carecra' --> True
用hashtable记录每个字符出现的频率，然后遍历hashtable算出频率为奇数的字符数，如果小于2就可以

2. Follow up: 给出所有能够组成的palindrome，因为时间原因可以不用担心duplicates。（potential follow up就是去重了）
选出一半数量的字符进行permutation就好了
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=114707&highlight=uber

#####Letter Combinations of a Phone Number 
[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
#####3个长度一样的array a1, a2, a3, 找出所有 A + B = C 的组合，A在a1里，B在a2，C在a3里；扩展到4个数组 a2, a2, a3, a4，找出A+B+C=D的组合。。 然后扩展到n各数组
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=114976&highlight=uber
#####有directory, file, permission 问怎么OO design..Create a class design (OO) to model a FileSystem
    Directory, File, Permissions, etc

#####linked list deep copy in O(1) space
#####如何设计网页上的auto complete功能
前后端怎么实现 怎么存储 （ajax, backend service query DB and return data, DB
is key, count pair and indexed by both key and count）
in memory的话用什么数据结构来存 (trie)
如何做auto complete提示的的ranking (trie的节点添加count)

假设现在用户没有输入任何东西 我希望auto complete显示用户对此field的常用输入
的top n记录 那么怎么存这个top n 怎么更新这个top n的ranking数据
(最后说的hashmap + heap)
http://www.mitbbs.com/article_t/JobHunting/32977923.html

#####Give you a json string, 怎么去flatten。。。比如 string 为 a:{b:{c:。。。} 要输出a:b:c:...
#####100个locker一开始都是锁着的，第一次reverse 1， 2， 3， 4。。。； 第二次...
#####” coding: input: log file, output: 假定同一个user的login time, logout time 没有overlap. output:

##### LEETCODE/LINTCODE PROBLEMS
[max depth of binary tree]()
[Combination]()
[Permuatation]()
[Subsets]()
[WordBreak]()
[roman to integer]()
[level order traversal]()
[min stack]()
[one edit distance]()
[Subsets](http://www.lintcode.com/en/problem/subsets/)
[Subsets II ](http://www.lintcode.com/en/problem/subsets-ii/) 
[merge two sorted arrays]()
[lowest common ancestor in binary search tree](http://www.lintcode.com/en/problem/lowest-common-ancestor/) iteratively
[median of two sorted array](http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/)
[Best Time to Buy and Sell Stock]()
[]()
[]()
[]()
[]()
[]()