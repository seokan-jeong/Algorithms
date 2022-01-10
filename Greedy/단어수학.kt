import kotlin.math.pow

fun main() {
    // Problem
    // 1339번. 단어 수학
    // 단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다.
    // 이 때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다.
    // 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안된다.
    // 예를 들어, GCF + ACDEB를 계산한다고 할 때, A=9, B=4, C=8, D= 6, E=5, F=3, G=7로 결정한다면,
    // 두 수의 합은 99437이 되어서 최대가 될 것이다.
    // N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만들어라.

    val n = readLine()!!.toInt()
    val alphabet = mutableMapOf<Char, Int>()

    for (i in 0 until n) {
        val inputString = readLine().toString()
        var len = inputString.length - 1

        inputString.forEach {
            val tmp = 10f.pow(len)
            if (alphabet.contains(it)) {
                alphabet[it] = alphabet[it]!!.plus(tmp.toInt())
            } else {
                alphabet[it] = tmp.toInt()
            }
            len--
        }
    }

    val list = alphabet.toList().sortedByDescending { it.second }
    var max = 9
    var sum = 0

    for (i in 0 until list.size) {
        sum += list[i].second * max
        max--
    }

    println(list)
    print(sum)

    // Solution
    // 문자열 입력받을 때 마다 알파벳 맵에 자릿수만큼 더한다.
    // 다 입력 받고 알파벳 맵을 내림차순으로 정렬하여 높은 알파벳부터
    // 9, 8, 7, ... 순으로 숫자를 곱해 최종 합을 구한다.
}
