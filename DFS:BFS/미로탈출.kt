fun main() {
    // Problem
    // 미로 탈출
    // 세오칸은 N X M 크기의 직사각형 형태의 미로에 갇혀 있다.
    // 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
    // 세오칸의 위치는 (1, 1)이고 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸 씩 이동할 수 있다.
    // 이 때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다.
    // 미로는 반드시 탈출할 수 있는 형태로 제시된다.
    // 이 때 세오칸이 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하라.

    // N, M을 공백으로 구분하여 입력 받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]

    // 2차원 리스트 입력 받기
    val graph = arrayListOf<ArrayList<Int>>()
    for (i in 0 until n) {
        var input = readLine()!!
        var tmp = arrayListOf<Int>()
        for (j in 0 until m) {
            tmp.add(input[j].toString().toInt())
        }
        graph.add(tmp)
    }

    // 이동할 네 방향 정의(상, 하, 좌, 우)
    val dx = arrayListOf<Int>(-1, 1, 0, 0)
    val dy = arrayListOf<Int>(0, 0, -1, 1)

    // BFS 구현
    fun bfs(x: Int, y: Int): Int {
        // queue 구현
        val queue = arrayListOf<Pair<Int, Int>>()
        queue.add(Pair(x, y))
        // queue가 빌 때까지 반복
        while (queue.isNotEmpty()) {
            val x = queue[0].first
            val y = queue[0].second
            queue.removeAt(0)
            // 현재 위치에서 네 방향으로의 위치 확인
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue
                }
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) {
                    continue
                }
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1
                    queue.add(Pair(nx, ny))
                }
            }
        }
        return graph[n - 1][m - 1]
    }

    print(bfs(0, 0))


    // Solution
    // BFS로 시작 지점에서 가까운 노드부터 차례대로 탐색
    // 특정한 노드를 방문하면 그 이전 노드의 거리에 1을 더한 값을 저장
}
