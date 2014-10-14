object Solution extends FastIO {
  def solve(): Unit = {
    var n = in.readInt()
    var a, b, c = 0
    while (n > 0) {
      in.readInt() match {
        case 1 => a += 1
        case 2 => b += 1
        case 3 => c += 1
      }
      n -= 1
    }
    if (a < b) { val tmp = a; a = b; b = tmp }
    if (a < c) { val tmp = a; a = c; c = tmp }
    if (b < c) { val tmp = b; b = c; c = tmp }
    println(if (c > 0 || b > 1 || b == 1 && a > 4) "Yes" else "No")
  }
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