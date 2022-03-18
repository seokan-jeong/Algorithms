import java.lang.Integer.min
import kotlin.collections.ArrayList

fun main() {
    // 미래 도시
    // 방문 판매원 A는 많은 회사가 모여 있는 공중 미래 도시에 있다.
    // 공중 미래 도시에는 1번부터 N번까지의 회사가 있는데 특정 회사끼리는 서로 도로를 통해 연결되어 있다.
    // 방문 판매원 A는 현재 1번 회사에 위치해 있으며, X번 회사에 방문해 물건을 판매하고자 한다.
    // 공중 미래 도시에서 특정 회사에 도착하기 위한 방법은 회사끼리 연결되어 있는 도로를 이용하는 방법이 유일하다.
    // 또한 연결된 2개의 회사는 양방향으로 이동할 수 있다.
    // 공중 미래도시에서의 도로는 마하의 속도로 사람을 이동시켜주기 때문에 특정 회사와 다른 회사가 도로로 연결되어 있다면, 정확히 1만큼의 시간으로 이동할 수 있다.
    // 또한 오늘 방문 판매원 A는 기대하던 소개팅에도 참석하고자 한다. 소개팅의 상대는 K번 회사에 존재한다.
    // 방문 판매원 A는 X번 회사에 가서 물건을 판매하기 전에 먼저 소개팅 상대의 회사에 찾아가서 함께 커피를 마실 예정이다.
    // 따라서 방문 판매원 A는 1번 회사에서 출발하여 K번 회사를 방문한 뒤에 X번 회사로 가는 것이 목표다.
    // 이 때 방문 판매원 A는 가능한 빠르게 이동하고자 한다. 방문 판매원이 회사 사이를 이동하게 되는 최소 시간을 계산하라.

    // Infinity 값
    val INF = 987654321

    // 노드의 개수 및 간선의 개수를 입력받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]
    // 2차원 리스트를 만들고, 모든 값을 무한으로 초기화
    val graph = arrayListOf<ArrayList<Int>>()
    for (i in 0..n) {
        val array = arrayListOf<Int>()
        for (j in 0..n) {
            array.add(INF)
        }
        graph.add(array)
    }

    // 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
    for (i in 0 until m) {
        // A와 B가 서로에게 가는 비용은 1이라고 설정
        input = readLine()!!.split(' ').map { it.toInt() }
        val a = input[0]
        val b = input[1]
        graph[a][b] = 1
        graph[b][a] = 1
    }

    // 최종 목적지 노드 X, 거쳐 갈 노드 K를 입력받기
    input = readLine()!!.split(' ').map { it.toInt() }
    val x = input[0]
    val k = input[1]

    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
    for (k in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                if (graph[a][k] != INF && graph[k][b] != INF) {
                    graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
                }
            }
        }
    }

    // 수행된 결과를 출력
    val distance = graph[1][k] + graph[k][x]

    if (distance >= INF) print("INF")
    else print(distance)

    // Solution
    // 플로이드 워셜 알고리즘 사용
}
