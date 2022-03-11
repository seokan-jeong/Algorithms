fun main() {
    // 간단한 다익스트라 알고리즘 예제

    // 노드의 개수, 간선의 개수를 입력받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]

    // 시작 노드 번호를 입력받기
    val start = readLine()!!.toInt()
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
    val graph = arrayListOf<ArrayList<ArrayList<Int>>>()
    for (i in 0..n) {
        graph.add(arrayListOf())
    }
    // 방문한 적이 있는지 체크하는 목적의 리스트를 만들기
    val visited = arrayListOf<Boolean>()
    for (i in 0..n) {
        visited.add(false)
    }
    // 최단 거리 테이블을 모두 무한으로 초기화
    val distance = arrayListOf<Int>()
    for (i in 0..n) {
        distance.add(Int.MAX_VALUE)
    }

    for (i in 0 until m) {
        input = readLine()!!.split(' ').map { it.toInt() }
        val a = input[0]
        val b = input[1]
        val c = input[2]
        graph[a].add(arrayListOf(b, c))
    }

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    fun get_smallest_node(): Int {
        var min_value = Int.MAX_VALUE
        var index = 0   // 가장 최단거리가 짧은 노드(인덱스)
        for (i in 1..n) {
            if ((distance[i] < min_value) and visited[i].not()) {
                min_value = distance[i]
                index = i
            }
        }
        return index
    }

    fun dijkstra(start: Int) {
        // 시작 노드에 대해서 초기화
        distance[start] = 0
        visited[start] = true
        for (i in graph[start]) {
            distance[i[0]] = i[1]
        }
        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (i in 0 until n) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리
            val now = get_smallest_node()
            visited[now] = true
            // 현재 노드와 연결된 다른 노드를 확인
            for (j in graph[now]) {
                val cost = distance[now] + j[1]
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[j[0]]) {
                    distance[j[0]] = cost
                }
            }
        }
    }

    // 다익스트라 알고리즘 수행
    dijkstra(start)

    // 모든 노드로 가기 위한 최단 거리를 출력
    for (i in 1..n) {
        // 도달할 수 없는 경우, 무한이라고 출력
        if (distance[i] == Int.MAX_VALUE) {
            print("INFINITY")
        } else {
            println(distance[i])
        }
    }
}
