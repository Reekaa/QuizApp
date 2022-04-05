import scala.io.Source
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import scala.collection.immutable.ListMap
import scala.util.matching.Regex
import Helpers.*

object QuizApp extends App {
  // APPLICATION LOGIC

  // read data from file
  val mapdata = readFile("quiz_data.txt")

  // UTILITY FUNCTIONS
  // reads quiz data file
  def readFile(filename: String): Map[String, List[(String, Int)]] = {
    var mapBuffer: Map[String, List[(String, Int)]] = Map()
    try {
      for (line <- Source.fromFile(filename).getLines()) {
        val splitline = line.split(",").map(_.trim).toList
        val newList = splitline.tail
        val listOfAnswers = newList map (x => {
          val y = x.split(":")
          (y(0).toString, y(1).toInt)
        })
        mapBuffer = mapBuffer ++ Map(splitline.head -> listOfAnswers)
      }
      // catch errors
    } catch {
      case ex: Exception => println("Sorry, an exception happened.")
    }
    mapBuffer
  }

  // define menu options as a Map of actions
  // for each menu item:
  // key is an Int, the value that will be read from the input
  // value is a function () => Boolean, i.e. no params and returns Boolean
  val actionMap = Map[Int, () => Boolean](1 -> handleOne, 2 -> handleTwo, 3 -> handleThree, 4 -> handleFour, 5 -> handleFive, 6 -> handleSix)

  // loop to read input and invoke menu option
  // uses function readOption to show menu and read input
  var opt = 0
  opt = readOption
  // uses function menu to invoke menu action
  // will terminate if menu returns false
  while (menu(opt)) {
    opt = readOption
  }

  // FUNCTIONS FOR MENU
  // shows menu and reads input
  def readOption: Int = {
    println(
      """|Please select one of the following:
         |  1 - Display all questions with their answers
         |  2 - Get all questions with percentage selection
         |  3 - Get all questions with number of worth-more and other answers
         |  4 - Get most popular answer for a specific subject area
         |  5 - Get the questions in descending order of number of worth-more answers where there at least two worth-more answers
         |  6 - quit""".stripMargin)
    readInt()
  }

  // invokes selected menu option
  // finds corresponding function to invoke in action map using get
  // pattern matching used as get returns an Option
  def menu(option: Int): Boolean = {
    actionMap.get(option) match {
      case Some(f) => f()
      case None =>
        println("Sorry, that command is not recognized")
        true
    }
  }

  //handlers for menu options
  def handleOne(): Boolean = {
    showAllQuestionsWithAnswers(currentQuizData)    // calls function showAllQuestionsWithAnswers, which invokes function currentAnswer
    true
  }

  def handleTwo(): Boolean = {
    getAnswerPercentages(currentQuizData)  // calls function getAnswerPercentages
    true
  }

  def handleThree(): Boolean = {
    getWorthMoreAndOtherAnswers(currentQuizData)  // calls function getWorthMoreAndOtherAnswers
    true
  }

  def handleFour(): Boolean = {
    getMostPopularAnswer(currentQuizData)        // calls function getMostPopularAnswer
    true
  }

  def handleFive(): Boolean = {
    setQuestionInDescendingOrder(currentQuizData)  // calls function setQuestionInDescendingOrder
    true
  }

  def handleSix(): Boolean = {
    println("Selected quit, application will close down")         // returns false so loop terminates
    false
  }

  // FUNCTIONS THAT INVOKE ACTION AND INTERACT WITH USER
  // each of these functions accepts user input if required for an operation,
  // invokes the relevant operation function and displays the results
  def showAllQuestionsWithAnswers(data: Map[String, List[(String, Int)]]) = {
    data foreach {
      case (k, v) =>  {
        println(s"\nQuestion: $k \nAnswers:")
        v.foreach {
          case (answer, numberOfPicks) => {
            println(s"$answer, $numberOfPicks")
          }
        }
      }
    }
  }

  def getAnswerPercentages(data: Map[String, List[(String, Int)]]) = {
    data foreach {
      case (k, v) =>  {
        val totalValues = sumUpValues(v)
        println(s"\nQuestion: $k \nAnswers with percentage:")
        v.foreach {
          case (answer, numberOfPicks) => {
            val percentage =  numberOfPicks.toFloat / totalValues * 100
            val round = percentage.round
            println(s"$answer, $round%")
          }
        }
      }
    }
  }

  def getWorthMoreAndOtherAnswers(data: Map[String, List[(String, Int)]]) = {
    data foreach { case (k, v) =>
      val valuesList = for (x <- v) yield (x._2)
      println(valuesList)
      val worthMoreValues = valuesList.filter(answers => (answers == 0)).length
      val otherValues = valuesList.filter(answers => (answers > 0)).length
      println(s"Question: $k : \nNumber of worth-more answers: $worthMoreValues\nNumber of other answers: $otherValues\n----------------------------------------------")
    }
  }

  def getMostPopularAnswer(data: Map[String, List[(String, Int)]]) = {
    val specificSubjectList = filterListForMusicSubject(data)
    val listOfAnswers = specificSubjectList.flatMap(_._2).toList
    val popularAnswer = mostPopulerAswer(listOfAnswers)
    println(s"Most popular answer in Music category is: $popularAnswer")
  }

  def setQuestionInDescendingOrder(data: Map[String, List[(String, Int)]]) = {
    val filteredQuestions = data.collect {
      case (key, value) if value.filter(answers => (answers._2 == 0)).length >= 2 => (key, value)
//      case (key, value) => println(value.filter(answers => (answers._2 == 0)).length)
    }
    println(filteredQuestions)
    // need to sort it

  }
  // OPERATION FUNCTIONS
  // each of these performs the required operation on the data and returns
  // the results to be displayed - does not interact with user
  def currentQuizData: Map[String, List[(String, Int)]] = {
    ListMap(mapdata.toSeq.sortBy(_._1):_*)
  }

}

