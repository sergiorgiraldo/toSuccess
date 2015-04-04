###From 1point2acres
####Math Questions
1. 3 24 -168 1008 -5040, what’s the next number? 
(4*5040= 20160)

2. Amagic tree, double the height every day, the tree is 80 on 10th day,on which day the tree is 20 height? (8th day)
x*2^10= 80
x*2^y=20
2^(10-y)= 4
y=8

3. Twosoftware developers coming out from No. 1 office and No. 106 office with theconstant speed. The developer in No.1 office crosses 5 offices per min, theother one passes 10 offices per min. In which number of office they will meetwith each other? (36)
5t+ 10t = 106-1
t= 7
5*7+1= 36

4. Twocoins worth 55 cents, one is not nickel (5 cents), what are the values of twocoins? (5 & 50)

5. Fillin the blank, 4 7 13 __ 49 97 (25)
x*2 -1

6. One goatclimbs the cliff, the cliff is 60.5 inches height, the goat climbs 3 inch permin then falls 2 inches. How many times that goat could get to the top? (59)
59+2

7. The company has 50,000 check, and 500 cash. They use cash to buy 150 stamps which each of them is 44 cents. They also bought 2 computers, each of them is 2025dollars. 1/15 of the computer expenses was paid by cash, and 1/10 is paid by check. After that, they use check paid four employees’ weekly payment, theannual income of each employee is 26,000 dollars and there are 52 weeks peryear. What’s the value of cash and check? (cash:164, check:47595)
500*y- 1.5*44 -135*2 =0
50000*x- 202.5*2 - 26000*52=0

8. Apple= 40 cents, banana = 60 cents, grapefruit = 80 cents, what’s the value of pear?(40)
20 cents per vowel

9. If one and half teenagers eat one and a half pizzas in one and a half days, how many pizzas can 9 teenagers eat in 3 days? (18)
3/2*2*3*2= 18

10. A man goes to a hardware shop and asks for price of an item. The shop keeper replies that the item is one for $1. The man gives the shop keeper $3 for 600. What did the man buy for his newly paintedhouse? 
(House number)

11. You have three kinds of magazines, all but two are Times, all but two are Science, all but two are Nature. How many magazines in total do you have? 
3

12. You are working on an exam and the questionis smudged and you can’t see the question. Based on the answers only, what is the answer? (E)
-A) All of the below ( obiviours false )
-B) None of the below (if true, c is true)
-C) Some of the above ( if true, b is true, then c is true )
-D) One of the above ( if c true, b true, if b true, d false)
-E) None of the above ( so we reach here )
-F) None of the above (if true, e is false, the a-d will be true )

13. If a clock looses 2 seconds per day, how much time will it loose in 2 days ? (6sec) <--- may not be true
     True Time       This Clock
1st  00:00:02pm       00:00:00
2rd  00:00:04pm       00:00:00


14. A man has two cubes on his desk. Every day he arranges both cubes so that the front faces show the current day of the month. What numbers are on the faces of the cubes to allow this? (0,1,2,3,4,5; 0,1,2,6,7,8)
total 12 faces:   
0 1 2 3 7 8 
0 1 2 4 5 6 
make sure both has 0 1 2
(9 --> turn 6 arround )

15. You can go to a fast food restaurant to buy chicken nuggets in 6-pack, 9-pack or 20-packs. Is there such a number N, such that for all numbers bigger than or equal to N, you can buy that number of chicken nuggets? (44)
Seems like brute force solution...

16. In how many ways cube can be painted using three different colors (57)
http://www.careercup.com/question?id=2104

####Coding Questions
1. Colorful Number:
A number can be broken into different sub-sequence parts. Suppose a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. And this number is a colorful number, since product of every digit of a sub-sequence are different. That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40. But 326 is not acolorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. You have to write a function that tells if the given number is a colorful number or not.

2. Well-ordered String:
You know a password is well-ordered string. Well-ordered string means that the order of the characters is in an alphabetical increasing order. Like “abEm” is a well-ordered number. However, “abmE” is not a well-order number. 

3. Desirable Number
A number is called ‘desirable’ if all the digits are strictly ascending eg: 159 as 1<5<9. You know that your rival has a strictly numeric password that is 'desirable'. Your close ally has given you the number of digits (N) in your rival's password. WAP that takes in 'N' as input and prints out all possible 'desirable' numbers that can be formed with N digits.

4. Telephone Number
Print all valid phone numbers of length n subject to following constraints:
If a number contains a 4, it should start with 4
No two consecutive digits can be same
Three digits (e.g. 7,2,9) will be entirely dis allowed

5. SMS
You are given a telephone keyboard
0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-space, #-char separater
if you type "2", you will get 'A', that is "2"-'A', "22"-'B' ,"222"-'C', "2222"-'2'
However, the digits can repeated many times
"22222"-you get 'A' again . 
You can use "#" to separate characters, for example
"2#22", you get "AB"
However, you may also have consecutive different digits without separator:"23"-'AD'. 
If you type "*", it means space..
You a given a sequence of digits, translate it into a text message

6. Keypad Permutation
Phone has letters on the number keys. for example, number 2 has ABC on it, number 3 has DEF, 4 number has GHI,... , andnumber 9 has WXYZ. Write a program that will print out all of the possible combination of those letters depending on the input.

7. The stepping number:
A number is called as a stepping number if the adjacent digits are having a difference of 1. For eg. 8,343,545 are stepping numbers. While 890, 098 are not. The difference between a ‘9’ and ‘0’ should not be considered as 1. Given start number(s) and an end number (e) your function should list out all the stepping numbers in the range including both the numbers s & e. 

8. Two Primes
Goldbach's conjecture : Every even integer greater than 2 can be expressed as the sum of two primes. Write a functionwhich takes a number as input, verify if is an even number greater than 2 and also print at least one pair of prime numbers.

9. Finding Words
Write a program for a word search. If thereis an NxN grid with one letter in each cell. Let the user enter a word and the letters of the word are said to be found in the grid either the letters match vertically, horizontally or diagonally in the grid. If the word is found, print the coordinates of the letters as output.

10. Spiral Matrix
Given a NXN matrix, starting from the upper right corner of the matrix start printing values in a counter-clockwise fashion.
E.g.: Consider N = 4
Matrix= 
{a, b, c, d,
e, f, g, h,
i, j, k, l,
m, n, o, p}
Your function should output: dcbaeimnoplhgfjk

11. Largest Sum Sub Array
Find the largest sum contiguous sub array. The length of the returned sub array must beat least of length 2.

12. Advisered Average Number
Write a program to display the advisered average for the list of numbers my omitting the three largest number in the series.
E.g:3,6,12,55,289,600,534,900,172. avg=(3+6+12+55+289+172) /6 and eliminating 534,900,600

13. Count And Say
First,let user input a number, say 1. Then, the function will generate the next 10numbers which satisfy this condition:
1, 11,21,1211,111221,312211...
explanation: first number 1, second number is one 1, so 11. Third number is two1(previous number), so 21. next number one 2 one 1, so 1211 and so on...

14. Valid Password
In 1-9 keypad one key is not working. If someone enters a password then not working key will not be entered. You have givenexpected password and entered password. Check that entered password is valid ornot. Ex: entered 164, expected 18684 (you need to take care as when u enter18684 and 164 only both will be taken as 164 input)

15. Verify Password
Verify if the given password is valid/invalid
1. must be 5-12 characters long . 
2. must contain at least one number and one lowercase character
3. a sequence must not be followed by the same sequence (like 123123qs is invalid, 123qs123 is valid)

16. Snake Sequence
You are given a grid of numbers. A snake sequence is made up of adjacent numbers such that for each number, the number on the right or the number below it is +1 or -1 its value. For example,
1 3 2 6 8
-9 7 1 -1 2 
1 5 0 1 9 
In this grid, (3, 2, 1, 0, 1) is a snake sequence. Given a grid, find the longest snake sequences and their lengths (so there can be multiple snake sequences with the maximum length).

17. Mountain Point
Given a M * N matrix, if the element in thematrix is larger than other 8 elements who stay around it, then named thatelement be mountain point. Print all the mountain points.

*18. Additive Number
Anadditive sequence is 1,2,3,5,8,13 where T(n) = T(n -1) + T(n - 2). A numberrange is given to you. Find the additive sequence number in that range.
Given the start and an ending integer as userinput, generate all integers with the following property.

19. Fibbonaci Number
There is one kind of numbers call FibbonaciNumber, which satisfy the following situation:
A. can be spilt into several numbers;
B. The first two number are the same, thenext number is equal to the sum of previous two
eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
If you are given a range by the user, findall numbers that are Fibbonaci numbers.

20. Coin Change
Something cost $10.25 and the customer pays with a $20 bill, the program will print out the most efficient "change-breakdown" which is 1 five, 4 ones, and 3quarters. Find the minimum number of coins required to make change for a given sum (given unlimited cumber of N different denominations coin)

21. Separate the number
Print the sequences from the input given by the user separated by semicolon
e.g.: 4678912356012356
output: 4;6789;123;56;0123;56;(subsequence in alphabetical order)

22. Find Max/Min Number
Take a series of integers as input till a zero is entered. Among these given integers, find the maximum of the odd numbers and the minimum of the even integers (not including zero) and print them.

23. Swapping String
Given two strings, you need to transpose the first string to the second string by means of only swaps between 2 consecutive characters in the first string. This must be performed by doing a series of these swaps in order to get the second string.

24. Mingo
A random generator (like a speakerstanding in a group housie game calls out a number) generates out any number from 1 to 1000. There is a 10X10 matrix. A random generator assigns values to each block of this matrix(within 1 to 1000 obviously).
Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers called out by the speaker, its called a 'Mingo'. Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.

25. Matrix Position
Given an NxN matrix with unique integers :Find and print positions of all numbers such that it is the biggest in its row andalso the smallest in its column . e.g. : In 3 x 3 with elements
1 2 3
4 5 6
7 8 9
the number is 3 and position (1,3)

26. Replace String
Froma given string, replace all instances of 'a' with 'one' and 'A' with 'ONE'.
Example Input: " A boy is playing in a garden"
Example Output: " ONE boy is playing in onegarden"
-- Not that 'A' and 'a' are to be replaced only when theyare single characters, not as part of another word.

27. Replace Words
Given a string. Replace the words whose length>=4and is even, with a space between the two equal halves of the word. Consideronly alphabets for finding the evenness of the word
I/P “A person can’t walk in this street”
O/P “A per son ca n’t wa lk in th is str eet”

28. Replace AEIOU
Replace a,e,i,o,u with A,E,I,O,U.
At most four eligible letters from the rearof the string are replaced.
The first three eligible letters in thestring are always exempted from replacement.

29. Security Keypad
There is a security keypad at the entrance ofa building. It has 9 numbers 1 – 9 in a 3×3 matrix format.
1 2 3
4 5 6
7 8 9 . from: 1point3acres.com/bbs
The security has decided to allow one digit error for a person but that digitshould be horizontal or vertical. Example: for 5 the user is allowed to enter2, 4, 6, 8 or for 4 the user is allowed to enter 1, 5, 7. IF the security codeto enter is 1478 and if the user enters 1178 he should be allowed. Write afunction to take security code from the user and print out if he should beallowed or not.

30. Calendar
Get a date (mon/day/year) from user. Printexact the week of dates (Sun to Sat). ex) input: 2/20/2001 if the day isWednesday
output: Sunday 2/17/2001
Monday 2/18/2001
Tuesday 2/19/2001
Wednesday 2/20/2001
Thursday 2/21/2001
Friday 2/22/2001
Saturday 2/23/2002

31. Seeds Number
Find the seed of a number. .
Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. find all possible seedfor a given number.

32. Tic Tac Toe
N*N matrix is given with input red or black.You can move horizontally, vertically or diagonally. If 3 consecutive samecolor found, that color will get 1 point. So if 4 red are vertically then pointis 2. Find the winner.

33. Fill a “magic square”matrix.
A magic square of order n is an arrangement of thenumbers from 1 to n^2 in an n by n matrix with each number occurring exactlyonce so that each row, each column and each main diagonal has the same sum. Then should be an odd number. In the middle cell of the top row, fill number 1.Then go to above row and right column, and fill following number 2. If it’s outof boundary, go to the opposite row or column. If the next cell is alreadyoccupied, go to the cell below this cell and fill following number. An exampleof 5*5 grid is like this for the first 9 numbers:
0 0 1 8 0
0 5 7 0 0
4 6 0 0 0
0 0 0 0 3
0 0 0 2 9

34. Bull and Cows Game
There’s a word guessing game. One personthink a word, and the other one guess a word, both words have the same length.The person should return the number of bulls and cows for the guessing. Bullsrepresent the number of same characters in the same spots, whereas cowsrepresent the number of characters guessed right but in the wrong spots. Writea program with two input strings, return the number of bulls and cows.

35. Palindromes
Print all palindromes of size greater than orequal to 3 of a given string. (How to do it with DP)?

36. Unique Number
Write, efficient code for extracting uniqueelements from a sorted list of array. e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).

37. Subtraction of two Arrays
Suppose you want to do the subtraction of twonumbers. Each digit of the numbers is divided and put in an array. Like A=[1,2, 3, 4, 5], B=[4, 5, 3, 5]. You should output an array C=[7, 8, 1, 0].Remember that your machine can’t hand numbers larger than 20.

38. Basketball Hit Rate
The hit rate of the basketball game is givenby the number of hits divided by the number of chances. For example, youhave 73 chances but hit 15 times, then your hit rate is 15/73=0.205 (keep the last3 digits). On average, you have 4.5 chances in each basketball game. Assume thetotal number of games is 162. Write a function for a basketball player. Hewill input the number
of hits he has made, the number of chances he had, and the number of remaininggames. The function should return the number of future hits, so that hecan refresh his hit rate to 0.45

39. Clock Angle
We are given a specific time(like 02:23), weneed to get the angle between hour and minute(less than 180)

40. Jump Chess
There’sa N*N board, two players join the jump game. The chess could go vertically andhorizontally. If the adjacent chess is opponent player’s and the spot besidethat is empty, then the chess could jump to that spot. One chess could not beenjumped twice. Given the position of the spot on the board, write the program tocount the longest length that chess could go.

41. Decimal Number
Let the user enter a decimal number. Therange allowed is 0.0001 to 0.9999. Only four decimal places are allowed. Theoutput should be an irreducible fraction. E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.

42. Continuous Alphabets
Printcontinuous alphabets from a sequence of arbitrary alphabets . 
For example:
Input: abcdefljdflsjflmnopflsjflasjftuvwxyz
Output: abcdef; mnop; tuvwxyz
Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
Output: abcdef; mnop; tuvwxyz

43. Substring Addition
Write a program to add the substring. eg :say you have alist {1 7 6 3 5 8 9 } and user is entering a sum 16. Output should display(2-4) that is {7 6 3} cause 7+6+3=16.

44. Balanced String
Given a string that has{},[],() and characters.Check if the string is balanced. E.g. {a[(b)]} is balanced. {a[(b])} isunbalanced.

45. RGBCompare
Given a string of RGB value (rr, gg, bb)which represents in hexadecimal. Compare if rr or gg or bb is the biggest, ortwo of those values are equal and larger than the third one, or three valuesare equal with each other.

46. Edge Detection
Two-dimensional array representation of animage can also be represented by a one-dimensional array of W*H size, where Wrepresent row and H represent column size and each cell represent pixel valueof that image. You are also given a threshold X. For edge detection, you haveto compute difference of a pixel value with each of it’s adjacent pixel andfind maximum of all differences. And finally compare if that maximum differenceis greater than threshold X. if so, then that pixel is a edge pixel and have todisplay it.

47. Plus Equal Number
Given a number find whether the digits in thenumber can be used to form an equation with + and ‘=’. That is if the number is123, we can have a equation of 1+2=3. But even the number 17512 also forms theequation 12+5=17.

48. Octal and Decimal Palindrome

The decimal and octal values of some numbers are both palindromes sometimes. Find such numbers within a given range.
