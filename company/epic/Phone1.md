My questions to ask:
1 what's your R&D team doing ?
2 is this a new position ? what happens to the previous person /  Why you start the position and what is the role in the development team?
3 自己的DB所以我还问了他们公司的DB的一些问题

1. why Epic?
decent salary, beautiful campus

2. Why software development engineer?
decent income, feel like making a difference

Design Questions

1 有N个病人，他们各自有自己的不同症状，问你如何找出两种症状最相近的病人
vector, cos similarity/others or K-means clustering

Follow up:
HashMap<ID, disease>
HashMap<disease, ID>
perform join (bitmap join)
----------
Build index by disease (b+-Tree), for quick lookup a specific disease
--------

2 有100层楼  我们要测试一种bag 最高可以从那一层丢下来而不破 用最简方式找到这层楼. 

follow up：现在只有两个bag可以用，如果bag破了就不能再用了，没破就可以继续用，还是用最简方式找到这层楼
10->50->75->100 
brute force second

3 如果设计一个手机APP，方便用户查询个人信息，怎么保证信息的安全
1 location check
2 带验证码，试错几次就不让试了

4 一个数组里面找到最大的两个数，要求一次遍历
1 max heap
2 two variables

5 N个城市，两城市之间的信息包括：［是否通航，（如果通航的话）机票多少钱，飞行时间多久］

问题是如何选择“A城”到“B城”的机票，价格尽量低，时间尽量少，stop尽量没有。

weighted Graph, shortest path with minimum cost, 

6 大概电梯接到 request 要怎么handle.
levator continues to travel in its current direction (up or down) until empty, stopping only to let individuals off or to pick up new individuals heading in the same direction.

7 Design a algorithm which could remind patients when and how much they should take medicine. 
it can alert the patients about potential drug-drug/drug-food interactions and plan a proper in-take schedule to avoid these interactions; (2) it can revise the in-take schedule automatically when a dose was missed. In both cases, the software always tries to produce the simplest schedule with least number of in-takes.

8 How to design a Maps app on mobile device
1. download maps
2. real time location pitch and map updated 
3. navigation functions
4. search functions

9. A robot fitted with a GPS device.How would you detect its movement ?
















