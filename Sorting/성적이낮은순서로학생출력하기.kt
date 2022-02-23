fun main() {
    // Problem
    // N명의 학생 정보가 있다. 학생 정보는 학생의 이름과 학생의 성적으로 구분된다.
    // 각 학생의 이름과 성적 정보가 주어졌을 때 성적이 낮은 순서대로 학생의 이름을 출력하라

    val n = readLine()!!.toInt()

    var array = arrayListOf<Pair<String, Int>>()
    for (i in 0 until n) {
        val input = readLine()!!.split(" ")
        array.add(Pair(input[0], input[1].toInt()))
    }

    array.sortBy { it.second }

    for (student in array) {
        print("${student.first} ")
    }

    // Solution
    // 성적 순으로 정렬
    // Pair 잘 써야함
}
