from collections import deque

def solution(board):
    n = len(board)
    cost = [[[float('inf')] * 4 for _ in range(n)] for _ in range(n)]
    q = deque([(0, 0, -1, 0)]) # (x, y, 직전 방향 인덱스, 현재 비용)
    
    # 시작점에서 첫 이동 방향에 대한 비용을 큐에 넣어 BFS 시작 (cost 초기화는 생략)
    
    dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)] 
    
    while q:
        x, y, d, c = q.popleft()
        
        for i, (dx, dy) in enumerate(dirs):
            nx, ny = x + dx, y + dy
            
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                
                if d == -1 or d == i:
                    nc = c + 100 # 직선 이동
                else:
                    nc = c + 600 # 코너 발생
                
                # 🚀 수정: 엄격하게 더 작은 비용일 때만 갱신하고 큐에 추가
                if cost[nx][ny][i] > nc: 
                    cost[nx][ny][i] = nc
                    q.append((nx, ny, i, nc))

    # 도착점 (n-1, n-1)에 4가지 방향 중 가장 작은 비용 반환
    return min(cost[-1][-1])