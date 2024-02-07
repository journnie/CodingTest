#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    farm_list = [list(map(int, input())) for _ in range(N)]

    diamond_sum = 0
    middle = N // 2
    
    for i in range(middle + 1):
        if i == middle:
            diamond_sum += sum(farm_list[i])
            break
            
        first_row = farm_list[i][middle-i:N-middle+i]
        last_row = farm_list[N-1-i][middle-i:N-middle+i]

        diamond_sum += sum(first_row) + sum(last_row)

    result = diamond_sum
    print(f'#{test_case} {result}')
