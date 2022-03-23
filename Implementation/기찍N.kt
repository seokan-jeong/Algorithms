fun main() {
    /* 2742. 기찍 N
    자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
     */

    val n = readLine()!!.toInt()
    for (i in n downTo (1)) {
        println(i)
    }
}
