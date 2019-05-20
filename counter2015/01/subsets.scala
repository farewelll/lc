// https://leetcode.com/problems/subsets/

object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    def subset(nums: List[Int]): List[List[Int]] = nums match {
      case Nil => List(List[Int]())
      case x::xs =>
        var a = subset(xs.asInstanceOf[List[Int]])
        a.map(res => res ::: List(x)) ::: a
    }
    subset(nums.toList)
  }
}
