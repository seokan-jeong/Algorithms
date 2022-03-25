/*  9372. 상근이의 여행
    상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다.
    하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.
    이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
    상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
 */
fun main() {
    val testCase = readLine()!!.toInt()
    for(case in 0 until testCase){
        var input = readLine()!!.split(' ').map { it.toInt() }
        val numberNations = input[0]
        val numberPlanes = input[1]

        for(i in 0 until numberPlanes){
            readLine()!!
        }

        println(numberNations - 1)
    }
}

/*  Solution
    국가의 수는 node, 비행기 종류는 edge
    문제 조건에 연결 그래프라고 나와있기 때문에 어떤 국가를 방문하던 모든 국가를 방문할 수 있음.
    따라서 최소 edge의 수인 node - 1이 무조건 정답임.
 */
