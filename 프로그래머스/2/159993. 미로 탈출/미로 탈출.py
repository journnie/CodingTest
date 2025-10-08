from collections import deque

def is_valid_move(nr, nc, m, n, maps):
    # n(열의 수)을 사용하여 올바른 경계 조건을 확인합니다.
    return 0 <= nr < m and 0 <= nc < n and maps[nr][nc] != "X"

def solution(maps):
    m, n = len(maps), len(maps[0])
    # 3차원 배열: [행][열][레버 상태(0/1)]
    visited = [[[False] * 2 for _ in range(n)] for _ in range(m)]
    
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    q = deque()
    
    start_r, start_c = -1, -1
    end_r, end_c = -1, -1
    
    # 시작 지점 (S)와 출구 (E) 좌표 저장
    for r in range(m):
        for c in range(n):
            if maps[r][c] == "S":
                start_r, start_c = r, c
            if maps[r][c] == "E":
                end_r, end_c = r, c
                
    # 큐 초기화
    q.append((start_r, start_c, 0, 0)) # (r, c, k, time)
    visited[start_r][start_c][0] = True
    
    while q:
        r, c, k, time = q.popleft()
        
        # 탈출 조건: 출구(E)에 도착했고, 레버를 당겼을 때 (k=1)
        if r == end_r and c == end_c and k == 1:
            return time
        
        for d in range(4) :
            nr, nc = r + dr[d], c + dc[d]
            
            # 맵 경계를 벗어나거나 벽('X')인 경우 건너뜀
            if not is_valid_move(nr, nc, m, n, maps):
                continue
            
            # 다음 상태 (nk)를 결정
            nk = k
            if maps[nr][nc] == "L":
                nk = 1 # 레버를 당기면 상태를 1로 변경
            
            # 새로운 상태로 방문한 적이 없을 경우에만 큐에 추가
            if not visited[nr][nc][nk]:
                visited[nr][nc][nk] = True
                q.append((nr, nc, nk, time + 1))
                
    # 큐가 빌 때까지 출구에 도달하지 못했다면 -1 반환
    return -1