---------------------------------------------------------------README----------------------------------------------------------------

Project :  COMS E6111 Advanced Database Systems, Fall 2012, Project 1

Name:
1. Kuber Kaul(UNI- kk2872 )
2. Harshil Gandhi(UNI - hmg2138)
			
List Of Files Submitted:

BingTest.java  -------------------- The java program
Doc.java  -------------------- Utility class
Term.java  -------------------- Utility class
TFIDF.java  -------------------- Utility class
Makefile --------------------------- The makefile
jsoup-1.7.1.jar --------------------------- The XML Parser
commons-codec-1.7.jar ------------------------- The Codec provides Base64 encoding and decoding as defined by RFC 2045. 

			
How To Run The Program :We have created a MakeFile in the directory. 
# To compile type "make" and it should compile the entire project. 
# To run type make run and it should run the entire project

Internal Design of the Project	:

1) The BingTest.java is the main classfile which uses objects of the utility classes "Doc", "Term" and "TFIDF".
i) alpha, beta, gamma -------------- These are the parameters controls the modification on the query. Based on the selection 
rule, we only care about the relative value of the query vector. So, we could always set alpha equal to one, and renormalize beta and gamma. The value of beta and gamma are less significant when we cares relative values only. We followed the value suggested in the book which behaves pretty well.Since, we used Ide-Dec-Hi, we did not have to use these parameters or normalization.

Query-Modification Method :	

a) Description of Algorithm
1) Two approaches
We have the naive approach and the IDE Dec Hi in our program. Unsurprisingly, the performance of these two approaches are close due to the limitation on the number of results in consideration.

i) Tf-Idf -------------- Calculates (term frequency*Inverse Document Frequency) to learn the impact of the specific words of the different documents. The Tf-Idf value of stock words such as is,the would be very low and hence not impact the new words in the search query much.
 
ii) The Ide-Dec-Hi algorithm ---------- The Ide-Dec-Hi uses the top non-relevant documents for feedback, instead of all non relevant documents retrieved within the first set shown the user.The rocchio method on the other hand allows both the input of the relevant  documents and non relevant documents and uses a weighting scheme based on a normalized version of the documents weights rather than the actual weight themselves.We used Ide-Dec-Hi which has been proved to provide better result in time.Also, We used Ide-Dec-Hi Algorithm instead of Ide-Dec-Hi regular as the former has been proved more optimized.

Source: http://orion.lcg.ufrj.br/Dr.Dobbs/books/book5/chap11.htm


Bing Search Account Key	:	Our Bing Search Account key, as mentioned clearly in the code as comment in the start 
				is gAQWhdOorE4LJ5ntPJT9mbKSemDzsrDxsN/xcZQA8Fo=

Additional Information	:	


1) For the words which are too common to include, such as "a", "the", it is best to have some word-to-ignore dictionary from some top search engine. We do not find such a dictionary. In stead, we tried several queries, to manually get a short list of such words. This is not always the case, for example, "the" might be the best expansion word if we want to search for Dwayne Johnson with "rock". Hence we did not utilize it.

2) We did not incorporate any algorithm to order the new query terms as Bing handles that part on its own and no matter what the order, Bing would reorder according to its own algorithm thus the impact would be always similar(Since Bing re-orders the new query terms itself)

3) One special point that we would like to mention about our search pattern is that we noticed that numbers and statistics play a vital role in the search queries. Our system is inclined to find numbers predominantly and add them in the query as often as possible.

4) We also have added an ignore list that eliminates a wide range of meaningless stopwords which dirupt the query expansion process.


Limitation:

1) We tried the program to search the MAC Operating System - Jaguar starting from original query word "jaguar". The top ten
   results returned by Bing do not contain any word regarding the operating system, which means the first results will be evaluated with zero relevance after the first round. In this case, it's impossible to get the desired results only by expanding the query.

2) The expansion is only based on the abstract and title. We decide not to use the cosine similarity due to the length of the
   abstract and title. It is important for expansion based on the contents of webpages, but will not help in this project described.
