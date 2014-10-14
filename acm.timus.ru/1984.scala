object Solution extends FastIO {
  def solve(): Unit = out.println(
    readInt() match {
      case 1 => 1
      case 2 => 2
      case n => 1 + 1 / Math.sin(Math.PI / n)
    }
  )
}

object Main {
  def main(args: Array[String]) {
    Solution.solve()
    Solution.out.close()
  }
}

trait FastIO {
  import java.io.{OutputStreamWriter, PrintWriter}
  val out: PrintWriter = new PrintWriter(new OutputStreamWriter(System.out))
  val in = Input

  object Input {
    import java.io.{StreamTokenizer, BufferedReader, InputStreamReader}
    val reader: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
    val tokenizer: StreamTokenizer = new StreamTokenizer(reader)
    def readDouble(): Double = tokenizer.nextToken() match { case StreamTokenizer.TT_NUMBER => tokenizer.nval }
    def readFloat(): Float = readDouble().toFloat
    def readInt(): Int = readDouble().toInt
    def readLong(): Long = readDouble().toLong
    def readLine(): String = reader.readLine()
    def readWord(): String = tokenizer.nextToken() match { case StreamTokenizer.TT_WORD => tokenizer.sval }
  }
}