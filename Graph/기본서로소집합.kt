import kotlin.collections.ArrayList

fun main() {
    // 기본적인 서로소 집합 알고리즘

    // 특정 원소가 속한 집합을 찾기
    fun find_parent(parent: ArrayList<Int>, x: Int): Int {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (parent[x] != x) {
            return find_parent(parent, parent[x])
        }
        return x
    }

    // 두 원소가 속한 집합을 합치기
    fun union_parent(parent: ArrayList<Int>, a: Int, b: Int) {
        val a = find_parent(parent, a)
        val b = find_parent(parent, b)
        if (a < b) {
            parent[b] = a
        } else {
            parent[a] = b
        }
    }

    // 노드의  개수와 간선(union 연산)의 개수 입력받기
    var input = readLine()!!.split(' ').map { it.toInt() }
    val v = input[0]
    val e = input[1]
    val parent = arrayListOf<Int>()
    (0..v).map { parent.add(0) }

    // 부노 테이블 상에서, 부모를 자기 자신으로 초기화
    for (i in 1..v) {
        parent[i] = i
    }

    // union 연산을 각각 수행
    for (i in 0 until e) {
        input = readLine()!!.split(' ').map { it.toInt() }
        val a = input[0]
        val b = input[1]
        union_parent(parent, a, b)
    }

    // 각 원소가 속한 집합 출력
    print("각 원소가 속한 집합: ")
    for (i in 1..v) {
        print("${find_parent(parent, i)} ")
    }
    println()

    // 부모 테이블 내용 출력
    print("부모 테이블: ")
    for (i in 1..v) {
        print("${parent[i]} ")
    }
}
