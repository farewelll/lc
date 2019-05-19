// https://leetcode.com/problems/subsets-ii/

object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    def subset(nums: List[Int]): List[List[Int]] = nums match {
      case Nil => List(List[Int]())
      case x::xs =>
        var a = subset(xs.asInstanceOf[List[Int]])
        a.map(res => res ::: List(x)) ::: a
    }
    subset(nums.toList).map(_.sorted).distinct
  }
}
