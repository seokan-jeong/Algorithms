/* 11650. 좌표 정렬하기
    2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로,
    x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 */

data class Coordinate(val first: Int, val second: Int)

fun main() {
   val n = readLine()!!.toInt()
   val array = arrayListOf<Coordinate>()

   for (i in 0 until n) {
      val input = readLine()!!.split(' ').map { it.toInt() }
      array.add(
         Coordinate(input[0], input[1])
      )
   }

   array.sortBy { it.second }
   array.sortBy { it.first }

   for (i in 0 until n) {
      println("${array[i].first} ${array[i].second}")
   }
}
