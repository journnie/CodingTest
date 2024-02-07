#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    area = [list(map(int, input().split())) for _ in range(N)]
    
    max_flies = 0
    
    for row in range(N - M + 1):
        for col in range(N - M + 1):
            flies = 0
            for i in range(row, row + M):
                for j in range(col, col + M):
                    flies += area[i][j]

            if flies > max_flies:
                max_flies = flies

    result = max_flies
    print(f'#{test_case} {result}')