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
    for(i in 0..8){
        visited.add(false)
    }

    dfs(graph, 1, visited)
}

fun dfs(graph: ArrayList<ArrayList<Int>>, v: Int, visited: ArrayList<Boolean>){
    // 현재 노드 방문 처리
    visited[v] = true
    print("$v ")
    // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for(i in graph[v]){
        if(!visited[i]){
            dfs(graph, i, visited)
        }
    }
}
