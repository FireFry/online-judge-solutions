object Solution extends App {
  val possibleWays = List(
    List(1, 2, 3, 4, 5),
    List(1, 3, 2, 4, 5),
    List(1, 4, 3, 2, 5),
    List(1, 3, 4, 2, 5))

  val costs = Array.ofDim[Int](5, 5)
  for {
    i <- 0 until 5
    j <- 0 until 5
  } costs(i)(j) = Input.readInt()

  def minWay(possibleWays: List[List[Int]], optimalWay: List[Int], optimapCost: Int): (List[Int], Int) = possibleWays match {
    case head::tail => {
      val cost: Int = findCost(head)
      if (cost < optimapCost) minWay(tail, head, cost) else minWay(tail, optimalWay, optimapCost)
    }
    case _ => (optimalWay, optimapCost)
  }

  def findCost(way: List[Int]): Int = way match {
    case from::to::tail => costs(from - 1)(to - 1) + findCost(to::tail)
    case _ => 0
  }

  val (optimalWay, optimalCost) = minWay(possibleWays, possibleWays.head, Int.MaxValue)
  println(optimalCost)
  println(optimalWay.mkString(" "))
}

object Input {
  import java.io.{StreamTokenizer, BufferedReader, InputStreamReader}
  val reader: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
  val tokenizer: StreamTokenizer = new StreamTokenizer(reader)
  def readDouble(): Double = tokenizer.nextToken() match { case StreamTokenizer.TT_NUMBER => tokenizer.nval }
  def readInt(): Int = readDouble().toInt
  def readLong(): Long = readDouble().toLong
}