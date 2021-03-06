# 다익스트라(Dijkstra) 최단 경로 알고리즘

- 그래프에서 여러 개의 노드가 있을 때, 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘이다.
- 다익스트라 최단 경로 알고리즘은 '음의 간선'이 없을 때 정상적으로 동작한다.
- 현실 세계의 길(간선)은 음의 간선으로 표현되지 않으므로 다익스트라 알고리즘은 실제로 GPS 소프트웨어의 기본 알고리즘으로 채택되곤 한다.
- 1. 출발 노드를 설정한다.
- 2. 최단 거리 테이블을 초기화한다.
- 3. 방문하지 않은 노드 중에서 최단 거리가 짧은 노드를 선택한다.
- 4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
- 5. 위 과정에서 3과 4번을 반복한다.
- 단계마다 '방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택'하기 위해 매 단계마다 1차원 리스트의 모든 원소를 확인(순차 탐색)한다.
