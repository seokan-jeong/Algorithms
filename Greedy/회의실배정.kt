fun main() {
    // Problem
    // 백준 1931번. 회의실 배정
    // 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
    // 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.

    val n = readLine().toString().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    var endTime = 0
    var count = 0

    for (i in 0 until n) {
        var (start, end) = readLine()!!.split(" ").map { it.toInt() }
        list.add(Pair(start, end))
    }
    list.sortWith(compareBy { it.first })
    list.sortWith(compareBy { it.second })

    for (i in 0 until n) {
        if (endTime <= list[i].first) {
            count++
            endTime = list[i].second
        }
    }

    print(count)

    // Solution
    // 회의 종료, 시작 시간 순으로 정렬을 하면
    // 종료시간이 가장 늦은 회의부터 정렬이 되며
    // 그 중에서도 시작 시간이 늦은 회의가 정렬이 되므로
    // 회의 끝나는 시간이 늦으면서 회의가 일찍 끝나는 순으로 정렬이 됨.
    // 회의가 시작 시간을 endTime에 넣어 다음에 비교할 회의의 끝나는 시간과 비교한 후
    // 겹치지 않으면 count를 늘려감.

}
