T = int(input())
for testcase in range(1, T+1):
    N, M = map(int, input().split())
    array = [list(map(int, input().split())) for _ in range(N)]
    max_fly = 0
    for col in range(N-M+1):
        for row in range(N-M+1):
            sum_fly = 0
            for i in range(M):
                sum_fly += sum(array[row+i][col:col+M])
            max_fly = max(max_fly, sum_fly)
    print(f'#{testcase} {max_fly}')
