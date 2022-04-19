/* 2609. 최대공약수와 최소공배수
    두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 */

fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a

fun main() {
    val input = readLine()!!.split(' ').map { it.toInt() }
    val num1 = input[0]
    val num2 = input[1]

    // 최대 공약수
    val gcd = gcd(num1, num2)
    println(gcd)

    // 최소공배수
    val lcm = num1 * num2 / gcd
    println(lcm)
}
