fun main() {
    val graph = arrayListOf<ArrayList<Int>>(
        arrayListOf(),
        arrayListOf(2, 3, 8),
        arrayListOf(1, 7),
        arrayListOf(1, 4, 5),
        arrayListOf(3, 5),
        arrayListOf(3, 4),
        arrayListOf(7),
        arrayListOf(2, 6, 8),
        arrayListOf(1, 7)
    )
    var visited = arrayListOf<Boolean>()
    for (i in 0..8) {
        visited.add(false)
    }

    bfs(graph, 1, visited)
}

fun bfs(graph: ArrayList<ArrayList<Int>>, start: Int, visited: ArrayList<Boolean>) {
    // queue 구현
    val queue = arrayListOf<Int>()
    queue.add(start)
    // 현재 노드를 방문 처리
    visited[start] = true
    // queue가 빌 때까지 반복
    while (queue.isNotEmpty()) {
        val v = queue[0]
        queue.removeAt(0)
        print("$v ")
        // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 queue에 삽입
        for (i in graph[v]) {
            if (!visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }
    }
}
