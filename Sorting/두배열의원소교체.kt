fun main() {
    // Problem
    // Seokan은 두 개의 배열 A와 B를 가지고 있다. 두 배열은 N개의 원소로 구성되어 있으며, 배열의 원소는 모두 자연수이다.
    // Seokan은 최대 K번의 바꿔치기 연산을 수행할 수 있는데, 바꿔치기 연산이란 배열 A에 있는 원소 하나와 배열 B에 있는 원소 하나를 골라서 두 원소를 서로 바꾸는 것을 말한다.
    // Seokan의 최종 목표는 배열 A의 모든 원소의 합이 최대가 되도록 하는 것이다.

    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val k = input[1]

    var a = arrayListOf<Int>()
    input = readLine()!!.split(' ').map { it.toInt() }
    for (i in input) {
        a.add(i)
    }

    var b = arrayListOf<Int>()
    input = readLine()!!.split(' ').map { it.toInt() }
    for (i in input) {
        b.add(i)
    }

    a.sort()    // 배열 A는 오름차순 정렬
    b.sortDescending() // 배열 B는 내림차순 정렬

    // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
    for (i in 0 until k) {
        if (a[i] < b[i]) {
            a[i] = b[i].also { b[i] = a[i] }
        } else {
            break
        }
    }

    print(a.sum())

    // Solution
    // 배열 A는 오름차순, 배열 B는 내림차순 정렬하여 앞 인덱스 원소들을
    // 비교하면서 최대 K번 교환
}
