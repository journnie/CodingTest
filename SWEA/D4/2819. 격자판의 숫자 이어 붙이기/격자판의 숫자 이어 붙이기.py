#import sys
#sys.stdin = open("practice_2.txt", "r")

T = int(input())
for tc in range(1, T + 1):
    arr = [input().split() for _ in range(4)]
    answer = set()
    # move
    moves = [[-1,0], [0,1], [1,0], [0,-1]] # up, right, down,  left

    def dfs(answer, position, mv_cnt, number):
        if mv_cnt == 0:
            answer.add(number)
            return

        x, y = position

        for dx, dy in moves:
            next_x, next_y = x + dx, y + dy

            if next_x < 0 or next_x >= 4: continue
            if next_y < 0 or next_y >= 4: continue

            dfs(answer, [next_x, next_y], mv_cnt - 1, number+str(arr[next_x][next_y]))


    for i in range(len(arr)):
        for j in range(len(arr[i])):
            number = str(arr[i][j])
            dfs(answer, [i, j], 6, number)

    print(f'#{tc} {len(answer)}')
