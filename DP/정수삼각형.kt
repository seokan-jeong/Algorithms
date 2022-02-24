import kotlin.math.max

fun main() {
    // 1932. 정수 삼각형
    //        7
    //      3   8
    //    8   1   0
    //  2   7   4   4
    // 4   5   2   6   5
    // 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
    // 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
    // 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
    // 삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

    val n = readLine()!!.toInt()
    val array = arrayListOf<ArrayList<Int>>()
    for (i in 0 until n) {
        array.add(arrayListOf<Int>())
        readLine()!!.split(' ').map { array[i].add(it.toInt()) }
    }

    for (i in 1 until n) {
        for (j in 0..i) {
            if (j == 0) {
                array[i][j] += array[i - 1][j]
            }else if(j == i){
                array[i][j] += array[i - 1][j - 1]
            }else {
                array[i][j] += max(array[i - 1][j - 1], array[i - 1][j])
            }
        }
    }

    print(array[n - 1].maxOrNull()!!)

    // Solution
    // 위에서 밑으로 모든 경우를 다 계산하는데
    // 한 층 아래에 있는 원소들은 상위 2개의 원소 값을 대각선으로 받았을 때 더 큰 값을 저장한다.
    // 최종적으로 가장 하위 층에서 가장 큰 값을 출력한다.
}
