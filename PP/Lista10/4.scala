import scala.collection.mutable

def copy[T](dest: mutable.Seq[T], src: mutable.Seq[T]): Unit = {
  require(dest.length >= src.length)
  var index = 0
  src.foreach(element => {
    dest.update(index, element)
    index += 1
  })
}
