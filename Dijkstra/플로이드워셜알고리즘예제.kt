fun main() {
    // 플로이드 워셜 알고리즘 예제

    // INF
    val INF: Int = 987654321

    // 노드의 개수 및 간선의 개수를 입력받기
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    // 2차원 그래프를 만들고, 모든 값을 무한으로 초기화
    val graph = arrayListOf<ArrayList<Int>>()
    for (i in 0..n) {
        val array = arrayListOf<Int>()
        for (j in 0..n) {
            array.add(INF)
        }
        graph.add(array)
    }

    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for (i in 1..n) {
        for (j in 1..n) {
            if (i == j) {
                graph[i][j] = 0
            }
        }
    }

    // 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
    for (i in 0 until m) {
        // A에서 B로 가는 비용은 C라고 설정
        val input = readLine()!!.split(' ').map { it.toInt() }
        graph[input[0]][input[1]] = input[2]
    }

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
    for (a in 1..n) {
        for (b in 1..n) {
            // 도달할 수 없는 경우, 무한(INF) 출력
            if (graph[a][b] == INF) print("INF ")
            else print("${graph[a][b]} ")
        }
        println()
    }
}
