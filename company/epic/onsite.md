####Question1 wikipedia里面给定一个文章作为start，另外一个文章作为end，求引用的最短路径

- BFS （queue)
- BiBFS

##### Follow up 如何用multi threads加速这个进程

每个level都是可以parallized 

####Question2 如果有一个病人来从新看病，怎么找到该病人的信息
据说是查主治医生
我觉得可以先问what does the database look like... 

#####Follow up I 有可能输入病人信息的时候出错，名字可以输入错误，生日也可能出错怎么找正确的信息
what does your search engine look like...

#####Follow up II 用名字, 生日, zip 来查病人， 但返回的结果非常多怎么排序
- A specific page's relevance ranking for a specific query currently depends on three factors:
	- Its relevance to the words and concepts in the query
	- Its overall link popularity
	- Whether or not it is being penalized for excessive search engine optimization (SEO).

- Search engine default ranking is tf-idf, lack of words dependency.
	- normalized term frequencies, (log)number of documents in the corpus /the document frequency of a term
	- calculate similarity scores between the query and document vectors, and rank the documents.

- PageRank

	Some document are more important/popular than others

- other features, such as social signal/personal info

	ref: http://www.searchmetrics.com/wp-content/uploads/infographic-seo-ranking-factors-2014.jpg

####Question3 提醒 疫苗（dose）的注射

Database
- person table(pid, age, name)
- vaccine table(vid, name, description)
- dose table(did, date, volume)
- report table(pid, vid did, nextdosedata)

Notification

send message to patients with phone number/ patients with email 

#####Follow up I: x轴是所有对应的该打疫苗的时间，y轴是大概15种疫苗，里面是每个疫苗用条状的block来表示最佳打疫苗的时间。怎么样决定打疫苗的时间，能够让去医院的次数最少

seems like the interval scheduling problems (greedy)
https://courses.cs.washington.edu/courses/cse421/08au/Greedy.pdf

#####Follow up II: 比如某一种药一次可以服用5ml 10ml 20ml，然后给出总的需要服用的剂量，比如40ml， 写一个function，要求最少服用次数，输出怎么服用的方案。比如这个case就是20ml 20ml。

- seems like knapsack problem/subset sum with minimu size.-->DP 

- 所有的可能组合选最小的

####Question3 Emergency Room
Priority Queue
