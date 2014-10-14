object Solution {
  def main(args: Array[String]) {
    val n = Input.readInt()
    val k = Input.readInt()

    def calc(n: Int, x: Long, y: Long): (Long, Long) = n match {
      case 0 => (x, y)
      case _ => {
        val d: Long = Input.readLong () - k
        if (d > 0) calc (n - 1, x + d, y) else calc (n - 1, x, y - d)
      }
    }

    val (x, y) = calc(n, 0, 0)
    print(x)
    print(' ')
    println(y)
  }
}

object Input {
  import java.io.{StreamTokenizer, BufferedReader, InputStreamReader}
  val reader: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
  val tokenizer: StreamTokenizer = new StreamTokenizer(reader)
  def readDouble(): Double = tokenizer.nextToken() match { case StreamTokenizer.TT_NUMBER => tokenizer.nval }
  def readInt(): Int = readDouble().toInt
  def readLong(): Long = readDouble().toLong
}