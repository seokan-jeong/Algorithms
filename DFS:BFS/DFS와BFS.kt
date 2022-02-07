fun main() {
    // Problem
    // 1260. DFS와 BFS
    // 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    // 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    // 정점 번호는 1번부터 N번까지이다.


    // N, M, V 입력받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]
    val v = input[2]

    // 간선 입력받기
    var graph = arrayListOf<ArrayList<Int>>()
    for (i in 0..n) {
        graph.add(arrayListOf<Int>())
    }
    for (i in 1..m) {
        input = readLine()!!.split(' ').map { it.toInt() }
        graph[input[0]].add(input[1])
        graph[input[1]].add(input[0])
    }
    for (i in 0..n) {
        graph[i].sort()
    }

    // visited 리스트 false로 초기화
    var visited = arrayListOf<Boolean>()
    for (i in 0..n) {
        visited.add(false)
    }

    // DFS 구현
    fun dfs(graph: ArrayList<ArrayList<Int>>, v: Int, visited: ArrayList<Boolean>) {
        // 현재 노드 방문 처리
        visited[v] = true
        print("$v ")
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (i in graph[v]) {
            if (!visited[i]) {
                dfs(graph, i, visited)
            }
        }
    }

    dfs(graph, v, visited)
    println()

    // visited 리스트 false로 초기화
    for (i in 0..n) {
        visited[i] = false
    }

    fun bfs(graph: ArrayList<ArrayList<Int>>, v: Int, visited: ArrayList<Boolean>) {
        // queue 구현
        val queue = arrayListOf<Int>()
        queue.add(v)
        // 현재 노드 방문 처리
        visited[v] = true
        // queue 빌 때까지 반복
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

    bfs(graph, v, visited)


    // Solution
    // 단순 DFS, BFS 탐색 예제 문제
}
