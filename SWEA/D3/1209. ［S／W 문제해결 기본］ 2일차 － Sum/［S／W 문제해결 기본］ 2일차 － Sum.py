#import sys
#sys.stdin = open("practice_1.txt", "r")

for _ in range(10):
    tc = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    max_sum = 0

    for j in range(100):
        col_sum = 0
        primary_sum = 0
        secondary_sum = 0
        row_sum = sum(arr[j])
        for i in range(100):
            primary_sum += arr[i][i]
            secondary_sum += arr[i][100 - i - 1]
            col_sum += arr[i][j]
        max_sum = max(row_sum, col_sum, primary_sum, secondary_sum, max_sum)
    print(f"#{tc} {max_sum}")