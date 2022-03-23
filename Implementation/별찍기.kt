fun main() {
    /*  2439. 별 찍기
    첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
    하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
     */

    val n = readLine()!!.toInt()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i < n - 1 - j) {
                print(" ")
            } else {
                print("*")
            }
        }
        println()
    }
}
