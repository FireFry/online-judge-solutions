
object Solution extends FastIO {
  val kingMoves = List((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1))
  val knightMoves = List((-2, -1), (2, -1), (-2, 1), (2, 1), (-1, -2), (1, -2), (-1, 2), (1, 2))

  def solve(): Unit = {
    val n = in.readInt()
    val x = in.readInt()
    val y = in.readInt()
    val x1 = n + 1 - x
    def matches(x: Int, y: Int): Boolean = x > 0 && x <= n && y > 0 && y <= n
    val king = (0 /: kingMoves) ((acc, t) => { acc + (if (matches(x + t._1, y + t._2)) 1 else 0) })
    val knight = (0 /: knightMoves) ((acc, t) => { acc + (if (matches(x + t._1, y + t._2)) 1 else 0) })
    val bishop = 2 * n - 2 - Math.abs(x- y) - Math.abs(x1 - y)
    val rook = 2 * n - 2
    val queen = bishop + rook
    out.print("King: ")
    out.println(king)
    out.print("Knight: ")
    out.println(knight)
    out.print("Bishop: ")
    out.println(bishop)
    out.print("Rook: ")
    out.println(rook)
    out.print("Queen: ")
    out.println(queen)
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