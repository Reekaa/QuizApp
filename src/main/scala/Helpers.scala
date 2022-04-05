object Helpers {
  def mostPopulerAswer(list: List[(String, Int)]): (String, Int) ={
    val mapList = list.maxBy(_._2)._1
    val highestInt = list.map(_._2).max
    (mapList, highestInt)
  }

  def orderedAnswers(list: List[(String, Int)] ) = {
    val descendingOrderList = list.toList.sortWith(_._2 > _._2)
    descendingOrderList
  }

  def sumUpValues(list: List[(String, Int)]) = {
    val summedUpValues = list.map(_._2).foldLeft(0)((x, y) => x + y)
    summedUpValues
  }

  //  def worthMoreAnswers(list: List[(String, Int)] ) = {
  //    val worthMoreAnswers = list.filter(x => (x == 0)).length
  //    worthMoreAnswers
  //  }
}
