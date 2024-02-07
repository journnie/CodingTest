#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    arr = list(map(int, input().split()))

    first_month = arr[0]
    first_day = arr[1]
    second_month = arr[2]
    second_day = arr[3]

    year_day = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
    result = 0

    if first_month == second_month:
        result = second_day - first_day + 1
    else: # first_month < second_month
        for month in range(first_month, second_month):
            result += year_day[month]
        result += second_day - first_day + 1

    print(f'#{test_case} {result}')
