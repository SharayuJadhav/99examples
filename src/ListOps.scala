import scala.collection.mutable.ListBuffer

/**
  * Created by sjn6308 on 7/14/16.
  */
object ListOps extends App{

  var a= List(1,2,3,4)

  println(a.last)
//  println(a(a.length -1))

  println(a.init.last)
//println(a(a.length-2))

  for (num <- a) println(num +5)

  def nthEle[T]( n :Int, list :List[T]):T={
    list(n)
  }

  println("3rd ele => "+nthEle(3,a))

  println("Reverse of list -------->" + a.reverse)

  var b= 0 :: a
  println(b)
   a::=0
  println(a)

  a ++= List(3,2,1,0)
  println(a)

  if (a== a.reverse) println("Palindrome")else println("Not palindrome")

  println("------------ Concating lists -----------")
  println(a ::: b)
  println(List.concat(a,b))
  println(a ++ b)

  println("---------Combining nested lists into one----------")
// var c= List(9,a,11,12,13,b,44,List(66,49),88)     // c.flatten does not work
  println(List(List(2,3),List(5,6),a,b).flatten)

  var c= List(List("Steffi","stephen"), List("sharayu","sharVAri"))
  println(c.flatten.map(_.capitalize).sorted)

  val fruits = Seq("apple", "baNAna", "ORange")
  println(fruits)
  println(fruits.flatten)
  println(fruits.flatMap(_.toLowerCase()))
  println(fruits.map(_.toUpperCase))

  println("------------>>>>distinct elements<<<------")
  println(List('b','a','n','a','n','a').distinct)

  println("------------removing redundant elements------")
  def compress[T](values: List[T]) : List[T] =
     values match {
       case Nil                      => Nil
       case x :: y :: xs if (x == y) => compress(y :: xs)
       case x :: xs                  => List(x) ::: compress(xs)
     }

  var chars = List('b', 'a', 'a', 'a', 'n', 'n', 'a', 'n', 'a', 'a', 's')
  println(compress (chars))

  println("------Sublisting ------")
  def pack[T](list: List[T]):List[List[T]]={
    if (list.isEmpty) List(List())
    else
      {
        val (packed, next)= list span { _ ==list.head}
        if (next== Nil) List(packed)
        else
          packed::pack(next)
      }
  }
  println(pack(chars))

  println("--------Sublisting with count------")
  def packCount[T](list: List[T]):List[(Int,T)]={
    pack(list).map(ele=> (ele.length,ele.head))
  }
  println(packCount(chars))

  def packcount[T](list: List[T]):List[(Int,T)]={       //without pack function
    if(list.isEmpty) Nil
    else {
      val (elements, next)= list span{_==list.head}
      (elements.length, elements.head) :: packcount(next)
    }
  }

  println(packcount(chars))

  def removeSingles[T](list: List[T]):List[Any]={
    packCount(list). map(t=> if(t._1 ==1) t._2 else t)
  }
println(removeSingles(chars))

//  def expandSublists[T](list: List[(Int,T)]):List[T]= {
//    list flatMap{ele=> List.make(ele._1,ele._2)}
//  }

println("------------duplication elements -------")
  def duplicateNtimes[T](count :Int,list: List[T]): List[T]={
   list flatMap { element => List.fill(count)(element)}
 }

  println(List('a','b','c') flatMap{e=> List(e,e)}) // duplicate twice

  println(duplicateNtimes(3,List("kool","Box")))

  /*def getsubList[T](count:Int, element: T) : List[T]={
    var i=0
    var x= List[T]()
    while(i<=count){
        x :::= element
      i=i+1
    }
    x
  }

  def dupNTimes[T](count: Int, list: List[T]):List[T]={
    if(list.isEmpty) Nil
    else {
      var res = List()
      for (element<-list) yield {
        res ++= getsubList(count,element)
      }
      res
    }
  }

  println(dupNTimes(4,List(8)))*/

  println(a.splitAt(a.length/2))
  println(a.splitAt(3))

  println(a.slice(2,6))
  println(a.zipWithIndex filter { v => (v._2 + 1) % 3 != 0 } map { _._1 })
}
