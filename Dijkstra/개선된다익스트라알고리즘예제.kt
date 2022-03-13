fun main() {
    // 개선된 다익스트라 알고리즘 예제

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

    fun dijkstra(start: Int) {
        val lambda = { a: Int, b: Int ->
            when {
                a < b -> 1
                a > b -> -1
                else -> 0
            }
        }

        val q = PriorityQueue(Comparator<Pair<Int, Int>> { a, b ->
            when {
                a.first != b.first -> lambda(a.first, b.first)
                else -> lambda(a.second, b.second)
            }
        })

        q.add(Pair(0, start))
        distance[start] = 0
        while (q.isNotEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            val item = q.poll()
            val dist = item.first
            val now = item.second
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (distance[now] < dist) {
                continue
            }
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (i in graph[now]) {
                val cost = dist + i[1]
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[i[0]]) {
                    distance[i[0]] = cost
                    q.add(Pair(cost, i[0]))
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
