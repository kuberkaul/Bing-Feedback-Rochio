default: BingTest.class
BingTest.class: src/BingTest.java
	javac -sourcepath src/ -classpath lib/commons-codec-1.7.jar:lib/jsoup-1.7.1.jar -d bin/ src/*.java

# BingTest.java is the file which has the main() function of the project. 
# The above command compiles BingTest.java along with its dependedent .java files. 
# Create a directory named src and put all your *.java files in it. This is specified by -sourcepath. 
# Create a directory named lib and put all your external *.jar files in it. This is specified by -classpath.
# Create an empty directory named bin where all your compiled *.class files will be created. This is specified by -d. 		
# This file should be in the directory that contains src, lib and bin directories. 
# To compile type "make" and it should compile the entire project. 

run:
	java -classpath bin/:lib/commons-codec-1.7.jar:lib/jsoup-1.7.1.jar  BingTest  
		
# The above command specifies how to run BingTest along with the input arguments. Replace them with number of required arguments.
# To run your project type "make run" and it should run the project. 
