import java.util
import java.util.Arrays

object Main extends App {
  def genericPartition(arr: Array[Int],
                       leftFunction: Int => Boolean,
                       RightFunction: Int => Boolean): Unit = {

    var low = 0
    var high = arr.length - 1
    while (low <= high) {
      if (leftFunction(arr(low))) low += 1
      else if (RightFunction(arr(high))) high -= 1
      else {
        val temp = arr(low)
        arr(low) = arr(high)
        arr(high) = temp
        low += 1
        high -= 1
      }
    }
    println(Arrays.toString(arr))
  }

  // Question4
  var arr = Array(1, 6, 1, 6, 6, 1, 6, 1, 1, 6, 6)
  var leftFunction = (input: Int) => input == 1
  var RightFunction = (input: Int) => input == 6
  genericPartition(arr, leftFunction, RightFunction)

  //Question3
  arr = Array(-3, 6, 12, 4, -7, 45, -6, -3, -1, 2, 3, 10, 1, 2, 3, 4, 5)
  leftFunction = (input: Int) => input % 2 == 0
  RightFunction = (input: Int) => input % 2 == 1
  genericPartition(arr, leftFunction, RightFunction)
}
