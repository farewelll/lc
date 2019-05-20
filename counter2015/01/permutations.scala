// https://leetcode.com/problems/permutations

import scala.collection.mutable.ListBuffer
object Solution {
  def permute(nums: Array[Int]): List[List[Int]] = {
    nums.length match {
      case 0 => List(List())
      case _ =>
        val res = for {x <- nums; xs <- permute((nums.to[ListBuffer] - x).toArray)} yield x :: xs
        res.toList
    }
  }
}
