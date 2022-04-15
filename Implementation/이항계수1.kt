/* 11050. 이항계수 1
    자연수 N과 정수 K가 주어졌을 때 이항 계수
    binom{N}{K}를 구하는 프로그램을 작성하시오.
 */

fun main() {
    val input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val k = input[1]

    var result = 1
    for (i in 0 until k) {
        result *= n - i
    }
    for (i in 0 until k) {
        result /= k - i
    }
    print(result)
}
