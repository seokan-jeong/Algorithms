import java.lang.Math.pow

/* 4153. 직각삼각형
    과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다.
    주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
 */

fun main() {
    while (true) {
        var input = readLine()!!.split(' ').map { it.toDouble() }
        if (input[0] == 0.0) {
            break
        }

        input = input.sortedDescending()

        if (pow(input[0], 2.0) == pow(input[1], 2.0) + pow(input[2], 2.0)) {
            println("right")
        } else {
            println("wrong")
        }
    }
}
