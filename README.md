# Algos #   
## Graphs: ##
package com.fb.graph 

1. Breadth First Search
1. Depth First Search
1. Topological Sort
1. Connected components
1. Strongly Connected Components
1. Pre/Post/InOrder Traversal
1. Directed and UnDirected Graphs
1. Mirror a Tree
1. SourceToDestInKPaths
1. Is mirror SelfTree      
1. Modify BST such that all greater values in the given BST are added to every node
1. Check if Binary Tree is Balanced
1. Convert Binary Tree as sum of its child nodes
1. Traverse Tree without using Recursion (Finds the pressessor of a node like Threaded BT)
1. Find out order of characters given the Dictionary of alphabets
1. Print Org History
1. Find paths in tree that sum to K (can have negative vals and can have more than one path)
1. Structurally similar Graphs

## Tree/ Random ##  
package com.stackoverflow.ques

1. Circumference of a Tree
1. Level Order print a Tree
1. Traverse a tree in Spiral order
1. Find the missing number in an Array
1. Snakes And Ladders
1. Print All Left nodes, All Right Nodes and All Leaf nodes

## LinkedLists ##  
package com.linkedin.algos;   

1. Reverse Linked List
1. Palindrome Linked List
1. Swap Kth Element from start end in Linked List
1. Find a Loop in Linked List and break the loop      

## Programs ##
package com.flipkart.programs;   

1. LRU Cache
1. MobilePad
1. MyBlockingQueue
1. MyHashMap
1. MyProducerConsumer uses MyBlockingQueue and wait/notify or condition/RentrantLock
1. ProducerConsumer used JDK1.5 Blocking Queue
1. SubStringSearch (BoyerMoores and Basic approach)       
1. MyThreadPool
1. Consistent Hashing
1. MySemaphore
1. MyBarrier
1. BloomFilter


## DP ##
CoinChange Problem      

## Others  ##
package com.yahoo.algos;   

1. KthLargest
1. MyStack
1. MyQueue
1. BST
1. BinarySearch
1. KthLargest (usingQuick Select)
1. Sorting algos
1. FirstRepeating
1. ShuffleArray
1. Job Sequencing given deadlines
1. Search in a sorted rotated array
1. Reverse/Rotate a String
1. Activity Selection, show timings start/end given say which all can we attend
1. Anagrams Of a word in given text
1. Find first N prime numbers
1. For given Array find max sum such that nothing adjacent
1. Rotate a Matrix by 90 degrees
1. MatrixExtend All 1 To Row and Cols
1. Decode an input in different ways given mapping say a=1 b=2 decode 121
1. Next Greatest Number With Same Digits

LSG Stats
BULK:
120k avg (100k Save 10k fetch) each 5 mins each host. 10 hosts each cluster and 19 clusters worldwide (13 in USFR)
= 120,000*10*19 / 300 = 76K rps (WW)

HS: 
40k save 100k fetch = 140k each 5 mins on 32 hosts each 22 USFR cluster and 12 Intl clusters ~70k
= [(22*32*140) + (12*32*70) ]/300 = 183K rps

LS
133k *3* 365 bf1 + 100k * 4* 300
~800k rps in USFR
