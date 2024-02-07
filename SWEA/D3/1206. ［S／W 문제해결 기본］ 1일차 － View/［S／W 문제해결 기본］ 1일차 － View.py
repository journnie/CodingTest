#import sys
#sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    N = int(input())
    building_list = list(map(int, input().split()))

    total_view = 0

    for i in range(N):
        tallest = building_list[i]
        is_tallest = True
        view = 0

        if i == 0:
            buildings_around = building_list[:i+3]
        elif i == 1:
            buildings_around = building_list[:i] + building_list[i+1:i+3]
        elif i == N-2:
            buildings_around = building_list[i-2:i] + building_list[i + 1:]
        elif i == N-1:
            buildings_around = building_list[i-2:i]
        else:
            buildings_around = building_list[i-2:i] + building_list[i+1:i+3]

        second_tallest = max(buildings_around)
        if second_tallest >= tallest:
            is_tallest = False
            continue
        if is_tallest:
            view = tallest - second_tallest
        total_view += view

    result = total_view
    print(f'#{test_case} {result}')