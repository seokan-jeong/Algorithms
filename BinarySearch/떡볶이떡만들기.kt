fun main() {
    // Problem
    // 떡볶이 떡 만들기
    // 오늘 세오칸은 여행 가신 부모님을 대신해서 떡집 일을 하기로 했다.
    // 세오칸네 떡볶이 떡은 떡의 길이가 일정하지 않다. 대신에 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 잘라서 맞춰준다.
    // 절단기에 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H 위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.
    // 손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하라.

    // 떡의 개수(N)와 요청한 떡의 길이(M)을 입력받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]
    // 각 떡의 개별 높이 정보를 입력받기
    val array = arrayListOf<Int>()
    readLine()!!.split(' ').map { array.add(it.toInt()) }

    // 이진 탐색을 위한 시작점과 끝점 설정
    var start = 0
    var end = array.maxOrNull()!!

    // 이진 탐색 수행
    var result = 0
    while (start <= end) {
        var total = 0
        var mid = (start + end) / 2
        for (x in array) {
            // 잘랐을 때 떡의 양 계산
            if (x > mid) {
                total += x - mid
            }
        }
        // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
        if (total < m) {
            end = mid - 1
        } else {
            result = mid    // 최대한 덜 잘랐을 때가 정답이므로 여기에서 result에 기록
            start = mid + 1
        }
    }

    print(result)
    
    // Solution
    // 이진 탐색을 통해 떡을 잘라나가며 절단기에 설정할 수 있는 최대 높잇값을 구한다.
}
