fun main() {
    // Problem
    // 음료수 얼려 먹기
    //  N X M 크기의 얼음 틀이 있다.
    // 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
    // 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
    // 이 때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림 개수를 구하라.

    // n, m 입력받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]

    // 2차원 리스트 입력받기
    val graph = arrayListOf<ArrayList<Int>>()
    for (i in 0 until n) {
        var input = readLine()!!
        var tmp = arrayListOf<Int>()
        for (j in 0 until m) {
            tmp.add(input[j].toString().toInt())
        }
        graph.add(tmp)
    }

    // DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
    fun dfs(x: Int, y: Int): Boolean {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false
        }
        // 현재 노드를 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1
            // 상, 하, 좌, 우의 위치도 모두 재귀적으로 호출
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x, y + 1)
            return true
        }
        return false
    }

    // 모든 노드에 대하여 음료수 채우기
    var result = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            // 현재 위치에서 DFS 수행
            if (dfs(i, j)) {
                result += 1
            }
        }
    }

    print(result)

    // Solution
    // DFS로 상, 하, 좌, 우에 연결되어 있는 노드를 탐색
}
