import java.lang.Integer.min
import kotlin.collections.ArrayList

fun main() {
    /*  11404. 플로이드
    n(2 ≤ n ≤ 100)개의 도시가 있다.
    그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다.
    각 버스는 한 번 사용할 때 필요한 비용이 있다.
    모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.
     */

    val INF = 987654321             // INFINITY Value
    val n = readLine()!!.toInt()    // 도시의 개수 N
    val m = readLine()!!.toInt()    // 버스의 개수 M

    val graph = arrayListOf<ArrayList<Int>>()
    for (i in 0..n) {
        val array = arrayListOf<Int>()
        for (j in 0..n) {
            if (i == j) {
                array.add(0)
            } else {
                array.add(INF)
            }
        }
        graph.add(array)
    }

    for (i in 0 until m) {
        val input = readLine()!!.split(' ').map { it.toInt() }
        val a = input[0]
        val b = input[1]
        val cost = input[2]
        if (graph[a][b] > 0) {
            graph[a][b] = min(graph[a][b], cost)
        }
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (graph[i][j] == INF) {
                graph[i][j] = 0
            }
            print("${graph[i][j]} ")
        }
        println()
    }

    /*  Solution
    n -> node
    m -> edge
    모든 도시에 대한 최단 경로를 구해야하므로 플로이드 워셜 알고리즘 사용
     */
}
