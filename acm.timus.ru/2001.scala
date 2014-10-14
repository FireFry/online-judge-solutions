import java.io.{StreamTokenizer, BufferedReader, InputStreamReader, OutputStreamWriter, PrintWriter}

object Solution {
  val writer: PrintWriter = new PrintWriter(new OutputStreamWriter(System.out))
  val reader: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
  val tokenizer: StreamTokenizer = new StreamTokenizer(reader)
  def readDouble(): Double = tokenizer.nextToken() match { case StreamTokenizer.TT_NUMBER => tokenizer.nval }
  def readFloat(): Float = readDouble().toFloat
  def readInt(): Int = readDouble().toInt
  def readLong(): Long = readDouble().toLong
  def readLine(): String = reader.readLine()
  def readWord(): String = tokenizer.nextToken() match { case StreamTokenizer.TT_WORD => tokenizer.sval }
  def main(args: Array[String]) {
    val a: Array[Integer] = new Array[Integer](6)
//    for (i <- 0 until a.length) a(i) = readInt()
//    writer.print(a(0) - a(4))
//    writer.print(' ')
//    writer.println(a(1) - a(3))
//    writer.flush()

    a.update(0, 1);//readInt()
    writer.println("1 1")
    writer.flush()
  }
}

//trait IO {
//  val writer: PrintWriter = new PrintWriter(new OutputStreamWriter(System.out))
//  val reader: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
//  val tokenizer: StreamTokenizer = new StreamTokenizer(reader)
//  def readDouble(): Double = tokenizer.nextToken() match { case StreamTokenizer.TT_NUMBER => tokenizer.nval }
//  def readFloat(): Float = readDouble().toFloat
//  def readInt(): Int = readDouble().toInt
//  def readLong(): Long = readDouble().toLong
//  def readLine(): String = reader.readLine()
//  def readWord(): String = tokenizer.nextToken() match { case StreamTokenizer.TT_WORD => tokenizer.sval }
//}