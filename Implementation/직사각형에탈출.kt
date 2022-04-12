import kotlin.math.min

/* 1085. 직사각형에서 탈출
    한수는 지금 (x, y)에 있다.
    직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
    직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 */

fun main() {
    val input = readLine()!!.split(' ').map { it.toInt() }
    val x = input[0]
    val y = input[1]
    val w = input[2]
    val h = input[3]

    val result = min(x, min(y, min(w - x, h - y)))

    print(result)
}
