# QuizApp

Advanced Programming Coursework March 2022
Quiz Application 

In this assignment you are required to develop a prototype for an application in Scala to extract information from quiz data. You will be provided with quiz data, and your application should allow the user to select from the set of options listed below and obtain the results of the chosen option. The application should have a simple text-based, menu-driven interface. 
Background
The quiz data was collected via a web site which asked members of a test group questions, each with a number of correct responses; the number of selections of each correct response was stored.
The data can be used by a quiz master to formulate questions:  the contestant with a correct answer  and the smallest number of selections from the test group wins that question. Of particular interest are answers which received zero selections i.e. worth-more answers.
Data 
The data is supplied to you as a comma-separated text file quizdata.txt. Each line of the file contains a question (subject area), with a collection of correct answer details. Each answer detail represents the answer text, and the number of selections from the test group.  A sample line from the file is shown below: 
US State names 5 letters or less (Geography), Iowa:0,Maine:72,Ohio:108,Texas:144,Utah:0,Idaho:36

Note the answer detail values are separated by a colon.

In this example, the question, in the Geography subject area, asks for US states whose names are 5 or less characters: there are six correct responses; two of which are worth-more answers i.e. attracted zero selections from the test group.

## Data Structure
Your application should read the file contents and store the data in a map structure where each line of the file is used to construct a map entry with the question as the key, and a list of tuples as the value. The type of the structure should be Map[String, List[(String,Int)]]. The sample line shown should be represented within the map as follows: 
Map(US State names 5 letters or less (Geography) ->
         List((Iowa,0),(Maine,72),(Ohio,108),(Texas,144),(Utah,0),(Idaho,36))

You will also be supplied with a fragment of Scala code, in a Scala Worksheet file quizdata.sc, that creates a map with the same format, containing equivalent data. You can use this, if you wish, to test other functions as required without the need to have completed the file reading functionality. 
Options
Your application should allow the user to perform the following analyses: 
1.	Get all the question and answer details and display suitably formatted.
2.	Get all the questions and for each answer the percentage selection of the total selections for that question.
3.	Get all the questions and the number of worth-more and other answers where a worth-more answer has zero selections and other answers have at least one selection.
4.	Get the questions and most popular answer(s) i.e. most selections, for a specified subject area e.g. Geography.
5.	Get the questions in descending order of number of worth-more answers where there at least two worth-more answers for the question.

Marks for each analysis will be awarded on the basis of completeness and correctness of the implementation.

## Testing 
You should test your operation functions using the test data - for each one you should define input data if required, note the result returned by the function and compare this to the expected result. 
You should test your complete application by invoking each menu option using suitable user input and comparing the displayed result with the expected result. 
Marks will be awarded on the basis of evidence of a rigorous approach to designing and implementing test cases. 


