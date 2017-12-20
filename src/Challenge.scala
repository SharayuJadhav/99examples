/**
  * Created by sjn6308 on 7/18/16.
  */
class Challenge {
  def main(args: Array[String]) {
    println(io.Source.stdin.getLines().take(2).map(_.toInt).sum)
  }

}
