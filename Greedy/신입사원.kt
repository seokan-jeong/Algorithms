fun main() {
    // Problem
    // 백준 1946번. 신입 사원
    // 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다.
    // 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
    // 이러한 조건을 만족시키면서, 선발할 수 있는 신입사원의 최대 인원수를 구하라.

    val t = readLine()!!.toInt()
    for(testCase in 0 until t){


        val n = readLine()!!.toInt()
        val list = mutableListOf<Pair<Int, Int>>()

        for(scores in 0 until n){
            var (doc, meet) = readLine()!!.split(" ").map { it.toInt() }
            list.add(Pair(doc, meet))
        }

        list.sortWith(compareBy { it.first })

        var count = 1
        var minMeet = list[0].second

        for(i in 1 until list.size){
            if(list[i].second < minMeet){
                minMeet = list[i].second
                count++
            }
        }

        println(count)

    }


    // Solution
    // 서류 점수로 오름차순 정렬을 해놓고 순서대로 면접 점수를 비교한다.
    // 서류 2등이 1등보다 면접 등수가 높으면 통과 후 커트라인을 2등 면접 등수로 변경한다.
}
