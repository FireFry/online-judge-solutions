import java.io.{OutputStreamWriter, PrintWriter, StreamTokenizer, BufferedReader, InputStreamReader}

object Solution {
  def main(args: Array[String]) {
    val reader: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
    val tokenizer: StreamTokenizer = new StreamTokenizer(reader)
    val out: PrintWriter = new PrintWriter(new OutputStreamWriter(System.out))
    tokenizer.nextToken()
    val n = tokenizer.nval.toInt
    tokenizer.nextToken()
    val k = tokenizer.nval.toInt
    val a = new Array[Int](n * n)
    val b = new Array[Boolean](n)
    var i = 0
    var j = 0
    while (i < k) {
      tokenizer.nextToken()
      b(tokenizer.nval.toInt - 1) = true
      i += 1
    }
    i = 0
    while (i < n) {
      j = 0
      while (j < n) {
        tokenizer.nextToken()
        a(i * n + j) = tokenizer.nval.toInt
        j += 1
      }
      i += 1
    }
    var result = 0
    var q = 0
    val size = n - k
    var v = 0
    while (q < size) {
      var mi = -1
      var mv = Int.MaxValue
      i = 0
      while (i < n) {
        if (b(i)) {
          j = 0
          while (j < n) {
            if (!b(j)) {
              v = a(i * n + j)
              if (mv > v) {
                mi = j
                mv = v
              }
            }
            j += 1
          }
        }
        i += 1
      }
      result += mv
      b(mi) = true
      q += 1
    }
    out.println(result)
    out.flush()
  }
}