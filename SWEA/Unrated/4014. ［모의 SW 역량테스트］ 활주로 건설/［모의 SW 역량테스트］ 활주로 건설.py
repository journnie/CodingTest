
#import sys
#sys.stdin = open("practice_1.txt", "r")

def makeRunway(row):
    down = False
    land = 1
    for i in range(1, N):
        if row[i] - row[i-1] == 0:
            land += 1
        elif row[i] - row[i - 1] == 1:  # up
            if down and land < 2*X:  # fig 10
                return False
            if not down and land < X:  # fig 4
                return False
            down = False
            land = 1

        elif row[i] - row[i-1] == -1:  # down
            if down and land < X:  # fig 6
                return False
            down = True
            land = 1
        # 근데 여기까지 안 내려옴..
        else:  # 만약 층이 두칸 이상일 경우 등등
            return False
    if down and land < X:  # fig 7을 생각하고 쓴 것
        return False
    return True


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, X = list(map(int, input().split()))
    arr = [list(map(int, input().split())) for _ in range(N)]
    col_arr = []


    for j in range(N):
        column = []
        for i in range(N):
            column.append(arr[i][j])
        col_arr.append(column)

    runway = 0

    for i in range(N):
        if makeRunway(arr[i]):
            runway += 1
        if makeRunway(col_arr[i]):
            runway += 1

    print(f"#{test_case} {runway}")
