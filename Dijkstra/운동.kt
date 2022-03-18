import java.lang.Integer.min
import kotlin.collections.ArrayList

fun main() {
    /*  1956. 운동
    V개의 마을와 E개의 도로로 구성되어 있는 도시가 있다.
    도로는 마을과 마을 사이에 놓여 있으며, 일방 통행 도로이다.
    마을에는 편의상 1번부터 V번까지 번호가 매겨져 있다고 하자.
    당신은 도로를 따라 운동을 하기 위한 경로를 찾으려고 한다.
    운동을 한 후에는 다시 시작점으로 돌아오는 것이 좋기 때문에, 우리는 사이클을 찾기를 원한다.
    단, 당신은 운동을 매우 귀찮아하므로, 사이클을 이루는 도로의 길이의 합이 최소가 되도록 찾으려고 한다.
    도로의 정보가 주어졌을 때, 도로의 길이의 합이 가장 작은 사이클을 찾는 프로그램을 작성하시오. 두 마을을 왕복하는 경우도 사이클에 포함됨에 주의한다.
     */

    val INF = 987654321
    var input = readLine()!!.split(' ').map { it.toInt() }
    val v = input[0]
    val e = input[1]

    val graph = arrayListOf<ArrayList<Int>>()
    for (i in 0..v) {
        val array = arrayListOf<Int>()
        for (j in 0..v) {
            array.add(INF)
        }
        graph.add(array)
    }

    for (i in 0 until e) {
        input = readLine()!!.split(' ').map { it.toInt() }
        graph[input[0]][input[1]] = input[2]
    }

    for (k in 1..v) {
        for (i in 1..v) {
            for (j in 1..v) {
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    val resultArray = arrayListOf<Int>()
    for (i in 1..v) {
        for (j in 1..v) {
            if (i == j) {
                resultArray.add(graph[i][j])
            }
        }
    }

    val resultValue = resultArray.minOrNull() ?: -1
    if(resultValue == INF){
        print(-1)
    }else{
        print(resultValue)
    }

    /*  Solution
        시작점이 나와있지 않고 최소비용으로 순환되는 도로를 찾으면 되기 때문에 플로이드 워셜 알고리즘을 사용해야 한다.
        또한, 순환해야하므로 같은 번호의 노드를 거칠 때도 점화식을 적용하기 위해서 초기에 INF 값을 넣어준다.
     */
}
