fun main() {
    // 1654. 랜선 자르기
    // 집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다. 박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.
    // 이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다. 박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
    // 예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)
    // 편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자.
    // 그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.
    // 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.

    val input = readLine()!!.split(' ').map { it.toInt() }
    val k = input[0]
    val n = input[1]
    val array = arrayListOf<Int>()
    for (i in 0 until k) {
        array.add(readLine()!!.toInt())
    }

    var start = 1.toLong()
    var end = array.maxOrNull()!!.toLong()
    var result = 0.toLong()

    while (start <= end) {
        var total = 0.toLong()
        val mid = (start + end) / 2

        for (x in array) {
            total += x / mid
        }

        if (total < n) {
            end = mid - 1
        } else {
            result = mid
            start = mid + 1
        }
    }

    print(result)

    // Solution
    // 해결 방법은 그냥 이진탐색이다.
    // 단, (2^13-1) 이하인 자연수 두 개를 더할 경우 int형을 벗어남을 인지해야 한다.
    // 또한, 랜선이 자연수라는 조건에 따라 이진 탐색을 하기 전 start에 0이 아닌 1을 대입해야 한다.
}
