import java.util.*
import kotlin.collections.ArrayList

fun main() {
    /*  Problem - 전보
    어떤 나라에는 N개의 도시가 있다.
    그리고 각 도시는 보내고자 하는 메시지가 있는 경우, 다른 도시로 전보를 보내서 다른 도시로 해당 메시지를 전송할 수 있다.
    하지만 X라는 도시에서 Y라는 도시로 전보를 보내고자 한다면, 도시 X에서 Y로 향하는 통로가 설치되어 있어야 한다.
    또한 통로를 거쳐 메시지를 보낼 때는 일정 시간이 소요된다.

    어느 날 C라는 도시에서 위급 상황이 발생했다. 그래서 최대한 많은 도시로 메시지를 보내고자 한다.
    메시지는 도시 C에서 출발하여 각 도시 사이에 설치된 통로를 거쳐, 최대한 많이 퍼져나갈 것이다.
    각 도시의 번호와 통로가 설치되어 있는 정보가 주어졌을 때, 도시 C에서 보낸 메시지를 받게되는 도시의 개수는 총 몇 개이며
    도시들이 모두 메시지를 받는 데까지 걸리는 시간은 얼마인지 계산하라.
     */

    // Priority Queue Lambda
    val lambda = { a: Int, b: Int ->
        when {
            a < b -> 1
            a > b -> -1
            else -> 0
        }
    }

    // Infinity Value
    val INF = 987654321

    // 노드의 개수, 간선의 개수, 시작 노드를 입력받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]
    val start = input[2]
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
    val graph = arrayListOf<ArrayList<ArrayList<Int>>>()
    (0..n).map { graph.add(arrayListOf()) }
    // 최단 거리 테이블을 모두 무한으로 초기화
    val distance = arrayListOf<Int>()
    (0..n).map { distance.add(INF) }

    // 모든 간선 정보를 입력받기
    for (i in 0 until m) {
        input = readLine()!!.split(' ').map { it.toInt() }
        val x = input[0];
        val y = input[1];
        val z = input[2]
        // X번 노드에서 Y번 노드로 가는 비용이 Z라는 의미
        graph[x].add(arrayListOf(y, z))
    }

    fun dijkstra(start: Int) {
        val pq = PriorityQueue(Comparator<Pair<Int, Int>> { a, b ->
            when {
                a.first != b.first -> lambda(a.first, b.first)
                else -> lambda(a.second, b.second)
            }
        })
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.add(Pair(0, start))
        distance[start] = 0
        while (pq.isNotEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보를 꺼내기
            val data = pq.poll()
            val dist = data.first
            val now = data.second
            if (distance[now] < dist) continue
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (i in graph[now]) {
                val cost = dist + i[1]
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[i[0]]) {
                    distance[i[0]] = cost
                    pq.add(Pair(cost, i[0]))
                }
            }
        }
    }

    dijkstra(start)

    // 도달할 수 있는 노드의 개수
    var count = 0
    // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
    var max_distance = 0
    for (d in distance) {
        // 도달할 수 있는 노드인 경우
        if (d != INF) {
            count += 1
            if (d > max_distance) {
                max_distance = d
            }
        }
    }

    print("${count - 1} $max_distance")

    /* Solution
    다익스트라 알고리즘 - 우선순위 큐
     */
}
