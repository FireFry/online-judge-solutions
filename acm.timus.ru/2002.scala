import scala.collection.mutable

object Solution {
  import java.io.{BufferedReader, InputStreamReader}
  val reader: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
  val registered: mutable.Map[String, String] = mutable.Map()
  val logined: mutable.Set[String] = mutable.Set()

  def main(args: Array[String]) {
    (0 until reader.readLine().toInt).foreach(_ => println(processLine(reader.readLine())))
  }

  def processLine(line: String): String = {
    if (line.charAt(0) == 'r') {
      val space: Int = line.indexOf(' ', 9)
      val username: String = line.substring(9, space)
      val password: String = line.substring(space + 1)
      if (registered.contains(username))
        "fail: user already exists"
      else {
        registered += ((username, password))
        "success: new user added"
      }
    } else if (line.charAt(3) == 'i') {
      val space: Int = line.indexOf(' ', 6)
      val username: String = line.substring(6, space)
      val password: String = line.substring(space + 1)
      if (!registered.contains(username))
        "fail: no such user"
      else if (registered.get(username).get != password)
        "fail: incorrect password"
      else if (logined.contains(username))
        "fail: already logged in"
      else {
        logined += username
        "success: user logged in"
      }
    } else {
      val username: String = line.substring(7)
      if (!registered.contains(username))
        "fail: no such user"
      else if (!logined.contains(username))
        "fail: already logged out"
      else {
        logined -= username
        "success: user logged out"
      }
    }
  }
}